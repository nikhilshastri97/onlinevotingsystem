package com.cg.ovs.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "nominated_tbl")
public class NominatedCandidate implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	// @Id
	@NotNull
	private int candidateId;
	
	@NotNull
	@Column(name = "nominationformno")
	private String nominationFormNo;

//	@OneToMany(targetEntity = RegisteredSocietyVoters.class, cascade = CascadeType.ALL) // all
//	@JoinColumn(name = "nc_rv_fk", referencedColumnName = "id")
//	private List <RegisteredSocietyVoters> registeredsocietyvoters;
}
