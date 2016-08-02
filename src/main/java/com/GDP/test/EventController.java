package com.GDP.test;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GDP.test.model.Event;
import com.GDP.test.service.EventService;
import com.GDP.test.service.UserService;


@RestController
public class EventController {


	@Autowired
	private EventService eventservice;
	
	@Autowired
	private UserService userservice;
	
	
	
	@RequestMapping(value = "/createanevent/{useremail}", method = RequestMethod.POST)
	public @ResponseBody Event submitEvent(@RequestBody Event newevent, @PathVariable String useremail, HttpSession session) {
	//public Event submitEvent(@RequestBody Event newevent, , @PathVariable String useremail) {
				
		//newevent.setCreatedBy(useremail + ".com");
		
	
		if(session.getAttribute("User") != null){
			newevent.setCreatedBy(useremail.replace("*****", "."));		
			return eventservice.createAnEvent(newevent, useremail);
		}else{
			return null;
		}
	}
	

		
	
	@RequestMapping(value = "pceventslist/{useremail}", method = RequestMethod.GET)
	public @ResponseBody List<Event> getEvents(@PathVariable String useremail, HttpSession session) {	
		
//		if(session.getAttribute("User") != null){
			List<Event> eventsList = null; 
			try { 
				eventsList = eventservice.getPCEvents(useremail);		 
			 } catch (Exception e) {
				e.printStackTrace(); 
			 }
			return eventsList;
//		}
//		else{		
//			return null;
//		}
	}
	
	
	
	
	@RequestMapping(value = "authoreventslist/{useremail}", method = RequestMethod.GET)
	public @ResponseBody List<Event> getEventsForAuthor(@PathVariable String useremail, HttpSession session) {	
		
		
//		if(session.getAttribute("User") != null){
			List<Event> eventsList = null; 
			try { 
				eventsList = eventservice.getAuthorEvents(useremail);		 
			 } catch (Exception e) {
				e.printStackTrace(); 
			 }
			return eventsList;
//		}
//		else{		
//			return null;
//		}
	}
	
	
	
	
	
	@RequestMapping(value = "/deleteEvent/{eventName}", method = RequestMethod.DELETE)
    public String DeleteAnEvent(@PathVariable("eventName") String eventName) { 		
                                  
            eventservice.deleteAnEvent(eventName);   
            return "Event " +eventName+ " has been deleted";
    }
	
	


	
	
}






