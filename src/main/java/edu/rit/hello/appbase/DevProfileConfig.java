package edu.rit.hello.appbase;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:dev.properties")
public class DevProfileConfig {

	private static Logger logger = Logger.getLogger(DevProfileConfig.class);
	
	public DevProfileConfig() {
		logger.info("Adding Dev properties");
		logger.info("");
	}
}
