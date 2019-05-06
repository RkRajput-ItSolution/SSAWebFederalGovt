package com.ssa.federal.gov.service;

import java.io.IOException;
import java.util.List;

import com.ssa.federal.gov.model.SSAAppModel;

public interface SSAAppService {

	public long SsaEnrollment(SSAAppModel ssnModel) throws IOException;

	public List<SSAAppModel> retriveAllSsnRecord();

	public List<String> getAllStatesNames( );

	/*
	 * 
	 * public java.util.List<SSAAppModel> retrivalAllSSns(Integer pageNo, Integer
	 * pageSize);
	 */
	public String findStateBySsn(Long ssn);
}
