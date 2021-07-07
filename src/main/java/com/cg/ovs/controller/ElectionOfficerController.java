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

import com.cg.ovs.entities.ElectionOfficer;
import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.exception.ElectionOfficerDetailsNotFoundException;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;
import com.cg.ovs.service.IElectionOfficerService;
import com.cg.ovs.service.INominatedCandidateService;
import com.cg.ovs.service.IRegisteredSocietyService;
import com.cg.ovs.service.VotedListServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/ElectionOfficer")

public class ElectionOfficerController 
{
	Logger logger = LoggerFactory.getLogger(ElectionOfficerController .class);
	@Autowired
	private IRegisteredSocietyService rSocietyServices;
	@Autowired
	private INominatedCandidateService nCServices;
	@Autowired
	private VotedListServiceImpl voteServices;
	@Autowired
	private IElectionOfficerService eOfficerService;

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name)
	{
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}
	
	@GetMapping("/getById/{id}")
	@ApiOperation("Get ElectionOfficer By ID")
	public ElectionOfficer fetchById(@PathVariable int id) throws NumberFormatException, ElectionOfficerDetailsNotFoundException
	{
		logger.info("Inside fetchById %s", id);
		return eOfficerService.fetchById(id);
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all ElectionOfficer Details")
	public List<ElectionOfficer> fetch() {
		logger.info("Fetching all ElectionOfficer records!!");
		return eOfficerService.fetchAll();
	}
	@PostMapping("/save")
	@ApiOperation("Add a ElectionOfficer details")
	public ResponseEntity<ElectionOfficer> save(@Valid @RequestBody ElectionOfficer electionofficer) {
		logger.info("Adding a electionofficer : " + electionofficer);
		ElectionOfficer e = eOfficerService.addElectionOfficer(electionofficer);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	@ApiOperation("Update an Existing ElectionOfficer details")
	public void update(@Valid @RequestBody ElectionOfficer electionofficer) {
		logger.info("Updating a ElectionOfficerDetails!!");
		eOfficerService.updateElectionOfficer(electionofficer);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing ElectionOfficer details")
	public ResponseEntity<Void> delete(@PathVariable int id) throws ElectionOfficerDetailsNotFoundException {
		logger.info("Deleting a ElectionOfficerDetails!!");
		eOfficerService.deleteElectionOfficer(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@DeleteMapping("/deleteRSV/{id}")
	@ApiOperation("delete an Existing RegisteredSocietyVoters Record")
	public ResponseEntity<Void> deleteRegistered(@PathVariable int id) throws RegisteredVoterNotFoundException {
		logger.info("Deleting a customer!!");
		 rSocietyServices.deleteRegisteredSocietyVoter(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/getByIdNC/{id}")
	@ApiOperation("Get NominatedCandidate By ID")
	public NominatedCandidate fetchByIdNominatedcandidates(@PathVariable int id) throws NumberFormatException, NominatedCandidateNotFoundException
	{
		logger.info("Inside fetchById %s", id);
		return nCServices.fetchById(id);
	}

	@GetMapping("/getAllNC")
	@ApiOperation("Fetch all NomainatedCandidate Details")
	public List<NominatedCandidate> viewNominatedCandidateList() {
		logger.info("Fetching all NominatedCandidate records!!");
		return nCServices.viewNominatedCandidateList();
	}
	
	@PostMapping("/saveNC")
	@ApiOperation("Add a NominatedCandidate details")
	public ResponseEntity<NominatedCandidate> save(@Valid @RequestBody NominatedCandidate nominatedcandidate) {
		logger.info("Adding a nominatedcandidate : " + nominatedcandidate);
		NominatedCandidate e = nCServices.addNominatedCandidate(nominatedcandidate);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateNC")
	@ApiOperation("Update an Existing NominatedCandidate details")
	public void update(@Valid @RequestBody NominatedCandidate nominatedcandidate) {
		logger.info("Updating a NominatedCandidateDetails!!");
		nCServices.updateNominatedCandidate(nominatedcandidate);
	}
	

	@DeleteMapping("/deleteNC/{id}")
	@ApiOperation("Delete an Existing NominatedCandidate details")
	public ResponseEntity<Void> deleteNC(@PathVariable int id) throws NominatedCandidateNotFoundException {
		logger.info("Deleting a NominatedCandidate!!");
		nCServices.deleteNominatedCandidate(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


}
