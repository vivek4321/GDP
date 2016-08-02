<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

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
        <title>Paper Submitting System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


		<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/core/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="http://csgrad17:8080/TestGDP/resources/css/styles.css" rel="stylesheet" type="text/css"/>
        
		<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
        <script src="http://csgrad17:8080/TestGDP/resources/js/scripts.js" type="text/javascript"></script>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		
		<link href="resources/css/datepicker.css" rel="stylesheet" type="text/css"/>        
		<script src="resources/js/lib/bootstrap-datepicker.js" type="text/javascript"></script>
		
	<style>
		.boxAligns { border-style: solid; border-width: 5px; }	
	 	.modal .modal-dialog { width: 70%; }
	 	
	 	.cell option {
		 	height: 30px;
		 	/* background-color: #9999ff; */ 
		 	background-color: #99ff99; 
		 	padding-top: 7px;
	    	padding-right: 10px;
	    	padding-bottom: 5px;
	    	padding-left: 10px;
	    	margin-bottom: 5px;
	 	}
	</style>
 

    </head>
    <body>	   
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
            <img src="http://csgrad17:8080/TestGDP/resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/>


        </div>
        <!-- ================Start - body Section=============== -->
        <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
			<div class="row">
				<div class="col-md-12"></div>	
			</div>
			<ul class="row pager pull-right" id="switchRole"></ul>
			
            <ul class="nav nav-tabs" style="margin-bottom: 15px; margin-top: 15px;">
              <!-- class="active"   <li class="active"><a data-toggle="tab" href="#home">Home</a></li>-->
                <li><a data-toggle="tab" href="#createevent">Create Event</a></li>
                <li><a data-toggle="tab" href="#assignepaper" id = "assignepapertab">Assign Papers</a></li>
                <li><a data-toggle="tab" href="#paperStatus">Paper Status</a></li>
                <li><a data-toggle="tab" href="#feedback">Paper Feedback</a></li>
                <li ><a data-toggle="tab" href="#newsubmission">Event Analytics</a></li>
                <!-- <li class="pull-right"><button  type="button" id="signout" name="btnSign" class="btn btn-primary" value="Register" >Sign Out</button></li> -->
            </ul>
            <div style="margin-left: 92%"><a  type="button" id="signout"  >Sign Out</a></div><br/>
            <div class="tab-content">
                <!-- <div id="home" class="tab-pane fade" >in active
                    <h3>Under Construction...</h3>
                    <p>......</p>
                </div> -->
                 <div id="paperStatus" class="tab-pane fade" >
                    <!-- <h3 class="text-center" style="margin-top: -3%;">View Paper Status</h3> -->
                    <div class="form-group"> 
                                    <div>
                                    <div class="row">
                                    	<div class="col-md-4"></div>
                                    	<div class="col-md-4">
                                    	
                                    	</div>
                                    	<div class="col-md-4"></div>
                                    </div>
                                    <div class="row">
                                    	<div class="col-md-4"></div>
                                    	<div class="col-md-4">
		                                    	<label  for="selectEvent">Event Name:</label>
		                                        <select id="loadeventnamesforPapersStatus" name="loadeventnamesforPapersStatus" class="form-control" onchange='loadPapersforPaperStatus(value)'>                                        
		                                            <option>Select an Event</option>                                            
		                                        </select>
                                    	</div>
                                    	<div class="col-md-4"></div>
                                    </div>
                                     	
                                    </div>
                    </div>
                    <table id="FeedbackStatusTable" class="table">
						<tr class="bg-primary">
							<th>Paper ID</th>
							<th>Paper Title</th>
							<th>Submitted By</th>
							<th>Current Status</th>
						</tr>
						<tbody id = "FeedbackStatusTableBody"></tbody>
					</table>
                 </div>
                 <div id="feedback" class="tab-pane fade" >
                <!--  <h3 class="text-center" style="margin-top: -3%;">View Feedback</h3> -->
                    <div class="form-group">
                    				<div class="row">
                                    	<div class="col-md-4"></div>
                                    	<div class="col-md-4">
		                                    	<div>
		                                     	<label  for="selectEvent">Event Name:</label>
		                                        <select id="loadeventnamesforPCViewingMRFeedback" name="loadeventnamesforPCViewingMRFeedback" class="form-control" onchange='PCViewMRFeedback(value)'>                                        
		                                            <option>Select an Event</option>                                            
		                                        </select>
		                                    	</div>		
                                    	</div>
                                    	<div class="col-md-4"></div>
                                    </div> 
                                    
                    </div>
                    <div id="EventPaperswithFeedback2"></div>
                    
                 </div>
                <div id="newsubmission" class="tab-pane fade">
                    <!-- <div id="EventPaperswithFeedback">                  	
                    </div> -->
                    
                    <div class="form-group"> 
                    		<div class="row">
                                    	<div class="col-md-4"></div>
                                    	<div class="col-md-4">
	                                    	<label  for="selectEvent">Event Name:</label>
	                                        <select id="loadeventnamesforAnalytics" name="loadeventnamesforAnalytics" class="form-control" onchange='ChartGenOnEventSelection(value)'>
	                                            <option>Select an Event</option>                                            
	                                        </select>
                                    	</div>
                                    	<div class="col-md-4"></div>
                                    </div>
                    		
                                    <div>
                                     	
                                    </div>
                    </div>
                    <div id="piechartAnalytics" style="width: 900px; height: 500px;"></div>
                    
                    
                    
                   
					
					
					
                </div>
                
                
                <div id="assignepaper" class="tab-pane fade">
<form>                        <!-- <h3 class="text-center" style="margin-top: -3%;">Assign Papers to Reviewers</h3> -->
		      <div class="form-group"> 
                                    <div class="row">
                                    	<div class="col-md-4"></div>
                                    	<div class="col-md-4">
	                                    	<label  for="selectEvent">Event Name:</label>
	                                        <select id="eventnamesloadAssign" name="eventnamesloadAssign" class="form-control" onchange='loadAssignPapers(id,value)'>
	                                            <option>Select an Event</option>
	                                            
	                                        </select>
                                    	</div>
                                    	<div class="col-md-4"></div>
                                    </div>
                                    <div >
                                     
                                    </div>
                                     
                                </div>
                       
		<table id="AssignPapersTables" class="table">
			<tr class="bg-primary">
				<th>Paper ID</th>
				<th>Paper Title</th>
				<th>Submitted By</th>
				<th>Reviewers</th>
			</tr>
			<tbody id = "AssignPapersTable"></tbody>
		</table>
		  <label class="col-md-5 control-label" for="regClearBtn"></label>
                                   <!--  <div class="col-md-5"> -->
		<input type="reset"  class="btn btn-primary"  value="Clear" />
       <input class='btn btn-primary' id ="btnAssign"  type="submit" value="Submit"/>
       
       
       
        <!-- Modal -->
  <div class="modal fade" id="asignMutliReviewers" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <!-- <h2 class="modal-title" style="text-align: center;">Assign Papers to Reviewers</h2> -->
          <h3 class="modal-title" id="paperTitleModel" style="text-align: center;" > Paper Title</h3>
        </div>
        
        
        <div class="modal-body" name="Example">
	        <div class="row">		        
		        <div class="col-md-5" class="boxAligns">
			        <div >		
			        <center><h3>Reviewers available</h3></center>		        
					        <select class="boxAligns form-control cell" style="height:500px" id="paperModel" name="leftSelection"  MULTIPLE>
                            </select>					        	       
			          </div>			        
			        <!-- <table class="boxAligns"><thead><th>hi</th><thead><tbody><tr>Hi</tr></tbody></table>
			        <div style="height: 200;width:100">hi</div> -->
		        </div>	         
		        
		        <div class="col-md-2">
			        <br> <br> <br> <br> <br> <br>
			        <button class="btn btn-primary" id="leftButtonClicked" style="align: center;"> &nbsp; &nbsp; Add &nbsp; &rArr;</button><br><br><br><br>
			        <button class="btn btn-primary" id="rightButtonClicked" > &lArr; Remove </button><br>
		        	<br>
		        </div>
		        
		        <div class="col-md-5">
		        	<center><h3>Assigned To</h3><center>
		        	<select class="boxAligns form-control cell" style="height:500px" id="rightpaperModel" name="rightSelection"  MULTIPLE>
                    </select>				
	        	</div>          
        	</div>
        
        <br>  <br>  <br>  <br>  
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" id="SaveButton" data-dismiss="modal" > Save </button>
	        	<button type="submit" class="btn btn-primary" id="SubmitButtonClicked" data-dismiss="modal" > Submit </button>
	          	<button type="button" class="btn" data-dismiss="modal">Close</button>
	        </div>
      </div>
      
    </div>
  </div>
      </div>
      <br/> <br/>
       </form>
                </div>
                
                
                
                <div id="createevent" class="tab-pane fade">
                    <form id="ceForm" method="post" class="form-horizontal">
                        <div class="row">
                            <!-- Text input-->
                            <div class="col-md-10">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="eventName">Event Name:</label>  
                                    <div class="col-md-5">
                                        <input id="eventName" name="eventName" type="text" placeholder="Enter your event name" class="form-control input-md" required>

                                    </div>
                                </div>


                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="eventDate">Event Date:</label>  

                                    <div class=' col-md-5' >
                                    <div class="input-append date datepicker no-padding" data-date-format="dd-mm-yyyy">
                                        <input id='eventDate' name="eventDate" class="input-medium form-control" size="16" type="text"><span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                                        <!-- <input id='eventDate' name="eventDate" type='date' class="form-control" /> -->
                                    </div>

                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="subDate">Submission Due Date:</label>  

                                   <div class=' col-md-5' >
                                    <div class="input-append date datepicker no-padding" data-date-format="dd-mm-yyyy">
    									<input id='subDate' name="subDate" class="input-medium form-control" size="16" type="text"><span class="add-on"><i class="icon-th"></i></span>
									</div>
                                        <!-- <input id='subDate' name="subDate" type='date' class="form-control" /> -->
                                    </div>

                                </div>
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="eventOrgName">Event Organizer:</label>  
                                    <div class="col-md-5">
                                        <input id="eventOrgName" name="eventOrgName" type="text" placeholder="Enter event organizer name" class="form-control input-md" required>

                                    </div>
                                </div>
                                <!-- Text Area input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="eventDes">Event Description:</label>  
                                    <div class="col-md-5">

                                        <textarea id="eventDes" name="eventDes"  class="form-control" rows="5" cols="20" required="required"
                                                  placeholder="Enter event description"></textarea>
                                    </div>
                                </div>
                                <!-- Button (Double) -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="regClearBtn"></label>
                                    <div class="col-md-5">
                                        <input type="reset" id="eventClearBtn" name="eventClearBtn" class="btn btn-primary" value="Clear" />
                                        <input type="submit" id="eventCreateBtn" name="eventCreateBtn" class="btn btn-primary" value="Create Event" />
                                    </div>
                                </div>
                            </div>
                            <!-- <div class="col-md-2">
                                Role:
                                <select id="dropdown1" class="dropdown-toggle">
                                    <option value="chair">Program Chair </option>
                                    <option value="reviewer">Reviewer</option>
                                    <option value="author">Author</option>

                                </select>
                            </div> -->
                        </div>     


                    </form>
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

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

//global variable for rignt selected reviewer id
var myOptsRight;
var paperIDtoSend;
var dataN;

function getThisId(id,author){
	 paperIDtoSend=id;
	 var paperTitle = $("#"+id).val();
	 $("#paperTitleModel").html(" Paper Title: " + paperTitle);
	
		$("#paperModel").find('option').remove();
		$("#rightpaperModel").find('option').remove();
		
		var namearray = new Array(dataN.musers.length);
		for (var i = 0; i < namearray.length; i++) {
			 /* opt = data.musers[i];
			 //opt = data.musers[i].email;			  			  
			 var el = document.createElement("option");
			 el.setAttribute("id", "uniqueIdentifier");  
			 el.textContent = opt;
			 el.value = opt;
			 $('.rrr').append(el); */
			 if(dataN.musers[i] !== author ){
				 $("#paperModel").append($("<option class='cell'>" + dataN.musers[i] + "</option>"));
			 }
						 		
						 				 
		}			
	
}

var myOptsleft = document.getElementById('paperModel').options;
myOptsRight = document.getElementById('rightpaperModel').options;

$('#leftButtonClicked').click(function(){
	SelectMoveRows(myOptsleft,myOptsRight);
});

$('#rightButtonClicked').click(function(){
	SelectMoveRows(myOptsRight,myOptsleft);
});




$(document).ready(function() {	
	$('#assignepapertab').click(loadEventsInAssignPapers);	
	
	$('#switchRole').append('<li><a href=' + "${pageContext.request.contextPath}/papersubmission.jsp" + '>Author</a> | </li>');
	$('#switchRole').append('<li><a href=' + "http://csgrad17:8080/TestGDP/getallpapers" + '>Reviewer</a></li>');
});

// individual submit clicked in the model

$('#SubmitButtonClicked').click(function(){
	
	event.preventDefault();	
	var paper = {};
	var users = [];		
	var mailIitem;
	
	paper["paperID"] = paperIDtoSend;
	for(var i=0; i< myOptsRight.length; i++){
		mailIitem = {};
		mailIitem["email"] = myOptsRight[i].text;
		users.push(mailIitem);
	}
	
	var json = {
			'paper' : paper,
			'users' : users
	}; 	
	/* console.log("###");
	console.log(json); */
	
	  /*  var json = {
		    "paper": {  "paperID": 19 },
		    "users": [   {"email": "vivek@gmail.com"}, {"email": "srikanth@gmail.com"}   ]
		}; */   
	
	   /* var json = [

	            {    "paper":{"paperID":21},   "users":[   {"email":"author@gmail.com"},{"email":"author2@gmail.com"}   ]   },

	            {    "paper":{"paperID":27},   "users":[   {"email":"author@gmail.com"},{"email":"author2@gmail.com"}     ]   }

	          ];  */  
	
	
	
	$.ajax({
        url : "http://csgrad17:8080/TestGDP/assignsinglepapersmr",
        data : JSON.stringify(json),
        type : "POST",
        contentType: 'application/json',
        dataType: "text",
        beforeSend : function(xhr) {
               xhr.setRequestHeader("Accept", "application/json");
               xhr.setRequestHeader("Content-Type", "application/json");
        },
        success : function(data) {	
        	alert("Asssigned Successfully");
        	 location.reload();
        },
        complete: function () {
		}
  });
  event.preventDefault();
  
 
});






function loadAssignPapers (name , value ){	
		var json = {
	        'eventName' : value,	        
  		};
		
 $.ajax({

	url : "http://csgrad17:8080/TestGDP/getpapersusers",
	data : JSON.stringify(json),
	type : "POST",
	contentType: 'application/json',
	dataType: "json",	
	beforeSend : function(xhr) {
		xhr.setRequestHeader("Accept", "application/json");
		xhr.setRequestHeader("Content-Type", "application/json");
	},
	success : function(data) {
		//Here we are asigining result data to a global variable and will use that new dataN in onclick of asign button
		dataN=data;		

          $("#AssignPapersTable").empty();         
          if(data.mpapers.length === 0)
        	  {  
	        	  var row = $("<tr />")        	 
	        	  $("#AssignPapersTable").append(row);
	        	  row.append($(' <td colspan="4">' + "<center><h4> No Papers have been submitted to this event to display</h4>      </center> " + '</td>'));
        	  }
         
         
			 $.each(data.mpapers, function() {
				var row = $("<tr />");			
				$("#AssignPapersTable").append(row);
				row.append($("<td>" + this.paperID + "</td>"));
				row.append($("<td>" + this.paperTitle + "</td>"));
				row.append($("<td>" + this.author + "</td>"));
				row.append('<button type="button" id="'+this.paperID+'" value="'+this.paperTitle+'" class="btn btn-primary btn-md" data-toggle="modal" onclick="getThisId(\''+this.paperID+'\',\''+this.author+'\')" data-target="#asignMutliReviewers">Assign</button>');
																																										
				//row.append("<button type='button' class='btn btn-primary' data-toogle='modal' data-target='#asignMutliReviewers'>Assign</button>");
				//row.append($("<td><select class='rrr' id='" + this.paperID + "' onchange='jsFunction(id,value)'><option>Select Reviewer</option></select></td>"));
				//row.append($("<td><select class='rrr' multiple='multiple' id='" + this.paperID + "' onchange='jsFunction(id,value)'><option>Select Reviewer</option></select></td>"));			
			});
			 
						
		},
		
		complete : function() {

		}
		
	}); 
}

/*********************** event loads ************/


function loadEventsInAssignPapers ()
	{
	var username = document.cookie;
  	//var u1 = username.split('.');
  	var u1 = username.replace(/\./g, "*****");
	$.ajax({

		url : "http://csgrad17:8080/TestGDP/pceventslist/"+u1,
		type : "GET",
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			$('#eventnamesloadAssign').empty();
			$('#eventnamesloadAssign').append($('<option >' + "Select an event" + '</option>'));
			$.each(data, function () {
				//console.log(this);				
			    $('#eventnamesloadAssign').append($('<option value="' + this.eventName + '">' + this.eventName + '</option>'));
			});
		},
		complete : function() {

		}
	});		

}


function SelectMoveRows(SS1,SS2)
{
event.preventDefault();	
    var SelID='';
    var SelText='';
    // Move rows from SS1 to SS2 from bottom to top
    for (i=SS1.length - 1; i>=0; i--)
    {
        if (SS1[i].selected == true)
        {
            SelID=SS1[i].value;
           // console.log(SS1[i].value);
            SelText=SS1[i].text;
            var newRow = new Option(SelText,SelID);
            SS2[SS2.length]=newRow;
            SS1[i]=null;
            
        }
    }
    
}



var username = document.cookie;
	//var u1 = username.split('.');
	//var u1 = username.replace(".", "*****");
	var u1 = document.cookie.replace(/\./g, "*****");
$.ajax({

	url : "http://csgrad17:8080/TestGDP/pceventslist/"+u1,
	type : "GET",
	dataType : "json",
	beforeSend : function(xhr) {
		xhr.setRequestHeader("Accept", "application/json");
		xhr.setRequestHeader("Content-Type", "application/json");
	},
	success : function(data) {
		
		$.each(data, function () {
			//console.log(this);				
		   // $('#paperStatusEvents').append($('<option value="' + this.eventName + '">' + this.eventName + '</option>'));
		    
		   
		    /* $('#EventPaperswithFeedback').append(					    		
		    		'<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" href="#'+this.eventName+'">'+this.eventName+'</a></h4></div><div id="'+this.eventName+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.eventName+'"></div></div></div></div>'    
		    ); */
		    
		    $('#loadeventnamesforAnalytics').append($('<option value="' + this.eventName + '">' + this.eventName + '</option>'));
		    $('#loadeventnamesforPapersStatus').append($('<option value="' + this.eventName + '">' + this.eventName + '</option>'));
		    $('#loadeventnamesforPCViewingMRFeedback').append($('<option value="' + this.eventName + '">' + this.eventName + '</option>'));		    		    
		});
	},
	complete : function() {

	}
});		


</script>









<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">

function ChartGenOnEventSelection(eventName){
	
	//alert(eventName);
	console.log();
		var performance = window.performance;
var t0 = performance.now();
//.log(performance+" asdfdsfdas "+t0);
	
	$.ajax({
		url : "http://csgrad17:8080/TestGDP/chartdata/"+ eventName,
		type : "GET",
		contentType : 'application/json',
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log("unassigned "+data.unassigned);
			console.log("assigned "+data.assigned);
			console.log("reviewInProgress "+data.reviewInProgress);
			console.log("reviewCompleted "+data.reviewCompleted);
			
			$('#piechartAnalytics').highcharts({
		        chart: {
		            plotBackgroundColor: null,
		            plotBorderWidth: null,
		            plotShadow: false,
		            type: 'pie'
		        },
		        title: {
		            text: 'Papers Status'
		        },
		        tooltip: {
		            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		        },
		        plotOptions: {
		            pie: {
		                allowPointSelect: true,
		                cursor: 'pointer',
		                dataLabels: {
		                    enabled: true,
		                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		                    style: {
		                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
		                    }
		                }
		            }
		        },
		        series: [{
		            name: 'Papers Status',
		            colorByPoint: true,
		            data: [{
		                name: 'Unassigned',
		                y: data.unassigned
		            }, {
		                name: 'Assigned',
		                y: data.assigned
		               
		            }, {
		                name: 'Review In Progress',
		                y: data.reviewInProgress
		            }, {
		                name: 'Review Completed',
		                y: data.reviewCompleted,
		                sliced: true,
		                selected: true
		            }]
		        }]
		    });

			var t1 = performance.now();
			console.log("Time taken to generate chart " + (t1 - t0) + " milliseconds.")
			//console.log(performance+" asdfdsfdas "+t1);
		},
		complete : function() {
			var t1 = performance.now();
			console.log("Time taken to complete AJAX call with chart " + (t1 - t0) + " milliseconds.")
		}
		
	});
	event.preventDefault();		
}




function loadPapersforPaperStatus(eventName){
	$("#FeedbackStatusTableBody").empty();
	$.ajax({
		url : "http://csgrad17:8080/TestGDP/getpapersforstatus/"+ eventName,
		type : "GET",
		contentType : 'application/json',
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			 $.each(data, function() {
					var row = $("<tr />");			
					$("#FeedbackStatusTableBody").append(row);
					row.append($("<td>" + this.paperID + "</td>"));
					row.append($("<td>" + this.paperTitle + "</td>"));
					row.append($("<td>" + this.author + "</td>"));
					row.append($("<td>" + this.status + "</td>"));
			});
		},
		complete : function() {
		}
		
	});
	event.preventDefault();	
}




//EventPaperswithFeedback2
function PCViewMRFeedback(eventName){
	var performance = window.performance;
	var t0 = performance.now();

	$.ajax({
		url : "http://csgrad17:8080/TestGDP/getpapersforPCviewingfeedback/"+eventName,
		type : "GET",
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {	
			console.log(data);
			$('#EventPaperswithFeedback2').empty();
			
			/* for(var i =0; i<data.length;i++){
				$('#EventPaperswithFeedback2').append(					    		
			    		'<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" href="#'+data[i].pID+'">'+data[i].paperTitle+'</a></h4></div><div id="'+data[i].pID+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.pID+'"></div></div></div></div>'    
			    );
				console.log(data.length);
				console.log(data[i].feedbackList.length);
				for(var x = 0; x < data[i].feedbackList.length; x++){
					$('#fbr'+this.pID).append(
				    		'<div class="panel"> <div class="panel-heading panel-success"> <h3 class="panel-title">'+data[i].reviewersList[x]+'</h3> </div> <div id="feedbackByReviewer" class="panel-body">'+data[i].feedbackList[x]+'</div> </div>'     
				    );
				}
				
			} */
			
			
			$.each(data, function ()  {
				
			    $('#EventPaperswithFeedback2').append(					    		
			    		/* '<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" href="#'+this.pID+'">'+this.paperTitle+'</a></h4></div><div id="'+this.pID+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.pID+'"></div></div></div></div>' */    
			    		
			    		'<div class="panel-group"><div class="panel panel-success"><div class="panel-heading"><h4 class="panel-title"><a style="text-decoration:none;" data-toggle="collapse" href="#'+this.pID+'">' +this.paperTitle + ' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Submitted By: </b>' + this.author +'</a></h4></div><div id="'+this.pID+'" class="panel-collapse collapse"><div class="panel-body" id="fbr'+this.pID+'"></div></div></div></div>'
			    );
			    
			    for(var x = 0; x < this.feedbackList.length; x++){
					$('#fbr'+this.pID).append(
				    		/* '<div class="panel"> <div class="panel-heading panel-success"> <h3 class="panel-title">'+this.reviewersList[x]+'</h3> </div> <div id="feedbackByReviewer" class="panel-body">'+this.feedbackList[x]+'</div> </div>' */     
				    		
							'<div class="panel"> <div class="panel-heading panel-success"> <h3 class="panel-title">'+this.feedbackList[x]+'</h3> </div> <div id="feedbackByReviewer" class="panel-body"><span class="pull-right"> <b>Reviewed By:   </b>'+this.reviewersList[x]+'</span></div> </div>'
				    );
				}	
									
			}); 
		},
		complete : function() {
			var t1 = performance.now();
			console.log("Time taken to load the barchart " + (t1 - t0) + " milliseconds.");

		}
	});	
	event.preventDefault();		
}


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
</script>




</html>
