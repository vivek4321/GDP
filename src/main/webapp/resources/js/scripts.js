/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//*******************************//user registration code start *******************************************



$(document).ready(function () {
	

	
	
	
	//*******************************//Move to sig in when register button clicked *******************************************	
	
	$( "#btnReg" ).click(function() {
		window.location = "http://csgrad17:8080/TestGDP/registration.jsp";
	});
	
	$( "#signout" ).click(function() {
		$.ajax({	        	 
	        url : "http://csgrad17:8080/TestGDP/signout",
	        type : "GET",
	        contentType: 'application/json',
	        dataType: "text",
	        beforeSend : function(xhr) {
	               xhr.setRequestHeader("Accept", "application/json");
	               xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success : function(data) {	
	        	if(data === "true"){
	        		window.location = "http://csgrad17:8080/TestGDP/";
	        	}
	        },
	        complete: function () {
			}
	  });
	  event.preventDefault();
	});
	
	
	
	
	
	
/*	$( "#signoutR" ).click(function() {
		$.ajax({
	        //url : "http://54.173.52.16:8080/test/signout",	
	        url : "http://csgrad17:8080/TestGDP/signout",
	        type : "GET",
	        contentType: 'application/json',
	        dataType: "text",
	        beforeSend : function(xhr) {
	               xhr.setRequestHeader("Accept", "application/json");
	               xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success : function(data) {	
	        	if(data === "true"){
	        		window.location = "../";
	        	}
	        },
	        complete: function () {
			}
	  });
	  event.preventDefault();
	});*/

	
	
	
	
	$( "#btnSignForgotPassword" ).click(function() {
		 var json = {
			'email' : $('#userEmailForgotPassword').val()
		 };	  
		 
		 $.ajax({
		        url : "http://csgrad17:8080/TestGDP/forgotPassword",
		        data : JSON.stringify(json),
		        type : "POST",
		        contentType: 'application/json',
		        dataType: "text",
		        beforeSend : function(xhr) {
		               xhr.setRequestHeader("Accept", "application/json");
		               xhr.setRequestHeader("Content-Type", "application/json");
		        },
		        success : function(data) {	

		          if(data.split("@@")[0]=="true"){
		        	  $('#userEmailForgotPassword').val("");
		        	  alert('Email sent successfully');
		        	  window.location="http://csgrad17:8080/TestGDP/";
		          }else{
		        	  $('#userEmailForgotPassword').val("");
		        	  alert('Entered email not found in our records. Please check your email');
		        	  
		          }
		          
		        },
		        complete: function () {
				}
		  });
		  event.preventDefault();		
	});
	
	
	
	$( "#btnResetPassword").click(function() {
		 var json = {
			'email' : $('#userEmailforpwReset').val(),
			'password' : $('#newPasswordConfirm').val()
		 };	  
		 
		 $.ajax({
		        url : "http://csgrad17:8080/TestGDP/resetPassword",
		        data : JSON.stringify(json),
		        type : "POST",
		        contentType: 'application/json',
		        dataType: "text",
		        beforeSend : function(xhr) {
		               xhr.setRequestHeader("Accept", "application/json");
		               xhr.setRequestHeader("Content-Type", "application/json");
		        },
		        success : function(data) {	
		        	alert("Password Reset Successfully. Please sign-in with your new Password");
		        	window.location="http://csgrad17:8080/TestGDP/";
		          
		        },
		        complete: function () {
				}
		  });
		  event.preventDefault();		
	});
	
	
	
//	
//	$( "#signoutviewpapers" ).click(function() {
//		window.location = "../signin.jsp";
//	});
	
	
/*	$('#dropdown1').change(function() {
		 
		if($(this).val() === "chair"){			 
			 window.location = "http://csgrad17:8080/TestGDP/createanevent.jsp";
		}else if($(this).val() === "reviewer") {			
			 var u1 = document.cookie.replace(/\./g, "*****");
			 window.location = "http://csgrad17:8080/TestGDP/getallpapers/"+u1;
		}else{
			 window.location = "http://csgrad17:8080/TestGDP/papersubmission.jsp";
		}       
    });*/
	
	
	
		$('#regFrm').submit(function(event) {
			
			if($("#regPassword").val() == $("#regConfrimPass").val()){
				var firstName = $("#regFirstname").val();
	            var lastName = $("#regLastname").val();
	            var emailAddress = $("#email").val().toLowerCase();	
	            var phone= $("#regPhonenum").val();
	            var password = $("#regPassword").val();
	            var dateOfBirth = $("#date1").val();
	            
				var json = {
					'firstName' : firstName,
					'lastName' : lastName,
					'email' : emailAddress,
					'contactNumber' : phone,
					'password' : password,
					'dob':dateOfBirth
				};
				$.ajax({
					url : "http://csgrad17:8080/TestGDP/register",
					data : JSON.stringify(json),
					type : "POST",				
					contentType: 'application/json',
					dataType: "text",
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Content-Type", "application/json");
					},
					success : function(data) {					
						alert(data);
						if(data.indexOf("Account with Username") > -1){
							$('#email').val('');
						}else{
							window.location = "http://csgrad17:8080/TestGDP/";
						}					
					},
				    complete: function () {
				    	 
				    }
				});
				event.preventDefault();
			}else{
				alert("Your confirmation password does not match the password you entered");
				$("#regPassword").val('');
				$("#regConfrimPass").val('');
				event.preventDefault();
			}				
		});
		//user registration code end.



 
//******************************* SIGN IN FORM *****************************************      
      
      
$('#signForm').submit(function(event) {

    var userName = $('#userName').val();
    var password = $('#password').val();
    //userNameSignIn = userName;
    
    //document.cookie=userName;
    document.cookie = userName.toLowerCase();
    var json = {
          'email' : userName,
          'password' : password
    };
    //http://odss-bearcatnetwork.rhcloud.com/TestGDP/
    	
    $.ajax({
    	  url : "http://csgrad17:8080/TestGDP/signin",
          data : JSON.stringify(json),
          type : "POST",
          contentType: 'application/json',
          dataType: "text",
          beforeSend : function(xhr) {
                 xhr.setRequestHeader("Accept", "application/json");
                 xhr.setRequestHeader("Content-Type", "application/json");
          },
          success : function(data) {
        	 
        	 var test = $('input[name=radio]:checked').val();
        	 useremail = $('#userName').val();
        	 var u1 = useremail.replace(/\./g, "*****");
        	 //console.log(data);    
        	 
        	 if(data.indexOf("exist in our records") > -1){
        	       	alert(data);
        	       	window.location = "http://csgrad17:8080/TestGDP/";
        	 }else{
        		 var res = data.split("$$$$");        	 
            	 $('#userEmailLogin').val(useremail);        	         	 
            	 //console.log($('#userEmailLogin').val(useremail));
            	
            	 if(res[0] != "Login Successful") {
            		 alert(res[0]);
           	  	 }  else if(test === "author" && res[3] ==="true"){    
           	  		 window.location = "http://csgrad17:8080/TestGDP/papersubmission.jsp";
            	  }
            	  else if(test === "reviewer" && res[2]==="true"){
            		  window.location = "http://csgrad17:8080/TestGDP/getallpapers";        		 
            	  } 
            	  else if(test === "chair" && res[1]==="true"){
            		  window.location = "http://csgrad17:8080/TestGDP/createanevent.jsp";
            	  } else if(test != "author" && test != "reviewer" && test != "chair"){
            		  alert("Please select your role");
            	  }   else {
            		  alert(" You have selected an incorrect role");
            	  }
        	 }  	  
          },
          complete: function () {
        	 
		  }
    });

    event.preventDefault();
});

//ENd






//******************************* CREATE AN EVENT  FORM *****************************************      
    
    
$('#ceForm').submit(function(event) {
  
  var eventName = $('#eventName').val();
  var eventDate = $('#eventDate').val();
  var subDate = $('#subDate').val();
  var eventOrgName = $('#eventOrgName').val();
  var eventDes = $('#eventDes').val();
  
  var username = document.cookie;
  //var u1 = username.split('.');
  var u1 = username.replace(/\./g, "*****");
  var json = {
        'eventName' : eventName,
        'dateOfEvent' : eventDate,
        'submissionDueDate' : subDate,
        'organizerName' : eventOrgName,
        'eventDescription' : eventDes
  };

  $.ajax({
        //url : "http://localhost:8080/test/createanevent/"+u1[0],
        url : "http://csgrad17:8080/TestGDP/createanevent/"+u1,
        data : JSON.stringify(json),
        type : "POST",
        contentType: 'application/json',
        dataType: "json",
        beforeSend : function(xhr) {
               xhr.setRequestHeader("Accept", "application/json");
               xhr.setRequestHeader("Content-Type", "application/json");
        },
        success : function(data) {	

//	        if(JSON.stringify(data) === '{}'){
//	        	window.location = "signin.jsp";
//	        }
//	        else{
	        	alert("Event " +data.eventName +" has been created successfully");
	        	  
	         	$('#eventName').val("");
	         	$('#eventDate').val("");
	         	$('#subDate').val("");
	         	$('#eventOrgName').val("");
	         	$('#eventDes').val("");
//	        }
        },
        complete: function (data) {
		}
  });
  event.preventDefault();
});

//ENd




//******************************* Enter FeedBack  FORM *****************************************      

$('#feedForm').click(function(event) {

var paperID = $('#feedHidden').val();
var feedBack = $('#feedbackData').val();

var json = {
      'paperFeedbackID' : paperID,
      'reviewedBy': document.cookie,  
      'feedback' : feedBack
};

$.ajax({
      url : "http://csgrad17:8080/TestGDP/submitFeedback",
      data : JSON.stringify(json),
      type : "POST",
      contentType: 'application/json',
      dataType: "text",
      beforeSend : function(xhr) {
             xhr.setRequestHeader("Accept", "application/json");
             xhr.setRequestHeader("Content-Type", "application/json");
      },      
      success : function(data) {  
    	  if(data === null){
    		  window.location = "../";
    	  }
    	  else{
          	  alert(data);
          	  location.reload();
    	  }
        },
        complete: function () {
		}

});
event.preventDefault();
});



/************************************Save Assign Papers******************************/



$('#btnAssign').click(function() {
	
	/*var table = $('#AssignPapersTable').tableToJSON();
	    var mydataPID = JSON.stringify(table); 
	    var value = $('select.rrr option:selected').text();
	 */ 
	 var json = jsonObj;	  		  
	 $.ajax({
	        url : "http://csgrad17:8080/TestGDP/assignpapers",
	        data : JSON.stringify(json),
	        type : "POST",
	        contentType: 'application/json',
	        dataType: "text",
	        beforeSend : function(xhr) {
	               xhr.setRequestHeader("Accept", "application/json");
	               xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success : function(data) {	
	          alert(data);
	          location.reload();	          	          
	        },
	        complete: function () {
			}
	  });
	  event.preventDefault();
	});

});
 
var myReviewers = new Array();
/*function jsFunction( ev) {
	myReviewers[length] = $(ev).val();
	console.log(myReviewers[length]);
}*/

jsonObj = [];
function jsFunction(id, opt){
	
	item = {}
    item ["paperID"] = id;
    item ["reviewerID"] = opt;
    jsonObj.push(item);	
}
