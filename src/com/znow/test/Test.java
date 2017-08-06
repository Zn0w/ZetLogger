package com.znow.test;

import com.znow.zetlogger.ZetLogger;

public class Test {

	private static ZetLogger logger = new ZetLogger("D://ZetLoggerTest/config.txt", "Test");
	
	public void go() {
		logger.info("Run method go");
		logger.trace("Method go is running");
		logger.warn("Data owerflow");
		logger.error("Method go has stopped with error 1549");
	}

}
