<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/musicupdate.css">
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
	<div id="musicupdate">
		<div id="musicupdate_maintext">Music Update</div>
		<form action="musicupdate" method="post" enctype="multipart/form-data">
			<div id="musicupdate_title">
				<div id="musicupdate_title_titletext">Title : </div>
				<div id="musicupdate_title_type">
					<select name="update_type" id="update_type">
						<option selected value="${musictext.mustype}">${mustype}</option>
						<option value="mus_other">OTHER</option>
						<option value="mus_korea">KPOP</option>
						<option value="mus_japan">JPOP</option>
						<option value="mus_american">APOP</option>
					</select>
				</div>
				<div id="musicupdate_title_title">
					<input type="text" name="update_title" value="${musictext.title}" id="musicupdate_title_titleinput">
				</div>
			</div>
			<div id="musicupdate_description">
				<textarea name="update_description" cols="135" rows="2000" id="update_description">${musictext.description}</textarea>
				<div id="musicupdate_pic">
					<input type="hidden" name="h_mus_pic1" value="${musictext.muspic1}">
					<input type="file" name="mus_pic1" id="update_pic">
				</div>
				<div id="musicupdate_pic">
					<input type="hidden" name="h_mus_pic2" value="${musictext.muspic2}">
					<input type="file" name="mus_pic2" value="${musictext.muspic2}" id="update_pic">
				</div>
				<div id="musicupdate_pic">
					<input type="hidden" name="h_mus_pic3" value="${musictext.muspic3}">
					<input type="file" name="mus_pic3" value="${musictext.muspic3}" id="update_pic">
				</div>
				<div id="musicupdate_pic">
					<input type="hidden" name="h_mus_pic4" value="${musictext.muspic4}">
					<input type="file" name="mus_pic4" value="${musictext.muspic4}" id="update_pic">
				</div>
				<div id="musicupdate_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>