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
	<%-- header全体 --%>
	<div id="wrap">
		<%-- logoイメージ --%>
		<div id="logo-img">
			<a href="/HOMEPAGE/" title="mainに移動。">
				<img id="logo-img" src="IMG/logo_img.png">
			</a>
		</div>
		<div id="login">
			<%-- loginチェック --%>
			<c:if test="${loginuser.name == null}"><jsp:include page="logincheck.jsp" /></c:if>
			<c:if test="${loginuser.name != null}"><jsp:include page="loginsuccess.jsp" /></c:if>
		</div>
	</div>
	<div id="header_message">${message}</div>
	<div id="menu">
	<ul id="nav">
		<li>
			<form action="programminglist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="Programming" id="menu_button">
			</form>
		</li>
		<li>
			<form action="travellist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="Travel" id="menu_button">
			</form>
		</li>
		<li>
			<form action="musiclist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="Music" id="menu_button">
			</form>
		</li>
		<li>
			<form action="otherlist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="Other" id="menu_button">
			</form>
		</li>
	</ul>
	</div>
</body>
</html>