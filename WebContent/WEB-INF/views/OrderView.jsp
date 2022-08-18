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
         <input type="hidden" value="${dst}">
         <table border="0">
         	<tr>
         		<td>CHI NHÁNH</td>
         		<td>
         			<select name="store">
         				<c:forEach items="${dsq}" var="i">
         					<input type="hidden" name="">
         					<option value="${i.quan}">${i.quan}</option>
         				</c:forEach>
         			</select>
         		</td>
         	</tr>
            <tr>
               <td>DỊCH VỤ</td>
               <td>
                 <c:forEach items="${dsdv}" var="i">
                   <input type="checkbox" name="dsdv" 
                   id="${i.id}" value="${i.ten}">
                   <label for="${i.id}">${i.ten} - </label> 
                   <label class="price" for="${i.id}">${i.gia}</label> 
                   <label for="${i.id}">nghìn đồng</label> 
                   <br/>
                 </c:forEach>
               </td>
            </tr>
            <tr>
            	<td> Tổng số tiền (nghìn đồng): </td>
            	<td><p id="output">0 nghìn đồng</p></td> 
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
<script>
const ingredients = document.querySelectorAll('input[type=checkbox]');
const price = document.getElementsByClassName('price');

for(let i = 0; i < ingredients.length; ++i){
	ingredients[i].addEventListener('click', updateDisplay);
}
function updateDisplay() {
	let total = 0;
	for(let i = 0; i < ingredients.length; ++i) {
	  if (ingredients[i].checked) {
	    total -= -price[i].innerHTML;
	  }
	}
	document.getElementById("output").innerHTML = total + " nghìn đồng";
}

</script>
</body>
</html>