package com.GDP.test.dao;

import java.util.List;

import com.GDP.test.model.Event;

public interface EventDAO {

	public Event createAnEvent(Event newevent, String useremail);
	public void deleteAnEvent(String eventName);
	public List<Event> getPCEvents(String useremail);
	public List<Event> getAuthorEvents(String useremail);
}
