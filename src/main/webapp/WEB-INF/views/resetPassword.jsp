<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Reset Password</title>
		<link href="resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/styles.css" rel="stylesheet" type="text/css"/>
        
		<script src="resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
        <script src="resources/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
          <img src="resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>

      
      </div>
            <!-- ================Start - body Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
               
         
            <div>
                
            <hr>
    
        <form id="forgotPasswordForm" class="form-horizontal">
           
           <h3 class="text-center" >Reset Your Password</h3>
    	   <h5 class="text-center">Enter your Email Address to reset your password</h5></br></br>
    			
                <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label">Email Address:</label>  
                    <div class="col-md-4">
                        <input id="userEmailforpwReset" type="email" placeholder="Enter your email id" class="form-control input-md" required="">
                    </div>
                </div>


				<div class="form-group">
                    <label class="col-md-4 control-label">New Password:</label>
                    <div class="col-md-4">
                        <input id="newPassword" name="newPassword" type="password" placeholder="Enter your new password" class="form-control input-md" required=""/>

                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label">Confirm New Password:</label>
                    <div class="col-md-4">
                        <input id="newPasswordConfirm" name="newPassword" type="password" placeholder="Confirm your new password" class="form-control input-md" required=""/>
						<br><p id="validate-status"></p>
                    </div>
                </div>
                

                <div class="form-group">
                    <div class="col-md-15">
                        <button type="submit" id="btnResetPassword" name="btnSign" class="btn btn-primary center-block" value="continue" >Continue</button>
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


<script>

$(document).ready(function() {

	$("#newPasswordConfirm").keyup(validate);	
	$('#forgotPasswordForm').submit(function(e){ 
	  var bool = validate();
	  if(!bool)
	   e.preventDefault(); // will stop the form from submitting
	  else
	   return true; //continue to submit form
	});
	});


	function validate() {
	var password1 = $("#newPassword").val();
	var password2 = $("#newPasswordConfirm").val();

	  if(password1 == password2) {
	     $("#validate-status").html("<span style='color:green'>Valid Password<span>");        
	  }
	  else {
	     $("#validate-status").html("<span style='color:red'>Your conformation paasword did not match the password you entered<span>");
	  }
	 return true ;  
	}

</script>



</body>
</html>
