package com.GDP.test.service.impl;


import java.io.IOException;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import com.GDP.test.PaperController.AuthorPapersFeedback;
import com.GDP.test.dao.PaperDAO;
import com.GDP.test.model.Paper;
import com.GDP.test.model.User;
import com.GDP.test.service.PaperService;
import com.fasterxml.jackson.core.JsonProcessingException;


public class PaperServiceImpl implements PaperService {

	PaperDAO paperdaoimpl;
	
	public PaperDAO getPaperdaoimpl() {
		return paperdaoimpl;
	}

	public void setPaperdaoimpl(PaperDAO paperdaoimpl) {
		this.paperdaoimpl = paperdaoimpl;
	}



	@Override
	public void saveAPaper(Paper paper, int eventID, String userEmail){
		paperdaoimpl.saveAPaper(paper,eventID, userEmail);
	}

//	@Override
//	public List<Paper> getAllPapers() {		
//		return paperdaoimpl.getAllPapers();
//	}

	@Override
	public Paper getAPaper(int paperID, String requestedReviewer) {
		return paperdaoimpl.getAPaper(paperID, requestedReviewer);
	}

	@Override	
	public boolean submitFeedback(int paperID, String reviewedBy ,String reviewerFeedback) {
		return paperdaoimpl.submitFeedback(paperID, reviewedBy, reviewerFeedback);
		
	}

	/*@Override
	public boolean setDownloadStatus(int paperID) {
		paperdaoimpl.setDownloadStatus(paperID);
		return true;
	}*/

	@Override
	public List<Paper> getPapersForAssigning(String eventName) {
		
		List<Paper> myPapers = paperdaoimpl.getPapersForAssigning(eventName);		 				
		return myPapers;
	}
	
	
	@Override
	public List<AuthorPapersFeedback> getPapersWithFeedback(String userEmail) {
		List<AuthorPapersFeedback> myPapers = paperdaoimpl.getPapersWithFeedback(userEmail);
		return myPapers;
	}

	/*@Override
	public void assignReviewerIDsToPapers(List<Paper> paperRevIDs) {
		paperdaoimpl.assignReviewerIDsToPapers(paperRevIDs);	
	}*/


	@Override
	public List<Paper> getPapersForFeedback(String userEmail) {
		return paperdaoimpl.getPapersForFeedback(userEmail);
	}



	@Override
	public void deleteAPaper(int paperID, String userEmail) {		
		paperdaoimpl.deleteAPaper(paperID, userEmail);
	}

	@Override
	public List<Paper> getPapersForUpdOrMod(String userEmail) {
		return paperdaoimpl.getPapersForUpdOrMod(userEmail);
	}

	@Override
	public void updateAPaper(int paperID, Blob updatedBlob, String updatedDownloadName, String userEmail) {
		paperdaoimpl.updateAPaper(paperID, updatedBlob, updatedDownloadName, userEmail);		
	}

	@Override
	public void modifyAPaper(int paperID, int eventID, String paperTitle, String eventName, String abstractOfThePaper,
			String userEmail) {
		paperdaoimpl.modifyAPaper(paperID, eventID, paperTitle, eventName, abstractOfThePaper, userEmail);		
	}

	@Override
	public void assignSinglePaper(String jsonstring) throws JsonProcessingException, IOException {
		paperdaoimpl.assignSinglePaper(jsonstring);
	}

	@Override
	public void assignMultiplePapers(String jsonstringArray) throws JsonProcessingException, IOException {
		paperdaoimpl.assignMultiplePapers(jsonstringArray);		
	}

	@Override
	public List<Paper> getPapersForPaperStatus(String eventName) {
		return paperdaoimpl.getPapersForPaperStatus(eventName);
	}

	@Override
	public List<AuthorPapersFeedback> getPapersWithFeedbackForPC(String eventName) {		
		return paperdaoimpl.getPapersWithFeedbackForPC(eventName);
	}



}
