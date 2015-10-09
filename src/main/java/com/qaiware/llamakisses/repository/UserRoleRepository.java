package com.qaiware.llamakisses.repository;

import org.springframework.dao.DataAccessException;

import com.qaiware.llamakisses.model.UserRole;

public interface UserRoleRepository {

    void create(UserRole userRole) throws DataAccessException;
	
}
