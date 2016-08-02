<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Hurray!</title>
</head>
<body>
<h1>
	Successful!
</h1>


</body>
</html>



<%

/* Thread.sleep(4000); */
RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");	        
rd.forward(request, response);  


%>