<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/otherupdate.css">
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
	<div id="otherupdate">
		<div id="otherupdate_maintext">Other Update</div>
		<form action="otherupdate" method="post" enctype="multipart/form-data">
			<div id="otherupdate_title">
				<div id="otherupdate_title_titletext">Title : </div>
				<div id="otherupdate_title_type">
					<select name="update_type" id="update_type">
						<option selected value="${othertext.othtype}">${othtype}</option>
						<option value="oth_other">OTHER</option>
					</select>
				</div>
				<div id="otherupdate_title_title">
					<input type="text" name="update_title" value="${othertext.title}" id="otherupdate_title_titleinput">
				</div>
			</div>
			<div id="otherupdate_description">
				<textarea name="update_description" cols="135" rows="2000" id="update_description">${othertext.description}</textarea>
				<div id="otherupdate_pic">
					<input type="hidden" name="h_oth_pic1" value="${othertext.othpic1}">
					<input type="file" name="oth_pic1" id="update_pic">
				</div>
				<div id="otherupdate_pic">
					<input type="hidden" name="h_oth_pic2" value="${othertext.othpic2}">
					<input type="file" name="oth_pic2" value="${othertext.othpic2}" id="update_pic">
				</div>
				<div id="otherupdate_pic">
					<input type="hidden" name="h_oth_pic3" value="${othertext.othpic3}">
					<input type="file" name="oth_pic3" value="${othertext.othpic3}" id="update_pic">
				</div>
				<div id="otherupdate_pic">
					<input type="hidden" name="h_oth_pic4" value="${othertext.othpic4}">
					<input type="file" name="oth_pic4" value="${othertext.othpic4}" id="update_pic">
				</div>
				<div id="otherupdate_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>