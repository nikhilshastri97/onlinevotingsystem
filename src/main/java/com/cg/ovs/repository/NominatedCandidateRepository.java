package com.cg.ovs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovs.entities.NominatedCandidate;

public interface NominatedCandidateRepository extends JpaRepository<NominatedCandidate, Integer> {

	NominatedCandidate getByCandidateId(int nid);
	
	Optional <NominatedCandidate> findByCandidateId(int nid);
}
