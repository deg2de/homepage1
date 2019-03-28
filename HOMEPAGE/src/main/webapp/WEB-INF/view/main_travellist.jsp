<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/main_travellist.css">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Pacifico"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Nanum+Pen+Script|Pacifico"
	rel="stylesheet">
</head>
<body>
	<div id="main_travellist">
		<div id="main_travellist_main">
			<div id="main_travellist_maintext">travel</div>
			<div id="main_travellist_more">
				<a href="travellist?pageno=${1}">more</a></div>
		</div>
			<table id="tablealign">
				<thead>
					<tr>
						<td id="list_head_title">Title</td>
						<td id="list_head_readcount">Read Count</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="travel" items="${travellist}">
					<tr>
						<td id="travel_list_title">
							<a href="travelread?list_no=${travel.listno}" id="list_titletext">${travel.title}</a>
						</td>
						<td id="travel_list_readcount">${travel.tracount}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>