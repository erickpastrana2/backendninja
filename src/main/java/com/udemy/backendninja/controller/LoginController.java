package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);


	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOS: showLoginForm() --PARAMS: error=" + error + ", logout:" + logout);
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		LOG.info("returning to login View");
		return ViewConstant.LOGIN;
	}

	@GetMapping({"/loginsuccess","/"})
	public String loginCheck() {
		LOG.info("METHOS: loginCheck()");
		LOG.info("returning to contacts View");
		return "redirect:/contacts/showcontacts";

	}

}
