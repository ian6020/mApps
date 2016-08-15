package com.mapps.controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapps.controllers.base.BaseController;
import com.mapps.controllers.base.ResponseObject;
import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

@RestController
public class HelloController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	//@RequestMapping("/resource")
	public @ResponseBody ResponseObject home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello Todays World");
		ResponseObject obj =  new ResponseObject(Status.SUCCESS, Code.VALID, "Login successful");
		obj.setObject(model);
		
		return obj;
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		if(user == null) logger.warn("Principal is NULL");
		return user;
	}
	
	@RequestMapping("/token")
	public @ResponseBody Map<String,String> token(HttpSession session) {
		return Collections.singletonMap("token", session.getId());
	}
}
