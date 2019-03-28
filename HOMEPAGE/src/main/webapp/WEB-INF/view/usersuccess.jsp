<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/usersuccess.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="usersuccess">
		<div id="usersuccess_maintext">Completed Page</div>
		<div id="usersuccess_text">${success_message}</div>
		<div id="usersuccess_text_mainbutton">
			<form action="main" method="get">
				<input type="submit" value="Main" id="usersuccess_mainbutton">
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>