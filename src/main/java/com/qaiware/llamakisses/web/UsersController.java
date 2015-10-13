package com.qaiware.llamakisses.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.service.UserService;

@Controller
public class UsersController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loggedIn(ModelMap model) {
		
		String principal = userService.getPrincipal();
		
		model.addAttribute("currentUser", principal);
		model.addAttribute("addView", "pages/index.jsp");
		logger.info(principal + " singed in successfully!");
		return "application";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model, @RequestParam("offerId") int offerId) {
		
		logger.info("Sign Up process for offer id: " + offerId );
		
        User user = new User();
        model.addAttribute("userForm", user);
		model.addAttribute("offerId", offerId);
		model.addAttribute("addView", "users/create.jsp");
		return "application";
	}
	
    @RequestMapping(value = "/signup/{offerId}", method = RequestMethod.POST)
    public String doSignUp(@Valid @ModelAttribute("userForm") User userForm,
            BindingResult result, ModelMap model, @PathVariable("offerId") int offerId) {
       
    	ArrayList<String> errors = userService.signUpValidation(userForm, result);
        
    	if (!errors.isEmpty()) {
            logger.info("Form errors" + result.getFieldErrors());
            userForm.setPassword("");
            userForm.setPasswordConfirm("");
            model.addAttribute("errors", errors);
            model.addAttribute("addView", "users/create.jsp");
    		return "application";
        }
    	
        userService.createUser(userForm, offerId, "ROLE_USER");
        model.addAttribute("msg", "You've registered successfully.");
        model.addAttribute("addView", "pages/index.jsp");
        return "application";
    }
}
