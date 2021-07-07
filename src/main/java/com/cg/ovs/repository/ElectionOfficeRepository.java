package com.cg.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovs.entities.ElectionOfficer;

public interface ElectionOfficeRepository extends JpaRepository<ElectionOfficer, Integer>
{
	public ElectionOfficer findByLastName(String lastName);

	public ElectionOfficer findByFirstName(String firstName);
	
}
