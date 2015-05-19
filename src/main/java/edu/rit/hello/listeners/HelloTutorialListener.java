package edu.rit.hello.listeners;

import org.apache.log4j.Logger;

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
		/* This will grab a bean from the applicaton context
		 * This is not the recommended way, but is the only known way
		 * Of Accessing beans in the start up listener
		 */
		//WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(super.context);
		//HelloTutorial appInstance = springContext.getBean(HelloTutorial.class);
	}

	/**
	 * Runs on shutdown to perform any necessary actions
	 */
	public void shutdown() {
		logger.info("Shutting down...");
	}
}