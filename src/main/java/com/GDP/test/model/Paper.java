package com.GDP.test.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name = "papers")
public class Paper {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "paperid")
	private int paperID;
	
	@Column(name = "papertitle")
	private String paperTitle;
	
	@Column(name = "paperdatafile")
	private Blob paperDataFile;
	
	@Column(name = "abstractofthepaper")
	private String abstractOfThePaper;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "paperdownloadname")
	private String paperDownloadName;
	
/*	@Column(name = "reviewerfeedback")
	private String reviewerFeedback;*/
	
/*	@Column(name = "reviewerid")
	private String reviewerID;*/
	
	@Column(name = "statustracker")
	private String statusTracker;
	
	@Column(name = "downloadtracker")
	private String downloadTracker;

	@Column(name = "eventname")
	private String eventName;
	
	@Column(name = "author")
	private String author;


	
	// saveAPaper - PaperDAOImpl:  papersubmission.jsp
	public Paper(String paperTitle, Blob paperDataFile, String abstractOfThePaper, String status,
			String paperDownloadName, String eventName, String author) {
		super();
		this.paperTitle = paperTitle;
		this.paperDataFile = paperDataFile;
		this.abstractOfThePaper = abstractOfThePaper;
		this.author = author;
		this.status = status;
		this.paperDownloadName = paperDownloadName;
		this.eventName = eventName;
	}
	
	

	// getPapersForAssigning - PaperDAOImpl:  createanevent.jsp
	//getPapersWithFeedback - PaperDAOImpl:  papersubmission.jsp	
	public Paper(int paperID, String paperTitle, String author) {
		super();
		this.paperID = paperID;
		this.paperTitle = paperTitle;
		this.author = author;
	}
	

	//getPapersForFeedback - PaperDAOImpl:  viewpapers.jsp
	//getPapersForFeedback - PaperDAOImpl:  papersubmission.jsp: To update or modify a Paper
	public Paper(int paperID, String paperTitle, String abstractOfThePaper, String status, String eventName, String author) {
		super();
		this.paperID = paperID;
		this.paperTitle = paperTitle;
		this.abstractOfThePaper = abstractOfThePaper;
		this.status = status;
		this.eventName = eventName;
		this.author = author;
	}
	
	// createanevent.jsp - getpapersforPaperStatus
	public Paper(int paperID, String paperTitle, String author, String status) {
		super();
		this.paperID = paperID;
		this.paperTitle = paperTitle;
		this.author = author;
		this.status = status;
	}
	
	
	public Paper() {
		super();
	}


	public int getPaperID() {
		return paperID;
	}

	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public Blob getPaperDataFile() {
		return paperDataFile;
	}

	public void setPaperDataFile(Blob paperDataFile) {
		this.paperDataFile = paperDataFile;
	}

	public String getAbstractOfThePaper() {
		return abstractOfThePaper;
	}

	public void setAbstractOfThePaper(String abstractOfThePaper) {
		this.abstractOfThePaper = abstractOfThePaper;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaperDownloadName() {
		return paperDownloadName;
	}

	public void setPaperDownloadName(String paperDownloadName) {
		this.paperDownloadName = paperDownloadName;
	}

	

	public String getStatusTracker() {
		return statusTracker;
	}

	public void setStatusTracker(String statusTracker) {
		this.statusTracker = statusTracker;
	}


	public String getDownloadTracker() {
		return downloadTracker;
	}



	public void setDownloadTracker(String downloadTracker) {
		this.downloadTracker = downloadTracker;
	}



	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Paper [paperID=" + paperID + ", paperTitle=" + paperTitle + ", abstractOfThePaper=" + abstractOfThePaper
				+ ", status=" + status + "]";
	}
	
	
	
	
}

