package com.qaiware.llamakisses.service;

import org.springframework.dao.DataAccessException;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.model.UserRole;

public interface UserService {

    User findUserById(int id) throws DataAccessException;
    
    User findUserByEmail(String email) throws DataAccessException;
    
    public void createUser(User user, String role) throws DataAccessException;
	
}
