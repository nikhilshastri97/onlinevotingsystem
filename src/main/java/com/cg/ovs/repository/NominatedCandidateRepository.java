package com.cg.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovs.entities.NominatedCandidate;

public interface NominatedCandidateRepository extends JpaRepository<NominatedCandidate, Integer> {

	NominatedCandidate getByCandidateId(int nid);

}
