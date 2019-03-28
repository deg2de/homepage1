<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/header.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<div id="loginsuccess">
		<div id="loginsuccess_message">
			<b>${loginuser.name}님 환영합니다.</b>
		</div>
		<div id="loginsuccess_update">
		<form action="userupdatecheck" method="get">
			<input type="submit" value="Account Info" id="loginsuccess_update_button">
		</form>
		</div>
		<div id="loginsuccess_logout">
		<form action="logout" method="post">
			<input type="submit" value="Logout" id="loginsuccess_logout_button">
		</form>
		</div>
	</div>
</body>
</html>