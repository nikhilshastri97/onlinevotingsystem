package com.cg.ovs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@Entity
	@Table(name = "election_result")
	public class ElectionResult {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name = "fname")
		//@NotNull
		//@Size(min = 2, message = "firstName should have mininum 2 characters!!")
		private String firstName;
		@Column(name = "lname")
		//@NotNull
		//@Size(min = 2, message = "lastName should have mininum 2 characters!!")
		private String lastName;
		
		@Column(name = "sname")
	    private String SocietyName;
		
		@Column (name = "address")
		private String address;
		
		@Column (name = "tsvotes")
		private Integer totalSocietyVotes;
		
		@Column (name = "tpvotes")
		private Integer totalPolledVotes;
		
		@Column (name = "tppercentage")
		private float totalPollingPercentage;
		
		@Column (name = "tcvotes")
		private Integer totalCandidatesVotes;
		
		@Column (name = "cvpercentage")
		private float candidateVotesPercentage;
		
		@Column (name = "result")
		private String result;

	}


