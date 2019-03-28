<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="JS/idCheck.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/usercreate.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="usercreate">
		<div id="usercreate_maintext">Create ID</div>
		<div id="usercreate_text">
			<form action="usercreate" method="post" name="usercreate">
				<table id="usercreate_text_table">
					<tr>
						<td>ID</td>
						<td><input type="text" name="userid"
							id="usercreate_text_input" value=${input_userid}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_userid}</td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="password" name="userpw"
							id="usercreate_text_input" value=${input_userpw}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_userpw}</td>
					</tr>
					<tr>
						<td>PW Check</td>
						<td><input type="password" name="userpw2"
							id="usercreate_text_input" value=${input_userpw2}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_userpw2}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="username"
							id="usercreate_text_input" value=${input_username}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_username}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="useremail"
							id="usercreate_text_input" value=${input_useremail}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_useremail}</td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input type="text" name="userphone"
							id="usercreate_text_input" value=${input_userphone}></td>
						<td>(*)</td>
						<td id="usercreate_text_message">${create_message_userphone}</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit" value="Sign Up"
							id="usercreate_text_mainbutton" onclick="return createId()"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>