package com.ssa.federal.gov.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class SsaAppExceptionHandler {

	@ExceptionHandler(value = { CustomExceptionHandler.class })
	public String globleExceptionHandle(Model model) {
		model.addAttribute("errMsg", "Something is Wrong! Try After Some Time .........!");
		return "error";
	}
	
}
