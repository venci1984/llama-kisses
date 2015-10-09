package com.qaiware.llamakisses.service;

import org.springframework.dao.DataAccessException;

import com.qaiware.llamakisses.model.User;

/**
 * Used as a facade so all controllers have a single point of entry
 *
 * @author Venci
 */
public interface UserService {

    User findUserById(int id) throws DataAccessException;
    
    User findUserByEmail(String email) throws DataAccessException;
    
    public void createUser(User user) throws DataAccessException;
	
}
