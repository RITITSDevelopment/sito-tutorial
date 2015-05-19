package edu.rit.hello;

import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import edu.rit.hello.listeners.HelloTutorialListener;
import edu.rit.hello.appbase.HelloConfig;

public class WebInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		application.sources(HelloConfig.class);	
		return application;    	
	}
	
	@Override
	public void onStartup(ServletContext ctx) throws ServletException{
		ctx.addListener(new HelloTutorialListener());
		super.onStartup(ctx);
	}
}
