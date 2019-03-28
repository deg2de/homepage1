<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="JS/userUpdateCheck.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/userupdatecheck.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="userupdatecheck">
		<div id="userupdatecheck_maintext">Login Check</div>
		<div id="userupdatecheck_text">
			<form action="userupdatecheck" method="post" name="userupdatecheck">
			<table align="center">
				<tr>
					<td>ID</td>
					<td>${userupdatecheck_userid}</td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="userupdatecheck_userpw" id="userupdatecheck_input"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Login Check" id="userupdatecheck_button" onclick="return userLoginCheck()"></td>
				</tr>
				<tr>
					<td colspan="2">${userupdatecheck_message}</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>