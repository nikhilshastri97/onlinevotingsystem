package com.cg.ovs.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.VotedList;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.service.INominatedCandidateService;
import com.cg.ovs.service.VotedListService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/NominatedCandidate")
public class NominatedCandidateController {
	Logger logger = LoggerFactory.getLogger(NominatedCandidateController.class);
	@Autowired
	private INominatedCandidateService service;
	@Autowired
	private VotedListService vLService;

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}

	@GetMapping("/getById/{id}")
	@ApiOperation("Get NominatedCandidate By ID")
	public NominatedCandidate fetchById(@PathVariable int id)
			throws NumberFormatException, NominatedCandidateNotFoundException {
		logger.info("Inside fetchById %s", id);
		return service.fetchById(id);
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all NomainatedCandidate Details")
	public List<NominatedCandidate> fetch() {
		logger.info("Fetching all NominatedCandidate records!!");
		return service.fetchAll();
	}

	@PostMapping("/save")
	@ApiOperation("Add a NominatedCandidate details")
	public ResponseEntity<NominatedCandidate> save(@Valid @RequestBody NominatedCandidate nominatedcandidate) {
		logger.info("Adding a nominatedcandidate : " + nominatedcandidate);
		NominatedCandidate e = service.addNominatedCandidate(nominatedcandidate);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing NominatedCandidate details")
	public void update(@Valid @RequestBody NominatedCandidate nominatedcandidate) {
		logger.info("Updating a NominatedCandidateDetails!!");
		service.updateNominatedCandidate(nominatedcandidate);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing NominatedCandidate details")
	public ResponseEntity<Void> delete(@PathVariable int id) throws NominatedCandidateNotFoundException {
		logger.info("Deleting a NominatedCandidate!!");
		service.deleteNominatedCandidate(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/saveVL")
	public void getCastVotedList(@PathVariable int nid, @Valid @RequestBody  VotedList votedList) throws NominatedCandidateNotFoundException {

		vLService.castVotedList(nid, votedList);

	}

}
