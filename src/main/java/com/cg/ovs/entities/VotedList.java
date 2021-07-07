package com.cg.ovs.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VotedList")
public class VotedList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date datetime;

	@OneToOne(cascade = CascadeType.ALL)
	private RegisteredSocietyVoters registeredSociety;

	@OneToOne(cascade = CascadeType.ALL)
	private CooperativeSociety society;

	@OneToOne(cascade = CascadeType.ALL)
	private NominatedCandidate candidates;
}
