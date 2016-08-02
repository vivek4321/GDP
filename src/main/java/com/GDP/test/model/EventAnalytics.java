package com.GDP.test.model;

public class EventAnalytics {

	
	private Long unassigned;
	private Long assigned;
	private Long reviewInProgress;
	private Long reviewCompleted;
	
	
	
	public EventAnalytics() {
		super();
	}

	

	public EventAnalytics(Long unassigned, Long assigned, Long reviewInProgress, Long reviewCompleted) {
		super();
		this.unassigned = unassigned;
		this.assigned = assigned;
		this.reviewInProgress = reviewInProgress;
		this.reviewCompleted = reviewCompleted;
	}



	public Long getUnassigned() {
		return unassigned;
	}



	public void setUnassigned(Long unassigned) {
		this.unassigned = unassigned;
	}



	public Long getAssigned() {
		return assigned;
	}



	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}



	public Long getReviewInProgress() {
		return reviewInProgress;
	}



	public void setReviewInProgress(Long reviewInProgress) {
		this.reviewInProgress = reviewInProgress;
	}



	public Long getReviewCompleted() {
		return reviewCompleted;
	}



	public void setReviewCompleted(Long reviewCompleted) {
		this.reviewCompleted = reviewCompleted;
	}

	
	
	
	
}
