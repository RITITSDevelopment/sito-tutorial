package edu.rit.hello.listeners;

import java.beans.Introspector;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * StartupListener
 * 
 * This abstract class provides the framework in which to build a "Start Up Listener"
 * 
 * The start up listener is responsible for all of the application specific setup 
 * needed before users can visit the application which includes tasks such as:
 * 
 * 1.) Reading property files to set application constants
 * 2.) Checking that outside resources, such as the database, are available
 * 3.) Sending automated communications to support staff that the application has (re)started
 * 4.) Starting up any processes that need to run in the background
 *
 * @author xxgisd, arfisd
 */
public abstract class StartupListener implements ServletContextListener {
	
	protected static Logger logger = Logger.getLogger("StartupListener");

	protected String basePath = null;

	protected ServletContext context = null;

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 * 
	 * This method is invoked when the Web Application has been removed 
	 * and is no longer able to accept requests
	 */
	public void contextDestroyed(ServletContextEvent event) {
		this.context = null;
		shutdown();
		logger.info("Flushing Cache");
		Introspector.flushCaches();
		logger.info("Cancellation complete");
	}

	/**
	 * This method is invoked when the Web Application has been removed 
	 * and is no longer able to accept requests
	 */
	public void shutdown() {
		
	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 * 
	 * This method is invoked when the Web Application
	 * is ready to service requests
	 */
	public void contextInitialized(ServletContextEvent event) {
		this.context = event.getServletContext();
		basePath = context.getRealPath("/WEB-INF/classes/");

		StringBuilder contextInitDetails = new StringBuilder();
		contextInitDetails.append("context initialized >> ");
		contextInitDetails.append("ServerInfo[" + context.getServerInfo() + "] ");
		contextInitDetails.append("ContextName[" + context.getServletContextName() + "] ");
		contextInitDetails.append("basePath[" + basePath + "] ");
		
		logger.info(contextInitDetails.toString());

		startup();
	}

	/**
	 * This method will be run when the listener is initialized;
	 * sub-classes will need to implement this method in order to 
	 * handle application specific start-up tasks
	 */
	public abstract void startup();

	/**
	 * Gets the base path at which all class files (and various other resources)
	 * can be found in the application server's file system
	 *
	 * @return basePath
	 */
	public String getBasePath() {
		return basePath;
	}
	
	/**
	 * Shows basic information about the application
	 */
	protected void showAttributes() {
		Enumeration<?> attributes = context.getAttributeNames();
		String attrName;
		while (attributes.hasMoreElements()) {
			attrName = (String) attributes.nextElement();
			logger.info("ContextAttribute[" + attrName + "][" + context.getAttribute(attrName) + "]");
		}

		attributes = context.getInitParameterNames();
		while (attributes.hasMoreElements()) {
			attrName = (String) attributes.nextElement();
			logger.info("InitParameter[" + attrName + "][" + context.getInitParameter(attrName) + "]");
		}
	}
}