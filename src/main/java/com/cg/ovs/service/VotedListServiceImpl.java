package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.VotedList;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.VotedListNotFoundException;
import com.cg.ovs.repository.NominatedCandidateRepository;
import com.cg.ovs.repository.VotedListDao;

@Service
public class VotedListServiceImpl implements VotedListService {

	Logger logger = LoggerFactory.getLogger(VotedListServiceImpl.class);

	@Autowired
	private VotedListDao repository;
	@Autowired
	private NominatedCandidateRepository ncrepository;

	@Override
	@Transactional
	public VotedList castVotedList(int nid, VotedList votedList) throws NominatedCandidateNotFoundException {

		Optional<NominatedCandidate> nc = ncrepository.findByCandidateId(nid);
		
		if (nc.isPresent()) {
			NominatedCandidate ncand = ncrepository.getByCandidateId(nid);

			if (!(ncand.getCandidateId() == nid)) {
				throw new NominatedCandidateNotFoundException();
			}

			votedList.setCandidates(ncand);
			return repository.save(votedList);

		}
		throw new NominatedCandidateNotFoundException();
	}

	@Override
	public VotedList updateVotedListDetails(VotedList votedList) {//
		return repository.save(votedList);

	}

	@Override
	public void deleteById(int id) throws VotedListNotFoundException {

		Optional<VotedList> votedList = repository.findById(id);
		if (!votedList.isPresent())
			throw new VotedListNotFoundException();

		repository.deleteById(id);

	}

	@Override
	public List<VotedList> findAll() {

		return repository.findAll();
	}

	@Override
	public VotedList searchById(int id) throws VotedListNotFoundException {

		Optional<VotedList> votedList = repository.findById(id);
		if (!votedList.isPresent())
			throw new VotedListNotFoundException();

		return votedList.get();
	}

}
