package com.qaiware.llamakisses.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.service.LlamaKissesService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(types = User.class)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final LlamaKissesService llamaKissesService; 
	
    @Autowired
    public HomeController(LlamaKissesService llamaKissesService) {
        this.llamaKissesService = llamaKissesService;
    }
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Executing HomeController");
		
		User user = this.llamaKissesService.findUserById(1);
		String name = user.getName();
		String email = user.getEmail();
		logger.info(name);
		logger.info(email);
		
		User user2 = this.llamaKissesService.findUserById(2);
		String name2 = user2.getName();
		String email2 = user2.getEmail();
		logger.info(name2);
		logger.info(email2);

		return "home";
	}
	
}
