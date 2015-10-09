package com.qaiware.llamakisses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qaiware.llamakisses.model.Offer;
import com.qaiware.llamakisses.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	private OfferRepository offerRepository;
	
	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Offer findOfferById(int id) throws DataAccessException {
		return offerRepository.findById(id);
	}

}
