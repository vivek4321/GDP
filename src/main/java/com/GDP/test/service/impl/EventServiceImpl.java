package com.GDP.test.service.impl;

import java.util.List;

import com.GDP.test.dao.EventDAO;
import com.GDP.test.model.Event;
import com.GDP.test.service.EventService;

public class EventServiceImpl implements EventService {

	EventDAO eventdaoimpl;
	

	public void setEventdaoimpl(EventDAO eventdaoimpl) {
		this.eventdaoimpl = eventdaoimpl;
	}


	
	//*********************************  IMPLEMENTED METHODS    *********************************
	
	@Override
	public Event createAnEvent(Event newevent, String useremail) {
		eventdaoimpl.createAnEvent(newevent, useremail);
		return newevent;
	}



	@Override
	public void deleteAnEvent(String eventName) {
		eventdaoimpl.deleteAnEvent(eventName);		
	}



	@Override
	public List<Event> getPCEvents(String useremail) {
		return eventdaoimpl.getPCEvents(useremail);
	}



	@Override
	public List<Event> getAuthorEvents(String useremail) {		
		return eventdaoimpl.getAuthorEvents(useremail);
	}

}
