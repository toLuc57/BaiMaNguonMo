<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang đặt lịch</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	      
      <h3>Đặt lịch</h3>
      
      <p style="color: red;">${errorString}</p>
      
      <form method="POST" action="${pageContext.request.contextPath}/order">
         <input type="hidden" name="idKhachHang" value="${khachHang.id}"> 
         <table border="0">
         	<tr>
         		<td>CHI NHÁNH</td>
         		<td>
         			<input type="search" name="findStore"/>
         			<select name="store">
         				<option value="Quận 5">Quận 5</option>
         				<option value="Quận 2">Quận 2</option>
         				<option value="Quận 1">Quận 1</option>
         			</select>
         		</td>
         	</tr>
            <tr>
               <td>DỊCH VỤ</td>
               <td>
                 <c:forEach items="${dsdv}" var="i">
                   <input type="checkbox" name="list" id="${i.id}" value="${i.ten}">
                   <label for="${i.id}">${i.ten} - </label> 
                   <label for="${i.id}">${i.gia}k</label> 
                   <br/>
                 </c:forEach>
               </td>
            </tr>
            <tr>
               <td>NHÂN VIÊN</td>
               <td>
                 <c:forEach items="${dsnv}" var="i">
                   <input type="radio" name="list" value="${i}">
                   <label>${i}</label>
                   <br/>
                 </c:forEach>
               </td>
            <tr>
            <tr>
               <td>THỜI GIAN</td>
               <td>
                 <c:forEach items="${dskg}" var="i">
                   <input type="radio" name="list" value="${i}">
                   <label>${i}</label>
                   <br/>
                 </c:forEach>
               </td>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="${pageContext.request.contextPath}/">Thoát</a>
               </td>
            </tr>
         </table>
      </form>	
</body>
</html>