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
					if (elements[1].equals("console")) {
						consoleOutputEnabled = true;
						saveToFileEnabled = false;
					} 
					else if (elements[1].equals("file")) {
						consoleOutputEnabled = false;
						saveToFileEnabled = true;
					} 
					else if (elements[1].equals("both")) {
						consoleOutputEnabled = true;
						saveToFileEnabled = true;
					} 
					else {
						System.out.println("'"+elements[1]+"' target option doesn't exist");
					}
				}
				else if (elements[0].equals("file")) {
					logFilePath = elements[1];
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

	protected String getLogFilePath() {
		return logFilePath;
	}

	protected boolean isConsoleOutputEnabled() {
		return consoleOutputEnabled;
	}

	protected boolean isSaveToFileEnabled() {
		return saveToFileEnabled;
	}
	
}
