<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="JS/loginCheck.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/header.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<div id="logincheck">
		<div id="logincheck_input">
			<form action="logincheck" method="post" name="frm">
				<table>
					<tr>
						<td id="logincheck_input_text"><b>ID</b></td>
						<td><input type="text" name="userid" id="logincheck_input_id"
							size="10"></td>
						<td rowspan="2"><input type="submit" value="Login"
							id="logincheck_input_button" onclick="return loginCheck()" title="ログイン"></td>
					</tr>
					<tr>
						<td id="logincheck_input_text"><b>PW</b></td>
						<td><input type="password" name="userpw"
							id="logincheck_input_pw" size="10"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="logincheck_newuser">
			<form action="usercreate" method="get">
				<input type="submit" value="create ID" id="logincheck_newuser_button" title="ID作成。">
			</form>
		</div>
		<div id="logincheck_search">
			<form action="usersearch" method="get">
				<input type="submit" value="Find ID,PW" id="logincheck_search_button" title="ID,PWを探す。">
			</form>
		</div>
	</div>
</body>
</html>