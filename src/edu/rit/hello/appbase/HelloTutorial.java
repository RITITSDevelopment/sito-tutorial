package edu.rit.hello.appbase;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import edu.rit.webapps.api.ApplicationBase;

/**
 * EwaSample
 * 
 * This class extends RIT's custom API used to manage application wide configuration
 * 
 * To access system wide resources, first get a reference to this application base:
 * TeamBuilder.getInstance()
 * 
 * @author arfisd
 */

//@Component
public class HelloTutorial extends ApplicationBase {
	
	protected static Logger logger = Logger.getLogger( HelloTutorial.class );
	
	// This single instance of "HelloStruts" will be used across the entire application
	//@Autowired
	private HelloTutorial appInstance;

	public String greeting = "Hello There";

	private static HelloTutorial staticApp;
	
	@PostConstruct
	public void init() {
		HelloTutorial.staticApp = appInstance;
	}
	
	/**
	 * Creates an instance of HelloStruts
	 */
	//public HelloTutorial() {
	//	logger.info("Created ApplicationBase Bean");
	//}
	
	/**
	 * Get the single instance of HelloStruts
	 *
	 * @return instance
	 */
	//public static HelloTutorial getInstance() {
	//	return instance;
	//}

	/**
	 * Gets the base URL at which this application is hosted
	 *
	 * @return BASE_URL
	 */
	public static String getBaseURL() {
		return (String) staticApp.getConstant( "BASE_URL" );
	}

	/**
	 * Gets the URL at which icons are hosted
	 * 
	 * @return BASE_ICON_URL
	 */
	public static String getBaseIconURL() {
		return (String) staticApp.getConstant( "BASE_ICON_URL" );
	}
}
