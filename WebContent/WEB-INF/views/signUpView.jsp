<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin người dùng</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSSFiles/CSSFrame.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<br/>
		<form class="frameAcc" method="POST" action="${pageContext.request.contextPath}/signup">
		  <h2>Đăng ký</h2>
		  <table>
		    <tr>	
			  <td>Họ Tên:</td>
			  <td><input type="text" name="hoTen" value="${hoTen}"></td>
		    </tr>
		    <tr>	
			  <td>Điện Thoại:</td>
			  <td><input type="text" name="sdt" value="${sdt}"></td>
		    </tr>
		    <tr>	
			  <td>Mật Khẩu:</td>
			  <td><input type="password" name="matKhau" value="${matKhau}"></td>
		    </tr>
		    <tr>
		      <td> <input type="submit" value="Thay đổi" /></td>
		    </tr>
		  </table>
		</form>

</body>
</html>