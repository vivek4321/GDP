<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
		<link href="resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/styles.css" rel="stylesheet" type="text/css"/>
        
		<script src="resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
        <script src="resources/js/scripts.js" type="text/javascript"></script>
        
        <link href="resources/css/datepicker.css" rel="stylesheet" type="text/css"/>        
		<script src="resources/js/lib/bootstrap-datepicker.js" type="text/javascript"></script>
</head>
<body>


<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
          <img src="resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>

      
      </div>
            <!-- ================Start - body Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
               
         <div class="">
        <h3 class="text-center" >Registration</h3>
    
            <hr>
    
        <form id="regFrm" method="post" class="form-horizontal">
           
                <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="regFirstname">First Name:</label>  
                    <div class="col-md-5">
                        <input id="regFirstname" name="regFirstname" type="text" placeholder="enter your first name" class="form-control input-md" required="" >

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="regLastname">Last Name:</label>  
                    <div class="col-md-5">
                        <input id="regLastname" name="regLastname" type="text" placeholder="enter your last name" class="form-control input-md">

                    </div>
                </div>
                
                
                 <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">E-mail:</label>  
                    <div class="col-md-5">
                        <input id="email" name="email" type="email" placeholder="enter your e-mail address" class="form-control input-md" required="">

                    </div>
                </div>
               
              
                 <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="regPhonenum">Phone Number:</label>  
                    <div class="col-md-5">
                        <input id="regPhonenum" name="regPhonenum" pattern="[0-9]{10}" type="text" placeholder="enter your '10 digit' phone number" class="form-control input-md" required="">

                    </div>
                </div>
                 
                  <!-- Text input-->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="datetimepicker1">Date of Birth:</label>  

                       <div class=' col-md-5' id='datetimepicker1'>
                       <div class="input-append date datepicker no-padding" data-date-format="dd-mm-yyyy">
                                        <input id="date1" name="date1" class="input-medium form-control" size="16" type="text"><span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                       
                           <!-- <input type='date' id="date1" name="date1" class="form-control" required="" /> -->
                      </div>
          
                 </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="regPassword">Password:</label>
                    <div class="col-md-5">
                        <input id="regPassword"  minlength="4"  name="regPassword" type="password" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Password should be at least 4 characters</span>
                    </div>
          
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="regConfrimPass">Password (Confirm):</label>
                    <div class="col-md-5">
                        <input id="regConfrimPass" minlength=4 name="regConfrimPass" type="password" placeholder="" class="form-control input-md" required="">
						<br><p id="validate-status"></p>
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="regClearBtn"></label>
                    <div class="col-md-8">
                        <input type="reset" id="regClearBtn" name="regClearBtn" class="btn btn-primary" value="Clear" />
                        <input type="submit" id="registerBrn" name="registerBrn" class="btn btn-primary" value="Register" />
                    </div>
                </div>

    
        </form>

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
		
		 $("#regConfrimPass").keyup(validate);		 
	});

$(document).ready(function() {
    // adding todays date as the value to the datepickers.
    var d = new Date();
    var curr_day = d.getDate();
    var curr_month = d.getMonth() + 1; //Months are zero based
    var curr_year = d.getFullYear();
    var eutoday = curr_day + "-" + curr_month + "-" + curr_year;
    var ustoday = curr_month + "-" + curr_day + "-" + curr_year;
    $("div.datepicker input").attr('value', eutoday);
    $("div.usdatepicker input").attr('value', ustoday);

    //calling the datepicker for bootstrap plugin
    // https://github.com/eternicode/bootstrap-datepicker
    // http://eternicode.github.io/bootstrap-datepicker/
    $('.datepicker').datepicker({
        autoclose: true,
        startDate: new Date()
    });
});

	function validate() {
	  var password1 = $("#regPassword").val();
	  var password2 = $("#regConfrimPass").val();
	 
	    if(password1 == password2) {
	       $("#validate-status").html("<span style='color:green'>Valid Password<span>");        
	    }
	    else {
	       $("#validate-status").html("<span style='color:red'>Invalid password<span>");
	    }
	   
	}
</script>
</body>
</html>
