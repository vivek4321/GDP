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
      <ul class="pager pull-right" id="switchRole"></ul>      
        <ul class="nav nav-tabs" style="margin-bottom: 15px; margin-top: 15px;">
                <li class="active"><a data-toggle="tab" href="#submitPaper">Submit A Paper</a></li>
                <li><a data-toggle="tab" href="#update">Update/Modify</a></li>
                <li><a data-toggle="tab" href="#remove">Remove</a></li>
                <li><a data-toggle="tab" href="#feedBack">Feed Back</a></li>
                <!--  <li class="pull-right"><button  type="button" id="signout" name="btnSign" class="btn btn-primary" value="Register" >Sign Out</button></li> -->
         
            </ul>
            <div style="margin-left: 92%"><a  type="button" id="signout">Sign Out</a></div><br/>
            <div class="tab-content">
            <div id="submitPaper" class="tab-pane fade in active">
            <form action="${pageContext.request.contextPath}/saveapaper.htm" method="post" enctype="multipart/form-data" class="form-horizontal">     
                <div class="row">
                <input type="hidden" id="userEmailLogin" name="userEmailLogin"/>
                <script>
                	$('#userEmailLogin').val(document.cookie);                
                </script>
                
                <div class="col-md-10">
                <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectEvent">Event Name:</label>  
                                    <div class="col-md-5">
                                        <select id="eventnamesload" name="eventnamesload" class="selectpicker form-control">
                                            <option>Select an Event</option>
                                            
                                        </select>
                                    </div>
                                </div>
                                     <div class="form-group">
                                    <label class="col-md-4 control-label" for="paperTitle">Paper Title:</label>  

                                    <div class=' col-md-5' >
                                        <input id='paperTitle' name="paperTitle" type='text' class="form-control" required />
                                    </div>

                                </div>
                
                          <div class="form-group">
                                    <label class="col-md-4 control-label" for="uploadPaper">Upload Paper:</label>  

                                    <div class=' col-md-5' >
                                        <input type="file" name="documentcontent1" id="documentcontent1" class="form-control" required  />
                                    </div>

                                </div>
                                
                               <div class="form-group">
                                    <label class="col-md-4 control-label" for="abstract">Abstract:</label>  
                                    <div class="col-md-5">

                                        <textarea id="paperabstract" name="paperabstract"  class="form-control" rows="5" cols="20" 
                                                  placeholder="Enter Abstract here" required ></textarea>
                                    </div>
                                </div>
                       <div class="form-group">
                                    <label class="col-md-4 control-label" for="submitBtn"></label>
                                    <div class="col-md-5">
                                        <!-- <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />-->
                                        <input type="submit" id="submitBtn" name="submitBtn" class="btn btn-primary" value="Submit Paper" />
                                    </div>
                                </div>
                </div>
                
                <!-- <div class="col-md-2">
                                Role:
                                <select id="dropdown1" class="dropdown-toggle">
                                	<option value="author">Author</option>
                                    <option value="chair">Program Chair </option>
                                    <option value="reviewer">Reviewer</option>
                                </select>
                
                </div>  -->  
                </div>                    
            </form>   
                                             
        </div>
        <div id="update" class="tab-pane fade">
        <form id="updateform" action="${pageContext.request.contextPath}/updateOrModifyAPaper" method="post" enctype="multipart/form-data" class="form-horizontal">
                    <div class="row">
                            <div class="col-md-10">
                                <!-- Paper selection-->
                                 <input type="hidden" id="userEmailForUpdate" name="userEmailForUpdate"/>
                <script>
                	$('#userEmailForUpdate').val(document.cookie);                
                </script>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectEvent">Paper: </label>  
                                    <div class="col-md-5">
                                        <select id = "paperDropdown" name="paperDropdown" class="selectpicker form-control">
                                            <option >Select paper</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- Version selection-->

                         <!--     <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectEvent">Available Versions:  </label>  
                                    <div class="col-md-5">
                                        <select name = "versionDropdown" id = "versionDropdown" class="selectpicker form-control">
                                            <option >Select version</option>
                                        </select>
                                    </div>
                                </div> -->

                                <!-- Radio button-->

                                <div class="form-group">

                                    
                                        <label class="col-md-4 control-label" for="submitBtn"></label>
                                    
                                    <div class="col-md-5">
                                        <input id="updateId" type="radio" name="updateOrModify"  value="update" onclick="hideupdate()">Update &nbsp;
                                        <input id="modifyId" type="radio" name="updateOrModify" value="modify" onclick="hidemodify()">Modify
                                    </div>

                                </div>
                                <!-- new version upload -->
                                <div class="form-group" id="updatestuff">
                                    <label class="col-md-4 control-label" for="uploadPaper">New Paper: </label>  

                                    <div class=' col-md-5' >
                                        <input id="newVersionUpload"  name="newVersionUpload" type='file' class="form-control"  />
                                    </div>
                                </div>

                                <div id= "modifystuff" class="form-group">
                                    <label class="col-md-4 control-label" for="paperTitle">Modify Title:</label>  

                                    <div class=' col-md-5' >
                                        <input id='modifyTitle' name="paperTitle" type='text' class="form-control" /> <br>
                                    </div>
                                    
                                   
                                    <label class="col-md-4 control-label" for="eventnamesloadupdate">Event Name:</label>  
                                    <div class="col-md-5">
                                        <select id="eventnamesloadupdate" name="eventnamesloadupdate" class="selectpicker form-control">
                                            <option>Select an Event</option>
                                            
                                        </select>
                                          <br>
                                    </div>
                             

                                    <label class="col-md-4 control-label" for="abstract">Update abstract:</label>  
                                    <div class="col-md-5">

                                        <textarea id="updateAbstract" name="abstract"  class="form-control" rows="5" cols="20" required="required"
                                                  placeholder="Enter Abstract here"></textarea>
                                    </div>
                                </div>
                                <!-- Text input-->

                                <!-- Button (Double) -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="submitBtn"></label>
                                    <div class="col-md-5">
                                        <!-- <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />-->
                                        <input type="submit" id="submitUpdates" name="submitUpdates" class="btn btn-primary" value="Submit" />
                                    </div>
                                </div>



                            </div>

                        </div>
                        </form>
      </div>
      
      
      
      
      
      

      
      <div id="remove" class="tab-pane fade">
		   
		<table id="RemovePapersTableHead" class="table">
			<tr class="bg-primary">
				<th>Paper Title</th>
				<th>Abstract</th>
				<th>Event Name</th>
				<th>Download A Paper</th>
				<th>Remove A Paper</th>
			</tr>
			<tbody id = "RemovePapersTableBody"></tbody>
		</table>

      <br/> <br/>                          
	  </div>









<div id="feedBack" class="tab-pane fade">
<form id="feedbackform" action="" class="form-horizontal">
                    <div class="row">
                            <!-- Paper selection-->
                            <div class="col-md-10">
                                <!-- <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectEvent">Paper: </label>  
                                    <div class="col-md-5">
                                        <select id = "dropdown" class="selectpicker form-control" >
                                            <option id="1">Select paper</option>
                                        </select>
                                    </div>
                                </div> -->
                                
                                <div id="feedbackTable">	
								</div>
								
                                <!-- View Feedback Button (Double)
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="submitBtn"></label>
                                    <div class="col-md-5">
                                        <!-- <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />
                                        <input type="button" id="viewFeedbackBtn" name="feedbackBtn" class="btn btn-primary" value="View Feedback" />
                                    </div>
                                    <div class="col-md-4 control label">
                                    </div> -->
                                    
                                                         <!-- <div class="form-group" >
                                    <label class="col-md-4 control-label" id="feedBackViewAreaLabel" for="feedBackViewArea">Feedback :</label>  
                                    <div class="col-md-5">

                                        <textarea id="feedBackViewArea" name="feedBackViewArea"  class="form-control" rows="10" cols="20" 
                                                  placeholder="View Feedback"  ></textarea>
                                    </div>
                                </div>
                                    <div class="form-group" >
                                        <label class="col-md-4 control-label" for="submitBtn"></label>
                                        <div class="col-md-5">
                                            <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />
                                            <input type="button" id="viewFeedbackBtn" data-toggle="modal" name="feedbackBtn" data-target="#myModal" class="btn btn-primary" value="Review Feedback" />
                                        
                                     
                                    </div>
                                        </div> -->
                                </div>
                                <!-- Text Area input-->
                                
           <!--                      <div class="form-group" >
                                    <label class="col-md-4 control-label" id="feedBackViewAreaLabel" for="feedBackViewArea">Feedback :</label>  
                                    <div class="col-md-5">

                                        <textarea id="feedBackViewArea" name="feedBackViewArea"  class="form-control" rows="10" cols="20" 
                                                  placeholder="View Feedback"  ></textarea>
                                    </div>
                                </div>
                                    <div class="form-group" >
                                        <label class="col-md-4 control-label" for="submitBtn"></label>
                                        <div class="col-md-5">
                                            <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />
                                            <!-- <input type="button" id="viewFeedbackBtn" data-toggle="modal" name="feedbackBtn" data-target="#myModal" class="btn btn-primary" value="Review Feedback" /> -->
                                        
                                     
                                    </div>
                                        </div>
                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label" for="abstract">Review: </label>  
                                                        <div class="col-md-9">

                                                            <textarea id="abstract" name="abstract"  class="form-control" rows="5" cols="20" required="required"
                                                                      placeholder="Type your review"></textarea>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancel</button> &nbsp;
                                                    <button id ="submitReview" type="button" class="btn btn-primary" data-dismiss="modal" >Submit Review</button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
</form>
                            </div>   

                        </div>
                        
                </div>
          <!--   </div>
        </div>
 -->

        <!-- ================End - Body Section=============== -->



 <!-- ================Start - Footer Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

            <p class="text-center">&copy; 2015 GDP team ,All rights are reserved.<p>

        </div>   

        <!-- ================End - Footer Section=============== -->

</body>
<script>
/*********************Update and Modify -start ******************************/
function hideupdate(){
    $("#modifystuff").hide();
  	$("#updatestuff").show();
}

function hidemodify(){
    $("#updatestuff").hide();
   	$("#modifystuff").show();
}
/*********************Update and Modify - End******************************/

$(document).ready(function () {
	
	//$('#submitBtn').click(function () {alert ("Paper has been submitted sucessfully")});
	
	
	$('#switchRole').append('<li><a href=' + "${pageContext.request.contextPath}/createanevent.jsp" + '>PC</a> | </li>');
	$('#switchRole').append('<li><a href=' + "http://csgrad17:8080/TestGDP/getallpapers" + '>Reviewer</a></li>');
	
	/*******************Loading Events************************/
	var username = document.cookie;
  	//var u1 = username.split('.');
  	var u1 = username.replace(/\./g, "*****");
	$.ajax({

		url : "http://csgrad17:8080/TestGDP/authoreventslist/"+u1,
		//url : "http://192.168.0.16:8080/test/eventlist/"+u1[0],
		type : "GET",
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			
			$.each(data, function () {
				console.log(this);
			    $('#eventnamesload').append($('<option value="' + this.eventID + "&&" + this.eventName + '">' + this.eventName + '</option>'));
			    $('#eventnamesloadupdate').append($('<option value="' + this.eventID + "&&" + this.eventName + '">' + this.eventName + '</option>'));			    
			});
		},
		complete : function() {

		}
	});		
	
	/***********************************Feedback Viewing*************************/
		var username = document.cookie;
		//var u1 = username.split('.');
		var u1 = username.replace(/\./g, "*****");
		$.ajax({

			url : "http://csgrad17:8080/TestGDP/getpapersforviewingfeedback/"+u1,
			type : "GET",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				
				$("#feedBackViewArea").hide();
				$("#feedBackViewAreaLabel").hide();
				
				/* $.each(data, function () {
					console.log(data);
					$('#dropdown').append($('<option value="' + "LLL" + '">' + this.pID + '</option>'));
					
				    //$('#dropdown').append($('<option value="' + this.reviewerFeedback + '">' + this.paperTitle + '</option>'));
				    //$('#dropdown').append($('<option value="' + this.feedback + '">' + this.paperFeedbackID + '</option>'));
				}); */
				
			    /* $("#dropdown").change(function (){
			        $("#feedBackViewArea").show();
			        var temp_val = document.getElementById("dropdown");
			        $("#feedBackViewAreaLabel").show();
			        $("#feedBackViewArea").val(temp_val.options[temp_val.selectedIndex].value);			                
			        //e.options[e.selectedIndex].value;			                			                
			        console.log($("#dropdown").val());
			        $('#feedBackViewArea').prop('readonly', true);
			    }); */
				
				
			    $.each(data, function ()  {	
					
				   /*  $('#feedbackTable').append(					    		
				    		'<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" href="#'+this.pID+'">'+this.pID+'</a></h4></div><div id="'+this.pID+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.pID+'"></div></div></div></div>'    
				    		 );
					for(var x=0; x<this.feedbackList.length;x++){
						$('#fbr'+this.pID).append(
					    		'<div class="panel"> <div class="panel-heading panel-success"> <h3 class="panel-title">'+this.reviewersList[x]+'</h3> </div> <div id="feedbackByReviewer" class="panel-body">'+this.feedbackList[x]+'</div> </div>'     
					    		 );
					} */
					
					
					
					
					$('#feedbackTable').append(					    		
				    		'<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" href="#'+this.paperTitle+'">'+this.paperTitle+'</a></h4><span class="pull-right">'+this.author+'<span></div><div id="'+this.paperTitle+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.paperTitle+'"></div></div></div></div>'    
				    		 );
					for(var x=0; x<this.feedbackList.length;x++){
						$('#fbr'+this.paperTitle).append(
					    		'<div class="panel"> <div class="panel-heading panel-success"> <h3 class="panel-title">'+this.reviewersList[x]+'</h3> </div> <div id="feedbackByReviewer" class="panel-body">'+this.feedbackList[x]+'</div> </div>'     
					    		 );
					}
				});
			},
			complete : function() {

			}
		});	
		/******************************U/Modify*************************/
		$.ajax({

			url : "http://csgrad17:8080/TestGDP/getpapersforUpdOrMod/"+u1,
			type : "GET",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				$.each(data, function () {
				    $('#paperDropdown').append($('<option value="' + this.paperID + '">' + this.paperTitle + '</option>'));
				});
				
				 $("#paperDropdown").change(function (){
				        
				        var temp_val = document.getElementById("paperDropdown");
				        var tempPaper;
				        
				        $.each(data, function () {
						        if (this.paperID ==temp_val.options[temp_val.selectedIndex].value)
						        {
						        	 tempPaper = this;
						        }				        					        	
						});	
				      
				       $("#modifyTitle").val(tempPaper.paperTitle);
				       $("#updateAbstract").val(tempPaper.abstractOfThePaper);				      
				     // $('#eventnamesloadupdate').val(tempPaper.eventID).attr("selected", "selected");
				 });
				 
				 
				 $.each(data, function () {
					var row = $("<tr />")						
					$("#RemovePapersTableBody").append(row);
					row.append($("<td>" + this.paperTitle + "</td>"));
					row.append($("<td>" + this.abstractOfThePaper + "</td>"));
					row.append($("<td>" + this.eventName + "</td>"));					
					row.append($("<td>" + "<a href=paperdownload/"+this.paperID+".htm>Download</a>"+ "</td>"));		
					row.append($("<td>" + "<a href=removeAPaper/"+this.paperID+"/"+ u1 +">Delete</a>"+ "</td>"));					
				});		
					
				
				
			},
			complete : function() {

			}
		});
		
		
});	
	

</script>

</html>