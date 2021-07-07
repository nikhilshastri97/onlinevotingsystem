package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.Users;
import com.cg.ovs.exception.UserNotFoundException;

@Service
public interface UsersService {

	// test
	static Users registerUser(Users users) {
		return users;
		// TODO Auto-generated method stub

	}

	List<Users> fetchAll();

	void updateUsers(Users users);

	void deleteUsers(int usersId) throws UserNotFoundException;

	public List<Users> viewUsersList();

	Users findByUsersId(int usersId) throws UserNotFoundException;

	List<Users> findAll();

//test
	//Users getByFirstName(String fname);

//test
	//Object addUser(Users users);

	// List<UserResponse> getJoinInfo();
}