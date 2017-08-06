package com.znow.zetlogger;

public class ZetLogger {
	
	private String className = "";
	private ZetLoggerConfigurator configurator = null;
	
	public ZetLogger(String configFilePath, String className) {
		this.className = className;
		
		configurator = new ZetLoggerConfigurator(configFilePath);
	}
	
	public void info(String info) {
		
	}
	
	public void trace(String info) {
		
	}
	
	public void warn(String info) {
		
	}
	
	public void error(String info) {
		
	}
	
	private void saveToFile(String filePath) {
		
	}
	
}
