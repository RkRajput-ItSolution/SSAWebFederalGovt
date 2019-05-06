package com.ssa.federal.gov.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SSAAppModel {

	private long ssn;

	
	//@Min(1)
	//@Max(10)
	// @Size(min = 3, max = 10, message = "Name Should be have min 3 Charachter and max 20 Characters.")
	@NotNull(message = "field should not be null")
	private String firstName;

	@NotEmpty(message = "Please enter your lastName.")
	 //@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
	private String lastName;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	private String gender;

	@NotNull
	private String phoneNo;

	private String state;

	private MultipartFile photo;

	private Date createDate;

	private Date updateDate;

	private String createdBy;

	private String updatedBy;

	private String vflag = "no";

}
