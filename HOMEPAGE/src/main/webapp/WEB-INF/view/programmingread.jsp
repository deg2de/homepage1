<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/programmingread.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="programmingread">
		<div id="programmingread_maintext">Programming</div>
		<div id="programmingread_setumei">
			<div id="programmingread_setumei_listno">NO</div>
			<div id="programmingread_setumei_userid">Name</div>
			<div id="programmingread_setumei_type">Type</div>
			<div id="programmingread_setumei_title">Title</div>
			<div id="programmingread_setumei_date">Date</div>
			<div id="programmingread_setumei_count">Count</div>
		</div>
		<div id="programmingread_title">
			<div id="programmingread_title_listno">${programmingtext.listno}</div>
			<div id="programmingread_title_userid">${programmingtext.userid}</div>
			<div id="programmingread_title_type">${programmingtext.protype}</div>
			<div id="programmingread_title_title">${programmingtext.title}</div>
			<div id="programmingread_title_date">${programmingtext.prodate}</div>
			<div id="programmingread_title_count">${programmingtext.procount}</div>
		</div>
		<div id="programmingread_upbutton">
			<c:if test="${loginuser.userid == programmingtext.userid}">
				<form action="programmingdelete" action="get">
				<input type="hidden" name="listno" value="${programmingtext.listno}">
				<input type="submit" value="Delete" id="programmingread_upbutton_delete">
				</form>
				<form action="programmingupdate" action="get">
				<input type="hidden" name="listno" value="${programmingtext.listno}">
				<input type="submit" value="Update" id="programmingread_upbutton_update">
				</form>
			</c:if>
				<form action="programminglist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="programmingread_upbutton_list">
				</form>
		</div>
		<div id="programmingread_text">
			<div id="programmingread_text_block">
				<c:if test="${!empty programmingtext.propic1}">
				<div id="programmingread_text_block_imgblock">
				<img src="IMG/upload/${programmingtext.propic1}" id="programmingread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty programmingtext.propic2}">
				<div id="programmingread_text_block_imgblock">
				<img src="IMG/upload/${programmingtext.propic2}" id="programmingread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty programmingtext.propic3}">
				<div id="programmingread_text_block_imgblock">
				<img src="IMG/upload/${programmingtext.propic3}" id="programmingread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty programmingtext.propic4}">
				<div id="programmingread_text_block_imgblock">
				<img src="IMG/upload/${programmingtext.propic4}" id="programmingread_text_block_img">
				</div>
				</c:if>
				${programmingtext.description}
			</div>
		</div>
		<div id="programmingread_downbutton">
				<form action="programminglist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="programmingread_downbutton_list">
				</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>