package com.qaiware.llamakisses.service;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindingResult;

import com.qaiware.llamakisses.model.User;

public interface UserService {

    User findUserById(int id) throws DataAccessException;
    
    User findUserByEmail(String email) throws DataAccessException;
    
    void createUser(User user, int offerId, String role) throws DataAccessException;
    
    ArrayList<String> signUpValidation(User user, BindingResult result);
    
	String getPrincipal();
	
}
