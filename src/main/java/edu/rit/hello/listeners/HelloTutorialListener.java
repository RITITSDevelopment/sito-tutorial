package edu.rit.hello.listeners;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.rit.hello.appbase.HelloTutorial;

/**
 * An extension of the startup listener to load HelloTutorial specific
 * constants and variables.
 * 
 * @author sito
 */
public class HelloTutorialListener extends StartupListener{
	static Logger logger = Logger.getLogger( HelloTutorialListener.class );

	/**
	 * Runs on startup and retrieves any properties files and constants
	 */
	public void startup() {
		logger.info("Starting HelloTutorial Listener");
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(super.context);
		HelloTutorial appInstance = springContext.getBean(HelloTutorial.class);

		appInstance.setConstantsFile("sitoSandbox.properties");
		appInstance.loadConstants();
		
		@SuppressWarnings("unchecked")
		Hashtable<String, String> constantsTable = appInstance.getConstantsTable();

		logger.info("Showing Constants");
		showConstants(constantsTable);
		logger.info("Done Showing Constants");
	}

	/**
	 * Runs on shutdown to perform any necessary actions
	 */
	public void shutdown() {
		logger.info("Shutting down...");
	}
}