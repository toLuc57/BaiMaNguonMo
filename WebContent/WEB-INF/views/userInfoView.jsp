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
		<form class="frameAcc" method="POST" action="${pageContext.request.contextPath}/account">
		  <h2>THÔNG TIN TÀI KHOẢN</h2>
		  <input type="hidden" name="id" value="${loginedUser.id}">
		  <table>
		    <tr>	
			  <td>Họ Tên:</td>
			  <td><input type="text" name="hoTen" value="${loginedUser.ten}"></td>
		    </tr>
		    <tr>	
			  <td>Điện Thoại:</td>
			  <td><input type="text" name="sdt" value="${loginedUser.dienThoai}" readonly></td>
		    </tr>
		    <tr>	
			  <td>Mật Khẩu:</td>
			  <td><input type="password" name="matKhau" value="${loginedUser.matKhau}"></td>
		    </tr>
		    <tr>
		      <td> <input type="submit" value="Thay đổi" /></td>
		    </tr>
		  </table>
		</form>
	
	<!-- Danh sách hóa đơn chưa hoàn thành -->
	<c:if test="${not empty dshdcht}">
	  <br/>
	  <form class="frameBill">
	  	<h2 style="text-align: center;">LỊCH HẸN</h2>
    	<table border="1">
			<tr>
			  <th>Mã đơn hàng</th>
		      <th>Tên Khách Hàng</th>
		      <th>Mã nhân viên</th>
		      <th>Ngày đặt</th>
		      <th>Ngày thực hiện</th>
		      <th>Trạng thái</th> 
		      <th>Tên nhân viên</th>
		      <th>Chi tiết</th>
		      <th>Thay đổi</th>  
		      <th>Hủy lịch</th>
		   </tr>
		   <c:forEach items ="${dshdcht}" var="hoaDon">
		   	<tr>
		   		<td>${hoaDon.id}</td>
		   		<td>${loginedUser.ten}</td>
		   		<td>${hoaDon.idNhanVien}</td>
		   		<td>${hoaDon.ngayDat}</td>
		   		<td>${hoaDon.ngayThucHien}</td>
		   		<td>${hoaDon.trangThai}</td>
		   		<td>${dsnv.get(hoaDon.idNhanVien).hoTen }</td>
		   		<td><a href="chitiet?idhh=${hoaDon.id}">Chi Tiết Hóa Đơn</a></td>
		   		<td>
		   		  <a href="update?idhh=${hoaDon.id}&idnv=${hoaDon.idNhanVien}&order=${hoaDon.getChiHienThiNgay()}">
		   		  Thay đổi
		   		  </a>
		   		<td><a href="xoa?idhh=${hoaDon.id}">Hủy lịch</a>
		   	</tr>
		   </c:forEach>
		</table>
	  </form>
 	</c:if>
	<c:if test="${empty dshdcht}">
	  <h3>Bạn chưa có đặt dịch vụ nào</h3>
	</c:if>
	
	<!-- Danh sách hóa đơn hoàn thành -->
	<c:if test="${not empty dshddht}">
	<br/>
	  <form class="frameBill">
	  	<h2 style="text-align: center;">LỊCH SỬ HÓA ĐƠN</h2>
    	<table border="1">
			<tr>
			  <th>Mã đơn hàng</th>
		      <th>Mã Khách Hàng</th>
		      <th>Mã nhân viên</th>
		      <th>Ngày đặt</th>
		      <th>Trạng thái</th> 
		      <th>Chi tiết</th>  
		   </tr>
		   <c:forEach items ="${dshddht}" var="hoaDon">
		   	<tr>
		   		<td>${hoaDon.id}</td>
		   		<td>${hoaDon.idKhachHang}</td>
		   		<td>${hoaDon.idNhanVien}</td>
		   		<td>${hoaDon.ngayDat}</td>
		   		<td>${hoaDon.trangThai}</td>
		   		<td><a href="chitiet?idhh=${hoaDon.id}">Chi Tiết Hóa Đơn</a></td>
		   	</tr>
		   </c:forEach>
		</table>
	  </form>
 	</c:if>
	<c:if test="${empty dshddht}">
	  <h3>Bạn chưa có hóa đơn nào trước đây</h3>
	</c:if>
</body>
</html>