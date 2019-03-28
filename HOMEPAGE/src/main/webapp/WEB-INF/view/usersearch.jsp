<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="JS/userSearch.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/usersearch.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="usersearch">
		<div id="usersearch_id_maintext">Search ID</div>
		<div id="usersearch_pw_maintext">Search PW</div>
		<div id="usersearch_id_text">
			<form action="usersearchid" method="post" name="usersearchid">
			<table align="center">
				<tr>
					<td>Name</td>
					<td><input type="text" name="search_id_username" id="usersearch_id_input"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="search_id_userphone" id="usersearch_id_input"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="ID search" id="usersearch_id_button" onclick="return userSearchId()"></td>
				</tr>
				<tr>
					<td colspan="2">${usersearch_id_message}</td>
				</tr>
			</table>
			</form>
		</div>
		<div id="usersearch_pw_text">
			<form action="usersearchpw" method="post" name="usersearchpw">
			<table align="center">
				<tr>
					<td>ID</td>
					<td><input type="text" name="search_pw_userid" id="usersearch_pw_input"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="search_pw_userphone" id="usersearch_pw_input"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="PW search" id="usersearch_pw_button" onclick="return userSearchPw()"></td>
				</tr>
				<tr>
					<td colspan="2">${usersearch_pw_message}</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>