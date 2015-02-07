package edu.rit.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import edu.rit.hello.listeners.HelloTutorialListener;
import edu.rit.hello.appbase.HelloTutorial;
//import edu.rit.hello.appbase.HelloTutConfig;
import edu.rit.hello.appbase.Main;

public class WebInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Main.class);	    	
	}
	
	@Override
	public void onStartup(ServletContext ctx) throws ServletException{
		ctx.addListener(new HelloTutorialListener());
		super.onStartup(ctx);
	}
}
