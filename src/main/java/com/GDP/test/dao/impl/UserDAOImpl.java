package com.GDP.test.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.GDP.test.SendAnEmailThread;
import com.GDP.test.ForgotPasswordEmailThread;
import com.GDP.test.dao.UserDAO;
import com.GDP.test.model.Paper;
import com.GDP.test.model.User;


public class UserDAOImpl  implements UserDAO{
//public class UserDAOImpl extends HibernateDaoSupport  implements UserDAO{
	
	
//*****************  NOT NEEDED IF THIS CLASS EXTENDS HIBERNATEDAOSUPPORT ***************************	
//	private HibernateTemplate hibernateTemplate;
//	
//	public HibernateTemplate getHibernateTemplate() {
//		return hibernateTemplate;
//	}
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
//	*****************  NOT NEEDED IF THIS CLASS EXTENDS HIBERNATEDAOSUPPORT ***************************
	
	


	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}




	//*********************************  TO REGISTER AN USER ACCOUNT    *********************************	
	@Override
	@Transactional
	public void registerAnUser(User newuser) {		
		//getHibernateTemplate().save(newuser);		
	    Session session = sf.getCurrentSession();
	    session.save(newuser);

	}
		

	
	
	//*********************************  TO CHECK SIGN IN CREDENTIALS   *********************************
	@Override
	@Transactional
	public User signInCheck(String userName) {
//	    Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select e from User e where email='"+userName+"' and password='"+password+"'");
//	    return (User)q.uniqueResult();
//	    Query q = getHibernateTemplate().getSession().createQuery("from User");		
		
		Session session = sf.getCurrentSession();
		return (User) session.get(User.class, userName);
		//return getHibernateTemplate().get(User.class, userName);
	}




	@Override
	@Transactional
	public List<User> getAllUsers() {
		
		Session session = sf.getCurrentSession();
		Query q = session.createQuery("Select email from User where isReviewer = true");
		//List<User> list1 = q.list();
		return q.list();
		
//		List<Object> objects = getHibernateTemplate().find("Select email from User where isReviewer = true");				
//	    List<User> list = new ArrayList<User>();
//	    
//	    for(Object one : objects) {			
//		    User u = new User((String) one);
//		    list.add(u);
//		}	    	    
//		return  list; 
	}

	@Override
	@Transactional
	public String passwordRecovery(String email) {
//		Query q1 = sf.getCurrentSession().createQuery("select Count(email) from User where email= '" + user.getEmail() + "'  ");
//		long emailcount =  (long) q1.uniqueResult();
		User oldUSer = (User) sf.getCurrentSession().get(User.class, email);
		if(oldUSer == null){
			return "false" + "@@" + "";
		}
		else{
			ForgotPasswordEmailThread r = new ForgotPasswordEmailThread(oldUSer.getEmail(), oldUSer.getFirstName());
			Thread t = new Thread(r);
			t.start();
			return "true" + "@@" + oldUSer.getFirstName();

		}
		
		
		
//		if(emailcount==1){ 
//			return true;
//		}else{
//			return false;
//		}	
		
	}

	@Override
	@Transactional
	public void passwordReset(User user) {
		User oldUSer = (User) sf.getCurrentSession().get(User.class, user.getEmail());
		oldUSer.setPassword(user.getPassword());
		sf.getCurrentSession().saveOrUpdate(oldUSer);
	}

	
	
	@Override
	@Transactional
	public void verifyUser(String email, String token) {
		
		User userToBeActivated = (User) sf.getCurrentSession().get(User.class, email);
		if(userToBeActivated.getVerificationStatus().equals(token)){
			userToBeActivated.setVerificationStatus("verified");
			sf.getCurrentSession().saveOrUpdate(userToBeActivated);
		}
	}

	@Override
	@Transactional
	public boolean existingUserCheck(String email) {
		User oldUSer = (User) sf.getCurrentSession().get(User.class, email);
		if(oldUSer == null){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	
	
	
}
