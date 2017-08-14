package com.znow.zetlogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ZetLoggerConfigurator {

	private String logFilePath = "";
	private boolean consoleOutputEnabled;
	private boolean saveToFileEnabled;
	
	private PrioritiesContainer priorities = new PrioritiesContainer();
	
	
	ZetLoggerConfigurator(String configFilePath) {
		getConfigurations(configFilePath);
	}
	
	private void getConfigurations(String configFilePath) {
		BufferedReader reader = null;
		
		try {
			File file = new File(configFilePath);
			
			reader = new BufferedReader(new FileReader(file));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] elements = line.split("#:#");
				
				if (elements[0].equals("target")) {
					getTargetConfig(elements[1]);
				}
				else if (elements[0].equals("file")) {
					logFilePath = elements[1];
				}
				else if (elements[0].equals("priority")) {
					getPriorityConfig(elements[1]);
				}
				else {
					System.out.println("'"+elements[0]+"' config key doesn't exist");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void getTargetConfig(String option) {
		if (option.equals("console")) {
			consoleOutputEnabled = true;
			saveToFileEnabled = false;
		} 
		else if (option.equals("file")) {
			consoleOutputEnabled = false;
			saveToFileEnabled = true;
		} 
		else if (option.equals("both")) {
			consoleOutputEnabled = true;
			saveToFileEnabled = true;
		} 
		else {
			System.out.println("'"+option+"' target option doesn't exist");
		}
	}
	
	private void getPriorityConfig(String options) {
		String[] prioritySettings = options.split(",");
		
		priorities.setPrioritiesCustomizable();
		
		for (String setting : prioritySettings) {
			if (setting.equals("info"))
				priorities.setInfoPriority(true);
			else if (setting.equals("trace"))
				priorities.setTracePriority(true);
			else if (setting.equals("warning"))
				priorities.setWarningPriority(true);
			else if (setting.equals("error"))
				priorities.setErrorPriority(true);
			else
				System.out.println("'"+setting+"' priority setting doesn't exist");
		}
	}

	protected String getLogFilePath() {
		return logFilePath;
	}

	protected boolean isConsoleOutputEnabled() {
		return consoleOutputEnabled;
	}

	protected boolean isSaveToFileEnabled() {
		return saveToFileEnabled;
	}
	
	protected PrioritiesContainer getPrioritiesContainer() {
		return priorities;
	}
	
}
