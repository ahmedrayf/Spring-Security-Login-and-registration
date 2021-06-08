package com.example.loginExample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.loginExample.model.User;
import com.example.loginExample.service.UserService;

@Controller
public class AuthenticationController {
	@Autowired
	UserService userService;
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {

		ModelAndView modelAndView = new ModelAndView();

		// check validation
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("alert", "Ther's error ,please check the form");
			modelMap.addAttribute("bindingresult", bindingResult);
		}

		else if(userService.isUserAlreadyPresent(user)) {
			modelAndView.addObject("alert", "The user already exist");
		}
		else {
			userService.saveUser(user);
			modelAndView.addObject("alert", "User is registereted successfully");
		}
		modelAndView.addObject("user" , new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}

}
