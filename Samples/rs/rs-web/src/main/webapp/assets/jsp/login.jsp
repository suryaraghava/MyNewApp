<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Outcomes</title>

<style type="text/css">
	.loginDiv{
		position:fixed;
	  top: calc(50vh - 200px/2);
	  left: calc(50vw - 400px/2);
	  width:500px;
	  height:100px;
	}
	
	input[type="text"], input[type="password"]{
		height: 25px;
	}
	input[type="submit"]{
		height: 30px;
		width: 90px;
		cursor: pointer;
	}
	body{
		font-family: Lato,"Helvetica Neue",Helvetica,Arial,sans-serif;
		font-size: 14px;
	}
</style>
</head>
<body>

	<div class="loginDiv">
		<c:if test="${param.error ne null}">
		<div>Invalid username and password.</div>
		</c:if>
		<c:if test="${param.logout ne null}">
			<div>You have been logged out.</div>
		</c:if>
		<form action="${contextPath}/login" method="POST">
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
			<table width="100%" height="100%" cellpadding="3" cellspacing="3" align="center">
				<tr>
					<td>
						User Name :
					</td>
					<td>
						<input type="text" name="username" />
					</td>
				</tr>
				<tr>
					<td>
						Password :
					</td>
					<td>
						<input type="password" name="password" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Sign In" />
					</td>
				</tr>
				
			</table>
			
		</form>
	</div>
	
</body>
</html>