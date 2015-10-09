package com.qaiware.llamakisses.repository;

import org.springframework.dao.DataAccessException;

import com.qaiware.llamakisses.model.Offer;

public interface OfferRepository {

	Offer findById(int id) throws DataAccessException;
	
}
