package edu.rit.hello.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rit.hello.appbase.HelloTutorial;
import edu.rit.hello.models.Metar;
import edu.rit.hello.models.User;

/**
 * This Controller acts as a gateway to the applications objects
 * 
 * @author cteisd
 */
@RestController
@RequestMapping(value="services")
class WebServiceController {
	
	protected Logger logger = Logger.getLogger(WebServiceController.class);
	
	@Autowired public HelloTutorial appBase;
	
	@Value("use_proxy") String use_proxy;
	
	/**
	 * This function maps to the /ajax url. Returns a user object in JSON form
	 * 
	 * @return new User
	 */
	@RequestMapping(value="ajax", method=RequestMethod.GET)
	public User ajax() {
		return new User("Clark", "Kent", "Reporter");
	}
	
	@RequestMapping(value="displayList", method=RequestMethod.GET)
	public ArrayList<User> displayList() {
		ArrayList<User> users = new ArrayList<User>(3);
		users.add(new User("Frank", "Castle", "FBI Agent"));
		users.add(new User("Tony", "Stark", "Stark Industries CEO"));
		users.add(new User("Bruce", "Wayne", "Wayne Enterprises CEO"));
		return users;
	}
	
	@RequestMapping(value="displayUser", method=RequestMethod.GET)
	public User displayUser(
			@RequestParam(value="firstName", defaultValue="Joe") String fName,
			@RequestParam(value="lastName", defaultValue="Smith") String lName,
			@RequestParam(value="occupation", defaultValue="Historian") String occupation
			) {
		return new User(fName, lName, occupation);
	}
	
	@RequestMapping(value="metar", method=RequestMethod.GET)
	public Metar getMetar(@RequestParam(value="location") String location) {
		logger.info(use_proxy);
		return Metar.getMetarData(location, use_proxy);
	}
}
