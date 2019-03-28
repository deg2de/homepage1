<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="JS/userUpdate.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/userupdate.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="userupdate">
		<div id="userupdate_maintext">Update Profile</div>
		<div id="userupdate_text">
			<form action="userupdate" method="post" name="userupdate">
				<table id="userupdate_text_table">
					<tr>
						<td>ID</td>
						<td>${loginuser.userid}</td>
						<td id="userupdate_text_message">${update_message_userid}</td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="password" name="userpw"
							id="userupdate_text_input" value=${userupdate_input_userpw}></td>
						<td id="userupdate_text_message">${update_message_userpw}</td>
					</tr>
					<tr>
						<td>PW Check</td>
						<td><input type="password" name="userpw2"
							id="userupdate_text_input" value=${userupdate_input_userpw2}></td>
						<td id="userupdate_text_message">${update_message_userpw2}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="username"
							id="userupdate_text_input" value=${userupdate_input_username}></td>
						<td id="userupdate_text_message">${update_message_username}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="useremail"
							id="userupdate_text_input" value=${userupdate_input_useremail}></td>
						<td id="userupdate_text_message">${update_message_useremail}</td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input type="text" name="userphone"
							id="userupdate_text_input" value=${userupdate_input_userphone}></td>
						<td id="userupdate_text_message">${update_message_userphone}</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit" value="Update"
							id="userupdate_text_mainbutton" onclick="return userUpdate()"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">${update_message}</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>