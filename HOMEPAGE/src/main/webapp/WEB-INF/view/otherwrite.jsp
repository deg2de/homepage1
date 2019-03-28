<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/otherwrite.css">
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
	<div id="otherwrite">
		<div id="otherwrite_maintext">Other Write</div>
		<form action="otherwrite" method="post" enctype="multipart/form-data">
			<div id="otherwrite_title">
				<div id="otherwrite_title_titletext">Title : </div>
				<div id="otherwrite_title_type">
					<select name="write_type" id="write_type">
						<option value="oth_other">OTHER</option>
					</select>
				</div>
				<div id="otherwrite_title_title">
					<input type="text" name="write_title" id="otherwrite_title_titleinput">
				</div>
			</div>
			<div id="otherwrite_description">
				<textarea name="write_description" cols="135" rows="2000" id="write_description"></textarea>
				<div id="otherwrite_pic"><input type="file" name="oth_pic1" id="write_pic"></div>
				<div id="otherwrite_pic"><input type="file" name="oth_pic2" id="write_pic"></div>
				<div id="otherwrite_pic"><input type="file" name="oth_pic3" id="write_pic"></div>
				<div id="otherwrite_pic"><input type="file" name="oth_pic4" id="write_pic"></div>
				<div id="otherwrite_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>