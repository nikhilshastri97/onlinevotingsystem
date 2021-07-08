package com.cg.ovs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;

public interface NominatedCandidateRepository extends JpaRepository<NominatedCandidate, Integer> {

	NominatedCandidate getByCandidateId(int nid) throws NominatedCandidateNotFoundException;
	
//	Optional <NominatedCandidate> findByCandidateId(int nid);
}
