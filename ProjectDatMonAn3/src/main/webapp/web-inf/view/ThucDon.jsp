<%@ page language="java" 
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thực đơn</h1>
	<ul>
		<c:forEach var = "item" items="${danhsachthucdon }">
			<li>${item.tenthucdon} 
		</c:forEach>
	</ul>
	
</body>
</html>