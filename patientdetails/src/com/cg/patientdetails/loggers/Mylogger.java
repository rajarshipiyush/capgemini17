package com.cg.patientdetails.loggers;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Mylogger {
	
	static Logger logger = Logger.getLogger(Mylogger.class);
	
	static
	{
		Layout layout = new SimpleLayout();
		Appender appender = null;
		try
		{
			appender = new FileAppender(layout, "log.txt");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		logger.addAppender(appender);
		
		
	}
	
	public static Logger getLoggerInstance()
	{
		return logger;
	}

}
