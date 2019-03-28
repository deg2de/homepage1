<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/travelupdate.css">
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
	<div id="travelupdate">
		<div id="travelupdate_maintext">Travel Update</div>
		<form action="travelupdate" method="post" enctype="multipart/form-data">
			<div id="travelupdate_title">
				<div id="travelupdate_title_titletext">Title : </div>
				<div id="travelupdate_title_type">
					<select name="update_type" id="update_type">
						<option selected value="${traveltext.tratype}">${tratype}</option>
						<option value="tra_other">OTHER</option>
						<option value="tra_korea">KOREA</option>
						<option value="tra_japan">JAPAN</option>
						<option value="tra_taiwan">TAIWAN</option>
						<option value="tra_china">CHINA</option>
						<option value="tra_usa">USA</option>
					</select>
				</div>
				<div id="travelupdate_title_title">
					<input type="text" name="update_title" value="${traveltext.title}" id="travelupdate_title_titleinput">
				</div>
			</div>
			<div id="travelupdate_description">
				<textarea name="update_description" cols="135" rows="2000" id="update_description">${traveltext.description}</textarea>
				<div id="travelupdate_pic">
					<input type="hidden" name="h_tra_pic1" value="${traveltext.trapic1}">
					<input type="file" name="tra_pic1" id="update_pic">
				</div>
				<div id="travelupdate_pic">
					<input type="hidden" name="h_tra_pic2" value="${traveltext.trapic2}">
					<input type="file" name="tra_pic2" value="${traveltext.trapic2}" id="update_pic">
				</div>
				<div id="travelupdate_pic">
					<input type="hidden" name="h_tra_pic3" value="${traveltext.trapic3}">
					<input type="file" name="tra_pic3" value="${traveltext.trapic3}" id="update_pic">
				</div>
				<div id="travelupdate_pic">
					<input type="hidden" name="h_tra_pic4" value="${traveltext.trapic4}">
					<input type="file" name="tra_pic4" value="${traveltext.trapic4}" id="update_pic">
				</div>
				<div id="travelupdate_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>