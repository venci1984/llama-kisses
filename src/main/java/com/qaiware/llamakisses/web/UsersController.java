package com.qaiware.llamakisses.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paymill.context.PaymillContext;
import com.paymill.models.Client;
import com.paymill.services.ClientService;
import com.qaiware.llamakisses.model.Offer;
import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.service.OfferService;
import com.qaiware.llamakisses.service.UserService;

@Controller
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	private final UserService userService;
	private final ClientService clientService;
	private final OfferService offerService;

	@Autowired
	public UsersController(UserService userService, PaymillContext paymillContext, OfferService offerService) {
		this.userService = userService;
		this.clientService = paymillContext.getClientService();
		this.offerService = offerService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loggedIn(ModelMap model) {
		
		model.addAttribute("currentUser", getPrincipal());
		model.addAttribute("addView", "pages/index.jsp");
		logger.info(getPrincipal());
		return "application";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model, @RequestParam("offerId") int offerId) {
		
		logger.info("Offer id: " + offerId );
		
        User user = new User();
        model.addAttribute("userForm", user);
		model.addAttribute("offerId", offerId);
		model.addAttribute("addView", "users/create.jsp");
		return "application";
	}
	
    @RequestMapping(value = "/signup/{offerId}", method = RequestMethod.POST)
    public String doSignUp(@Valid @ModelAttribute("userForm") User userForm,
            BindingResult result, ModelMap model, @PathVariable("offerId") int offerId) {
 
        ArrayList<String> errors = new ArrayList<>(); 
        
        for (FieldError fieldError : result.getFieldErrors()) {
			errors.add(fieldError.getDefaultMessage()); 
		}
        
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
        	errors.add("Password didn't match");
        }
    	
        logger.info("User's email: " + userForm.getEmail());
        if (emailExits(userForm.getEmail())) {
        	errors.add("Email already taken");
        }
        
    	if (!errors.isEmpty()) {
            logger.info("Form errors" + result.getFieldErrors());
            userForm.setPassword("");
            userForm.setPasswordConfirm("");
            model.addAttribute("errors", errors);
            model.addAttribute("addView", "users/create.jsp");
    		return "application";
        }
    	
        Client client = clientService.createWithEmail(userForm.getEmail());
        Offer offer = offerService.findOfferById(offerId);
        logger.info("Create subscription for client with paymill_id: " + client.getId() + " for offerId: " + offer.getName());
        userForm.setPaymill_id(client.getId());
        userForm.setOffer(offer);   
        userService.createUser(userForm, "ROLE_USER");
        logger.info("New user created: " + userForm);
        model.addAttribute("msg", "You've registered successfully.");
        model.addAttribute("addView", "pages/index.jsp");
        return "application";
    }

	private String getPrincipal() {
		
		String email = null;
		String fullName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		if (emailExits(email)) {
			User user = userService.findUserByEmail(email);
			fullName = user.getName();
		}
		
		return fullName;
	}
	
	boolean emailExits(String email) {

		try {
			userService.findUserByEmail(email);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

		return true;
	}
}
