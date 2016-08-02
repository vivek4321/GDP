<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>



<%

            response.setHeader("Cache-Control", "no-cache"); //forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
            

            String userName = (String) session.getAttribute("User");
            if (null == userName) {
                request.setAttribute("Error", "Session has ended.  Please login.");
                RequestDispatcher rd = request.getRequestDispatcher("http://csgrad17:8080/TestGDP/");
                rd.forward(request, response);
            }
%>
        
        


<html>
<head>
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/scripts.js" type="text/javascript"></script>
        
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body>

<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
            <img src="http://csgrad17:8080/TestGDP/resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>


        </div>
        <!-- ================Start - body Section=============== -->
      <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
        <div style="margin-left: 92%"><a  type="button" id="signout">Sign Out</a></div><br/>
        <center>
        <h3>Paper Submitted Successfully</h3>
        Please Click here to go back
        
        <br><br><br>
        <a href="/redirectAfterSuccess" class="btn btn-primary"></a>
        </center>
           
           
           
           
            </div>
        
 

        <!-- ================End - Body Section=============== -->



 <!-- ================Start - Footer Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

            <p class="text-center">&copy; 2015 GDP team ,All rights are reserved.<p>

        </div>   

        <!-- ================End - Footer Section=============== -->

</body>
<script>
/*********************Update and Modify -start ******************************/

	


</script>

</html>