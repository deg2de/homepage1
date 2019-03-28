<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/travelsuccess.css">
<link rel="stylesheet" type="text/css" href="CSS/listtablesize.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="travelsuccess">
		<div id="travelsuccess_maintext">Travel Page</div>
		<div id="travelsuccess_text">${message}</div>
		<div id="travelsuccess_text_listbutton">
			<form action="travellist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="Travel" id="travelsuccess_listbutton">
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>