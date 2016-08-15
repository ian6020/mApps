package com.mapps.controllers.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

@RestController
public class HomeController {

	@RequestMapping("/login")
	public @ResponseBody ResponseStatus login(
			@RequestParam String user, @RequestParam String password) {
		return new ResponseStatus(Status.SUCCESS, Code.VALID, "Login successful");
	}
	
	@RequestMapping(value="/signup")
	public @ResponseBody ResponseStatus foo() {
		return new ResponseStatus(Status.SUCCESS, Code.VALID, "Signup successful");
	}
}
