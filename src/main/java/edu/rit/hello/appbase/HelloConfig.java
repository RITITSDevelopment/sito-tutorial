package edu.rit.hello.appbase;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
	protected static Logger logger = Logger.getLogger(HelloConfig.class);
	
	@Bean
	public HelloTutorial appInstance() {
		logger.info("Registering HelloTutorial Bean");
		return new HelloTutorial();
	}
		
}
