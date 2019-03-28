<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/musicread.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="musicread">
		<div id="musicread_maintext">Music</div>
		<div id="musicread_setumei">
			<div id="musicread_setumei_listno">NO</div>
			<div id="musicread_setumei_userid">Name</div>
			<div id="musicread_setumei_type">Type</div>
			<div id="musicread_setumei_title">Title</div>
			<div id="musicread_setumei_date">Date</div>
			<div id="musicread_setumei_count">Count</div>
		</div>
		<div id="musicread_title">
			<div id="musicread_title_listno">${musictext.listno}</div>
			<div id="musicread_title_userid">${musictext.userid}</div>
			<div id="musicread_title_type">${musictext.mustype}</div>
			<div id="musicread_title_title">${musictext.title}</div>
			<div id="musicread_title_date">${musictext.musdate}</div>
			<div id="musicread_title_count">${musictext.muscount}</div>
		</div>
		<div id="musicread_upbutton">
			<c:if test="${loginuser.userid == musictext.userid}">
				<form action="musicdelete" action="get">
				<input type="hidden" name="listno" value="${musictext.listno}">
				<input type="submit" value="Delete" id="musicread_upbutton_delete">
				</form>
				<form action="musicupdate" action="get">
				<input type="hidden" name="listno" value="${musictext.listno}">
				<input type="submit" value="Update" id="musicread_upbutton_update">
				</form>
			</c:if>
				<form action="musiclist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="musicread_upbutton_list">
				</form>
		</div>
		<div id="musicread_text">
			<div id="musicread_text_block">
				<c:if test="${!empty musictext.muspic1}">
				<div id="musicread_text_block_imgblock">
				<img src="IMG/upload/${musictext.muspic1}" id="musicread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty musictext.muspic2}">
				<div id="musicread_text_block_imgblock">
				<img src="IMG/upload/${musictext.muspic2}" id="musicread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty musictext.muspic3}">
				<div id="musicread_text_block_imgblock">
				<img src="IMG/upload/${musictext.muspic3}" id="musicread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty musictext.muspic4}">
				<div id="musicread_text_block_imgblock">
				<img src="IMG/upload/${musictext.muspic4}" id="musicread_text_block_img">
				</div>
				</c:if>
				${musictext.description}
			</div>
		</div>
		<div id="musicread_downbutton">
				<form action="musiclist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="musicread_downbutton_list">
				</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>