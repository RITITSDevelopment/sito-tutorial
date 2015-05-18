package edu.rit.hello.appbase;

import org.apache.log4j.Logger;

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

public class HelloTutorial extends ApplicationBase {
	
	protected static Logger logger = Logger.getLogger( HelloTutorial.class );

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
		return (String) this.getConstant( "BASE_URL" );
	}

	/**
	 * Gets the URL at which icons are hosted
	 * 
	 * @return BASE_ICON_URL
	 */
	public String getBaseIconURL() {
		return (String) this.getConstant( "BASE_ICON_URL" );
	}
}
