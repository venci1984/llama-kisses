package com.qaiware.llamakisses.repository;

import org.springframework.dao.DataAccessException;
import com.qaiware.llamakisses.model.User;


public interface UserRepository {

    User findById(int id) throws DataAccessException;
    
    User findByEmail(String email) throws DataAccessException;
    
}
