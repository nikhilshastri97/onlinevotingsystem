package com.cg.ovs.service;

import java.util.List;
import java.util.Optional;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovs.entities.ElectionResult;
import com.cg.ovs.repository.ElectionResultRepository;

@Service
public class ElectionResultServiceImpl implements ElectionResultService {

	Logger logger = LoggerFactory.getLogger(ElectionResultService.class);
	   
    @Autowired
    private  ElectionResultRepository repository;

	@Override
	public ElectionResult addElectionResult(ElectionResult result) {

		return repository.save(result);
	}

	@Override
	public List<ElectionResult> viewElectionResultList() {

		return repository.findAll();
	}

	@Override
	public ElectionResult viewCandidatewiseResult(int  candidateId) {

		ElectionResult viewResult = null; 
		Optional<ElectionResult> optional = repository.findById(candidateId);                                 		if (optional.isPresent())
		viewResult = optional.get();        
		return viewResult;  
	
	}

}