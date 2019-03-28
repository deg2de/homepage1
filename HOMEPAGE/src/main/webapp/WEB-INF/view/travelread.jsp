<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/travelread.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="travelread">
		<div id="travelread_maintext">Travel</div>
		<div id="travelread_setumei">
			<div id="travelread_setumei_listno">NO</div>
			<div id="travelread_setumei_userid">Name</div>
			<div id="travelread_setumei_type">Type</div>
			<div id="travelread_setumei_title">Title</div>
			<div id="travelread_setumei_date">Date</div>
			<div id="travelread_setumei_count">Count</div>
		</div>
		<div id="travelread_title">
			<div id="travelread_title_listno">${traveltext.listno}</div>
			<div id="travelread_title_userid">${traveltext.userid}</div>
			<div id="travelread_title_type">${traveltext.tratype}</div>
			<div id="travelread_title_title">${traveltext.title}</div>
			<div id="travelread_title_date">${traveltext.tradate}</div>
			<div id="travelread_title_count">${traveltext.tracount}</div>
		</div>
		<div id="travelread_upbutton">
			<c:if test="${loginuser.userid == traveltext.userid}">
				<form action="traveldelete" action="get">
				<input type="hidden" name="listno" value="${traveltext.listno}">
				<input type="submit" value="Delete" id="travelread_upbutton_delete">
				</form>
				<form action="travelupdate" action="get">
				<input type="hidden" name="listno" value="${traveltext.listno}">
				<input type="submit" value="Update" id="travelread_upbutton_update">
				</form>
			</c:if>
				<form action="travellist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="travelread_upbutton_list">
				</form>
		</div>
		<div id="travelread_text">
			<div id="travelread_text_block">
				<c:if test="${!empty traveltext.trapic1}">
				<div id="travelread_text_block_imgblock">
				<img src="IMG/upload/${traveltext.trapic1}" id="travelread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty traveltext.trapic2}">
				<div id="travelread_text_block_imgblock">
				<img src="IMG/upload/${traveltext.trapic2}" id="travelread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty traveltext.trapic3}">
				<div id="travelread_text_block_imgblock">
				<img src="IMG/upload/${traveltext.trapic3}" id="travelread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty traveltext.trapic4}">
				<div id="travelread_text_block_imgblock">
				<img src="IMG/upload/${traveltext.trapic4}" id="travelread_text_block_img">
				</div>
				</c:if>
				${traveltext.description}
			</div>
		</div>
		<div id="travelread_downbutton">
				<form action="travellist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="travelread_downbutton_list">
				</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>