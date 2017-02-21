package com.resto.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.resto.model.message.Message;

/**
 * 
 * @author Munisekhar
 *
 */
@Controller
public class UserController {

	@RequestMapping(value = "/patient", method = {RequestMethod.POST, RequestMethod.GET})
	public String displayPatientHomePage() {
		return "patient";
	}

	@RequestMapping(value = "/provider", method = {RequestMethod.POST, RequestMethod.GET})
	public String displayProviderHomePage() {
		return "provider";
	}

	@RequestMapping(value = "/payer", method = {RequestMethod.POST, RequestMethod.GET})
	public String displayPayerHomePage() {
		return "payer";
	}

	@RequestMapping(value = "/ad", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView accessDenied(HttpServletRequest request) {
		String viewName = "403";
		if("json".equals(request.getParameter("t"))){
			viewName = "error403";
		}
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/error403", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Message error403(HttpServletRequest request) {
		return new Message.MessageBuilder().message("Access Denied").build();
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
