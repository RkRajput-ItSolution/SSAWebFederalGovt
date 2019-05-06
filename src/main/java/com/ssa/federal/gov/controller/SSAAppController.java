package com.ssa.federal.gov.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssa.federal.gov.exception.CustomExceptionHandler;
import com.ssa.federal.gov.model.SSAAppModel;
import com.ssa.federal.gov.properties.SSAAppProperties;
import com.ssa.federal.gov.service.SSAAppService;

@Controller
public class SSAAppController {
	private static final Logger logger = LoggerFactory.getLogger(SSAAppController.class);
	@Autowired
	private SSAAppService service;

	@Autowired
	private SSAAppProperties aapProps;

	public SSAAppController() {
		System.out.println("SSAAppController 0-param Constructor");
	}

	/**
	 * This handler method display the home page for registration form.
	 * 
	 * @param ssnModel
	 * @param model
	 * @return
	 * @throws CustomExceptionHandler
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)

	public String showForm(@Valid @ModelAttribute("ssnModel") SSAAppModel ssnModel, BindingResult result, Model model)
			throws CustomExceptionHandler {

		try {
			/*
			 * String a = null; a.length();
			 */
			// int a=10/0;
			refrenceForm(model);

		} catch (Exception e) {
			throw new CustomExceptionHandler("Some Problem Occured Try Again....!!");

		}
		return "registration_ssn";
	}

	/**
	 * This handler method display the success page with ssn number
	 * 
	 * @param ssnModel
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = { "/registration_ssn" }, method = RequestMethod.POST)
	public String enrollForSSNForm(@Valid @ModelAttribute("ssnModel") SSAAppModel ssnModel, BindingResult result,
			Model model) throws Exception {
		Map<String, String> propsMap = aapProps.getSssProps();
		logger.info("***** Controller Class Method  Entered *****");
		logger.debug("***** SSAController:: enrollForSSNForm() method called*****::>", ssnModel);
		/*
		 * String a = null; a.length();
		 */
		try {

			if (result.hasErrors()) {
				return "registration_ssn";
			}

			long ssn = service.SsaEnrollment(ssnModel);
			if (ssn != 0 && ssn > 0) {
				model.addAttribute("enrollSuccess", propsMap.get("enrollSuccess") + " " + ssn);
				logger.debug("***** SSAController:: enrollForSSNForm() Success *****");
			}

			else {
				// fail msg
				model.addAttribute("enrollFailure", propsMap.get("enrollFail"));
				logger.warn("***** SSAController:: enrollForSSNForm() Failure*****");
			}

			logger.debug("***** SSAController:: enrollForSSNForm() method ended*****");
			
			logger.info("***** SSAController:: Enrollment form generated successful*****");

			model.addAttribute("ssnNo", ssn);
		} catch (Exception e) {
			logger.error("***** SSAController::Occured Problem in enrollForSSNForm() method *****");
			throw new CustomExceptionHandler("Some Problem Occured Try Again....!!");

		}
		// remove old form data
		ssnModel = null;
		model.addAttribute("ssnModel", new SSAAppModel());
		refrenceForm(model);
		return "registration_ssn";
	}

	/**
	 * This handler method is useful for show all records of ssa application in jsp
	 * by using lvn(report_ssn)
	 * 
	 * @param ssnModel
	 * @param model
	 * @return
	 * @throws CustomExceptionHandler
	 */
	@RequestMapping(value = "/report")
	public String showAllSsaRecords(@ModelAttribute("ssnModel") SSAAppModel ssnModel, BindingResult result, Model model)
			throws CustomExceptionHandler {

		logger.debug("***** SSAController:: showAllSsaRecords() method Started*****::>", ssnModel);
		try {
			List<SSAAppModel> listModel = null;

			// use SErvice
			listModel = service.retriveAllSsnRecord();
			model.addAttribute("listModels", listModel);
			logger.debug("***** SSAController:: enrollForSSNForm() Ended *****");
			logger.debug("***** SSAController:: enrollForSSNForm() Success *****");
		}

		catch (Exception e) {
			logger.error("***** SSAController::Some Problem Occured in enrollForSSNForm() method . *****");
			throw new CustomExceptionHandler("Some Problem Occured Try Again....!!");

		}
		logger.error("***** SSAController::enrollForSSNForm() method SuccessFully Executed. *****");
		return "report_ssn";

	}

	/*
	 * @ExceptionHandler(value= {ArithmeticException.class}) public String
	 * handleAE(Model model) { model.addAttribute("errMsg", "AE:Please Try Again.");
	 * return "error";
	 * 
	 * }
	 */
	private void refrenceForm(Model model) {
		// List<SSAAppModel> statesList = service.getAllStateByNames();
		List<String> stateNames = service.getAllStatesNames();
		/**
		 * Add State List by using List collection and add in model Attribute
		 */
		// List<String> stList = new ArrayList<>();
		/*
		 * stList.add("Alabama"); stList.add("Alaska"); stList.add("Arizona");
		 * stList.add("Arkansas"); stList.add("California"); stList.add("Colorado");
		 * stList.add("Connecticut"); stList.add("Delaware"); stList.add("Florida");
		 * stList.add("Georgia"); stList.add("Hawaii"); stList.add("Idaho");
		 * stList.add("Illinois"); stList.add("Indiana"); stList.add("Iowa");
		 * stList.add("Kansas"); stList.add("Kentucky"); stList.add("Louisiana");
		 * stList.add("Maine"); stList.add("Maryland"); stList.add("Massachusetts");
		 * stList.add("Michigan"); stList.add("Minnesota"); stList.add("Mississippi");
		 * stList.add("Missouri"); stList.add("Montana"); stList.add("Nebraska");
		 * stList.add("Nevada"); stList.add("New Hampshire"); stList.add("New Jersey");
		 * stList.add("New Mexico"); stList.add("New York");
		 * stList.add("North Carolina"); stList.add("North Dakota"); stList.add("Ohio");
		 * stList.add("Oklahoma"); stList.add("Oregon"); stList.add("Pennsylvania");
		 * stList.add("Rhode Island"); stList.add("South Carolina");
		 * stList.add("South Dakota"); stList.add("Tennessee"); stList.add("Texas");
		 * stList.add("Utah"); stList.add("Vermont"); stList.add("Virginia");
		 * stList.add("Washington"); stList.add("West Virginia");
		 * stList.add("Wisconsin"); stList.add("Wyoming");
		 */

		model.addAttribute("statesList", stateNames);

		// add gender reference method
		List<String> gendersList = new ArrayList<>();
		gendersList.add("Male");
		gendersList.add("Fe-Male");
		model.addAttribute("gendersList", gendersList);
	}

	/*
	 * @GetMapping("/redirectWithRedirectAttributes") public RedirectView
	 * redirectWithRedirectAttributes(RedirectAttributes attributes) {
	 * 
	 * attributes.addFlashAttribute("flashAttribute",
	 * "redirectWithRedirectAttributes"); attributes.addAttribute("attribute",
	 * "redirectWithRedirectAttributes"); return new RedirectView("redirectedUrl");
	 * }
	 */
}
