<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/main_otherlist.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<div id="main_otherlist">
		<div id="main_otherlist_main">
			<div id="main_otherlist_maintext">other</div>
			<div id="main_otherlist_more">
				<a href="otherlist?pageno=${1}">more</a></div>
		</div>
			<table id="tablealign">
				<thead>
					<tr>
						<td id="list_head_title">Title</td>
						<td id="list_head_readcount">Read Count</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="other" items="${otherlist}">
					<tr>
						<td id="other_list_title">
							<a href="otherread?list_no=${other.listno}" id="list_titletext">${other.title}</a>
						</td>
						<td id="other_list_readcount">${other.othcount}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>