<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Paper Submitting System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


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


            <ul class="nav nav-tabs" style="margin-bottom: 15px; margin-top: 15px;">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#newsubmission">New Submissions</a></li>
                <li><a data-toggle="tab" href="#assignepaper">Assign Papers</a></li>
                <li><a data-toggle="tab" href="#createevent">Create Event</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <h3>Under Construction...</h3>
                    <p>......</p>
                </div>
                <div id="newsubmission" class="tab-pane fade">
                    <h3>Under Construction...</h3>
                    <p>...</p>
                </div>
                <div id="assignepaper" class="tab-pane fade">
                    <h3>Under Construction...</h3>
                    <p>...</p>
                </div>
                <div id="createevent" class="tab-pane fade">
                    <form id="ceForm" class="form-horizontal">
                        <div class="row">
                            <!-- Text input-->
                            <div class="col-md-10">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="eventName">Event Name:</label>  
                                    <div class="col-md-5">
                                        <input id="eventName" name="eventName" type="text" placeholder="Enter your event name" class="form-control input-md" required="">

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
                                        <input id="eventOrgName" name="eventOrgName" type="text" placeholder="Enter event organizer name" class="form-control input-md" required="">

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
                            <div class="col-md-2">
                                Role:
                                <select class="dropdown-toggle">
                                    <option value="author">Program Chair </option>
                                    <option value="reviewer">Reviewer</option>
                                    <option value="pc">Author</option>

                                </select>
                            </div>
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
        

    </body>

</html>
