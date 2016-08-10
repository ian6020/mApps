package com.mapps.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppBean {
	
	@Value("${port}")
	private Integer port;
	
	@Value("${dbLogger}")
	private Integer dbLogger;
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getDbLogger() {
		return dbLogger;
	}
	public void setDbLogger(Integer dbLogger) {
		this.dbLogger = dbLogger;
	}
	
}
