package com.GDP.test.dao.impl;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.GDP.test.PaperController.AuthorPapersFeedback;
import com.GDP.test.dao.PaperDAO;
import com.GDP.test.model.Event;
import com.GDP.test.model.Paper;
import com.GDP.test.model.ReviewerFeedback;
import com.GDP.test.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//public class PaperDAOImpl extends HibernateDaoSupport implements PaperDAO {
public class PaperDAOImpl implements PaperDAO {
	
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
	public void saveAPaper(Paper paper , int eventID, String userEmail) {	
		
		try{
			User user = new User();		
			user = (User) sf.getCurrentSession().get(User.class, userEmail);
			
			if(user.getUserPapers().size() == 0){
				user.setUserPapers(new ArrayList<Paper>());
				user.getUserPapers().add(paper);
			}else{
				List<Paper> userPapers = user.getUserPapers();
				userPapers.add(paper);
				user.setUserPapers(userPapers);
			}
			
											
			//user.getUserPapers().add(paper);
			
			List<Event> userEvents = user.getUserEvents();
			
			//userPapers.add(paper);
			//user.setUserPapers(userPapers);
			

			Event event = (Event) sf.getCurrentSession().get(Event.class, eventID);
			int c = 0;
			for(Event e1: userEvents){
				if(e1.getEventName().equals(event.getEventName())){
					c = 1;
					break;
				}
			}
			if(c==1){
				sf.getCurrentSession().saveOrUpdate(user);	
			}
			else{
				userEvents.add(event);
				user.setUserEvents(userEvents);						// error if a user submits an another paper to an event in the table users_events. i.e. We cant set the already existing event to the userEvents list.   
				//System.out.println("######################");
				sf.getCurrentSession().saveOrUpdate(user);
				List<User> eventUsers = event.getEventUsers();
				eventUsers.add(user);
				event.setEventUsers(eventUsers);
			}

//			userEvents.add(event);
//			user.setUserEvents(userEvents);						// error if a user submits an another paper to an event in the table users_events. i.e. We cant set the already existing event to the userEvents list.   
//			//System.out.println("######################");
//			sf.getCurrentSession().saveOrUpdate(user);	
		
			List<Paper> eventPapers = event.getEventPapers();
			eventPapers.add(paper);
			event.setEventPapers(eventPapers);
			//System.out.println("************************");
			sf.getCurrentSession().saveOrUpdate(event);
			
			
			
			
	/////   TO CHECK IF THE MAPPING WORKS PERFECT
			
			
//			Event eventTemp = (Event) sf.getCurrentSession().get(Event.class, eventID);
//			System.out.println("$$$$$$$$$$$$$$$");
//			List<User> eventUsers1 = eventTemp.getEventUsers();
//			for(User u : eventUsers1){
//				System.out.println(u.getEmail());
//			}
//			
//			User userTemp = (User) sf.getCurrentSession().get(User.class, userEmail);
//			System.out.println("###########");
//			List<Event> userEvents1 = userTemp.getUserEvents();
//			for(Event e: userEvents1){
//				System.out.println(e.getEventName());
//			}
//			
//			System.out.println("&&&&&&&&&&&&&&&&");
//			List<Paper> userPapers1 = userTemp.getUserPapers();
//			for(Paper p1: userPapers1){
//				System.out.println(p1.getPaperTitle());
//			}
//			
//			System.out.println("********************");
//			List<Paper> eventPapers1 = eventTemp.getEventPapers();
//			for(Paper p2 : eventPapers1){
//				System.out.println(p2.getPaperTitle());
//			}
		}catch(NullPointerException e){
			System.out.println("User is not there please login again");
		}catch(Exception e){
			System.out.println("User is not there please login again");
		}
		

		
		

	}
	

	@Override
	@Transactional
	public void updateAPaper(int paperID, Blob updatedBlob, String updatedDownloadName, String userEmail) {

		Paper paper = (Paper) sf.getCurrentSession().get(Paper.class, paperID);
		paper.setPaperDataFile(updatedBlob);
		paper.setPaperDownloadName(updatedDownloadName);
		paper.setStatus("unassigned");		
		paper.setStatusTracker(null);
		sf.getCurrentSession().saveOrUpdate(paper);
		
	}	
	
	
	@Override
	@Transactional
	public void modifyAPaper(int paperID, int eventID, String paperTitle, String eventName, String abstractOfThePaper,
			String userEmail) {
				

		User userTemp = (User) sf.getCurrentSession().get(User.class, userEmail);
		Event event = (Event) sf.getCurrentSession().get(Event.class, eventID);
		Paper paper = (Paper) sf.getCurrentSession().get(Paper.class, paperID);
		String oldEventName = paper.getEventName();
		Query q = sf.getCurrentSession().createQuery("select eventID from Event where eventName= '" + oldEventName + "'  ");
		int oldEventID = (Integer) q.uniqueResult();
		Event oldEvent = (Event) sf.getCurrentSession().get(Event.class, oldEventID);		
		Paper newPaper = new Paper(paperTitle, paper.getPaperDataFile(), abstractOfThePaper, "unassigned", paper.getPaperDownloadName(), eventName, userEmail);
		newPaper.setStatusTracker(null);
		
		
		List<Paper> oldUserPapers1 = userTemp.getUserPapers();
		for(Paper p1 : oldUserPapers1){
			if(p1.getPaperID() == paper.getPaperID()){
				oldUserPapers1.remove(p1);
				break;
			}
		}
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$");
//		for(Paper pp1 : oldUserPapers1){
//			System.out.println(pp1.getPaperTitle());
//		}
		
		
		
		
		
		List<Paper> oldEventPapers1 = oldEvent.getEventPapers();
		for(Paper p2 : oldEventPapers1){
			if(p2.getPaperID() == paper.getPaperID()){
				oldEventPapers1.remove(p2);
				break;
			}
		}
//		System.out.println("********************");
//		for(Paper pp2 : oldEventPapers1){
//			System.out.println(pp2.getPaperTitle());
//		}		
		sf.getCurrentSession().delete(paper);
		
		
		
		
		List<Event> userEvents1 = userTemp.getUserEvents();	
		List<User> oldEventUsers1 = oldEvent.getEventUsers();
		Query q1 = sf.getCurrentSession().createQuery("select Count(eventName) from Paper where eventName= '" + oldEvent.getEventName() + "' and author= '" + userEmail + "'  ");
		Long eventsCount1 =  (Long) q1.uniqueResult();
		if(eventsCount1 == 0){			
			for(Event e: userEvents1){
				if(e.getEventID() == oldEventID){
					userEvents1.remove(e);		
					break;
				}
			}
			for(User u : oldEventUsers1){
				if(u.getEmail().equals(userEmail)){
					oldEventUsers1.remove(u);
					break;
				}
			}	
		}
		
				
		
//		System.out.println("############");
//		for(Event ep : userEvents1){
//			System.out.println(ep.getEventName());
//		}
//		
//			
//		System.out.println("%%%%%%%%%%%%%%%%%%");
//		for(User up: oldEventUsers1){
//			System.out.println(up.getEmail());
//		}
		
		

		
		List<Paper> newUserPapers = userTemp.getUserPapers();		
		newUserPapers.add(newPaper);	
		userTemp.setUserPapers(newUserPapers);
		
		
		List<Paper> newEventPapers = event.getEventPapers();
		newEventPapers.add(newPaper);
		event.setEventPapers(newEventPapers);
				
		
		Query q2 = sf.getCurrentSession().createQuery("select Count(eventName) from Paper where eventName= '" + event.getEventName() + "' and author= '" + userEmail + "'  ");
		Long eventsCount2 =  (Long) q2.uniqueResult();
		if(eventsCount2 == 0){
			userEvents1.add(event);
			userTemp.setUserEvents(userEvents1);
			
			List<User> newEventUsers = event.getEventUsers();
			newEventUsers.add(userTemp);
			event.setEventUsers(newEventUsers);
		}

		sf.getCurrentSession().saveOrUpdate(userTemp);
		sf.getCurrentSession().saveOrUpdate(event);
		
	}

	
	
	
	@Override
	@Transactional
	public void deleteAPaper(int paperID, String userEmail) {
			    
	    Paper paperToRemove = (Paper) sf.getCurrentSession().get(Paper.class, paperID);
	    User userTemp = (User) sf.getCurrentSession().get(User.class, userEmail);
	    
	    Query q = sf.getCurrentSession().createQuery("select eventID from Event where eventName= '" + paperToRemove.getEventName() + "'  ");
		int oldEventID = (Integer) q.uniqueResult();
		Event oldEvent = (Event) sf.getCurrentSession().get(Event.class, oldEventID);
	    
	    List<Paper> oldUserPapers1 = userTemp.getUserPapers();
		for(Paper p1 : oldUserPapers1){
			if(p1.getPaperID() == paperID){
				oldUserPapers1.remove(p1);
				break;
			}
		}		
		
		
		List<Paper> oldEventPapers1 = oldEvent.getEventPapers();
		for(Paper p2 : oldEventPapers1){
			if(p2.getPaperID() == paperID){
				oldEventPapers1.remove(p2);
				break;
			}
		}
		sf.getCurrentSession().delete(paperToRemove);
	    
		
		
	    //to check if the user has any other papers submitted to the same event
		List<Event> oldUserEvents1 = userTemp.getUserEvents();
		List<User> oldEventUsers1 = oldEvent.getEventUsers();
		Query q1 = sf.getCurrentSession().createQuery("select Count(eventName) from Paper where eventName= '" + oldEvent.getEventName() + "' and author= '" + userEmail + "'  ");
		Long eventsCount =  (Long) q1.uniqueResult();
		if(eventsCount == 0){
			for(Event e: oldUserEvents1){
				if(e.getEventID() == oldEventID){
					oldUserEvents1.remove(e);		
					break;
				}
			}
			for(User u : oldEventUsers1){
				if(u.getEmail().equals(userEmail)){
					oldEventUsers1.remove(u);
					break;
				}
			}
		}
    

		sf.getCurrentSession().saveOrUpdate(userTemp);
		sf.getCurrentSession().saveOrUpdate(oldEvent);
		
		
//		System.out.println("##########");
//		for(Event ep: oldUserEvents1){
//			System.out.println(ep.getEventName());
//		}
//		
//		
//		System.out.println("*************");
//		for(User up: oldEventUsers1){
//			System.out.println(up.getEmail());
//		}
	    
	}
	
	
	
//	@Override
//	@Transactional
//	public List<Paper> getAllPapers() {		
//		return getHibernateTemplate().loadAll(Paper.class);		
//	}

	@Override
	@Transactional
	public Paper getAPaper(int paperID, String requestedReviewer) {
		Paper p = (Paper) sf.getCurrentSession().get(Paper.class, paperID);		
		p.setDownloadTracker(p.getDownloadTracker() + " " + requestedReviewer);
		sf.getCurrentSession().saveOrUpdate(p);
		return p;
	}

	
	
	@Override
	@Transactional
	public boolean submitFeedback(int paperID, String reviewedBy, String reviewerFeedback) {
		//Paper paper = getHibernateTemplate().get(Paper.class, paperID);
		Paper paper = (Paper) sf.getCurrentSession().get(Paper.class, paperID);	

		if(paper.getDownloadTracker() == null || !paper.getDownloadTracker().contains(reviewedBy.split("@")[0])){
			return false;
		}
		else{
			
			ReviewerFeedback reviewerFeedArea = new ReviewerFeedback(paperID, paper.getAuthor() ,reviewedBy, reviewerFeedback);
			reviewerFeedArea.setPaperTitle(paper.getPaperTitle());
			reviewerFeedArea.setEventName(paper.getEventName());
			sf.getCurrentSession().save(reviewerFeedArea);
			
			String[] str1 = paper.getStatusTracker().split("/");
			String fin = Integer.toString((Integer.parseInt(str1[0]) + 1)) + "/" + str1[1];
			
			String[] str2 = fin.split("/");
			if(str2[0].equals(str2[1])){
				paper.setStatusTracker(fin);
				paper.setStatus("Reviews Completed");
				sf.getCurrentSession().saveOrUpdate(paper);
				return true;
			}else{
				paper.setStatusTracker(fin);
				paper.setStatus("Reviews in Progress");
				sf.getCurrentSession().saveOrUpdate(paper);
				return true;
			}
			
		}		
		
		
	}

	



	//@SuppressWarnings("null")
	@Override
	@Transactional
	public List<Paper> getPapersForAssigning(String eventName) {	
		
		
		Query q = sf.getCurrentSession().createQuery("Select new Paper(paperID, paperTitle, author) from Paper where eventName= '"+eventName+"' and status= 'unassigned'   ");
//		  List<Object> objects = getHibernateTemplate().find("Select new Paper(paperID, paperTitle, reviewerFeedback, author) from Paper where reviewerID is null and eventName= '"+eventName+"'" );
//	      List<Paper> list = new ArrayList<Paper>();      
//	      
//			for(Object one : objects) {
//			    Paper temp = (Paper)one;
//			    list.add(temp);
//			}
			return q.list();
	}
	
	
	@Override
	@Transactional
	public List<Paper> getPapersForFeedback(String useremail) {

		String id = useremail.replace("*****", ".");
		User user = (User) sf.getCurrentSession().get(User.class, id);
		
		
		//Query q = sf.getCurrentSession().createQuery("Select new Paper(paperID, paperTitle, abstractOfThePaper, status, eventName, author) from Paper where reviewerid = '" + id + "'");
		//return q.list();
		return user.getPapersToReview();
		
		
	}


	@Override
	@Transactional
	public List<AuthorPapersFeedback> getPapersWithFeedback(String userEmail) {

		String id = userEmail.replace("*****", ".");		
		Query q  = sf.getCurrentSession().createQuery("Select new ReviewerFeedback(paperFeedbackID, paperTitle, submittedBy, feedback, reviewedBy) from ReviewerFeedback where submittedBy = '" + id +"'  ");

		List<AuthorPapersFeedback> list  = new ArrayList<AuthorPapersFeedback>();
		
		for(ReviewerFeedback rf : (List<ReviewerFeedback>)q.list()){
			
			int flag = 0;
			if(list != null){
				for(AuthorPapersFeedback apf: list){
					if(apf.getPaperTitle().equals(rf.getPaperTitle())){
						List<String> reviewersList = apf.getReviewersList();
						reviewersList.add(rf.getReviewedBy());
						List<String> feedbackList = apf.getFeedbackList();
						feedbackList.add(rf.getFeedback());	
						flag = 1;
						break;
					}
				}
			}
			if(flag == 0){
				List<String> reviewersListNew = new ArrayList<String>();
				reviewersListNew.add(rf.getReviewedBy());
				List<String> feedbackListNew = new ArrayList<String>();
				feedbackListNew.add(rf.getFeedback());
				list.add(new AuthorPapersFeedback(rf.getPaperFeedbackID(), rf.getPaperTitle(), rf.getSubmittedBy(), reviewersListNew, feedbackListNew));
			}
		}		
		return list;

	}
	
	

	@Override
	@Transactional
	public List<Paper> getPapersForUpdOrMod(String userEmail) {
		//String id = userEmail + ".com";
		String id = userEmail.replace("*****", ".");
		Query q = sf.getCurrentSession().createQuery("Select new Paper(paperID, paperTitle, abstractOfThePaper, status, eventName, author) from Paper where status= 'unassigned' and author= '" + id + "'");
//		List<Object> objects = getHibernateTemplate().find("Select new Paper(paperID, paperTitle, abstractOfThePaper, status, eventName, author) from Paper where reviewerFeedback is null and author = '" + id + "'");				
//		List<Paper> list = new ArrayList<Paper>();
//	      
//		for(Object one : objects) {
//		    Paper temp = (Paper)one;
//		    list.add(temp);
//		}
		return q.list();
	}
	
	
	
	//################### Not being used - Currently using assignSinglePaper() to assign papers ###################
	/*@Override
	@Transactional
	public void assignReviewerIDsToPapers(List<Paper> paperRevIDs) {		 
		
		for(Paper p: paperRevIDs){
			
			//Paper paper = getHibernateTemplate().get(Paper.class, p.getPaperID());
			Paper paper = (Paper) sf.getCurrentSession().get(Paper.class, p.getPaperID()); 
			//paper.setReviewerID(p.getReviewerID());
			sf.getCurrentSession().update(paper);
			//getHibernateTemplate().update(paper);
		}
		
	}*/

	
	
	
	@Override
	@Transactional
	public void assignSinglePaper(String jsonstring) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();		
		JsonNode root = mapper.readTree(jsonstring);
		
		JsonNode contactNode1 = root.path("paper");				
		Paper paperToAdd = (Paper) sf.getCurrentSession().get(Paper.class, contactNode1.path("paperID").asInt());
		paperToAdd.setStatus("Assigned");

		JsonNode contactNode2 = root.path("users");
		int userCount = 0;
		for (JsonNode node : contactNode2) {
			User userToSave = (User) sf.getCurrentSession().get(User.class, node.path("email").asText());
			List<Paper> papersToReview = userToSave.getPapersToReview();
			userCount++;
			paperToAdd.setStatusTracker("0/"+userCount);
			papersToReview.add(paperToAdd);
			userToSave.setPapersToReview(papersToReview);
			sf.getCurrentSession().saveOrUpdate(userToSave);
		}
	}
	
	
	
	
	@Override
	@Transactional
	public void assignMultiplePapers(String jsonstringArray) throws JsonProcessingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();		
		JsonNode rootArray = mapper.readTree(jsonstringArray);		
		
		for(JsonNode root : rootArray){
			JsonNode contactNode1 = root.path("paper");
			Paper paperToAdd = (Paper) sf.getCurrentSession().get(Paper.class, contactNode1.path("paperID").asInt());
			
			JsonNode contactNode2 = root.path("users");
			
			for (JsonNode node : contactNode2) {
				User userToSave = (User) sf.getCurrentSession().get(User.class, node.path("email").asText());
				List<Paper> papersToReview = userToSave.getPapersToReview();
				papersToReview.add(paperToAdd);
				userToSave.setPapersToReview(papersToReview);
				sf.getCurrentSession().saveOrUpdate(userToSave);
			}						
		}
}

	@Override
	@Transactional
	public List<Paper> getPapersForPaperStatus(String eventName) {
		Query q = sf.getCurrentSession().createQuery("Select new Paper(paperID, paperTitle, author, status) from Paper where eventName= '"+eventName+"'   ");
		return q.list();
	}

	
	
	
	@Override
	@Transactional
	public List<AuthorPapersFeedback> getPapersWithFeedbackForPC(String eventName) {
		Query q = sf.getCurrentSession().createQuery("Select new ReviewerFeedback(paperFeedbackID,paperTitle, submittedBy, feedback, reviewedBy) from ReviewerFeedback where eventName= '"+eventName+"'   ");
		List<AuthorPapersFeedback> list  = new ArrayList<AuthorPapersFeedback>();
		
		for(ReviewerFeedback rf : (List<ReviewerFeedback>)q.list()){
			
			int flag = 0;
			if(list != null){
				for(AuthorPapersFeedback apf: list){
					if(apf.getPaperTitle().equals(rf.getPaperTitle())){
						List<String> reviewersList = apf.getReviewersList();
						reviewersList.add(rf.getReviewedBy());
						List<String> feedbackList = apf.getFeedbackList();
						feedbackList.add(rf.getFeedback());	
						flag = 1;
						break;
					}
				}
			}
			if(flag == 0){
				List<String> reviewersListNew = new ArrayList<String>();
				reviewersListNew.add(rf.getReviewedBy());
				List<String> feedbackListNew = new ArrayList<String>();
				feedbackListNew.add(rf.getFeedback());
				list.add(new AuthorPapersFeedback(rf.getPaperFeedbackID(), rf.getPaperTitle(), rf.getSubmittedBy(), reviewersListNew, feedbackListNew));
			}
		}		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
