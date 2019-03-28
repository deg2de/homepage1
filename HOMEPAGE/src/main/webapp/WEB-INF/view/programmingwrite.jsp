<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/programmingwrite.css">
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
	<div id="programmingwrite">
		<div id="programmingwrite_maintext">Programming Write</div>
		<form action="programmingwrite" method="post" enctype="multipart/form-data">
			<div id="programmingwrite_title">
				<div id="programmingwrite_title_titletext">Title : </div>
				<div id="programmingwrite_title_type">
					<select name="write_type" id="write_type">
						<option value="pro_other">OTHER</option>
						<option value="pro_html">HTML</option>
						<option value="pro_css">CSS</option>
						<option value="pro_javascript">JavaScript</option>
						<option value="pro_java">JAVA</option>
						<option value="pro_jsp">JSP</option>
						<option value="pro_php">PHP</option>
						<option value="pro_oracle">ORACLE</option>
						<option value="pro_mysql">MySQL</option>
						<option value="pro_spring">SPRING</option>
						<option value="pro_xml">XML</option>
						<option value="pro_c">C</option>
						<option value="pro_cplus2">C++</option>
						<option value="pro_csharp">C#</option>
						<option value="pro_windows">WINDOWS</option>
						<option value="pro_linux">LINUX</option>
					</select>
				</div>
				<div id="programmingwrite_title_title">
					<input type="text" name="write_title" id="programmingwrite_title_titleinput">
				</div>
			</div>
			<div id="programmingwrite_description">
				<textarea name="write_description" cols="135" rows="2000" id="write_description"></textarea>
				<div id="programmingwrite_pic"><input type="file" name="pro_pic1" id="write_pic"></div>
				<div id="programmingwrite_pic"><input type="file" name="pro_pic2" id="write_pic"></div>
				<div id="programmingwrite_pic"><input type="file" name="pro_pic3" id="write_pic"></div>
				<div id="programmingwrite_pic"><input type="file" name="pro_pic4" id="write_pic"></div>
				<div id="programmingwrite_downbutton">
					<input type="submit" value="OK" id="okbutton">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>