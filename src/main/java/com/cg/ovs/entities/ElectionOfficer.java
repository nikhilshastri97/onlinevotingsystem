package com.cg.ovs.entities;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="voter_tbl")
public class ElectionOfficer
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="fname")
	@NotNull
	private String firstName;
	
	@Column(name="lname")
	@NotNull
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobileno")
	private long mobileno;
	
	@Column(name="mail")
	@Email(message = "Enter a valid email address!!")
	private String emailId;
	
	@Column(name="address1")
	private String address1;
		
	@Column(name="district")
	private String district;
	
	@Column(name="pincode")
	@Size(min = 6,max=6, message = "Pincode should have  6 characters!!")
	private String pincode;

//	@OneToMany(targetEntity=NominatedCandidate.class,cascade=CascadeType.MERGE)
//	@JoinColumn(name="EoNi_fk",referencedColumnName="id")
//	private List<NominatedCandidate> candidate;
//	
//	@OneToMany(targetEntity=RegisteredSocietyVoters.class,cascade=CascadeType.MERGE)
//	@JoinColumn(name="EoRs_fk",referencedColumnName="id")
//	private List<RegisteredSocietyVoters> voter;
	
	//@OneToMany(targetEntity=VotedList.class,cascade=CascadeType.MERGE)
	//@JoinColumn(name="EoVl=fk",referencedColumnName="id")
	//private List<VotedList> list;



}
