package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;

@Service
public interface INominatedCandidateService {
	NominatedCandidate addNominatedCandidate(NominatedCandidate nominatedcandidate);

	List<NominatedCandidate> fetchAll();

	void updateNominatedCandidate(NominatedCandidate nominatedcandidate);

	NominatedCandidate fetchById(int id) throws NominatedCandidateNotFoundException;

	void deleteNominatedCandidate(int id) throws NominatedCandidateNotFoundException;

	List<NominatedCandidate> viewNominatedCandidateList();

}
