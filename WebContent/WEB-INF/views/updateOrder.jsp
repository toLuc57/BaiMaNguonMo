<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi lịch</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	      
      <h3>Thay đổi lịch</h3>
      
      <p style="color: red;">${errorString}</p>
      
      <form method="POST" action="${pageContext.request.contextPath}/update">
         <input type="hidden" name="idhh" value="${idhh}"> 
         <table border="0">
         <tr>
         <td>NGÀY</td>
         <td><input type="date" id="orderDate" name="orderDate" value="${orderDate}"></td>
         <tr>
            <td> KHUNG GIỜ </td>
            <td>
              <c:forEach items="${dskg}" var="i">
                  <input type="radio" id="shift${i.id}" 
                  class="shifts" name="shift" value="${i.batDau}">
                  <label for="shift${i.id}">${i.batDau} - ${i.ketThuc}</label>
                  <br/>
              </c:forEach>
            </td>
         </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="${pageContext.request.contextPath}/">Thoát</a>
               </td>
            </tr>
      	</table>
      </form>	
<script>
document.getElementById('orderDate').valueAsDate = new Date();
</script>
</body>
</html>