package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.Users;
import com.cg.ovs.exception.UserNotFoundException;
import com.cg.ovs.repository.UsersRepository;

@Service
public class UsersServiceClass implements UsersService {

	Logger logger = LoggerFactory.getLogger(UsersServiceClass.class);

	@Autowired
	private UsersRepository repository;

	@Override
	public void updateUsers(Users users) {

		logger.info("inside registerUser method of UsersService");
		repository.save(users);
	}

	@Override
	public void deleteUsers(int usersId) throws UserNotFoundException {
		Optional<Users> users = repository.findById(usersId);
		if (!users.isPresent())
			throw new UserNotFoundException();

		repository.deleteById(usersId);
	}

	@Override
	public List<Users> viewUsersList() {

		return repository.findAll();
	}

	@Override
	public Users findByUsersId(int usersId) throws UserNotFoundException {
		Optional<Users> users = repository.findById(usersId);
		if (!users.isPresent())
			throw new UserNotFoundException();

		return users.get();
	}

	// test

	@Override
	public List<Users> fetchAll() {

		return repository.findAll();
	}

	@Override
	public List<Users> findAll() {

		return repository.findAll();
	}

	/*
	 * @Override public Users getByFirstName(String fname) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Object addUser(Users users) { // TODO Auto-generated method
	 * stub return null; }
	 */

}