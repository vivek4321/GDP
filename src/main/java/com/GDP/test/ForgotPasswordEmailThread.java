

package com.GDP.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPasswordEmailThread implements Runnable{

	String mailID;
	String firstName;
	
	public ForgotPasswordEmailThread(String mailID, String firstName) {
		super();
		this.mailID = mailID;
		/*this.firstName = firstName;*/
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
	}

	@Override
	public void run() {

		
	////Send an Email via Outlook Office 365 SMTP server using TLS connection.
	    
	    
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.office365.com");        
	    props.put("mail.smtp.port", "587");
	    

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication("S522575@mail.nwmissouri.edu", "newPORT@1234");   //Your username may require the entire email id 'username@example.com'
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("S522575@mail.nwmissouri.edu"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(mailID));
	        message.setSubject("Reset your Password");
	        

	        
	        String someHtmlMessage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head>\n" +
"    <title></title>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"    <style type=\"text/css\">\n" +
".font-sans-serif {\n" +
"  font-family: sans-serif;\n" +
"}\n" +
".font-avenir {\n" +
"  font-family: Avenir, sans-serif;\n" +
"}\n" +
".mso .wrapper .font-avenir {\n" +
"  font-family: sans-serif !important;\n" +
"}\n" +
".font-lato {\n" +
"  font-family: Lato, Tahoma, sans-serif;\n" +
"}\n" +
".mso .wrapper .font-lato {\n" +
"  font-family: Tahoma, sans-serif !important;\n" +
"}\n" +
".font-cabin {\n" +
"  font-family: Cabin, Avenir, sans-serif;\n" +
"}\n" +
".mso .wrapper .font-cabin {\n" +
"  font-family: sans-serif !important;\n" +
"}\n" +
".font-open-Sans {\n" +
"  font-family: \"Open Sans\", sans-serif;\n" +
"}\n" +
".mso .wrapper .font-open-Sans {\n" +
"  font-family: sans-serif !important;\n" +
"}\n" +
".font-roboto {\n" +
"  font-family: Roboto, Tahoma, sans-serif;\n" +
"}\n" +
".mso .wrapper .font-roboto {\n" +
"  font-family: Tahoma, sans-serif !important;\n" +
"}\n" +
".font-ubuntu {\n" +
"  font-family: Ubuntu, sans-serif;\n" +
"}\n" +
".mso .wrapper .font-ubuntu {\n" +
"  font-family: sans-serif !important;\n" +
"}\n" +
".font-pt-sans {\n" +
"  font-family: \"PT Sans\", \"Trebuchet MS\", sans-serif;\n" +
"}\n" +
".mso .wrapper .font-pt-sans {\n" +
"  font-family: \"Trebuchet MS\", sans-serif !important;\n" +
"}\n" +
".font-georgia {\n" +
"  font-family: Georgia, serif;\n" +
"}\n" +
".font-merriweather {\n" +
"  font-family: Merriweather, Georgia, serif;\n" +
"}\n" +
".mso .wrapper .font-merriweather {\n" +
"  font-family: Georgia, serif !important;\n" +
"}\n" +
".font-bitter {\n" +
"  font-family: Bitter, Georgia, serif;\n" +
"}\n" +
".mso .wrapper .font-bitter {\n" +
"  font-family: Georgia, serif !important;\n" +
"}\n" +
".font-pt-serif {\n" +
"  font-family: \"PT Serif\", Georgia, serif;\n" +
"}\n" +
".mso .wrapper .font-pt-serif {\n" +
"  font-family: Georgia, serif !important;\n" +
"}\n" +
".font-pompiere {\n" +
"  font-family: Pompiere, \"Trebuchet MS\", sans-serif;\n" +
"}\n" +
".mso .wrapper .font-pompiere {\n" +
"  font-family: \"Trebuchet MS\", sans-serif !important;\n" +
"}\n" +
".font-roboto-slab {\n" +
"  font-family: \"Roboto Slab\", Georgia, serif;\n" +
"}\n" +
".mso .wrapper .font-roboto-slab {\n" +
"  font-family: Georgia, serif !important;\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  .wrapper .column .size-8 {\n" +
"    font-size: 8px !important;\n" +
"    line-height: 14px !important;\n" +
"  }\n" +
"  .wrapper .column .size-9 {\n" +
"    font-size: 9px !important;\n" +
"    line-height: 16px !important;\n" +
"  }\n" +
"  .wrapper .column .size-10 {\n" +
"    font-size: 10px !important;\n" +
"    line-height: 18px !important;\n" +
"  }\n" +
"  .wrapper .column .size-11 {\n" +
"    font-size: 11px !important;\n" +
"    line-height: 19px !important;\n" +
"  }\n" +
"  .wrapper .column .size-12 {\n" +
"    font-size: 12px !important;\n" +
"    line-height: 19px !important;\n" +
"  }\n" +
"  .wrapper .column .size-13 {\n" +
"    font-size: 13px !important;\n" +
"    line-height: 21px !important;\n" +
"  }\n" +
"  .wrapper .column .size-14 {\n" +
"    font-size: 14px !important;\n" +
"    line-height: 21px !important;\n" +
"  }\n" +
"  .wrapper .column .size-15 {\n" +
"    font-size: 15px !important;\n" +
"    line-height: 23px !important;\n" +
"  }\n" +
"  .wrapper .column .size-16 {\n" +
"    font-size: 16px !important;\n" +
"    line-height: 24px !important;\n" +
"  }\n" +
"  .wrapper .column .size-17 {\n" +
"    font-size: 17px !important;\n" +
"    line-height: 26px !important;\n" +
"  }\n" +
"  .wrapper .column .size-18 {\n" +
"    font-size: 17px !important;\n" +
"    line-height: 26px !important;\n" +
"  }\n" +
"  .wrapper .column .size-20 {\n" +
"    font-size: 17px !important;\n" +
"    line-height: 26px !important;\n" +
"  }\n" +
"  .wrapper .column .size-22 {\n" +
"    font-size: 18px !important;\n" +
"    line-height: 26px !important;\n" +
"  }\n" +
"  .wrapper .column .size-24 {\n" +
"    font-size: 20px !important;\n" +
"    line-height: 28px !important;\n" +
"  }\n" +
"  .wrapper .column .size-26 {\n" +
"    font-size: 22px !important;\n" +
"    line-height: 31px !important;\n" +
"  }\n" +
"  .wrapper .column .size-28 {\n" +
"    font-size: 24px !important;\n" +
"    line-height: 32px !important;\n" +
"  }\n" +
"  .wrapper .column .size-30 {\n" +
"    font-size: 26px !important;\n" +
"    line-height: 34px !important;\n" +
"  }\n" +
"  .wrapper .column .size-32 {\n" +
"    font-size: 28px !important;\n" +
"    line-height: 36px !important;\n" +
"  }\n" +
"  .wrapper .column .size-34 {\n" +
"    font-size: 30px !important;\n" +
"    line-height: 38px !important;\n" +
"  }\n" +
"  .wrapper .column .size-36 {\n" +
"    font-size: 30px !important;\n" +
"    line-height: 38px !important;\n" +
"  }\n" +
"  .wrapper .column .size-40 {\n" +
"    font-size: 32px !important;\n" +
"    line-height: 40px !important;\n" +
"  }\n" +
"  .wrapper .column .size-44 {\n" +
"    font-size: 34px !important;\n" +
"    line-height: 43px !important;\n" +
"  }\n" +
"  .wrapper .column .size-48 {\n" +
"    font-size: 36px !important;\n" +
"    line-height: 43px !important;\n" +
"  }\n" +
"  .wrapper .column .size-56 {\n" +
"    font-size: 40px !important;\n" +
"    line-height: 47px !important;\n" +
"  }\n" +
"  .wrapper .column .size-64 {\n" +
"    font-size: 44px !important;\n" +
"    line-height: 50px !important;\n" +
"  }\n" +
"}\n" +
"body {\n" +
"  margin: 0;\n" +
"  padding: 0;\n" +
"  min-width: 100%;\n" +
"}\n" +
".mso body {\n" +
"  mso-line-height-rule: exactly;\n" +
"}\n" +
".no-padding .wrapper .column .column-top,\n" +
".no-padding .wrapper .column .column-bottom {\n" +
"  font-size: 0px;\n" +
"  line-height: 0px;\n" +
"}\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  border-spacing: 0;\n" +
"}\n" +
"td {\n" +
"  padding: 0;\n" +
"  vertical-align: top;\n" +
"}\n" +
".spacer,\n" +
".border {\n" +
"  font-size: 1px;\n" +
"  line-height: 1px;\n" +
"}\n" +
".spacer {\n" +
"  width: 100%;\n" +
"}\n" +
"img {\n" +
"  border: 0;\n" +
"  -ms-interpolation-mode: bicubic;\n" +
"}\n" +
".image {\n" +
"  font-size: 12px;\n" +
"  mso-line-height-rule: at-least;\n" +
"}\n" +
".image img {\n" +
"  display: block;\n" +
"}\n" +
".logo {\n" +
"  mso-line-height-rule: at-least;\n" +
"}\n" +
".logo img {\n" +
"  display: block;\n" +
"}\n" +
"strong {\n" +
"  font-weight: bold;\n" +
"}\n" +
"h1,\n" +
"h2,\n" +
"h3,\n" +
"p,\n" +
"ol,\n" +
"ul,\n" +
"blockquote,\n" +
".image {\n" +
"  font-style: normal;\n" +
"  font-weight: 400;\n" +
"}\n" +
"ol,\n" +
"ul,\n" +
"li {\n" +
"  padding-left: 0;\n" +
"}\n" +
"blockquote {\n" +
"  Margin-left: 0;\n" +
"  Margin-right: 0;\n" +
"  padding-right: 0;\n" +
"}\n" +
".column-top,\n" +
".column-bottom {\n" +
"  font-size: 42px;\n" +
"  line-height: 42px;\n" +
"  transition-timing-function: cubic-bezier(0, 0, 0.2, 1);\n" +
"  transition-duration: 150ms;\n" +
"  transition-property: all;\n" +
"}\n" +
".half-padding .column .column-top,\n" +
".half-padding .column .column-bottom {\n" +
"  font-size: 21px;\n" +
"  line-height: 21px;\n" +
"}\n" +
".column {\n" +
"  text-align: left;\n" +
"}\n" +
".contents {\n" +
"  table-layout: fixed;\n" +
"  width: 100%;\n" +
"}\n" +
".padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 60px;\n" +
"  word-break: break-word;\n" +
"  word-wrap: break-word;\n" +
"}\n" +
".wrapper {\n" +
"  display: table;\n" +
"  table-layout: fixed;\n" +
"  width: 100%;\n" +
"  min-width: 650px;\n" +
"  -webkit-text-size-adjust: 100%;\n" +
"  -ms-text-size-adjust: 100%;\n" +
"}\n" +
".wrapper a {\n" +
"  transition: opacity 0.2s ease-in;\n" +
"}\n" +
"table.wrapper {\n" +
"  table-layout: fixed;\n" +
"}\n" +
".one-col,\n" +
".two-col,\n" +
".three-col {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"  width: 600px;\n" +
"}\n" +
".centered {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".btn a {\n" +
"  border-radius: 3px;\n" +
"  display: inline-block;\n" +
"  font-size: 14px;\n" +
"  font-weight: 700;\n" +
"  line-height: 24px;\n" +
"  padding: 13px 35px 12px 35px;\n" +
"  text-align: center;\n" +
"  text-decoration: none !important;\n" +
"}\n" +
".btn a:hover {\n" +
"  opacity: 0.8;\n" +
"}\n" +
".two-col .btn a {\n" +
"  font-size: 12px;\n" +
"  line-height: 22px;\n" +
"  padding: 10px 28px;\n" +
"}\n" +
".three-col .btn a {\n" +
"  font-size: 11px;\n" +
"  line-height: 19px;\n" +
"  padding: 6px 18px 5px 18px;\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  .btn a {\n" +
"    display: block !important;\n" +
"    font-size: 14px !important;\n" +
"    line-height: 24px !important;\n" +
"    padding: 13px 10px 12px 10px !important;\n" +
"  }\n" +
"}\n" +
".two-col .column {\n" +
"  width: 300px;\n" +
"}\n" +
".two-col .first .padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 30px;\n" +
"}\n" +
".two-col .second .padded {\n" +
"  padding-left: 30px;\n" +
"  padding-right: 60px;\n" +
"}\n" +
".three-col .column {\n" +
"  width: 200px;\n" +
"}\n" +
".three-col .first .padded {\n" +
"  padding-left: 60px;\n" +
"  padding-right: 0;\n" +
"}\n" +
".three-col .second .padded {\n" +
"  padding-left: 30px;\n" +
"  padding-right: 30px;\n" +
"}\n" +
".three-col .third .padded {\n" +
"  padding-left: 0;\n" +
"  padding-right: 60px;\n" +
"}\n" +
"@media only screen and (min-width: 0) {\n" +
"  .wrapper {\n" +
"    text-rendering: optimizeLegibility;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  [class=wrapper] {\n" +
"    min-width: 280px !important;\n" +
"    width: 100% !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col,\n" +
"  [class=wrapper] .two-col,\n" +
"  [class=wrapper] .three-col {\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  [class=wrapper] .column,\n" +
"  [class=wrapper] .gutter {\n" +
"    display: block;\n" +
"    float: left;\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  [class=wrapper] .padded {\n" +
"    padding-left: 0 !important;\n" +
"    padding-right: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .block {\n" +
"    display: block !important;\n" +
"  }\n" +
"  [class=wrapper] .hide {\n" +
"    display: none !important;\n" +
"  }\n" +
"  [class=wrapper] .image img {\n" +
"    height: auto !important;\n" +
"    width: 100% !important;\n" +
"  }\n" +
"}\n" +
".footer {\n" +
"  width: 100%;\n" +
"}\n" +
".footer .inner {\n" +
"  padding: 58px 0 29px 0;\n" +
"  width: 600px;\n" +
"}\n" +
".footer .left td,\n" +
".footer .right td {\n" +
"  font-size: 12px;\n" +
"  line-height: 22px;\n" +
"}\n" +
".footer .left td {\n" +
"  text-align: left;\n" +
"  width: 400px;\n" +
"}\n" +
".footer .right td {\n" +
"  max-width: 200px;\n" +
"  mso-line-height-rule: at-least;\n" +
"}\n" +
".footer .links {\n" +
"  line-height: 26px;\n" +
"  Margin-bottom: 26px;\n" +
"  mso-line-height-rule: at-least;\n" +
"}\n" +
".footer .links a:hover {\n" +
"  opacity: 0.8;\n" +
"}\n" +
".footer .links img {\n" +
"  vertical-align: middle;\n" +
"}\n" +
".footer .address {\n" +
"  Margin-bottom: 18px;\n" +
"}\n" +
".footer .campaign {\n" +
"  Margin-bottom: 18px;\n" +
"}\n" +
".footer .campaign a {\n" +
"  font-weight: bold;\n" +
"  text-decoration: none;\n" +
"}\n" +
".footer .sharing div {\n" +
"  Margin-bottom: 5px;\n" +
"}\n" +
".wrapper .footer .fblike,\n" +
".wrapper .footer .tweet,\n" +
".wrapper .footer .linkedinshare,\n" +
".wrapper .footer .forwardtoafriend {\n" +
"  background-repeat: no-repeat;\n" +
"  background-size: 200px 56px;\n" +
"  border-radius: 2px;\n" +
"  color: #ffffff;\n" +
"  display: block;\n" +
"  font-size: 11px;\n" +
"  font-weight: bold;\n" +
"  line-height: 11px;\n" +
"  padding: 8px 11px 7px 28px;\n" +
"  text-align: left;\n" +
"  text-decoration: none;\n" +
"}\n" +
".wrapper .footer .fblike:hover,\n" +
".wrapper .footer .tweet:hover,\n" +
".wrapper .footer .linkedinshare:hover,\n" +
".wrapper .footer .forwardtoafriend:hover {\n" +
"  color: #ffffff !important;\n" +
"  opacity: 0.8;\n" +
"}\n" +
".footer .fblike {\n" +
"  background-image: url(https://i5.createsend1.com/static/eb/master/07-bonbon/imgf/fblike.png);\n" +
"}\n" +
".footer .tweet {\n" +
"  background-image: url(https://i6.createsend1.com/static/eb/master/07-bonbon/imgf/tweet.png);\n" +
"}\n" +
".footer .linkedinshare {\n" +
"  background-image: url(https://i7.createsend1.com/static/eb/master/07-bonbon/imgf/lishare.png);\n" +
"}\n" +
".footer .forwardtoafriend {\n" +
"  background-image: url(https://i10.createsend1.com/static/eb/master/07-bonbon/imgf/forward.png);\n" +
"}\n" +
"@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {\n" +
"  .footer .fblike {\n" +
"    background-image: url(https://i8.createsend1.com/static/eb/master/07-bonbon/imgf/fblike@2x.png) !important;\n" +
"  }\n" +
"  .footer .tweet {\n" +
"    background-image: url(https://i9.createsend1.com/static/eb/master/07-bonbon/imgf/tweet@2x.png) !important;\n" +
"  }\n" +
"  .footer .linkedinshare {\n" +
"    background-image: url(https://i1.createsend1.com/static/eb/master/07-bonbon/imgf/lishare@2x.png) !important;\n" +
"  }\n" +
"  .footer .forwardtoafriend {\n" +
"    background-image: url(https://i2.createsend1.com/static/eb/master/07-bonbon/imgf/forward@2x.png) !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  .footer {\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  .footer td {\n" +
"    display: none;\n" +
"  }\n" +
"  .footer .inner,\n" +
"  .footer .inner td {\n" +
"    display: block;\n" +
"    text-align: center !important;\n" +
"    max-width: 280px !important;\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  .footer .sharing {\n" +
"    Margin-bottom: 40px;\n" +
"  }\n" +
"  .footer .sharing div {\n" +
"    display: inline-block;\n" +
"  }\n" +
"  .footer .fblike,\n" +
"  .footer .tweet,\n" +
"  .footer .linkedinshare,\n" +
"  .footer .forwardtoafriend {\n" +
"    display: inline-block !important;\n" +
"  }\n" +
"}\n" +
".wrapper h1,\n" +
".wrapper h2,\n" +
".wrapper h3,\n" +
".wrapper p,\n" +
".wrapper ol,\n" +
".wrapper ul,\n" +
".wrapper li,\n" +
".wrapper blockquote,\n" +
".image,\n" +
".btn,\n" +
".divider {\n" +
"  Margin-bottom: 0;\n" +
"  Margin-top: 0;\n" +
"}\n" +
".wrapper .column h1 + * {\n" +
"  Margin-top: 24px;\n" +
"}\n" +
".wrapper .column h2 + * {\n" +
"  Margin-top: 20px;\n" +
"}\n" +
".wrapper .column h3 + * {\n" +
"  Margin-top: 18px;\n" +
"}\n" +
".wrapper .column p + *,\n" +
".wrapper .column ol + *,\n" +
".wrapper .column ul + *,\n" +
".wrapper .column blockquote + *,\n" +
".image + .contents td > :first-child {\n" +
"  Margin-top: 24px;\n" +
"}\n" +
".contents:nth-last-child(n+3) h1:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) h1:last-child {\n" +
"  Margin-bottom: 24px;\n" +
"}\n" +
".contents:nth-last-child(n+3) h2:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) h2:last-child {\n" +
"  Margin-bottom: 20px;\n" +
"}\n" +
".contents:nth-last-child(n+3) h3:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) h3:last-child {\n" +
"  Margin-bottom: 18px;\n" +
"}\n" +
".contents:nth-last-child(n+3) p:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) p:last-child,\n" +
".contents:nth-last-child(n+3) ol:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) ol:last-child,\n" +
".contents:nth-last-child(n+3) ul:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) ul:last-child,\n" +
".contents:nth-last-child(n+3) blockquote:last-child,\n" +
".no-padding .contents:nth-last-child(n+2) blockquote:last-child,\n" +
".contents:nth-last-child(n+3) .image,\n" +
".no-padding .contents:nth-last-child(n+2) .image,\n" +
".contents:nth-last-child(n+3) .divider,\n" +
".no-padding .contents:nth-last-child(n+2) .divider,\n" +
".contents:nth-last-child(n+3) .btn,\n" +
".no-padding .contents:nth-last-child(n+2) .btn {\n" +
"  Margin-bottom: 24px;\n" +
"}\n" +
".wrapper .column li + * {\n" +
"  Margin-top: 12px;\n" +
"}\n" +
".two-col .column p + *,\n" +
".two-col .column ol + *,\n" +
".two-col .column ul + *,\n" +
".two-col .column blockquote + *,\n" +
".two-col .image + .contents td > :first-child {\n" +
"  Margin-top: 21px;\n" +
"}\n" +
".two-col .column li + * {\n" +
"  Margin-top: 10px;\n" +
"}\n" +
".two-col .contents:nth-last-child(n+3) p:last-child,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) p:last-child,\n" +
".two-col .contents:nth-last-child(n+3) ol:last-child,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) ol:last-child,\n" +
".two-col .contents:nth-last-child(n+3) ul:last-child,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) ul:last-child,\n" +
".two-col .contents:nth-last-child(n+3) blockquote:last-child,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) blockquote:last-child,\n" +
".two-col .contents:nth-last-child(n+3) .image,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) .image,\n" +
".two-col .contents:nth-last-child(n+3) .divider,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) .divider,\n" +
".two-col .contents:nth-last-child(n+3) .btn,\n" +
".no-padding .two-col .contents:nth-last-child(n+2) .btn {\n" +
"  Margin-bottom: 21px;\n" +
"}\n" +
".three-col .column p + *,\n" +
".three-col .column ol + *,\n" +
".three-col .column ul + *,\n" +
".three-col .column blockquote + *,\n" +
".three-col .image + .contents td > :first-child {\n" +
"  Margin-top: 20px;\n" +
"}\n" +
".three-col .column li + * {\n" +
"  Margin-top: 10px;\n" +
"}\n" +
".three-col .contents:nth-last-child(n+3) p:last-child,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) p:last-child,\n" +
".three-col .contents:nth-last-child(n+3) ol:last-child,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) ol:last-child,\n" +
".three-col .contents:nth-last-child(n+3) ul:last-child,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) ul:last-child,\n" +
".three-col .contents:nth-last-child(n+3) blockquote:last-child,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) blockquote:last-child,\n" +
".three-col .contents:nth-last-child(n+3) .image,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) .image,\n" +
".three-col .contents:nth-last-child(n+3) .divider,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) .divider,\n" +
".three-col .contents:nth-last-child(n+3) .btn,\n" +
".no-padding .three-col .contents:nth-last-child(n+2) .btn {\n" +
"  Margin-bottom: 20px;\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  .wrapper p + *,\n" +
"  .wrapper ol + *,\n" +
"  .wrapper ul + *,\n" +
"  .wrapper blockquote + *,\n" +
"  .image + .contents td > :first-child {\n" +
"    Margin-top: 24px !important;\n" +
"  }\n" +
"  .contents:nth-last-child(n+3) p:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) p:last-child,\n" +
"  .contents:nth-last-child(n+3) ol:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) ol:last-child,\n" +
"  .contents:nth-last-child(n+3) ul:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) ul:last-child,\n" +
"  .contents:nth-last-child(n+3) blockquote:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) blockquote:last-child,\n" +
"  .contents:nth-last-child(n+3) .image:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) .image:last-child,\n" +
"  .contents:nth-last-child(n+3) .divider:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) .divider:last-child,\n" +
"  .contents:nth-last-child(n+3) .btn:last-child,\n" +
"  .no-padding .contents:nth-last-child(n+2) .btn:last-child {\n" +
"    Margin-bottom: 24px !important;\n" +
"  }\n" +
"  .column li + * {\n" +
"    Margin-top: 12px !important;\n" +
"  }\n" +
"}\n" +
".edge {\n" +
"  padding-left: 32px;\n" +
"  padding-right: 32px;\n" +
"}\n" +
".separator {\n" +
"  font-size: 32px;\n" +
"  line-height: 32px;\n" +
"}\n" +
".preheader .title,\n" +
".preheader .webversion {\n" +
"  font-size: 11px;\n" +
"  line-height: 17px;\n" +
"  letter-spacing: 0.01em;\n" +
"}\n" +
".preheader .title {\n" +
"  padding: 9px;\n" +
"  text-align: left;\n" +
"}\n" +
".preheader .webversion {\n" +
"  padding: 9px;\n" +
"  text-align: right;\n" +
"  width: 280px;\n" +
"}\n" +
".preheader .webversion a {\n" +
"  font-weight: bold;\n" +
"}\n" +
".header table {\n" +
"  width: 600px;\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".preheader a,\n" +
".header a {\n" +
"  text-decoration: none;\n" +
"}\n" +
".logo div {\n" +
"  font-weight: bold;\n" +
"}\n" +
".logo div.logo-center {\n" +
"  text-align: center;\n" +
"}\n" +
".logo div.logo-center img {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".divider img {\n" +
"  display: block;\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".gmail {\n" +
"  width: 768px;\n" +
"  min-width: 768px;\n" +
"}\n" +
".gmail td {\n" +
"  font-size: 1px;\n" +
"  line-height: 1px;\n" +
"}\n" +
".wrapper a:hover {\n" +
"  text-decoration: none;\n" +
"}\n" +
".wrapper h1 {\n" +
"  font-size: 34px;\n" +
"  line-height: 42px;\n" +
"}\n" +
".wrapper h2 {\n" +
"  font-size: 26px;\n" +
"  line-height: 34px;\n" +
"}\n" +
".wrapper h3 {\n" +
"  font-size: 20px;\n" +
"  line-height: 28px;\n" +
"}\n" +
".wrapper p,\n" +
".wrapper ol,\n" +
".wrapper ul {\n" +
"  font-size: 16px;\n" +
"  line-height: 24px;\n" +
"}\n" +
".wrapper ol {\n" +
"  Margin-left: 20px;\n" +
"}\n" +
".wrapper ul {\n" +
"  Margin-left: 17px;\n" +
"}\n" +
".mso .wrapper ul {\n" +
"  margin-left: 20px !important;\n" +
"}\n" +
".mso .wrapper ul li {\n" +
"  list-style-image: none;\n" +
"  list-style-type: disc;\n" +
"}\n" +
".wrapper li {\n" +
"  padding-left: 4px;\n" +
"}\n" +
".mso .wrapper li {\n" +
"  padding-left: 5px !important;\n" +
"  margin-left: 10px !important;\n" +
"}\n" +
".wrapper blockquote {\n" +
"  Margin-left: 0;\n" +
"  padding-left: 20px;\n" +
"  padding-right: 0;\n" +
"}\n" +
".preheader,\n" +
".preheader table,\n" +
".header,\n" +
".one-col,\n" +
".two-col,\n" +
".three-col,\n" +
".one-col-feature,\n" +
".one-col-bg,\n" +
".two-col-bg,\n" +
".three-col-bg,\n" +
".one-col-feature-bg {\n" +
"  width: 100%;\n" +
"}\n" +
".one-col,\n" +
".two-col,\n" +
".three-col,\n" +
".one-col-feature {\n" +
"  background-color: #ffffff;\n" +
"  table-layout: fixed;\n" +
"}\n" +
".one-col .column {\n" +
"  width: 600px;\n" +
"}\n" +
".two-col .column {\n" +
"  width: 300px;\n" +
"}\n" +
".two-col .first .padded {\n" +
"  padding-left: 0;\n" +
"  padding-right: 30px;\n" +
"}\n" +
".two-col .second .padded {\n" +
"  padding-left: 30px;\n" +
"  padding-right: 0;\n" +
"}\n" +
".two-col ol {\n" +
"  Margin-left: 17px;\n" +
"}\n" +
".two-col ul {\n" +
"  Margin-left: 16px;\n" +
"}\n" +
".two-col li {\n" +
"  padding-left: 3px;\n" +
"}\n" +
".two-col blockquote {\n" +
"  padding-left: 16px;\n" +
"}\n" +
".three-col .column {\n" +
"  width: 200px;\n" +
"}\n" +
".three-col .first .padded {\n" +
"  padding-left: 0;\n" +
"  padding-right: 20px;\n" +
"}\n" +
".three-col .second .padded {\n" +
"  padding-left: 10px;\n" +
"  padding-right: 10px;\n" +
"}\n" +
".three-col .third .padded {\n" +
"  padding-left: 20px;\n" +
"  padding-right: 0;\n" +
"}\n" +
".three-col ol {\n" +
"  Margin-left: 16px;\n" +
"}\n" +
".three-col ul {\n" +
"  Margin-left: 15px;\n" +
"}\n" +
".three-col li {\n" +
"  padding-left: 4px;\n" +
"}\n" +
".three-col blockquote {\n" +
"  padding-left: 16px;\n" +
"}\n" +
".one-col-feature {\n" +
"  Margin-left: auto;\n" +
"  Margin-right: auto;\n" +
"}\n" +
".one-col-feature .column {\n" +
"  width: 600px;\n" +
"}\n" +
".one-col-feature .padded {\n" +
"  padding-left: 110px;\n" +
"  padding-right: 110px;\n" +
"}\n" +
".one-col-feature h1,\n" +
".one-col-feature h2,\n" +
".one-col-feature h3,\n" +
".one-col-feature p,\n" +
".one-col-feature a,\n" +
".one-col-feature .btn {\n" +
"  text-align: center;\n" +
"}\n" +
".one-col-feature ol {\n" +
"  Margin-left: 22px;\n" +
"}\n" +
".one-col-feature ol li {\n" +
"  padding-left: 0;\n" +
"}\n" +
".one-col-feature ul {\n" +
"  Margin-left: 19px;\n" +
"}\n" +
".one-col-feature ul li {\n" +
"  padding-left: 4px;\n" +
"}\n" +
".one-col-feature blockquote {\n" +
"  padding: 0;\n" +
"  text-align: center;\n" +
"  border: none;\n" +
"}\n" +
".one-col-feature blockquote p {\n" +
"  text-align: center;\n" +
"  margin-left: -35px;\n" +
"  margin-right: -35px;\n" +
"}\n" +
".wrapper h2 {\n" +
"  font-weight: bold;\n" +
"}\n" +
".wrapper h3 {\n" +
"  font-style: italic;\n" +
"}\n" +
".wrapper blockquote {\n" +
"  font-style: italic;\n" +
"}\n" +
"@media only screen and (max-width: 769px) {\n" +
"  .gmail {\n" +
"    display: none !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 730px) {\n" +
"  .edge,\n" +
"  .buffer {\n" +
"    padding: 0px !important;\n" +
"  }\n" +
"}\n" +
"@media only screen and (max-width: 650px) {\n" +
"  [class=wrapper] blockquote {\n" +
"    border-left-width: 5px !important;\n" +
"    padding-left: 15px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature,\n" +
"  [class=wrapper] .column,\n" +
"  [class=wrapper] .logo {\n" +
"    width: 280px !important;\n" +
"  }\n" +
"  [class=wrapper] .preheader .title {\n" +
"    display: none;\n" +
"  }\n" +
"  [class=wrapper] .preheader .webversion {\n" +
"    text-align: center !important;\n" +
"  }\n" +
"  [class=wrapper] .header table {\n" +
"    width: 100% !important;\n" +
"  }\n" +
"  [class=wrapper] .logo {\n" +
"    width: 100% !important;\n" +
"    padding-left: 10px !important;\n" +
"    padding-right: 10px !important;\n" +
"  }\n" +
"  [class=wrapper] .logo img {\n" +
"    max-width: 280px !important;\n" +
"    height: auto !important;\n" +
"  }\n" +
"  [class=wrapper] .column.second .padded,\n" +
"  [class=wrapper] .column.third .padded {\n" +
"    padding-top: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col,\n" +
"  [class=wrapper] .two-col,\n" +
"  [class=wrapper] .three-col,\n" +
"  [class=wrapper] .one-col-feature {\n" +
"    table-layout: auto !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col p,\n" +
"  [class=wrapper] .two-col p,\n" +
"  [class=wrapper] .three-col p,\n" +
"  [class=wrapper] .one-col-feature p,\n" +
"  [class=wrapper] .one-col ol,\n" +
"  [class=wrapper] .two-col ol,\n" +
"  [class=wrapper] .three-col ol,\n" +
"  [class=wrapper] .one-col-feature ol,\n" +
"  [class=wrapper] .one-col ul,\n" +
"  [class=wrapper] .two-col ul,\n" +
"  [class=wrapper] .three-col ul,\n" +
"  [class=wrapper] .one-col-feature ul {\n" +
"    font-size: 16px !important;\n" +
"    line-height: 24px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col ol,\n" +
"  [class=wrapper] .two-col ol,\n" +
"  [class=wrapper] .three-col ol,\n" +
"  [class=wrapper] .one-col-feature ol,\n" +
"  [class=wrapper] .one-col ul,\n" +
"  [class=wrapper] .two-col ul,\n" +
"  [class=wrapper] .three-col ul,\n" +
"  [class=wrapper] .one-col-feature ul {\n" +
"    margin-left: 20px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col li,\n" +
"  [class=wrapper] .two-col li,\n" +
"  [class=wrapper] .three-col li,\n" +
"  [class=wrapper] .one-col-feature li {\n" +
"    padding-left: 4px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature .column {\n" +
"    width: 280px !important;\n" +
"    padding: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature .spacer {\n" +
"    line-height: 12px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature blockquote {\n" +
"    padding-left: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature blockquote p {\n" +
"    margin-left: 0 !important;\n" +
"    margin-right: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature h1 {\n" +
"    line-height: 54px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature h2 {\n" +
"    line-height: 42px !important;\n" +
"  }\n" +
"  [class=wrapper] .one-col-feature li {\n" +
"    padding-left: 0 !important;\n" +
"  }\n" +
"  [class=wrapper] .padded {\n" +
"    padding-left: 15px !important;\n" +
"    padding-right: 15px !important;\n" +
"  }\n" +
"  [class=wrapper] h1 {\n" +
"    font-size: 34px !important;\n" +
"    line-height: 42px !important;\n" +
"  }\n" +
"  [class=wrapper] h2 {\n" +
"    font-size: 26px !important;\n" +
"    line-height: 34px !important;\n" +
"  }\n" +
"  [class=wrapper] h3 {\n" +
"    font-size: 20px !important;\n" +
"    line-height: 28px !important;\n" +
"  }\n" +
"  [class=wrapper] .second .column-top,\n" +
"  [class=wrapper] .third .column-top {\n" +
"    display: none !important;\n" +
"  }\n" +
"}\n" +
"</style>\n" +
"  <!--[if !mso]><!--><style type=\"text/css\">\n" +
"@import url(https://fonts.googleapis.com/css?family=Cabin:400,700,400italic,700italic|PT+Serif:400,700,400italic,700italic);\n" +
"</style><link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700,400italic,700italic|PT+Serif:400,700,400italic,700italic\" rel=\"stylesheet\" type=\"text/css\" /><!--<![endif]--><style type=\"text/css\">\n" +
".wrapper h1{}.wrapper h1{font-family:\"PT Serif\",Georgia,serif}.mso .wrapper h1{font-family:Georgia,serif !important}.wrapper h2{}.wrapper h2{font-family:\"PT Serif\",Georgia,serif}.mso .wrapper h2{font-family:Georgia,serif !important}.wrapper h3{}.wrapper h3{font-family:\"PT Serif\",Georgia,serif}.mso .wrapper h3{font-family:Georgia,serif !important}.wrapper p,.wrapper ol,.wrapper ul,.wrapper .image{}.wrapper p,.wrapper ol,.wrapper ul,.wrapper .image{font-family:Cabin,Avenir,sans-serif}.mso .wrapper p,.mso .wrapper ol,.mso .wrapper ul,.mso .wrapper .image{font-family:sans-serif !important}.wrapper .btn a{}.wrapper .btn a{font-family:Cabin,Avenir,sans-serif}.mso .wrapper .btn a{font-family:sans-serif !important}.logo div{}.logo div{font-family:\"PT Serif\",Georgia,serif}.mso .logo div{font-family:Georgia,serif \n" +
"!important}.title,.webversion,.fblike,.tweet,.linkedinshare,.forwardtoafriend,.link,.address,.permission,.campaign{}.title,.webversion,.fblike,.tweet,.linkedinshare,.forwardtoafriend,.link,.address,.permission,.campaign{font-family:Cabin,Avenir,sans-serif}.mso .title,.mso .webversion,.mso .fblike,.mso .tweet,.mso .linkedinshare,.mso .forwardtoafriend,.mso .link,.mso .address,.mso .permission,.mso .campaign{font-family:sans-serif !important}body,.wrapper,.emb-editor-canvas{background-color:#c2e3e3}.wrapper .title,.wrapper .webversion,.wrapper .footer .inner td{color:#9dc4c4}.title a,.webversion a,.footer a{color:#9dc4c4}.title a:hover,.webversion a:hover,.footer a:hover{color:#6da7a7 !important}.wrapper h1 a,.wrapper h2 a,.wrapper h3 a,.wrapper p a,.wrapper li a{color:#f9ae20}.wrapper h1 a:hover,.wrapper h2 a:hover,.wrapper h3 a:hover,.wrapper p a:hover,.wrapper li a:hover{color:#e09506 \n" +
"!important}.wrapper h1{color:#499f9e}.wrapper h2{color:#499f9e}.wrapper h3{color:#499f9e}.wrapper p,.wrapper ol,.wrapper ul{color:#8f8c8f}.wrapper .image{color:#8f8c8f}.wrapper .btn a{background-color:#f9ae20;color:#fff}.wrapper .btn a:hover{color:#fff !important}.logo div{color:#c2e3e3}.logo div a{color:#c2e3e3}.logo div a:hover{color:#c2e3e3 !important}.one-col blockquote,blockquote .one-col-feature{border-left:5px solid #d9d9d9}.two-col blockquote,.three-col blockquote{border-left:4px solid #d9d9d9}.one-col-feature{background-color:#fff}.one-col-feature a{color:#f9ae20}.emb-editor-canvas{background-color:#bbe0e0}@media (min-width:0){body{background-color:#bbe0e0}}.wrapper .footer .fblike,.wrapper .footer .tweet,.wrapper .footer .linkedinshare,.wrapper .footer .forwardtoafriend{background-color:#617272}\n" +
"</style><meta name=\"robots\" content=\"noindex,nofollow\" />\n" +
"<meta property=\"og:title\" content=\"My First Campaign\" />\n" +
"</head>\n" +
"<!--[if mso]>\n" +
"  <body class=\"mso\">\n" +
"<![endif]-->\n" +
"<!--[if !mso]><!-->\n" +
"  <body class=\"no-padding\" style=\"margin: 0;padding: 0;min-width: 100%;background-color: #c2e3e3;\">\n" +
"<!--<![endif]-->\n" +
"    <center class=\"wrapper\" style=\"display: table;table-layout: fixed;width: 100%;min-width: 650px;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;background-color: #c2e3e3;\">\n" +
"      <table class=\"preheader\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">\n" +
"        <tbody><tr>\n" +
"          <td class=\"title\" style=\"padding: 9px;vertical-align: top;font-family: Cabin,Avenir,sans-serif;font-size: 11px;line-height: 17px;letter-spacing: 0.01em;text-align: left;color: #9dc4c4;\">\n" +
"            \n" +
"          </td>\n" +
"          \n" +
"        </tr>\n" +
"      </tbody></table>\n" +
"      <div class=\"spacer\" style=\"font-size: 1px;line-height: 16px;width: 100%;\">&nbsp;</div>\n" +
"      <table class=\"header\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">\n" +
"        <tbody><tr>\n" +
"          <td style=\"padding: 0;vertical-align: top;\" align=\"center\">\n" +
"            <table class=\"gmail\" style=\"border-collapse: collapse;border-spacing: 0;width: 600px;min-width: 768px;Margin-left: auto;Margin-right: auto;\"><tbody><tr><td style=\"padding: 0;vertical-align: top;font-size: 1px;line-height: 1px;\">&nbsp;</td></tr></tbody></table>\n" +
"            \n" +
"          </td>\n" +
"        </tr>\n" +
"      </tbody></table>\n" +
"      \n" +
"          <table class=\"one-col-bg\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">\n" +
"            <tbody><tr>\n" +
"              <td class=\"edge\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 32px;\">\n" +
"                <table class=\"one-col\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 100%;background-color: #369e9c;table-layout: fixed;\">\n" +
"                  <tbody><tr>\n" +
"                    <td style=\"padding: 0;vertical-align: top;\">&nbsp;</td>\n" +
"                    <td class=\"column\" style=\"padding: 0;vertical-align: top;text-align: left;width: 600px;\">\n" +
"                      <div><div class=\"column-top\" style=\"font-size: 0px;line-height: 0px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>\n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <div style=\"line-height:40px;font-size:1px\">&nbsp;</div>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <div class=\"image\" style=\"font-size: 12px;mso-line-height-rule: at-least;font-style: normal;font-weight: 400;Margin-bottom: 24px;Margin-top: 0;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\" align=\"center\">\n" +
"              <img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 900px;\" src=\"https://drive.google.com/uc?export=view&id=0Bxx0L73mMJuvbVAxWWN4NUc0NmM\" alt=\"Banner\" width=\"480\" height=\"64\" />\n" +


/*"              <img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 900px;\" src=\"https://drive.google.com/uc?export=view&id=0Bxx0L73mMJuvMk5BV080MjRIZ2M\" alt=\"Banner\" width=\"480\" height=\"64\" />\n" +*/


"            </div>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <div style=\"line-height:5px;font-size:1px\">&nbsp;</div>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-size: 16px;line-height: 24px;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\"><span style=\"color:#faf5fa\">Hi <strong style=\"font-weight: bold;\">"+ firstName +"</strong>,</span></p><p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 24px;font-size: 16px;line-height: 24px;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\"><span style=\"color:#faf5fa\">Please click on the following button to reset your password.</span></p><br/>\n" +
"			\n" +
"			<div class=\"btn\" style=\"Margin-bottom: 24px;Margin-top: 0;text-align: center;\">\n" +
"              <![if !mso]><a style=\"border-radius: 3px;display: inline-block;font-size: 14px;font-weight: 700;line-height: 24px;padding: 13px 35px 12px 35px;text-align: center;text-decoration: none !important;transition: opacity 0.2s ease-in;font-family: Cabin,Avenir,sans-serif;background-color: #2020f9;color: #fff;\" href=\"http://csgrad17:8080/TestGDP/resetPassword.jsp\" data-width=\"168\">RESET YOUR PASSWORD</a><![endif]>\n" +
"            <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://csgrad17:8080/TestGDP/resetPassword.jsp\" style=\"width:238px\" arcsize=\"7%\" fillcolor=\"#2020F9\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,12px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:sans-serif;font-weight:700;mso-line-height-rule:exactly;mso-text-raise:4px\">RESET YOUR PASSWORD</center></v:textbox></v:roundrect><![endif]--></div>\n" +
"			\n" +
"			<p style=\"font-style: normal;font-weight: 400;Margin-bottom: 24px;Margin-top: 24px;font-size: 16px;line-height: 24px;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\"><strong style=\"font-weight: bold;\"><span style=\"color:#faf5fa\">The GDP Team</span></strong></p>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <div style=\"line-height:5px;font-size:1px\">&nbsp;</div>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <div style=\"line-height:5px;font-size:1px\">&nbsp;</div>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            \n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <p class=\"size-11\" style=\"font-style: normal;font-weight: 400;Margin-bottom: 24px;Margin-top: 0;font-size: 11px;line-height: 19px;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\"><span style=\"color:#ffffff\"></span></p>\n" +
"          \n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">\n" +
"                          <tbody><tr>\n" +
"                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 60px;padding-right: 60px;word-break: break-word;word-wrap: break-word;\">\n" +
"                              \n" +
"            <p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-size: 16px;line-height: 24px;font-family: Cabin,Avenir,sans-serif;color: #8f8c8f;\">\n" +
"          \n" +
"                            </p></td>\n" +
"                          </tr>\n" +
"                        </tbody></table>\n" +
"                      \n" +
"                      \n" +
"                    </td>\n" +
"                    <td style=\"padding: 0;vertical-align: top;\">&nbsp;</td>\n" +
"                  </tr>\n" +
"                </tbody></table>\n" +
"              </td>\n" +
"            </tr>\n" +
"          </tbody></table>\n" +
"          <p style=\"line-height: 32px; color: #999; width: 93%; text-align: right; font-size: 13px; margin: 0; padding: 0;\"> © 2016 GDP Team, All rights are reserved.</p>\n" +
"          \n" +
"        \n" +
"      \n" +
"    </center>\n" +
"  \n" +
"\n" +
"</body></html>";
	        
	        
	        
	        message.setContent(someHtmlMessage, "text/html; charset=utf-8");
	        Transport.send(message);

	        //System.out.println(email);
	        //System.out.println("Your mail has been Sent");	        

	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }

		
		
	}

	
}

