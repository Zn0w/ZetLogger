package com.znow.zetlogger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZetLogger {
	
	private String className = "";
	private ZetLoggerConfigurator configurator = null;
	
	public ZetLogger(String configFilePath, String className) {
		this.className = className;
		
		configurator = new ZetLoggerConfigurator(configFilePath);
	}
	
	public void info(String info) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String logEntry = dateFormat.format(date) + "  INFO     " + className + " - " + info;
		
		if (configurator.isConsoleOutputEnabled()) {
			System.out.println(dateFormat.format(date) + "  INFO     " + className + " - " + info);
		}
	}
	
	public void trace(String info) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String logEntry = dateFormat.format(date) + "  TRACE    " + className + " - " + info;
		
		if (configurator.isConsoleOutputEnabled()) {
			System.out.println(dateFormat.format(date) + "  TRACE    " + className + " - " + info);
		}
	}
	
	public void warn(String info) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String logEntry = dateFormat.format(date) + "  WARNING  " + className + " - " + info;
		
		if (configurator.isConsoleOutputEnabled()) {
			System.out.println(dateFormat.format(date) + "  WARNING  " + className + " - " + info);
		}
	}
	
	public void error(String info) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String logEntry = dateFormat.format(date) + "  ERROR    " + className + " - " + info;
		
		if (configurator.isConsoleOutputEnabled()) {
			System.out.println(dateFormat.format(date) + "  ERROR    " + className + " - " + info);
		}
	}
	
	private void saveToFile(String filePath) {
		
	}
	
}
