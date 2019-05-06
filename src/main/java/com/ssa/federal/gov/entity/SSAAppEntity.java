package com.ssa.federal.gov.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "SSAApp_Master")
public class SSAAppEntity {
	
	public SSAAppEntity() {
		System.out.println("SSAAppEntity:::SSAAppEntity()");
	}
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
   //create sequence ssn_seq start with 805739313 increment by 1;
	
	@Id
    @GeneratedValue(generator = "ssa_ssn_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ssa_ssn_seq", sequenceName = "ssn_seq", initialValue = 805731323, allocationSize = 1)
	@Column(name = "Ssn")
	private long ssn;
	
	 
	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "DateOfBirth")
	private Date dob;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "State")
	private String state;

	@Lob
	// @Basic(fetch = FetchType.LAZY)
	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "Create_Date")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

	@Column(name = "Update_Date")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	@Column(name = "Create_By")
	private String createdBy;

	@Column(name = "Update_By")
	private String updatedBy;
}
