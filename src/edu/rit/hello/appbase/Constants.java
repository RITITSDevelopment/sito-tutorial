package edu.rit.hello.appbase;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

/** 
* This class contains constaints used by the application
*
* @author jssisd
*/
public final class Constants {
	/**
	 * The package name for this application.
	 */
	public static final String Package = "appbase";
	
	@Autowired
	private HelloTutorial appInstance;
	
	private static HelloTutorial staticApp;
	
	@PostConstruct
	public void init() {
		Constants.staticApp = appInstance;
	}
	
	/**
	 * Get constant from the application
	 * 
	 * @return value
	 */
	public  Object getValue( String key) {
		return appInstance.getConstant(key);
	}

	/**
	 * Get constant (as a String) from the application
	 * 
	 * @return value
	 */
	public static String getString( String key) {
  	 	return (String) staticApp.getConstant(key);
	}

	public String getBaseURL() {
		return Constants.getString("app.url");
	}
}