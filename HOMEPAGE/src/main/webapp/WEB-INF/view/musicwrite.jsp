<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/musicwrite.css">
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
	<div id="musicwrite">
		<div id="musicwrite_maintext">Music Write</div>
		<form action="musicwrite" method="post" enctype="multipart/form-data">
			<div id="musicwrite_title">
				<div id="musicwrite_title_titletext">Title : </div>
				<div id="musicwrite_title_type">
					<select name="write_type" id="write_type">
						<option value="mus_other">OTHER</option>
						<option value="mus_korea">KPOP</option>
						<option value="mus_japan">JPOP</option>
						<option value="mus_american">APOP</option>
					</select>
				</div>
				<div id="musicwrite_title_title">
					<input type="text" name="write_title" id="musicwrite_title_titleinput">
				</div>
			</div>
			<div id="musicwrite_description">
				<textarea name="write_description" cols="135" rows="2000" id="write_description"></textarea>
				<div id="musicwrite_pic"><input type="file" name="mus_pic1" id="write_pic"></div>
				<div id="musicwrite_pic"><input type="file" name="mus_pic2" id="write_pic"></div>
				<div id="musicwrite_pic"><input type="file" name="mus_pic3" id="write_pic"></div>
				<div id="musicwrite_pic"><input type="file" name="mus_pic4" id="write_pic"></div>
				<div id="musicwrite_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>