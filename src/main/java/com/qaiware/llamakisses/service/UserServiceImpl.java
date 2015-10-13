package com.qaiware.llamakisses.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.paymill.context.PaymillContext;
import com.paymill.models.Client;
import com.paymill.services.ClientService;
import com.qaiware.llamakisses.model.Offer;
import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.model.UserRole;
import com.qaiware.llamakisses.repository.UserRepository;
import com.qaiware.llamakisses.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	private ClientService clientService;
	@Autowired
	private OfferService offerService;

	@Autowired
	public UserServiceImpl(PaymillContext paymillContext) {
		this.clientService = paymillContext.getClientService();
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) throws DataAccessException {
		return userRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByEmail(String email) throws DataAccessException {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public void createUser(User user, int offerId, String role) throws DataAccessException {

		Client client = clientService.createWithEmail(user.getEmail());
		Offer offer = offerService.findOfferById(offerId);
		user.setPaymill_id(client.getId());
		user.setOffer(offer);
		userRepository.create(user);
		UserRole userRole = new UserRole();
		userRole.setEmail(user.getEmail());
		userRole.setRole(role);
		userRoleRepository.create(userRole);
	}

	@Override
	public ArrayList<String> signUpValidation(User user, BindingResult result) {

		ArrayList<String> errors = new ArrayList<>();

		for (FieldError fieldError : result.getFieldErrors()) {
			errors.add(fieldError.getDefaultMessage());
		}

		if (!user.getPassword().equals(user.getPasswordConfirm())) {
			errors.add("Password didn't match");
		}

		if (emailExits(user.getEmail())) {
			errors.add("Email already taken");
		}

		return errors;
	}

	@Override
	public String getPrincipal() {

		String email = null;
		String fullName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			email = ((UserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		if (emailExits(email)) {
			User user = findUserByEmail(email);
			fullName = user.getName();
		}

		return fullName;
	}

	private boolean emailExits(String email) {

		try {
			findUserByEmail(email);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

		return true;
	}

}
