package com.GDP.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.GDP.test.model.Event;
import com.GDP.test.model.Paper;
import com.GDP.test.model.ReviewerFeedback;
import com.GDP.test.model.User;
import com.GDP.test.service.PaperService;
import com.GDP.test.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
public class PaperController {

	@Autowired
	private PaperService paperservice;

	@Autowired
	private UserService userservice;

	
	
	// @RequestMapping(value = "/getallpapers", method = RequestMethod.GET)
	// public @ResponseBody List<Paper> showPapers() {
	@RequestMapping("/getallpapers")
	public ModelAndView ShowPapersForGivingFeedback(HttpSession session) {

		
//		if(session.getAttribute("User") != null){
			List<Paper> papers = paperservice.getPapersForFeedback((String) session.getAttribute("User"));			
			return new ModelAndView("viewpapers2", "listofpapers", papers);
//		}
//		else{		
//			return null;
//		}

	}
	
	

	
	
	@RequestMapping(value = "/getpapersusers", method = RequestMethod.POST)
	public @ResponseBody Wrapper ShowPapersForAssigning(@RequestBody Event event, HttpSession session) {

//		if(session.getAttribute("User") != null){
			List<User> finusers = userservice.getAllUsers();
			List<Paper> finpapers = paperservice.getPapersForAssigning(event.getEventName());
			Wrapper wrapper = new Wrapper(finpapers, finusers);
			return wrapper;
//		}
//		else{		
//			return null;
//		}

	}
	
	
	@RequestMapping(value = "/getpapersforstatus/{eventName}", method = RequestMethod.GET)
	public @ResponseBody List<Paper> GetPapersForStatus(@PathVariable String eventName, HttpSession session) {

//		if(session.getAttribute("User") != null){			
			return paperservice.getPapersForPaperStatus(eventName);
//		}
//		else{		
//			return null;
//		}

	}
	
	
	

	@RequestMapping(value = "/getpapersforviewingfeedback/{userEmail}", method = RequestMethod.GET)
	public @ResponseBody List<AuthorPapersFeedback> ShowPapersForViewingFeedback(@PathVariable String userEmail, HttpSession session) {

//		if(session.getAttribute("User") != null){
					
			List<AuthorPapersFeedback> papers = paperservice.getPapersWithFeedback(userEmail);
			
			return papers;
//		}
//		else{		
//			return null;
//		}
	}
	
	
	@RequestMapping(value = "/getpapersforPCviewingfeedback/{eventName}", method = RequestMethod.GET)
	public @ResponseBody List<AuthorPapersFeedback> ShowPapersForPCViewingFeedback(@PathVariable String eventName, HttpSession session) {

//		if(session.getAttribute("User") != null){		
			List<AuthorPapersFeedback> papers = paperservice.getPapersWithFeedbackForPC(eventName);			
			return papers;
//		}
//		else{		
//			return null;
//		}
	}
	

	

	@RequestMapping(value = "/getpapersforUpdOrMod/{userEmail}", method = RequestMethod.GET)
	public @ResponseBody List<Paper> GetPapersForUpdationOrModification(@PathVariable String userEmail, HttpSession session) {

//		if(session.getAttribute("User") != null){
			List<Paper> papers = paperservice.getPapersForUpdOrMod(userEmail);
			return papers;
//		}
//		else{		
//			return null;
//		}

	}
	
	
	
	//################### Not being used - Currently using assignSinglePaper() to assign papers ###################
	/*@RequestMapping(value = "/assignpapers", method = RequestMethod.POST)
	public String AssignPapersToReviewers(@RequestBody List<Paper> assignRevIDToPapers, HttpSession session) {

//		if(session.getAttribute("User") != null){
			paperservice.assignReviewerIDsToPapers(assignRevIDToPapers);
			return "Assigned Papers Successfully";
//		}
//		else{		
//			return null;
//		}

	}*/
	
	

	@RequestMapping(value = "/assignsinglepapersmr", method = RequestMethod.POST)
	public String AssignPapersToMultipleReviewers(@RequestBody String jsonstring, HttpSession session) throws JsonProcessingException, IOException  {
	
//		if(session.getAttribute("User") != null){
			//paperservice.assignMultipleReviewerIDsToPapers(assignRevIDToPapers);
		
		
		paperservice.assignSinglePaper(jsonstring);
		
//		ObjectMapper mapper = new ObjectMapper();		
//		JsonNode root = mapper.readTree(jsonstring);		
//		
//		JsonNode contactNode1 = root.path("paper");
//		System.out.println(contactNode1.path("paperID").asText());
//		
//		JsonNode contactNode2 = root.path("users");
//		for (JsonNode node : contactNode2) {
//			System.out.println(node.path("email").asText());
//		}		 
		
		
		return "Asssigned Successfully";
//		}
//		else{		
//			return null;
//		}

	}
	
	
	
	
	
	
	
	//####################  Functionality not implemented yet  ######################
	@RequestMapping(value = "/assignmultipapersmr", method = RequestMethod.POST)
	public String AssignMultiplePapersToMultipleReviewers(@RequestBody String jsonstringArray, HttpSession session) throws JsonProcessingException, IOException  {
	
//		if(session.getAttribute("User") != null){
			//paperservice.assignMultipleReviewerIDsToPapers(assignRevIDToPapers);
		
		//paperservice.assignMultiplePapers(jsonstringArray);
		
		
//		ObjectMapper mapper = new ObjectMapper();		
//		JsonNode rootArray = mapper.readTree(jsonstringArray);
//		System.out.println(rootArray.size());
////		for(JsonNode root : rootArray){
////			JsonNode contactNode1 = root.path("paper");
////			JsonNode contactNode2 = root.path("users");
////			
////			System.out.println(contactNode1);
////			System.out.println(contactNode2);
////						
////		}
		
		
		return "Asssigned Successfully";
//		}
//		else{		
//			return null;
//		}

	}
	
	
	
	
	
	
	/*@RequestMapping(value = "/getassignpapersmr", method = RequestMethod.GET)
	public @ResponseBody WrapperForMulRev GetAssignPapersToMultipleReviewers() {

		List<WrapperForMulRev> list = new ArrayList<WrapperForMulRev>();
		
		Paper p1 = new Paper();
		p1.setPaperID(22);
		List<User> ulist1 = new ArrayList<User>();
		User u1 = new User();
		User u2 = new User();
		u1.setEmail("srikanth@gmail.com");
		ulist1.add(u1);
		u2.setEmail("vivek@gmail.com");
		ulist1.add(u2);
		WrapperForMulRev wrapper1 = new WrapperForMulRev(p1, ulist1);
		list.add(wrapper1);
		
		
		return wrapper1;
	}*/
	
	
	
	
	

	@RequestMapping("/saveapaper.htm")	
	public ModelAndView SaveADoc(MultipartHttpServletRequest request, HttpSession session) throws IOException, SQLException {

		
		try{
			//			if(session.getAttribute("User") != null){
					String[] arr = request.getParameter("eventnamesload").split("&&");
			
					MultipartFile fileToSave = request.getFile("documentcontent1");
					byte[] byteFile = fileToSave.getBytes();
					Blob blob = new SerialBlob(byteFile);
			
					Paper paper = new Paper(request.getParameter("paperTitle"), blob, request.getParameter("paperabstract"), "unassigned", fileToSave.getOriginalFilename(), arr[1], request.getParameter("userEmailLogin"));
					paperservice.saveAPaper(paper, Integer.parseInt(arr[0]), request.getParameter("userEmailLogin"));	
			
					/*File convFile = new File("C:/test/" + fileToSave.getOriginalFilename().split("\\.")[0] + "_" + arr[1] + "_" + "V1." + fileToSave.getOriginalFilename().split("\\.")[1]);
					fileToSave.transferTo(convFile);*/
			
			
			//			}
			//			else{	
			//			//return new ModelAndView("redirect:/");
			//			return new ModelAndView("signin");
			//			}
		}catch(Exception e){

		}
		return new ModelAndView("redsubmit");


	}
	
	@RequestMapping("/redirectAfterSuccess")	
	public ModelAndView redirectAfterSuccess(){

		
//		if(session.getAttribute("User") != null){
			 //String[] arr = request.getParameter("eventnamesload").split("&&");
				
//			 MultipartFile fileToSave = request.getFile("documentcontent1");
//			 byte[] byteFile = fileToSave.getBytes();
//			 Blob blob = new SerialBlob(byteFile);
//			
//			 Paper paper = new Paper(request.getParameter("paperTitle"), blob, request.getParameter("paperabstract"), "unassigned", fileToSave.getOriginalFilename(), arr[1], request.getParameter("userEmailLogin"));
//			 paperservice.saveAPaper(paper, Integer.parseInt(arr[0]), request.getParameter("userEmailLogin"));			

			/*File convFile = new File("C:/test/" + fileToSave.getOriginalFilename().split("\\.")[0] + "_" + arr[1] + "_" + "V1." + fileToSave.getOriginalFilename().split("\\.")[1]);
			fileToSave.transferTo(convFile);*/

			return new ModelAndView("papersubmission");
//		}
//		else{		
//			//return new ModelAndView("redirect:/");
//			return new ModelAndView("signin");
//		}


	}
	
	
	
	

	@RequestMapping("/updateOrModifyAPaper")
	public ModelAndView UpdateOrModifyADoc(MultipartHttpServletRequest request, HttpSession session) throws IOException, SQLException {		
		
		
//		if(session.getAttribute("User") != null){
			if(request.getParameter("updateOrModify").equals("update")){
				
				MultipartFile fileToSave = request.getFile("newVersionUpload");
				byte[] byteFile = fileToSave.getBytes();
				Blob blob = new SerialBlob(byteFile);

				paperservice.updateAPaper(Integer.parseInt(request.getParameter("paperDropdown")), blob, fileToSave.getOriginalFilename(), request.getParameter("userEmailForUpdate"));
				
				
				// perform the following when whole paper is retrieved from the DB by its paperID.
				// We can query for the eventID from the paper object's event name.
//				String[] arr = request.getParameter("eventnamesload").split("&&");
//				File convFile = new File("C:/test/" + fileToSave.getOriginalFilename().split("\\.")[0] + "_" + arr[1] + "_" + request.getParameter("currentVersion") + "." + fileToSave.getOriginalFilename().split("\\.")[1]);
//				fileToSave.transferTo(convFile);

				return new ModelAndView("papersubmission");
			}
			else{			
				String[] arr = request.getParameter("eventnamesloadupdate").split("&&");
				paperservice.modifyAPaper(Integer.parseInt(request.getParameter("paperDropdown")), Integer.parseInt(arr[0]), request.getParameter("paperTitle"), arr[1], request.getParameter("abstract"), request.getParameter("userEmailForUpdate"));
				
//				File convFile = new File("C:/test/" + fileToSave.getOriginalFilename().split("\\.")[0] + "_" + arr[1] + "_" + "V1." + fileToSave.getOriginalFilename().split("\\.")[1]);
//				fileToSave.transferTo(convFile);
				return new ModelAndView("papersubmission");
			}
//		}
//		else{		
//			return new ModelAndView("signin");
//			//return new ModelAndView("redirect:/");
//		}
		

				
	}
	
	

	
	
	
	

	@RequestMapping(value = "/submitFeedback", method = RequestMethod.POST)
	public String Feedback(@RequestBody ReviewerFeedback rFeedback, HttpSession session) {

		
//		if(session.getAttribute("User") != null){
			if (paperservice.submitFeedback(rFeedback.getPaperFeedbackID(), rFeedback.getReviewedBy() , rFeedback.getFeedback())) {
				return "Feedback submitted successfully";
			} else {
				return "Paper with id " + rFeedback.getPaperFeedbackID()
						+ " is Yet to be reviewed. Feedback can't be submitted at the moment";
			}
//		}
//		else{		
//			return null;
//		}
		
	}
	
	
	

	public class Wrapper {

		List<Paper> mpapers;
		List<User> musers;

		public Wrapper(List<Paper> mpapers, List<User> musers) {
			super();
			this.mpapers = mpapers;
			this.musers = musers;
		}

		public List<Paper> getMpapers() {

			return mpapers;
		}

		public void setMpapers(List<Paper> mpapers) {
			this.mpapers = mpapers;
		}

		public List<User> getMusers() {
			return musers;
		}

		public void setMusers(List<User> musers) {
			this.musers = musers;
		}

	}
	
	
	
	
	
	
	
	
	
	/*public class WrapperForMulRev {

		
		Paper paper;
		List<User> users;
		
		public WrapperForMulRev(Paper paper, List<User> users) {
			super();
			this.paper = paper;
			this.users = users;
		}

		public WrapperForMulRev() {
			super();
		}

		public Paper getPaper() {
			return paper;
		}

		public void setPaper(Paper paper) {
			this.paper = paper;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		@Override
		public String toString() {
			return "WrapperForMulRev [paper=" + paper + ", users=" + users + "]";
		}
					
	}*/
	
	
	
	
	
	public static class AuthorPapersFeedback {
		int pID;
		String paperTitle;
		String author;
		List<String> reviewersList;
		List<String> feedbackList;
		


		public AuthorPapersFeedback() {
			super();
		}
		
		public AuthorPapersFeedback(String paperTitle, List<String> reviewersList, List<String> feedbackList) {
			super();
			this.paperTitle = paperTitle;
			this.reviewersList = reviewersList;
			this.feedbackList = feedbackList;
		}

		public AuthorPapersFeedback(int pID, String paperTitle, String author, List<String> reviewersList, List<String> feedbackList) {
			super();
			this.pID = pID;
			this.paperTitle = paperTitle;
			this.author = author;
			this.reviewersList = reviewersList;
			this.feedbackList = feedbackList;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getpID() {
			return pID;
		}

		public void setpID(int pID) {
			this.pID = pID;
		}

		public List<String> getReviewersList() {
			return reviewersList;
		}

		public void setReviewersList(List<String> reviewersList) {
			this.reviewersList = reviewersList;
		}

		public List<String> getFeedbackList() {
			return feedbackList;
		}

		public void setFeedbackList(List<String> feedbackList) {
			this.feedbackList = feedbackList;
		}

		public String getPaperTitle() {
			return paperTitle;
		}

		public void setPaperTitle(String paperTitle) {
			this.paperTitle = paperTitle;
		}
		
		
		
	}
	
	
	
	
	

}
