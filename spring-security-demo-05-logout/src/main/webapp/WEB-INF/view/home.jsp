<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Ana sayfa</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>
	ALLLLOOOOOOOOOOOOOOOOOOOOOOOOOOO
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
			    <input type="submit" value="Logout" />
	 </form:form>
	 
	
</body>

</html>