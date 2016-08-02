<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LogIn Assistance</title>
		<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/styles.css" rel="stylesheet" type="text/css"/>
        
		<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
          <img src="http://csgrad17:8080/TestGDP/resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>

      
      </div>
            <!-- ================Start - body Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
               
         
            <div>
                
            
    
        <form id="forgotPasswordForm" method="post" class="form-horizontal">
           
           <h3 class="text-center" >Password Recovery</h3>
    	   <h5 class="text-center">Enter your Email Address to reset your password</h5><hr>
    	   </br></br>
    			
                <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label">Email Address:</label>  
                    <div class="col-md-4">
                        <input id="userEmailForgotPassword" type="email" placeholder="Enter your email id" class="form-control input-md" required="">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-4 control-label" ></label>
                    <div class="col-md-4">
                        <button type="submit" id="btnSignForgotPassword" name="btnSign" class="btn btn-primary center-block" value="Submit" >Send Email</button>
                    </div>
                </div>
        </form>
        
        
        
        <div class="form-group" id="sendMail" style="display: none;">
            <label class="col-md-12 control-label" style="text-align: center;">A Mail has been sent to reset your password</label>
        </div>

    </div>
                
                
                
            </div>
            
            
                   <!-- ================End - Body Section=============== -->
                   
        <!-- ================Start - Footer Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

            <p class="text-center">&copy; 2015 GDP team ,All rights are reserved.<p>
            

        </div>   

        <!-- ================End - Footer Section=============== -->                   


</body>
</html>
