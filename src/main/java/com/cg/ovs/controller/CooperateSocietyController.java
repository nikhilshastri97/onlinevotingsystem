package com.cg.ovs.controller;

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

import com.cg.ovs.entities.CooperativeSociety;
import com.cg.ovs.exception.CooperativeSocietyNotFoundException;
import com.cg.ovs.service.ICooperativeSocietyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/CooperativeSociety")
public class CooperateSocietyController {

	Logger logger = LoggerFactory.getLogger(CooperateSocietyController.class);

	@Autowired
	private ICooperativeSocietyService service; // CooperativeSocietyService is a dependency of
												// CooperateSocietyController

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}

	@GetMapping("/getById/{societyId}")
	@ApiOperation("Fetch Society Details ")
	public CooperativeSociety fetchById(@PathVariable int societyId)
			throws NumberFormatException, CooperativeSocietyNotFoundException {
		logger.info("Inside fetchById %s", societyId);
		return service.fetchById(societyId);
	}

	@PostMapping("/save")
	@ApiOperation("Add a CooperativeSociety Record")
	public ResponseEntity<CooperativeSociety> save(@Valid @RequestBody CooperativeSociety cooperativesociety) {
		logger.info("Adding a Society Details!! ");
		CooperativeSociety society = service.addCooperativeSociety(cooperativesociety);
		return new ResponseEntity<>(society, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	@ApiOperation("Update Society Details")
	public void update(@Valid @RequestBody CooperativeSociety cooperativesociety) {
		logger.info("Updating a Society Details!!");
		service.updateSocietyDetails(cooperativesociety);
	}

	@DeleteMapping("/delete/{societyId}")
	@ApiOperation("Delete an Existing Cooperate Society Member Details")
	public ResponseEntity<CooperativeSociety> delete(@PathVariable int societyId)
			throws CooperativeSocietyNotFoundException {
		logger.info("Deleting a customer!!");
		service.deleteSociety(societyId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
