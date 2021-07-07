/*package com.cg.society.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
//@Entity
//@Table(name="CooperativeSociety")
@Embeddable
public class CooperativeSociety {
	
	  	
	    //@GeneratedValue(strategy=GenerationType.AUTO)
	    private int societyId;
	  	
	    //@Column(name = "s_Name")
	    @NotNull
	    private String societyName;
	    
	   // @Column(name = "head_of_Society")
	    @NotNull
	    private String headOfSociety;
	    
	    //@Column(name = "Village")
	    @NotNull
	    private String village;
	    
	  /* // @Column(name = "Mandal")
	    @NotNull
	    private String mandal;
	    
	    //@Column(name = "District")
	    @NotNull
	    private String district;*/
	    
	  /*  //@Column(name = "pincode")
	    @NotNull
	    @Size(min = 6,max=6, message = "Pincode should have  6 characters!!")
	    private String pincode;
	    
	    
	    
	}
	*/

package com.cg.ovs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
//@Table(name = "CooperativeSociety_Table")

public class CooperativeSociety {

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="societyId")
	@NotNull
	private int id;
	
	@Column(name = "s_Name")
	@NotNull
	private String societyName;
	
	@Column(name = "head_of_Society")
	@NotNull
	private String headOfSociety;
	@Column(name = "Village")
	@NotNull
	private String village;
	
	@Column(name = "District")
	@NotNull
	private String district;
	@Column(name = "pincode")
	@NotNull
	@Size(min = 6,max=6, message = "Pincode should have  6 characters!!")
	private String pincode;
	
	
	
	
	
}


