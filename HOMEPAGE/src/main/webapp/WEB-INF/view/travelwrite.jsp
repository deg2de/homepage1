<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/travelwrite.css">
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
	<div id="travelwrite">
		<div id="travelwrite_maintext">Travel Write</div>
		<form action="travelwrite" method="post" enctype="multipart/form-data">
			<div id="travelwrite_title">
				<div id="travelwrite_title_titletext">Title : </div>
				<div id="travelwrite_title_type">
					<select name="write_type" id="write_type">
						<option value="tra_other">OTHER</option>
						<option value="tra_korea">KOREA</option>
						<option value="tra_japan">JAPAN</option>
						<option value="tra_taiwan">TAIWAN</option>
						<option value="tra_china">CHINA</option>
						<option value="tra_usa">USA</option>
					</select>
				</div>
				<div id="travelwrite_title_title">
					<input type="text" name="write_title" id="travelwrite_title_titleinput">
				</div>
			</div>
			<div id="travelwrite_description">
				<textarea name="write_description" cols="135" rows="2000" id="write_description"></textarea>
				<div id="travelwrite_pic"><input type="file" name="tra_pic1" id="write_pic"></div>
				<div id="travelwrite_pic"><input type="file" name="tra_pic2" id="write_pic"></div>
				<div id="travelwrite_pic"><input type="file" name="tra_pic3" id="write_pic"></div>
				<div id="travelwrite_pic"><input type="file" name="tra_pic4" id="write_pic"></div>
				<div id="travelwrite_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>