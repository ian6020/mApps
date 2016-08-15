package com.mapps.controllers.base;

import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.context.MessageSource;



public abstract class BaseController {
	
	@Resource
	private MessageSource messageSource;
	
	protected String getDBMessage(String key, Locale locale) {
		String msg = messageSource.getMessage("system.db.save.error", null, 
				"Error in saving to database", locale);
		if(key == null) return msg;
		else return messageSource.getMessage(key, null, key, locale);
	}
}
