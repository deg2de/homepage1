<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/otherread.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="otherread">
		<div id="otherread_maintext">Other</div>
		<div id="otherread_setumei">
			<div id="otherread_setumei_listno">NO</div>
			<div id="otherread_setumei_userid">Name</div>
			<div id="otherread_setumei_type">Type</div>
			<div id="otherread_setumei_title">Title</div>
			<div id="otherread_setumei_date">Date</div>
			<div id="otherread_setumei_count">Count</div>
		</div>
		<div id="otherread_title">
			<div id="otherread_title_listno">${othertext.listno}</div>
			<div id="otherread_title_userid">${othertext.userid}</div>
			<div id="otherread_title_type">${othertext.othtype}</div>
			<div id="otherread_title_title">${othertext.title}</div>
			<div id="otherread_title_date">${othertext.othdate}</div>
			<div id="otherread_title_count">${othertext.othcount}</div>
		</div>
		<div id="otherread_upbutton">
			<c:if test="${loginuser.userid == othertext.userid}">
				<form action="otherdelete" action="get">
				<input type="hidden" name="listno" value="${othertext.listno}">
				<input type="submit" value="Delete" id="otherread_upbutton_delete">
				</form>
				<form action="otherupdate" action="get">
				<input type="hidden" name="listno" value="${othertext.listno}">
				<input type="submit" value="Update" id="otherread_upbutton_update">
				</form>
			</c:if>
				<form action="otherlist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="otherread_upbutton_list">
				</form>
		</div>
		<div id="otherread_text">
			<div id="otherread_text_block">
				<c:if test="${!empty othertext.othpic1}">
				<div id="otherread_text_block_imgblock">
				<img src="IMG/upload/${othertext.othpic1}" id="otherread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty othertext.othpic2}">
				<div id="otherread_text_block_imgblock">
				<img src="IMG/upload/${othertext.othpic2}" id="otherread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty othertext.othpic3}">
				<div id="otherread_text_block_imgblock">
				<img src="IMG/upload/${othertext.othpic3}" id="otherread_text_block_img">
				</div>
				</c:if>
				<c:if test="${!empty othertext.othpic4}">
				<div id="otherread_text_block_imgblock">
				<img src="IMG/upload/${othertext.othpic4}" id="otherread_text_block_img">
				</div>
				</c:if>
				${othertext.description}
			</div>
		</div>
		<div id="otherread_downbutton">
				<form action="otherlist" method="get">
				<input type="hidden" name="pageno" value="${1}">
				<input type="submit" value="List" id="otherread_downbutton_list">
				</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>