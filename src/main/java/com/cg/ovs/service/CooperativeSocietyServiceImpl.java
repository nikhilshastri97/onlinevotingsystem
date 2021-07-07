package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.CooperativeSociety;
import com.cg.ovs.exception.CooperativeSocietyNotFoundException;
import com.cg.ovs.repository.CooperativeSocietyRepository;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService {

	Logger logger = LoggerFactory.getLogger(CooperativeSocietyServiceImpl.class);

	@Autowired(required = true)
	private CooperativeSocietyRepository repository;// repository is a dependency of customerserviceimpl

	@Override
	public CooperativeSociety addCooperativeSociety(CooperativeSociety society) {
		logger.info("inside addCooperativeSocietydetails method of CooperativeServiceImpl");
		return repository.save(society);
	}

	@Override
	public List<CooperativeSociety> fetchAll() {
		return repository.findAll();
	}

	@Override
	public CooperativeSociety updateSocietyDetails(CooperativeSociety cooperativesociety) {
		return repository.save(cooperativesociety);
	}

	@Override
	public void deleteSociety(int societyId) throws CooperativeSocietyNotFoundException {
		Optional<CooperativeSociety> cooperativeSociety = repository.findById(societyId);
		if (!cooperativeSociety.isPresent())
			throw new CooperativeSocietyNotFoundException();
		repository.deleteById(societyId);
	}

	@Override
	public CooperativeSociety fetchById(int societyId) throws CooperativeSocietyNotFoundException {
		Optional<CooperativeSociety> cooperativeSociety = repository.findById(societyId);
		if (!cooperativeSociety.isPresent())
			throw new CooperativeSocietyNotFoundException();
		return cooperativeSociety.get();

	}

	

}
