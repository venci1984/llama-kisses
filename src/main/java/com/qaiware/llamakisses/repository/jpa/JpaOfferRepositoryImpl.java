package com.qaiware.llamakisses.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.qaiware.llamakisses.model.Offer;
import com.qaiware.llamakisses.repository.OfferRepository;

@Repository
public class JpaOfferRepositoryImpl implements OfferRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Offer findById(int id) throws DataAccessException {
		
        Query query = this.em.createQuery("SELECT offer FROM Offer offer WHERE offer.id= :id");
        query.setParameter("id", id);
        return (Offer) query.getSingleResult();
	}

}
