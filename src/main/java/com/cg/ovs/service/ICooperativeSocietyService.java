package com.cg.ovs.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.CooperativeSociety;
import com.cg.ovs.exception.CooperativeSocietyNotFoundException;

@Service
public interface ICooperativeSocietyService {
	
	
	
	CooperativeSociety updateSocietyDetails(CooperativeSociety society);
	
	void deleteSociety(int societyId) throws CooperativeSocietyNotFoundException ;
	
	CooperativeSociety fetchById(int societyId) throws CooperativeSocietyNotFoundException;

	List<CooperativeSociety> fetchAll();

	CooperativeSociety addCooperativeSociety(@Valid CooperativeSociety cooperativesociety);

	

	 
}
