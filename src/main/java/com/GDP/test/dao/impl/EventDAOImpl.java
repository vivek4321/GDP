package com.GDP.test.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.GDP.test.dao.EventDAO;
import com.GDP.test.model.Event;
import com.GDP.test.model.Paper;
import com.GDP.test.model.User;

//public class EventDAOImpl extends HibernateDaoSupport implements EventDAO {
public class EventDAOImpl implements EventDAO {	

	
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
//*********************************  IMPLEMENTED METHODS    ******************************************
	
	@Override
	@Transactional
	public Event createAnEvent(Event newevent, String useremail) {
		 
		 Session session = sf.getCurrentSession();			 
		 session.save(newevent);
		 return newevent;
	}
	



	@Override
	@Transactional
	public List<Event> getPCEvents(String useremail) {
		
		//String id = useremail + ".com";
		String id = useremail.replace("*****", ".");
		Session session = sf.getCurrentSession();
		Query q = session.createQuery("Select new Event(eventID, eventName) from Event where createdBy ='"+ id +"'  ");
		return q.list();
	}
	
	
	@Override
	@Transactional
	public List<Event> getAuthorEvents(String useremail) {
		String id = useremail.replace("*****", ".");
		Session session = sf.getCurrentSession();
		Query q = session.createQuery("Select new Event(eventID, eventName) from Event where createdBy != '"+ id +"'  ");
		return q.list();
	}
	

	@Override
	@Transactional
	public void deleteAnEvent(String eventName) {
	    Session session = sf.getCurrentSession();
	    Event eve = (Event) session.get(Event.class, eventName);
	    session.delete(eve);

//	    Event eve = (Event) getHibernateTemplate().get(Event.class, eventName);
//		getHibernateTemplate().delete(eve);
	}



}
