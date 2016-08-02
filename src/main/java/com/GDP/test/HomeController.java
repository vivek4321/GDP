package com.GDP.test;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.GDP.test.model.Chart;
import com.GDP.test.model.EventAnalytics;
import com.GDP.test.model.Paper;
import com.GDP.test.service.ChartService;
import com.GDP.test.service.PaperService;


@Controller
public class HomeController{
	
	
	@Autowired
	private PaperService paperservice;
	
	@Autowired
	private ChartService chartservice;
	
	
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("signin");
	}
	
	
	@RequestMapping("/goBackAfterPaperSubmit")
	public ModelAndView RedirectAfterPaperSubmissionAck() {
		return new ModelAndView("papersubmission");
	}
	
	
	@RequestMapping(value = "/chartdata/{eventName}", method = RequestMethod.GET)
	public @ResponseBody EventAnalytics getChartData(@PathVariable String eventName) {
	
		EventAnalytics ea = new  EventAnalytics(); 
		try { 
			ea =  chartservice.getAllData(eventName);
		 } catch (Exception e) {
			 
		 }
		return ea;
		

	}
	
	
	
	
	 @RequestMapping("/paperdownload/{paperID}.htm")
	  public ModelAndView downloadAPaper(@PathVariable("paperID") Integer paperToDownload, HttpServletResponse response, HttpSession session) throws SQLException {
	       
//		 if(session.getAttribute("User") != null){
		      Paper paperToUserSave = paperservice.getAPaper(paperToDownload, (String) session.getAttribute("User"));
		      try {

		          response.setHeader("Content-Disposition", "attachment;filename=" + paperToUserSave.getPaperDownloadName());            
		          OutputStream out = response.getOutputStream();
//		          response.setContentType(docToUserSave.getContentType());                        
		          IOUtils.copy(paperToUserSave.getPaperDataFile().getBinaryStream(), out);            
		          out.flush();
		          out.close();
		          
		          
		          
		      } catch (IOException e) {
		          e.printStackTrace();
		      } catch (SQLException e) {
		          e.printStackTrace();
		      }
			return null; 
//		}
//		else{		
//			return new ModelAndView("redirect:/");
//		}
                 
	  }
	 
	 
	 
	 
	 
	 
	 
	  @RequestMapping("/removeAPaper/{paperID}/{email}")
	  public ModelAndView removeAPaper(@PathVariable("paperID") Integer paperToRemove, @PathVariable("email") String email, HttpSession session) throws SQLException {
	     	
//		if(session.getAttribute("User") != null){
			paperservice.deleteAPaper(paperToRemove, email.replace("*****", "."));
			return new ModelAndView("redirect:/papersubmission.jsp");
//		}
//		else{		
//			return new ModelAndView("redirect:/");
//		}
	  }
	 
	 
} 
	 
	 