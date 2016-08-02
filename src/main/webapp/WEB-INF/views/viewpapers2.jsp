<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false"%> --%>


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
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/carousel.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/styles.css" rel="stylesheet" type="text/css" />
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/scripts.js" type="text/javascript"></script>
</head>
<body>
	<div id="page" class="container white"
		style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
		<img src="http://csgrad17:8080/TestGDP/resources/img/Banner.png"
			class="img-responsive img-rounded imgBanner" alt="Banner" />
	</div>
	
	
	
	
	<div class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
<div class="row">
<div class="col-md-12">
<ul class="pager pull-right" id="switchRole"></ul>
<ul class="nav nav-tabs" style="margin-bottom: 15px; margin-top: 15px;">
               	<li class="active"><a data-toggle="tab" href="#reviewPaper">Review Paper</a></li>                	
           	</ul>
</div>	

</div>
<a class="pull-right" style="margin-right: 15px" type="button" id="signout"  >Sign Out</a>


<div class="tab-content">
           <div id="#reviewPaper" class="tab-pane fade in active">
           
		<c:choose>
			<c:when test="${empty listofpapers}">
				<center>
					<h1>No Papers to display.</h1>
				</center>
			</c:when>

			<c:otherwise>
				<center>
					<h3 class="text-center">Review Papers</h3>
					<br />
					<table class="table">
						<thead class="bg-primary">
							<th>Paper ID</th>
							<th>Paper Title</th>
							<th>Abstract</th>
							<th>Status</th>
							<th>Submitted By</th>
							<th>Download a Paper</th>
							<th>Enter Feedback</th>
						</thead>
						<tbody>
							<c:forEach items="${listofpapers}" var="paper">
								<tr>
									<td><c:out value="${paper.paperID}" /></td>
									<td><c:out value="${paper.paperTitle}" /></td>
									<td><c:out value="${paper.abstractOfThePaper}" /></td>
									<td><div id="${paper.paperID}status"><c:out value="${paper.status}" /></div></td>
									<td><c:out value="${paper.author}" /></td>
									<td><a href="${pageContext.request.contextPath}/paperdownload/${paper.paperID}.htm" id="${paper.paperID}download">Download</a></td>
									<td><button class="btn btn-primary" data-toggle="modal" 
											data-target="#enterFeedback"
											onClick="call('(${paper.paperID})' , '(${paper.paperTitle})')">Feedback</button></td>
											
									<script>
										$('#${paper.paperID}download').click(function() {									
											$( "#${paper.paperID}status" ).html("Review in Progress");
										});
									</script>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</center>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</div>

	<div id="enterFeedback" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header bg-success">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Enter Feedback</h4>
				</div>
				<form action="" id="feedBackDataForm">
				<div class="row">
                            
                            
					<div class="modal-body">
					<div class="form-group">
                                    <label class="col-md-3 control-label" for="paperTitle">Paper Title:</label>  

                                    <div class=' col-md-4' >
						<b><p id="pd" class="text-capitalize"></p></b></div>
						</div>
						<input type="hidden" value="" id="feedHidden"> <br />
						<div class="form-group">
                                    <label class="col-md-3 control-label" for="paperTitle">Feedback :</label>  

                                    <div class=' col-md-9' >
						<textarea id="feedbackData" class="form-control" rows="5"  ></textarea>
						</div></div>
					</div>
					</div>
					<br/>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						<button type="submit" id="feedForm" class="btn btn-primary"
							data-dismiss="modal">Submit</button>
					</div>
				</form>
			</div>

		</div>
	</div>


	<%-- <a href="${pageContext.request.contextPath}/addapaper.htm">Submit A New Paper</a> --%>

	<!-- ================Start - body Section=============== -->


	<!-- ================End - Body Section=============== -->
	<!-- ================Start - Footer Section=============== -->
	<div id="page" class="container white"
		style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

		<p class="text-center">
			&copy; 2015 GDP team ,All rights are reserved.
			<p>

        </div>   

        <!-- ================End - Footer Section=============== -->
</body>

<script type="text/javascript">
	
	function call(datad, totle) { 

		totle = totle.substring(1, (totle.length) - 1);
		datad = datad.substring(1, (datad.length) - 1);
		$("#pd").html(totle);

		$('#feedHidden').val(datad);
	}

	$(document).ready(function() {
 
		
		$('#switchRole').append('<li><a href=' + "${pageContext.request.contextPath}/createanevent.jsp" + '>PC</a> | </li>');
		$('#switchRole').append('<li><a href=' + "${pageContext.request.contextPath}/papersubmission.jsp" + '>Author</a></li>');
		
		
		/* $.ajax({

			url : "http://localhost:8080/test/getallpapers",
			type : "GET",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {		

			},
			complete : function() {

			}
		});	 */	
 
	});
</script>
</html>
