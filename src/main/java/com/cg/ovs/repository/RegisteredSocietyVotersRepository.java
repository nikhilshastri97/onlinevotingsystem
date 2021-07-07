package com.cg.ovs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.entities.RegisteredSocietyVoters;


@Repository
public interface RegisteredSocietyVotersRepository extends JpaRepository<RegisteredSocietyVoters, Integer> {

	Optional<RegisteredSocietyVoters> findByVoterId(int voterId);

	RegisteredSocietyVoters searchByVoterId(int voterId);



	
		
}
