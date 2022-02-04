<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>


<head>
<title>Ana sayfa</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>ALLLLOOOOOOOOOOOOOOOOOOOOOOOOOOO</p>

	<hr>

	<p>
		User
		<security:authentication property="principal.username" />
		<br> <br> Roles
		<security:authentication property="principal.authorities" />
	</p>

	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>

			<a href="${pageContext.request.contextPath}/leaders"> LeaderShip
				meeting</a> ONly menager

		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<p>

			<a href="${pageContext.request.contextPath}/systems"> System
				meeting</a> ONly admin

		</p>
	</security:authorize>

	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>


</body>

</html>