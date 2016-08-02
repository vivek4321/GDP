package com.GDP.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviewerfeedback")
public class ReviewerFeedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "feedbackid")
	private int feedbackID;
	
	@Column(name = "paperfeedbackid")
	private int paperFeedbackID;
	
	@Column(name = "papertitle")
	private String paperTitle;
	
	@Column(name = "eventname")
	private String eventName;
	
	@Column(name = "submittedby")
	private String submittedBy;
	
	@Column(name = "reviewedby")
	private String reviewedBy;
	
	@Column(name = "feedback")
	private String feedback;
	
	
	
	
	
	

	public ReviewerFeedback() {
		super();
	}

	public ReviewerFeedback(int paperFeedbackID, String submittedBy, String reviewedBy,
			String feedback) {
		super();		
		this.paperFeedbackID = paperFeedbackID;
		this.submittedBy = submittedBy;
		this.reviewedBy = reviewedBy;
		this.feedback = feedback;
	}
	
	

	public ReviewerFeedback(int paperFeedbackID, String paperTitle, String submittedBy, String reviewedBy, String feedback) {
		super();
		this.paperFeedbackID = paperFeedbackID;
		this.paperTitle = paperTitle;
		this.submittedBy = submittedBy;
		this.reviewedBy = reviewedBy;
		this.feedback = feedback;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getPaperFeedbackID() {
		return paperFeedbackID;
	}

	public void setPaperFeedbackID(int paperFeedbackID) {
		this.paperFeedbackID = paperFeedbackID;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	
	
}
