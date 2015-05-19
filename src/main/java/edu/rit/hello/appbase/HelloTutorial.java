package edu.rit.hello.appbase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

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

public class HelloTutorial {
	
	protected static Logger logger = Logger.getLogger( HelloTutorial.class );

	@Value("BASE_URL") String base;
	
	/**
	 * Creates an instance of HelloStruts
	 */
	public HelloTutorial() {}

	/**
	 * Gets the base URL at which this application is hosted
	 *
	 * @return BASE_URL
	 */
	public String getBaseURL() {
		return base;
	}
}
