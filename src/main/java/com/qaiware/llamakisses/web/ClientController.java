package com.qaiware.llamakisses.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paymill.context.PaymillContext;
import com.paymill.models.Client;
import com.paymill.services.ClientService;

@Controller
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	private final ClientService clientService;

	@Autowired
	public ClientController(PaymillContext paymillContext) {
		this.clientService = paymillContext.getClientService();
	}
	@RequestMapping(value = "/test")
	public String test() {
		
		Client client = clientService.createWithEmail("test@abv.bg");
		logger.info(client.getId());
		
		return "test";
	}
}
