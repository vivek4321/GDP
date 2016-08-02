<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>

<%





	String error = (String) request.getAttribute("Error");
	if (error != null) {
		out.write("<center><strong>");
		out.write("<font color=\"Red\">");
		out.write(error);
		out.write("</font>");
		out.write("</strong></center>");
	}
%>


<html>
<head>
	<title>LogIn</title>
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
                <h3 class="text-center" >Sign-In</h3>
    
            <hr>
    
        <form id="signForm" method="post" class="form-horizontal">
           
                <!-- Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label" for="userName">User email:</label>  
                    <div class="col-md-4">
                        <input id="userName" name="userName" type="email" placeholder="Enter your email" class="form-control input-md" required="">

                    </div>
                </div>



                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Password :</label>
                    <div class="col-md-4">
                        <input id="password" name="password" type="password" placeholder="Enter password" class="form-control input-md" required=""/>

                    </div>
                </div>
                 <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <input type="radio" name="radio" id="chair" value="chair" >Program Chair &nbsp;
                            <input type="radio" name="radio" id="reviewer" value="reviewer">Reviewer &nbsp;
                            <input type="radio" name="radio" id="author" value="author">Author <br><br>
                            <a id="forgotPassword" href="http://csgrad17:8080/TestGDP/forgotPassword.jsp">Forgot password?</a>
                        </div>

                    </div>
                    <!-- Forgot Password --> 
              <!--   <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <a id="forgotPassword" href="#">Forgot password?</a>
                </div>
                
            </div> -->
                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" ></label>
                    <div class="col-md-8">
                        <input type="submit" id="btnSign" name="btnSign" class="btn btn-primary" value="Sign-In" />
                        <button  type="button" id="btnReg" name="btnSign" class="btn btn-primary" value="Register" >Register</button>
 
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


</body>


</html>
