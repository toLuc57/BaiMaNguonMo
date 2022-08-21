<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết hóa đơn</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSSFiles/CSSFrame.css">
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<br/>
	<form class="frameBill">
		<h2 style="text-align: center;">CHI TIẾT HÓA ĐƠN</h2>
		<table border="1">
			<tr>
				<th>Mã hóa đơn</th>
				<th>Mã dịch vụ</th>
			    <th>đánh giá</th>
			    <th>Giá cả</th> 
			</tr>
			<c:forEach items ="${cthd}" var="chiTiet">
			<tr>
				<td>${chiTiet.id}</td>
				<td>${chiTiet.idDichVu}</td>
				<td>${chiTiet.danhGia}</td>
				<td>${chiTiet.gia}</td>
			</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/account">Quay lại</a>
	</form>
	
             
</body>
</html>