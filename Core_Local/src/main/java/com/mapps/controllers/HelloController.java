package com.mapps.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapps.controllers.base.BaseController;
import com.mapps.controllers.base.ResponseObject;
import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

@RestController
public class HelloController extends BaseController {
	
	@RequestMapping("/")
	@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders={"x-auth-token", "x-requested-with"})
	public @ResponseBody ResponseObject resource() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello Todays World");
		ResponseObject obj =  new ResponseObject(Status.SUCCESS, Code.VALID, "Login successful");
		obj.setObject(model);
	
		return obj;
	}
	
}
