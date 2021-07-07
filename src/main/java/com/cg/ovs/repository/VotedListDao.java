package com.cg.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.VotedList;

@Repository
public interface VotedListDao extends JpaRepository<VotedList, Integer> {

	
	
	
}
