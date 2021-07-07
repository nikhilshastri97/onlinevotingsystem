package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.VotedList;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.VotedListNotFoundException;

@Service
public interface VotedListService {

	VotedList castVotedList(int nid, VotedList votedList) throws NominatedCandidateNotFoundException;

	VotedList updateVotedListDetails(VotedList votedList);

	void deleteById(int id) throws VotedListNotFoundException;

	List<VotedList> findAll();

	VotedList searchById(int id) throws VotedListNotFoundException;

}
