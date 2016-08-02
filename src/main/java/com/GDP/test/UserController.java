package com.GDP.test;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.GDP.test.model.Paper;
import com.GDP.test.model.User;
import com.GDP.test.service.PaperService;
import com.GDP.test.service.UserService;



@RestController
//@Controller
public class UserController {


@Autowired
private UserService userservice;

@Autowired
private PaperService paperservice;


@RequestMapping("/accountActivation/{email}/{token}")
public ModelAndView accountVerification(@PathVariable String email, @PathVariable String token) {
	userservice.verifyUser(email, token);
	return new ModelAndView("success");
}




@RequestMapping(value = "/register", method = RequestMethod.POST)
public @ResponseBody String toRegister(@RequestBody User newUser, HttpSession session){
	
//	if(session.getAttribute("User") != null){

		if(!userservice.existingUserCheck(newUser.getEmail())){
			Random randomGenerator = new Random();
			Integer randomInt = randomGenerator.nextInt(1000000);
			newUser.setIsAuthor(true);
			newUser.setIsReviewer(true);
			newUser.setIsProgramChair(true);
			newUser.setVerificationStatus(randomInt.toString());
			userservice.registerAnUser(newUser);
			SendAnEmailThread r = new SendAnEmailThread(newUser.getEmail(), randomInt.toString(), newUser.getFirstName());		
			Thread t = new Thread(r);
			t.start();
			return "Welcome "+newUser.getFirstName()+ ", Account has been created successfully. Please check your mail account to verify your account.";
			
		}else{
			return "Account with Username "+ newUser.getEmail() +" already exists. Please try again with another email.";
		}
		
//	}
//	else{		
//		return null;
//	}
}





@RequestMapping(value = "/signin", method = RequestMethod.POST)
public String validateUser(@RequestBody User user, HttpSession session){		
		
		User usercheck = userservice.signInCheck(user.getEmail());
		if(usercheck == null){
			return "Username doesn't exist in our records";
		}else{
			if(usercheck.getVerificationStatus().equals("verified")){
				if ((usercheck.getEmail().equals(user.getEmail()) && usercheck.getPassword().equals(user.getPassword()))) {			
					session.setAttribute("User", usercheck.getEmail()); 
					return "Login Successful" + "$$$$" + usercheck.getIsProgramChair()+  "$$$$" + usercheck.getIsReviewer() + "$$$$" +usercheck.getIsAuthor() ;						
				} 
				else {			
					return "Login failed: Incorrect username/password";
				}
			}
			else {
				return "Login failed: Account not verified";
			}
		}				
}


//For forgot password
@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
public @ResponseBody String forgotPassword(@RequestBody User newUser){			
	return userservice.passwordRecovery(newUser.getEmail());
}


@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
public @ResponseBody boolean resetPassword(@RequestBody User newUser){			
	userservice.passwordReset(newUser);
	return true;
}





@RequestMapping(value = "/signout", method = RequestMethod.GET)
public @ResponseBody String invalidateUser(HttpSession session){				

		session.removeAttribute("User");
		if (session != null) {
			session.invalidate();
		}

		return "true";
}




}



