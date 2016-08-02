<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>All Charts</title>
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/core/carousel.css" rel="stylesheet" type="text/css" />
	<link href="http://csgrad17:8080/TestGDP/resources/css/styles.css" rel="stylesheet" type="text/css" />
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/bootstrap.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/lib/jquery.easing.min.js" type="text/javascript"></script>
	<script src="http://csgrad17:8080/TestGDP/resources/js/scripts.js" type="text/javascript"></script>
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
		url : "http://csgrad17:8080/TestGDP/chartdata",
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
			/* 	chartdata.addColumn('number', 'Events'); */
			 /* chartdata.addColumn('number', 'Papers'); */
				chartdata.addColumn('number', 'Users');
				
				/* JSON.parse(mydata); */
					//console.log(temp[0].year);
				
				
				
				
			 $.each(mydata, function() {
				 console.log(this.year);
				 chartdata.addRows([ [this.profit.toString(), /* this.sales, */ this.expenses/* , this.profit  */]]);
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
						
							title : 'Statstics on users registered per annum  ',
							is3D: true,
							subtitle : 'Events, Papers, and User'
						
				};
				
				/* var chart = new google.charts.BarChart(document
						.getElementById('columnchart_material')); */
						
				var chart=new google.visualization.LineChart(document.getElementById('linechartpage'));

				chart.draw(chartdata, options);			
		},
		complete : function() {
		}
	});
	$.ajax({
		url : "http://csgrad17:8080/TestGDP/chartdata",
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
				/* chartdata.addColumn('number', 'Events'); */
			 chartdata.addColumn('number', 'Papers');
				/* chartdata.addColumn('number', 'Users'); */
				
				/* JSON.parse(mydata); */
					//console.log(temp[0].year);
				
				
				
				
			 $.each(mydata, function() {
				 console.log(this.year);
				 chartdata.addRows([ [this.year.toString(), /* this.sales, */ this.expenses/* , this.profit */ ]]);
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
						
							title : 'Num of papers (%) reviewd by each reviewer',
							is3D: true,
							subtitle : 'Events, Papers, and User'
						
				};
				
				/* var chart = new google.charts.BarChart(document
						.getElementById('columnchart_material')); */
						
				var chart=new google.visualization.PieChart(document.getElementById('piechartpage'));

				chart.draw(chartdata, options);			
		},
		complete : function() {
		}
	});
	$.ajax({
		url : "http://csgrad17:8080/TestGDP/chartdata",
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
			/* 	chartdata.addColumn('number', 'Events'); */
			 chartdata.addColumn('number', 'Papers');
				chartdata.addColumn('number', 'Users');
				
				/* JSON.parse(mydata); */
					//console.log(temp[0].year);
				
				
				
				
			 $.each(mydata, function() {
				 console.log(this.year);
				 chartdata.addRows([ [this.profit.toString(), this.sales, this.expenses/* , this.profit  */]]);
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
						
							title : 'Statstics Num of users,Events and Papers ',
							is3D: true,
							subtitle : 'Events, Papers, and User'
						
				};
				
				/* var chart = new google.charts.BarChart(document
						.getElementById('columnchart_material')); */
						
				var chart=new google.visualization.ColumnChart(document.getElementById('columnchartpage'));

				chart.draw(chartdata, options);			
		},
		complete : function() {
		}
	});
	$.ajax({
		url : "http://csgrad17:8080/TestGDP/chartdata",
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
				chartdata.addColumn('number', 'Papers');
		/* 	 chartdata.addColumn('number', 'Papers');
				chartdata.addColumn('number', 'Users');
				 */
				/* JSON.parse(mydata); */
					//console.log(temp[0].year);
				
				
				
				
			 $.each(mydata, function() {
				 console.log(this.year);
				 chartdata.addRows([ [this.year.toString(), this.sales /*, this.expenses, this.profit  */]]);
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
						
							title : 'Statstics Num of Papers/ User',
							is3D: true,
							subtitle : 'Events, Papers, and User: 2014-2020'
						
				};
				
				/* var chart = new google.charts.BarChart(document
						.getElementById('columnchart_material')); */
						
				var chart=new google.visualization.BarChart(document.getElementById('barchartpage'));

				chart.draw(chartdata, options);			
		},
		complete : function() {
		}
	});

});




</script>
</head>
<body style="margin: auto;">
<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
          <img src="http://csgrad17:8080/TestGDP/resources/img/Banner.png" class="img-responsive img-rounded imgBanner" alt="Banner"/></div>
<div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">
           <center>  <br/><br/>
                      <a href="myanalysis_piec.jsp"  
										class="justreload">Piechart</a> | <a href="myanalysis_barchart.jsp"  
										class="justreload">Histo gram</a> | <a href="myanalisis_papers_users.jsp" 
										class="justreload">Bar chart</a> | <a href="myanalysis_line.jsp" 
										class="justreload">Line chart</a>
									<br/><br/>	
										</center>
   
   <center>
           <h3> Piechart  </h3>
	<div id="piechartpage" style="width: 900px; height: 500px;"></div>
	<br/><hr/><br/>
	<h3> Histo Gram </h3>
	<div id="columnchartpage" style="width: 900px; height: 500px;"></div>
	<br/><hr/><br/>
	<h3> Barchart</h3>
	<div id="barchartpage" style="width: 900px; height: 500px;"></div>
	<br/><hr/><br/>
	<h3> Line Chart</h3>
	<div id="linechartpage" style="width: 900px; height: 500px;"></div>
	</center>
	
	</div>
	
	      <div id="page" class="container white" style="margin-bottom: 15px; margin-top: 15px; border: solid #444; border-radius: 5px;">

            <p class="text-center">&copy; 2015 GDP team ,All rights are reserved.<p>

        </div>   

        <!-- ================End - Footer Section=============== -->                
	
</body>






</html>
