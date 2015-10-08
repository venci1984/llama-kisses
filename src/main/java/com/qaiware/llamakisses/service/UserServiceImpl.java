package com.qaiware.llamakisses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
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
	@Transactional(readOnly = true)
	public void createUser(User user) throws DataAccessException {		
		userRepository.create(user);		
	}

}