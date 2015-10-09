package com.qaiware.llamakisses.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.service.LlamaKissesService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final LlamaKissesService llamaKissesService;

	@Autowired
	public HomeController(LlamaKissesService llamaKissesService) {
		this.llamaKissesService = llamaKissesService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "login_error", required = false) String login_error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (login_error != null) {
			model.addObject("error", "Invalid username or password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("application");

		return model;
	}

	@RequestMapping(value = "/welcome")
	public String loggedIn(ModelMap model) {
		
		model.addAttribute("currentUser", getPrincipal());
		logger.info(getPrincipal());
		return "application";
	}

	private String getPrincipal() {
		
		String email = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		User user = llamaKissesService.findUserByEmail(email);
		String fullName = user.getName();

		return fullName;
	}
}
