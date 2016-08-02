<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
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

<%--              <c:choose>
            <c:when test="${empty listofpapers}">
                <center><h1>No Papers to display.</h1></center>                
            </c:when>
            
                <c:otherwise>                
                    <center>
                        <h1>SUBMITTED PAPERS</h1>
                        <table border="1" width="800px">
                            <tr>
                                <th>Paper Title</th>
                                <th>Abstract</th>  
                                <th>Download a Paper</th>                            
                            </tr>

                            <c:forEach items="${listofpapers}" var="paper">
                                <tr> 
                                    <td><c:out value="${paper.paperTitle}"/></td>
                                    <td><c:out value="${paper.abstractOfThePaper}"/></td>

                                    <td><a href="${pageContext.request.contextPath}/paperdownload/${paper.paperID}.htm">Download</a></td>                                       
                                </tr>
                            </c:forEach>
                        </table>
                        
                    </center>
                </c:otherwise>
        </c:choose>  
        <a href="${pageContext.request.contextPath}/addapaper.htm">Submit A New Paper</a> --%>
        
        <!-- ================Start - body Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">


            <ul class="nav nav-tabs" style="margin-bottom: 15px; margin-top: 15px;">
                <li class="active"><a data-toggle="tab" href="#submitPaper">Submit A Paper</a></li>
                <li><a data-toggle="tab" href="#update">Update/Modify</a></li>
                <li><a data-toggle="tab" href="#remove">Remove</a></li>
                <li><a data-toggle="tab" href="#feedBack">Feed Back</a></li>
            </ul>

            <div class="tab-content">
                <div id="submitPaper" class="tab-pane fade in active">
                    <form id="ceForm" action="${pageContext.request.contextPath}/saveapaper.htm" method="post" enctype="multipart/form-data" class="form-horizontal">
                        <div class="row">
                            <!-- Text input-->
                            <div class="col-md-10">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectEvent">Event Name:</label>  
                                    <div class="col-md-5">
                                        <select class="selectpicker form-control">
                                            <option>Security Shell</option>
                                            <option>Tech Zone</option>
                                            <option>Great It</option>
                                        </select>
                                    </div>
                                </div>


                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="paperTitle">Paper Title:</label>  

                                    <div class=' col-md-5' >
                                        <input id='paperTitle' name="paperTitle" type='date' class="form-control" />
                                    </div>

                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="uploadPaper">Upload Paper:</label>  

                                    <div class=' col-md-5' >
                                        <input id="uploadPaper"  name="uploadPaper" type='file' class="form-control"  />
                                    </div>

                                </div>

                                <!-- Text Area input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="abstract">Abstract:</label>  
                                    <div class="col-md-5">

                                        <textarea id="abstract" name="abstract"  class="form-control" rows="5" cols="20" required="required"
                                                  placeholder="Eneter Abstract here"></textarea>
                                    </div>
                                </div>
                                <!-- Button (Double) -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="submitBtn"></label>
                                    <div class="col-md-5">
                                        <!-- <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />-->
                                        <input type="button" id="submitBtn" name="submitBtn" class="btn btn-primary" value="Submit Paper" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                Role:
                                <select class="dropdown-toggle">
                                    <option value="author">Program Chair </option>
                                    <option value="reviewer">Reviewer</option>
                                    <option value="pc">Author</option>

                                </select>
                            </div>
                        </div>     
<c:choose>
            <c:when test="${empty listofpapers}">
                <center><h1>No Papers to display.</h1></center>                
            </c:when>
            
                <c:otherwise>                
                    <center>
                        <h1>SUBMITTED PAPERS</h1>
                        <table border="1">
                            <tr>
                                <th>Paper Title</th>
                                <th>Abstract</th>  
                                <th>Download a Paper</th>                            
                            </tr>

                            <c:forEach items="${listofpapers}" var="paper">
                                <tr> 
                                    <td><c:out value="${paper.paperTitle}"/></td>
                                    <td><c:out value="${paper.abstractOfThePaper}"/></td>

                                    <td><a href="${pageContext.request.contextPath}/paperdownload/${paper.paperID}.htm">Download</a></td>                                       
                                </tr>
                            </c:forEach>
                        </table>
                        
                    </center>
                </c:otherwise>
        </c:choose>  
       <%--  <a href="${pageContext.request.contextPath}/addapaper.htm">Submit A New Paper</a>  --%>

                    </form>
                    
                </div>
                <div id="update" class="tab-pane fade">
                    <h3>Under Construction...</h3>
                    <p>...</p>
                </div>
                <div id="remove" class="tab-pane fade">
                    <h3>Under Construction...</h3>
                    <p>...</p>
                </div>
                <div id="feedBack" class="tab-pane fade">
                    <h3>Under Construction...</h3>
                    <p>...</p>
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
