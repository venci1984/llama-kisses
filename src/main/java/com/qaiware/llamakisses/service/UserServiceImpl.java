package com.qaiware.llamakisses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.model.UserRole;
import com.qaiware.llamakisses.repository.UserRepository;
import com.qaiware.llamakisses.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
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
	public void createUser(User user, String role) throws DataAccessException {
		
		userRepository.create(user);
		UserRole userRole = new UserRole();
		userRole.setEmail(user.getEmail());
		userRole.setRole(role);
		userRoleRepository.create(userRole);
	}
	
}
