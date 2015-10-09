package com.qaiware.llamakisses.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.qaiware.llamakisses.model.User;
import com.qaiware.llamakisses.repository.UserRepository;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(int id) throws DataAccessException {
		
        Query query = this.em.createQuery("SELECT user FROM User user WHERE user.id= :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
	}

	@Override
	public User findByEmail(String email) throws DataAccessException {
		
        Query query = this.em.createQuery("SELECT user FROM User user WHERE user.email= :email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
	}

}
