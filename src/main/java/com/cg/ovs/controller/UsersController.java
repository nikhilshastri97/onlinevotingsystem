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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovs.entities.Users;
import com.cg.ovs.exception.UserNotFoundException;
import com.cg.ovs.service.UsersService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class UsersController {

	Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UsersService service;

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Online Voting System " + name + "</h1>";
	}

	@GetMapping("/getById/{id}")
	@ApiOperation("Get Users By ID")
	public Users fetchById(@PathVariable String id) throws NumberFormatException, UserNotFoundException {
		logger.info("Inside fetchById %s", id);
		return service.findByUsersId(Integer.valueOf(id));
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Users Details")
	public List<Users> fetch() {
		logger.info("Fetching all users records!!");
		return service.fetchAll();
	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing User Record")
	public void update(@Valid @RequestBody Users users) {
		logger.info("Updating a users!!");
		service.updateUsers(users);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing Users Record")
	public ResponseEntity<Void> delete(@PathVariable String id) throws NumberFormatException, UserNotFoundException {
		logger.info("Deleting a users!!");
		service.deleteUsers(Integer.valueOf(id));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}