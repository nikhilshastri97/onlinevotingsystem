package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.RegisteredSocietyVoters;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;

@Service
public interface IRegisteredSocietyService {

	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter);

	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);

	public void deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException;

	// public RegisteredSocietyVoters loginValidate(String userid,String password) ;

	public RegisteredSocietyVoters fetchById(int id) throws RegisteredVoterNotFoundException;

	public List<RegisteredSocietyVoters> findAll();

	public RegisteredSocietyVoters addRegisteredSocietyVoters(RegisteredSocietyVoters registeredsociety);

}
