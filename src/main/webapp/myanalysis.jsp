<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Bar Chart</title>
	<link href="resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/core/carousel.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/styles.css" rel="stylesheet" type="text/css" />
	<script src="resources/js/lib/jquery.min.js" type="text/javascript"></script>
	<script src="resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
	<script src="resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
	<script src="resources/js/scripts.js" type="text/javascript"></script>
</head>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">




google.load("visualization", "1.1", {
	packages : [ "corechart" ]
});
//google.setOnLoadCallback(drawChart);



/* function drawChart(temp) {

	var chartdata = new google.visualization.DataTable();
	chartdata.addColumn('number', 'Year');
	chartdata.addColumn('number', 'Sales');
	chartdata.addColumn('number', 'Expenses');
	chartdata.addColumn('number', 'Profit');
	
	/* JSON.parse(mydata); */
		//console.log(temp[0].year);
	
	
	
	
	/* for (var item in temp) {
		var y= item.year;
		var s=item.sales;
		var e=item.expenses;
		var p=item.profit;
	
		chartdata.addRows([ [y, s, e, p]]);
	} */
	
	
	/* $.each(mydata, function()
	{
		var y=mydata.year;
		var s=mydata.sales;
		var e=mydata.expenses;
		var p=mydata.profit;
		chartdata.addRows([ [y, s, e, p]]);
	}); */
	
/* 	var options = {
			chart : {
				title : 'Company Performance',
				subtitle : 'Sales, Expenses, and Profit: 2014-2017',
			}
	};
	
	var chart = new google.charts.Bar(document
			.getElementById('columnchart_material'));

	chart.draw(chartdata, options);
} 
 */




$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/test/chartdata",
		type : "GET",
		contentType : 'application/json',
		dataType : "json",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			var mydata = JSON.parse (JSON.stringify(data) );
			 
			
			
			
			 var chartdata = new google.visualization.DataTable();
				chartdata.addColumn('string', 'Year');
				chartdata.addColumn('number', 'Events');
			 chartdata.addColumn('number', 'Papers');
				chartdata.addColumn('number', 'Users');
				
				/* JSON.parse(mydata); */
					//console.log(temp[0].year);
				
				
				
				
			 $.each(mydata, function() {
				 console.log(this.year);
				 chartdata.addRows([ [this.year.toString(), this.sales, this.expenses, this.profit ]]);
			         });
				
				/* $.each(mydata, function()
				{
					var y=mydata.year;
					var s=mydata.sales;
					var e=mydata.expenses;
					var p=mydata.profit;
					chartdata.addRows([ [y, s, e, p]]);
				}); */
				
				var options = {
						
							title : 'Statstics Num of users,Events and Papers : 2014-2020',
							is3D: true,
							subtitle : 'Events, Papers, and User: 2014-2020'
						
				};
				
				/* var chart = new google.charts.BarChart(document
						.getElementById('columnchart_material')); */
						
				var chart=new google.visualization.ColumnChart(document.getElementById('columnchart_material'));

				chart.draw(chartdata, options);			
		},
		complete : function() {
		}
	});

});




</script>
</head>
<body>
	<div id="columnchart_material" style="width: 900px; height: 500px;"></div>
</body>






</html>
