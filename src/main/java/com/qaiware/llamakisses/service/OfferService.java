package com.qaiware.llamakisses.service;

import org.springframework.dao.DataAccessException;

import com.qaiware.llamakisses.model.Offer;

public interface OfferService {

    Offer findOfferById(int id) throws DataAccessException;
	
}
