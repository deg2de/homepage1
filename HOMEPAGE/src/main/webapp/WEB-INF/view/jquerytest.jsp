<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
var btn1 = window.document.getElementById("btn1");

if(btn1.attachEvent) {
	btn1.attachEvent("onclick", function(){alert("hello")});
} else {
	btn1.addEventListener("click", function(){alert("hello")}, false);
}
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="btn1" value="test1">
</body>
</html>