package com.ssa.federal.gov.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ssa.federal.gov.model.SSAAppModel;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("StudentRegistrationValidator.supports(-)");
		//return clazz==StudentCommand.class;
		return clazz.isAssignableFrom(SSAAppModel.class);

		
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		System.out.println("StudentRegistrationValidator.validate(-,-)");
		SSAAppModel command=null;
		//type casting
		command=(SSAAppModel)cmd;
		if(command.getVflag().equalsIgnoreCase("no")) {
			System.out.println("server side form validations are taking place");
		if(command.getFirstName()==null ||command.getFirstName().length()==0 || command.getFirstName().equals(""))
			errors.rejectValue("firstName","firstName.required");
		
		if(command.getLastName()==null || command.getLastName().equals("") ||command.getLastName().length()==0)
			errors.rejectValue("lastName","lastName.required");
		else if(command.getLastName().length()<10)
			errors.rejectValue("lastName","lastName.minlength");
		
	
	}
	}
}
