package com.GDP.test.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import com.GDP.test.PaperController.AuthorPapersFeedback;
import com.GDP.test.model.Paper;
import com.GDP.test.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface PaperDAO {

	public void saveAPaper(Paper paper, int eventID, String userEmail);
	public void updateAPaper(int paperID, Blob updatedBlob, String updatedDownloadName, String userEmail);
	public void modifyAPaper(int paperID, int eventID, String paperTitle, String eventName, String abstractOfThePaper, String userEmail);
	public void deleteAPaper(int paperID, String userEmail);
	//public List<Paper> getAllPapers();
	public Paper getAPaper(int paperID, String requestedReviewer);	
	public boolean submitFeedback(int paperID, String reviewedBy , String reviewerFeedback );
//	public boolean setDownloadStatus(int paperID);
	public List<Paper> getPapersForAssigning(String eventName);
	public List<Paper> getPapersForPaperStatus(String eventName);
	public List<Paper> getPapersForFeedback(String useremail);
	public List<AuthorPapersFeedback> getPapersWithFeedback(String userEmail);
	public List<AuthorPapersFeedback> getPapersWithFeedbackForPC(String eventName);
	public List<Paper> getPapersForUpdOrMod(String userEmail);
	//public void assignReviewerIDsToPapers(List<Paper> paperRevIDs);
	
	public void assignSinglePaper(String jsonstring) throws JsonProcessingException, IOException;
	public void assignMultiplePapers(String jsonstringArray) throws JsonProcessingException, IOException ;
}

