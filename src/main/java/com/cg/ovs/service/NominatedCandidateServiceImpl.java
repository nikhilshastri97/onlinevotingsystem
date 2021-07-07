package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.repository.NominatedCandidateRepository;
@Service
public class NominatedCandidateServiceImpl implements INominatedCandidateService
{
	Logger logger = LoggerFactory.getLogger(NominatedCandidateServiceImpl.class);
	@Autowired
	private NominatedCandidateRepository repository ;
	@Override
	public NominatedCandidate addNominatedCandidate(NominatedCandidate nominatedcandidate)
	{
		logger.info("inside addNominatedCandidate method of NominatedCandidateServiceImpl");
		return repository.save(nominatedcandidate);
	}
	@Override
	public List<NominatedCandidate> fetchAll() 
	{
		return repository.findAll();
	}
	@Override
	public void updateNominatedCandidate(NominatedCandidate nominatedcandidate)
	{
		repository.save(nominatedcandidate);	
	}
	@Override
	public NominatedCandidate fetchById(int id) throws NominatedCandidateNotFoundException 
	{
		Optional<NominatedCandidate> nominatedcandidate = repository.findById(id);
		if (!nominatedcandidate.isPresent())
			throw new NominatedCandidateNotFoundException();

		return nominatedcandidate.get();
	}
	@Override
	public void deleteNominatedCandidate(int id) throws NominatedCandidateNotFoundException
	{
		Optional<NominatedCandidate> nominatedcandidate = repository.findById(id);
		if (!nominatedcandidate.isPresent())
			throw new NominatedCandidateNotFoundException ();

	    repository.deleteById(id); 
		
	}
	@Override
	public List<NominatedCandidate> viewNominatedCandidateList() {
		
		return repository.findAll();
	}

	
}
