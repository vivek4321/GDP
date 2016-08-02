<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>



<%

            response.setHeader("Cache-Control", "no-cache"); //forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
            

            String userName = (String) session.getAttribute("User");
            //out.println(userName);
            if (null == userName) {
                request.setAttribute("Error", "Session has ended.  Please login.");
                //RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("");                
                rd.forward(request, response);
            }
%>





<html>
<head>
	<link href="resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
</head>
<body>

<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
            <img src="resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>


        </div>
        <!-- ================Start - body Section=============== -->
      <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
                         <h2>Paper has been submitted successfully!</h2>
                      <%-- <form action="${pageContext.request.contextPath}/goBackAfterPaperSubmit" >
                       <div class="form-group">
                                    <label class="col-md-4 control-label" for="submitBtn"></label>
                                    <div class="col-md-5">
                                        <!-- <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />-->
                                        <input type="submit" id="goBackBtn"  name="goBackBtn" class="btn btn-primary" value="Go Back " />                                    
                                    </div>
                                </div>
                                </form> --%>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/goBackAfterPaperSubmit">Go Back</a>
                </div>

 <!-- ================Start - Footer Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

            <p class="text-center">&copy; 2015 GDP team ,All rights are reserved.<p>

        </div>   

        <!-- ================End - Footer Section=============== -->

</body>
</html>