package com.GDP.test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "users")
public class User {

	@Id
    @Column(name = "email", nullable=false)
	private String email;
	
    @Column(name = "password")
	private String password;
	
    @Column(name = "firstname")
	private String firstName;
	
    @Column(name = "lastname")
	private String lastName;
	
    @Column(name = "contactnumber")
	private String contactNumber;
	
    @Column(name = "dateofbirth")
	private String dob;					

    @Column(name = "isauthor")
   	private boolean isAuthor;
    
    @Column(name = "isreviewer")
   	private boolean isReviewer;	
    
    @Column(name = "isprogramchair")
   	private boolean isProgramChair;
    
    @Column(name = "verificationstatus")
    private String verificationStatus;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "users_papers",
	        joinColumns = @JoinColumn(name = "users_email", referencedColumnName = "email"),		//  name = "papers_paperid", referencedColumnName = "paperid"
	        inverseJoinColumns = @JoinColumn(name = "papers_paperid", referencedColumnName = "paperid")
	)
   	private List<Paper> userPapers = new ArrayList<Paper>(0);
    
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "users_paperstoreview",
	        joinColumns = @JoinColumn(name = "users_emailiddd", referencedColumnName = "email"),		
	        inverseJoinColumns = @JoinColumn(name = "papers_paperiddd", referencedColumnName = "paperid")
	)
   	private List<Paper> papersToReview;
    
      
    
    @Override
	public String toString() {
		return "User [email=" + email + "]";
	}



	@ManyToMany(cascade = CascadeType.ALL)
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "users_emailid", referencedColumnName = "email"),		//  name = "events_eventidd", referencedColumnName = "eventid"
            inverseJoinColumns = @JoinColumn(name = "events_eventidd", referencedColumnName = "eventid")
    )
    private List<Event> userEvents;
	
	
	
	
		
	
	public User(String email, String password, String firstName, String lastName, String contactNumber, String dob, boolean isAuthor, boolean isReviewer, boolean isProgramChair, String verificationStatus) {
		super();		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.dob = dob;
		this.isAuthor = true;
		this.isReviewer = false;
		this.isProgramChair = false;
		this.verificationStatus = verificationStatus;			
	}
	
		
	
/*	public User(List<Paper> userPapers, List<Paper> papersToReview, List<Event> userEvents) {
		super();
		this.userPapers = userPapers;
		this.papersToReview = papersToReview;
		this.userEvents = userEvents;
	}*/



	public User(String email) {
		//super();
		this.email = email;
	}
	
	public User() {
		super();
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	
	public boolean getIsAuthor() {
		return isAuthor;
	}

	public void setIsAuthor(boolean isAuthor) {
		this.isAuthor = isAuthor;
	}
	
	public boolean getIsReviewer() {
		return isReviewer;
	}

	public void setIsReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
	}

	public boolean getIsProgramChair() {
		return isProgramChair;
	}

	public void setIsProgramChair(boolean isProgramChair) {
		this.isProgramChair = isProgramChair;
	}


    
	public List<Paper> getUserPapers() {
		return userPapers;
	}



	public void setUserPapers(List<Paper> userPapers) {
		this.userPapers = userPapers;
	}



	public List<Event> getUserEvents() {
		return userEvents;
	}



	public void setUserEvents(List<Event> userEvents) {
		this.userEvents = userEvents;
	}


	public List<Paper> getPapersToReview() {
		return papersToReview;
	}


	public void setPapersToReview(List<Paper> papersToReview) {
		this.papersToReview = papersToReview;
	}


	public String getVerificationStatus() {
		return verificationStatus;
	}


	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	
	
	
}
