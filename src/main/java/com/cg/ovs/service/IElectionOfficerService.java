package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.ElectionOfficer;
import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.RegisteredSocietyVoters;
import com.cg.ovs.exception.ElectionOfficerDetailsNotFoundException;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;

@Service
public interface IElectionOfficerService {
	ElectionOfficer addElectionOfficer(ElectionOfficer electionofficer);

	List<ElectionOfficer> fetchAll();

	ElectionOfficer updateElectionOfficerDetails(ElectionOfficer ElectionOfficer);

	void deleteElectionOfficer(int id) throws ElectionOfficerDetailsNotFoundException;

	ElectionOfficer fetchById(int id) throws ElectionOfficerDetailsNotFoundException;

	public void deleteNominatedCandidate(int id) throws NominatedCandidateNotFoundException;

	public NominatedCandidate addNCandidate(NominatedCandidate nominatedCandidate);

	public NominatedCandidate updateNCandidate(NominatedCandidate nominatedCandidate);

	void deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException;

	List<RegisteredSocietyVoters> viewRegisteredVoterList();

}
