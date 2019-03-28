<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/main.css">
<title>leesugbok homepage</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="alllist">
		<div id="main_programminglist">
			<jsp:include page="main_programminglist.jsp" />
		</div>
		<div id="main_travellist">
			<jsp:include page="main_travellist.jsp" />
		</div>
		<div id="main_musiclist">
			<jsp:include page="main_musiclist.jsp" />
		</div>
		<div id="main_otherlist">
			<jsp:include page="main_otherlist.jsp" />
		</div>
	</div>
</div>
<div id="downbar"></div>
<jsp:include page="footer.jsp"/>
</body>
</html>