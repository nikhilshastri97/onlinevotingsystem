package com.cg.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	// test
	//Object findByFirstName(String string);

}