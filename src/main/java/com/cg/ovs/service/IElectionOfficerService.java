package com.cg.ovs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovs.entities.ElectionOfficer;
import com.cg.ovs.exception.ElectionOfficerDetailsNotFoundException;
@Service
public interface IElectionOfficerService
{
	ElectionOfficer addElectionOfficer(ElectionOfficer  electionofficer);

     List<ElectionOfficer> fetchAll();
     
    void updateElectionOfficer(ElectionOfficer customer);
    
    void deleteElectionOfficer(int id) throws ElectionOfficerDetailsNotFoundException;

 	ElectionOfficer fetchById(int id) throws ElectionOfficerDetailsNotFoundException;


	
}
