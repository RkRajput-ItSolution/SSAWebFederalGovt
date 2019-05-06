package com.ssa.federal.gov.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssa.federal.gov.exception.SsaAppRestException;
import com.ssa.federal.gov.service.SSAAppService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:9090/v2/api-docs
//http://localhost:9090/swagger-ui.html
@RestController
@Api(value = "SSAWebAppRestApi", description = "This is used to Validate SSN.......")
public class SsaAppResource {
	public static final Logger logger = LoggerFactory.getLogger(SsaAppResource.class);
	@Autowired
	private SSAAppService service;

	@ApiOperation(httpMethod = "GET", value = "This is used to get State Name by using SSN...", response = String.class, tags = "getWelcomeNote")
	@GetMapping(value = "/findStateBySsn/{ssn}", produces = { "application/json", "application/xml" })
	public @ResponseBody String getStateBySsn(@PathVariable("ssn") String ssn) throws JsonProcessingException {
		String stateName = null;
		logger.debug("***** RestController:: getStateBySsn Method Started ******");
		try {
			logger.debug("***** RestController:: getStateBySsn Method Execution Started ******");
			stateName = service.findStateBySsn(Long.parseLong(ssn));
			// ObjectMapper mapper=new ObjectMapper();
			logger.debug("***** RestController:: getStateBySsn Method Ended ******");
			logger.debug("***** RestController:: getStateBySsn Method Execution Ended ******");

		} catch (Exception e) {
			logger.debug("***** RestController:: Some Problem Raised in getStateBySsn Method Execution Failed ******");
			throw new SsaAppRestException();
		}
		// return mapper.writeValueAsString(stateName);
		logger.debug("***** RestController:: getStateBySsn Method Execution Ended Sucessfully ******");

		return stateName;

	}
}