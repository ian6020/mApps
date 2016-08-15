package com.mapps.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppBean {
	
	@Value("${dbLogger}")
	private Integer dbLogger;

	public Integer getDbLogger() {
		return dbLogger;
	}
	public void setDbLogger(Integer dbLogger) {
		this.dbLogger = dbLogger;
	}
	
}
