package com.qaiware.llamakisses.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.qaiware.llamakisses.model.UserRole;
import com.qaiware.llamakisses.repository.UserRoleRepository;

@Repository
public class JpaUserRoleRepositoryImpl implements UserRoleRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(UserRole userRole) throws DataAccessException {
		
		if (userRole.getId() == null) {
			this.em.persist(userRole);
		} else {
			this.em.merge(userRole);
		}
		
	}

	

}
