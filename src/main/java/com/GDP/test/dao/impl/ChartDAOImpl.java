package com.GDP.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.GDP.test.dao.ChartDAO;
import com.GDP.test.model.Chart;
import com.GDP.test.model.EventAnalytics;




//public class ChartDAOImpl extends HibernateDaoSupport implements ChartDAO {
public class ChartDAOImpl implements ChartDAO {
	
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	@Transactional
	public EventAnalytics getAllData(String eventName) {
		
		Long unassigned = (Long) sf.getCurrentSession().createQuery("select Count(status) from Paper where eventName= '" + eventName + "' and status= 'unassigned'  ").uniqueResult();
		Long assigned = (Long) sf.getCurrentSession().createQuery("select Count(status) from Paper where eventName= '" + eventName + "' and status= 'assigned'  ").uniqueResult();;
		Long reviewInProgress = (Long) sf.getCurrentSession().createQuery("select Count(status) from Paper where eventName= '" + eventName + "' and status= 'reviews in progress'  ").uniqueResult();;
		Long reviewCompleted = (Long) sf.getCurrentSession().createQuery("select Count(status) from Paper where eventName= '" + eventName + "' and status= 'reviews completed'  ").uniqueResult();;

		return new EventAnalytics(unassigned, assigned, reviewInProgress, reviewCompleted);
		
	}

}
