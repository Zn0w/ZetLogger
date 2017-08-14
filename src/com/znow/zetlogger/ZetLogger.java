package com.znow.zetlogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
		if (configurator.getPrioritiesContainer().getInfoPriority()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String logEntry = dateFormat.format(date) + "  INFO     " + className + " - " + info;
			
			if (configurator.isConsoleOutputEnabled()) {
				System.out.println(logEntry);
			}
			
			if (configurator.isSaveToFileEnabled()) {
				saveToFile(configurator.getLogFilePath(), logEntry);
			}
		}
		else {
			return;
		}
	}
	
	public void trace(String info) {
		if (configurator.getPrioritiesContainer().getTracePriority()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String logEntry = dateFormat.format(date) + "  TRACE    " + className + " - " + info;
			
			if (configurator.isConsoleOutputEnabled()) {
				System.out.println(logEntry);
			}
			
			if (configurator.isSaveToFileEnabled()) {
				saveToFile(configurator.getLogFilePath(), logEntry);
			}
		}
		else {
			return;
		}
	}
	
	public void warn(String info) {	
		if (configurator.getPrioritiesContainer().getWarningPriority()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String logEntry = dateFormat.format(date) + "  WARNING  " + className + " - " + info;
			
			if (configurator.isConsoleOutputEnabled()) {
				System.out.println(logEntry);
			}
			
			if (configurator.isSaveToFileEnabled()) {
				saveToFile(configurator.getLogFilePath(), logEntry);
			}
		}
		else {
			return;
		}
	}
	
	public void error(String info) {
		if (configurator.getPrioritiesContainer().getErrorPriority()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String logEntry = dateFormat.format(date) + "  ERROR    " + className + " - " + info;
			
			if (configurator.isConsoleOutputEnabled()) {
				System.out.println(logEntry);
			}
			
			if (configurator.isSaveToFileEnabled()) {
				saveToFile(configurator.getLogFilePath(), logEntry);
			}
		}
		else {
			return;
		}
	}
	
	private void saveToFile(String filePath, String logEntry) {
		FileWriter fw = null;
		BufferedWriter writer = null;
		
		try {
			fw = new FileWriter(filePath, true);
			
			writer = new BufferedWriter(fw);
			
			writer.write(logEntry);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (writer != null)
						writer.close();
					
					if (fw != null)
						fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}
