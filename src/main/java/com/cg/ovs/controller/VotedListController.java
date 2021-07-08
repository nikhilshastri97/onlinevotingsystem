package com.cg.ovs.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovs.entities.VotedList;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.VotedListNotFoundException;
import com.cg.ovs.service.VotedListService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/VotedList")
public class VotedListController {

	Logger logger = LoggerFactory.getLogger(VotedListController.class);

	@Autowired
	private VotedListService service;

	@PostMapping("/save/{nid}")
	public void castVotedList(@PathVariable int nid, @Valid @RequestBody VotedList votedList) throws NominatedCandidateNotFoundException{
		logger.info("Error in nid"+ nid);
		service.castVotedList(nid, votedList);

	}

	@PutMapping("/update")
	public VotedList updateVotedListDetails(@Valid @RequestBody VotedList votedList) {
		return service.updateVotedListDetails(votedList);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete Voted List Details")
	public void deletedVotedListDetails(@PathVariable int id) throws VotedListNotFoundException {
		service.deleteById(id);
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Voted List")
	public List<VotedList> findAll() {
		return service.findAll();

	}

	@GetMapping("/searchById/{id}")
	@ApiOperation("Search Voter by findById")
	public VotedList searchById(@PathVariable int id) throws VotedListNotFoundException {

		return service.searchById(id);
	}

}