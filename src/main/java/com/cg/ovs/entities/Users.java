package com.cg.ovs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

@Table(name = "users_table")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer usersId;
	@Column(name = "pass")
	@NotNull
	@Size(min = 6, message = "Password should have mininum 2 characters!!")
	private String password;
	@Column(name = "fname")
	@NotNull
	@Size(min = 2, message = "First Name should have mininum 2 characters!!")
	private String firstName;
	@Column(name = "lname")
	@NotNull
	@Size(min = 2, message = "Last Name should have mininum 2 characters!!")
	private String lastName;
	@Column(name = "email")
	@Email(message = "Enter a valid email address!!")
	private String email;
	@Column(name = "mob")
	private String contactno;

	@OneToOne(cascade = CascadeType.ALL)
	private NominatedCandidate nominatedCandidate;

	@OneToOne(cascade = CascadeType.ALL)
	private ElectionResult electionResult;

//test
	/*
	 * public void setAddress(String string) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * //test public void setMobile(int i) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public Users(int i, String string, String string2, String string3, String
	 * string4, int j, ArrayList arrayList) { // TODO Auto-generated constructor
	 * stub }
	 */

}