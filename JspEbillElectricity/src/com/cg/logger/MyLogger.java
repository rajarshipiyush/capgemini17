package com.cg.logger;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class MyLogger {
	
static Logger logger = Logger.getLogger(MyLogger.class);
	
	static
	{
		SimpleLayout layout = new SimpleLayout();
		try
		{
			FileAppender appender = new FileAppender(layout,"P:/servletjspClassDemo/jspbillelectricity.txt");
			logger.addAppender(appender);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static Logger getLoggerInstance()
	{
		return logger;
	}

}
