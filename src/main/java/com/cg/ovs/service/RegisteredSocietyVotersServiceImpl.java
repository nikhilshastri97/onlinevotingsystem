package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.RegisteredSocietyVoters;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;
import com.cg.ovs.repository.RegisteredSocietyVotersRepository;


@Service
public class RegisteredSocietyVotersServiceImpl implements IRegisteredSocietyService {

	Logger logger = LoggerFactory.getLogger(RegisteredSocietyVotersServiceImpl.class);
	
	@Autowired//(required=true)
	private RegisteredSocietyVotersRepository repository; // repository is a dependency of RegisteredSocietyVotersServiceImpl 
	
	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {

		logger.info("Inside addVoterRegistration method of RegisteredSocietyVotersServiceImpl");
		return repository.save(voter);
	}

	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {

		return repository.save(voter);
	}

	@Override
	public void  deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException {

		Optional<RegisteredSocietyVoters> registeredsocietyvoters = repository.findByVoterId(voterId);
		if(!registeredsocietyvoters.isPresent()) throw new RegisteredVoterNotFoundException();
		repository.deleteById(voterId);
	}

		
	/*@Override
	public RegisteredSocietyVoters loginValidate(String userid, String password) {

		return null;
	}*/

	@Override
	public RegisteredSocietyVoters fetchById(int voterId) throws RegisteredVoterNotFoundException {

		Optional<RegisteredSocietyVoters> registeredsocietyvoters = repository.findById(voterId);
		if (!registeredsocietyvoters.isPresent())
			throw new RegisteredVoterNotFoundException();

		return registeredsocietyvoters.get();
	}

	@Override
	public List<RegisteredSocietyVoters> findAll() {

		return repository.findAll();
	}

	@Override
	public RegisteredSocietyVoters addRegisteredSocietyVoters(RegisteredSocietyVoters registeredsociety) {

		logger.info("inside addCustomer method of CustomerServiceImpl");
		return repository.save(registeredsociety);
	
		
	}

	

}
