<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/programminglist.css">
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
	<div id="programminglist">
		<div id="programminglist_maintext">Programming</div>
		<div id="upbutton">
			<table>
			<tr>
				<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${1}">
					<input type="submit" value="Top" id="listbutton">
					</form>
				</td>
				<td>
					<form action="programmingwrite" method="get">
					<input type="submit" value="write" id="writebutton">
					</form>
				</td>
			</tr>
			</table>
		</div>
		<div id="list">
			<table id="tablealign">
				<thead>
					<tr>
						<td id="list_head_no">No</td>
						<td id="list_head_type">Type</td>
						<td id="list_head_title">Title</td>
						<td id="list_head_name">Name</td>
						<td id="list_head_date">Date</td>
						<td id="list_head_readcount">Read Count</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="programming" items="${programminglist}">
					<tr>
						<td id="list_no">${programming.listno}</td>
						<td id="list_type">${programming.protype}</td>
						<td id="list_title">
							<a href="programmingread?list_no=${programming.listno}" id="list_titletext">${programming.title}</a>
						</td>
						<td id="list_name">${programming.userid}</td>
						<td id="list_date">${programming.prodate}</td>
						<td id="list_readcount">${programming.procount}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="nowpage">
			${nowlistpageno} / ${totalpagesize} Page
		</div>
		<div id="listpageno">
			<table id="tablealign">
			<tr>
				<c:if test="${nowlistpageno != 1}">
					<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${1}">
					<input type="submit" value="first" id="pagebuttonsize">
					</form>
					</td>
					<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${nowlistpageno - 1}">
					<input type="submit" value="down" id="pagebuttonsize">
					</form>
					</td>
				</c:if>
				<c:forEach var="listno" begin = "${firstlistpage}" end="${lastlistpage}">
					<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${listno}">
					<input type="submit" value="${listno}" id="listbuttonsize">
					</form>
					</td>
				</c:forEach>
				<c:if test="${nowlistpageno != totalpagesize}">
					<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${nowlistpageno + 1}">
					<input type="submit" value="up" id="pagebuttonsize">
					</form>
					</td>
					<td>
					<form action="programminglist" method="get">
					<input type="hidden" name="pageno" value="${totalpagesize}">
					<input type="submit" value="last" id="pagebuttonsize">
					</form>
					</td>
				</c:if>
			</tr>
			</table>
		</div>
		<div id="downbutton">
			<form action="programmingwrite" method="get">
			<input type="submit" value="write" id="writebutton">
			</form>
		</div>
		<div id="search">
		<form action="programminglist" method="post">
			<select name="searchprotype" id="searchtype">
				<option value="pro_title">제목</option>
				<option value="pro_titletext">제목+내용</option>
				<option value="pro_type">종류</option>
				<option value="pro_name">작성자</option>
			</select>
			<input type="text" name="searchtext" id="searchtext">
			<input type="submit" value="search" id="searchbutton">
			<input type="hidden" name="pageno" value="${1}">
		</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>