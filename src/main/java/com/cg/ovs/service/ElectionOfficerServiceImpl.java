package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.ElectionOfficer;
import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.RegisteredSocietyVoters;
import com.cg.ovs.exception.ElectionOfficerDetailsNotFoundException;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;
import com.cg.ovs.repository.ElectionOfficeRepository;
import com.cg.ovs.repository.NominatedCandidateRepository;
import com.cg.ovs.repository.RegisteredSocietyVotersRepository;

@Service
public class ElectionOfficerServiceImpl implements IElectionOfficerService {
	@Autowired
	private NominatedCandidateRepository nCRepository;
	@Autowired
	private RegisteredSocietyVotersRepository rCRepository;
	Logger logger = LoggerFactory.getLogger(ElectionOfficerServiceImpl.class);
	@Autowired
	private ElectionOfficeRepository repository;

	@Override
	public ElectionOfficer addElectionOfficer(ElectionOfficer electionofficer) {
		logger.info("inside addElectionOfficeDetails method of ElectionOfficerServiceImpl");
		return repository.save(electionofficer);
		// return vr.save(electionofficer);

	}

	@Override
	public List<ElectionOfficer> fetchAll() {
		return repository.findAll();
	}

	@Override
	public ElectionOfficer fetchById(int id) throws ElectionOfficerDetailsNotFoundException {
		Optional<ElectionOfficer> electionofficer = repository.findById(id);
		if (!electionofficer.isPresent())
			throw new ElectionOfficerDetailsNotFoundException();

		return electionofficer.get();
	}

	@Override
	public void deleteElectionOfficer(int id) throws ElectionOfficerDetailsNotFoundException {
		Optional<ElectionOfficer> electionofficer = repository.findById(id);
		if (!electionofficer.isPresent())
			throw new ElectionOfficerDetailsNotFoundException();

		repository.deleteById(id);

	}

	@Override
	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer ElectionOfficer) {

		return repository.save(ElectionOfficer);
	}

	public void deleteNominatedCandidate(int id) throws NominatedCandidateNotFoundException {
		Optional<NominatedCandidate> nominatedcandidate = nCRepository.findById(id);
		if (!nominatedcandidate.isPresent())
			throw new NominatedCandidateNotFoundException();

		nCRepository.deleteById(id);

	}

	@Override
	public NominatedCandidate addNCandidate(NominatedCandidate nominatedCandidate) {

		return nCRepository.save(nominatedCandidate);
	}

	public NominatedCandidate updateNCandidate(NominatedCandidate nominatedCandidate)

	{

		return nCRepository.save(nominatedCandidate);
	}

	@Override

	public void deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException {

		Optional<RegisteredSocietyVoters> registeredsocietyvoters = rCRepository.findByVoterId(voterId);
		if (!registeredsocietyvoters.isPresent())
			throw new RegisteredVoterNotFoundException();
		rCRepository.deleteById(voterId);
	}

	@Override

	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {

		return rCRepository.findAll();
	}

}
