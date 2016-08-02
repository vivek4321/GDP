package com.GDP.test.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "events")
public class Event {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventid")
	private int eventID;
	
    @Column(name = "eventname")
	private String eventName;
	
	@Column(name = "dateofevent")
	private String dateOfEvent;
	
	@Column(name = "submissionduedate")
	private String submissionDueDate;
	
	@Column(name = "organizer")
	private String organizerName;
	
	@Column(name = "eventdescription")
	private String eventDescription;
	
	@Column(name = "createdby")
	private String createdBy;
	
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  orphanRemoval = true:  delete a paper from eventPapers list, events_papers and Papers tables     
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "events_papers",
	        joinColumns = @JoinColumn(name = "events_eventid", referencedColumnName = "eventid"),				//  name = "events_eventid", referencedColumnName = "eventid"
	        inverseJoinColumns = @JoinColumn(name = "papers_paperidd", referencedColumnName = "paperid")			//name = "papers_paperidd", referencedColumnName = "paperid"
	)
	private List<Paper> eventPapers;
	
	
	
	
	
	
	
	@ManyToMany(mappedBy = "userEvents")
	private List<User> eventUsers;
	
	
	public Event(String eventName, String dateOfEvent, String submissionDueDate, String organizerName,
			String eventDescription, String createdBy) {
		super();
		this.eventName = eventName;
		this.dateOfEvent = dateOfEvent;
		this.submissionDueDate = submissionDueDate;
		this.organizerName = organizerName;
		this.eventDescription = eventDescription;
		this.createdBy = createdBy;
	}

	
	

	public Event(int eventID, String eventName) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
	}




	public Event() {
		super();
	}



	public int getEventID() {
		return eventID;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getDateOfEvent() {
		return dateOfEvent;
	}


	public void setDateOfEvent(String dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}


	public String getSubmissionDueDate() {
		return submissionDueDate;
	}


	public void setSubmissionDueDate(String submissionDueDate) {
		this.submissionDueDate = submissionDueDate;
	}


	public String getOrganizerName() {
		return organizerName;
	}


	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}


	public String getEventDescription() {
		return eventDescription;
	}


	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	

	public List<Paper> getEventPapers() {
		return eventPapers;
	}


	public void setEventPapers(List<Paper> eventPapers) {
		this.eventPapers = eventPapers;
	}




	public List<User> getEventUsers() {
		return eventUsers;
	}




	public void setEventUsers(List<User> eventUsers) {
		this.eventUsers = eventUsers;
	}




	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	
	
}
