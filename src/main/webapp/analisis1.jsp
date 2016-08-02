<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>OOPS!</title>
<link href="resources/css/core/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/core/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/core/carousel.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/styles.css" rel="stylesheet" type="text/css" />
<script src="resources/js/lib/jquery.min.js" type="text/javascript"></script>
<script src="resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.easing.min.js"
	type="text/javascript"></script>
<script src="resources/js/scripts.js" type="text/javascript"></script>
</head>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	var nam;
	google.load("visualization", "1.1", {
		packages : [ "bar" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		
		
		var mydata =  [ [ 'Year', 'Sales', 'Expenses', 'Profit' ],
					[ '2014', 1000, 400, 200 ], [ '2015', 1170, 460, 250 ],
					[ '2016', 660, 1120, 300 ], [ '2017', 1030, 540, 350 ] ]
		//var sample = nam;
		
		/*
		var x = new Array(10);
for (var i = 0; i < 10; i++) {
  x[i] = new Array(20);
}
		
		
		
		var devicegroupusers = '[{"name":"Default","count":2},{"name":"IT","count":1},{"name":"R\u0026D","count":1}]', 
		result = [["name","count"]],
		devicegroupusers = JSON.parse(devicegroupusers);

		$.each(devicegroupusers ,function(_,devicegroupuser) {
		result.push(
		[
		devicegroupuser["name"],devicegroupuser["count"]
		]
		);
		});
		console.log(result);
		 */

		var data = new google.visualization.arrayToDataTable(mydata);

		var options = {
			chart : {
				title : 'Company Performance',
				subtitle : 'Sales, Expenses, and Profit: 2014-2017',
			}
		};

		var chart = new google.charts.Bar(document
				.getElementById('columnchart_material111'));

		chart.draw(data, options);
	}
	$(document).ready(function() {
		$.ajax({
			url : "http://localhost:8080/test/chartdata",
			// data : JSON.stringify(json),
			type : "GET",
			contentType : 'application/json',
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				// 		          alert(data); 
				var nam =  JSON.stringify(data)  ;
				console.log(nam)
				for (var item in nam) {
				    console.log(item[0]);
				}
				/*    var $grouplist = $('#groups');
				   $.each(myData, function() {
				       $('<li>' + this.eventName + '</li>').appendTo($grouplist);
				   }); */
				// console.log(JSON.parse(data));
				// 		      	  alert("Event " +data.eventName +" has been created successfully");
				// 		      	  window.location = "success.jsp";
			},
			complete : function() {
				// 				         alert("ajax completed ");
			}
		});

	});
</script>
</head>
<body>
	<div id="columnchart_material" style="width: 900px; height: 500px;"></div>
</body>






</html>
