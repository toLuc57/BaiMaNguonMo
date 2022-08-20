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
         <td>
           NGÀY <input type="date" id="orderDate" name="orderDate" value="2010-01-01">
         </td>
         </tr>
         	<tr>
         		<td>CHI NHÁNH</td>
         		<td>
         			<select id="branch" onchange="selectBranch()">
         				<c:forEach items="${dscn}" var="i">
         					<option value="${i}">${i}</option>
         				</c:forEach>
         			</select>
         		</td>
         	</tr>
         	<tr>
         		<td>TIỆM</td>
         		<td>
         			<c:forEach items="${dsccn.keySet()}" var="cn">
         				<div style="display:none;" id="${cn}" >
         				<c:forEach items="${dsccn.get(cn)}" var="i">
         					<input type="radio" id="store${i.id}" value="${i.ten}" 
         					name="store" onclick="selectStore(${i.id})"> 
         					<label>${i.ten}</label>
         				</c:forEach>
         			</div>
         			</c:forEach>
         		</td>
         	</tr>
            <tr>
               <td>DỊCH VỤ</td>
               <td>
                 <c:forEach items="${dsdv}" var="i">
                   <input type="checkbox" name="service" 
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
                 <c:forEach items="${dscnvtct.keySet()}" var="cnvt">
                   <c:if test="${not empty dscnvtct.get(cnvt)}">
                     <div style="display:none;" id="${cnvt}" class="dscnvtt">
                       <c:forEach items="${dscnvtct.get(cnvt)}" var="i">
                         <input type="radio" name="staff" value="${i.id}">
                         <label>${i.hoTen}</label>
                         <br/>
                       </c:forEach>
                     </div>
                     <br/>
                   </c:if>
                 </c:forEach>                 
               </td>
            </tr>
            <tr>
               <td> KHUNG GIỜ </td>
               <td>
                 <c:forEach items="${dskg}" var="i">
                   <div id="shifts${i.id}" class="displayShifts">
                     <input type="radio" class="shifts" name="shift" value="${i.id}">
                     <label for="shift${i.id}">${i.batDau} - ${i.ketThuc}</label>
                   </div>
                 
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
      	<h2>Ngoài lề</h2>
      	<p id="ngoaile">Test </p>
		<c:forEach items="${dscclvct.keySet()}" var="t">
	      <c:forEach items="${dscclvct.get(t)}" var="i">
		    <input type="hidden" class="${t}_${i.ngayLamViec}" value="${i.idKhungGio}"> 
	       </c:forEach>
		 </c:forEach>
		 
		 <c:forEach items="${dscclvccnv.keySet()}" var="nv">
	      <c:forEach items="${dscclvccnv.get(nv)}" var="i">
		    <input type="hidden" class="${nv}" value="${i.idKhungGio}"> 
	       </c:forEach>
		 </c:forEach>
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

function selectBranch(){
	var branchs = document.getElementById("branch");
	var currentBranch = branchs.value;
	for(let i = 0; i < branchs.length; ++i){
		if(currentBranch == branchs[i].value){
			document.getElementById("dstccn"+i).style.display = "block";
		} else {
			document.getElementById("dstccn"+i).style.display = "none";
		}
	}
}

function selectStore(idStore){
	var staff = document.getElementsByClassName("dscnvtt");
	for(let i = 0; i < staff.length; ++i){
		staff[i].style.display = "none";
	}
	document.getElementById("dsnvtt"+idStore).style.display = "block";
	
	var orderDate = document.getElementById("orderDate").value;
	var displayShifts = document.getElementsByClassName("displayShifts");
	var allShifts =  document.getElementsByClassName("shifts"+idStore);
	var shiftsStore = document.getElementsByClassName("dsclvtt"+idStore+"_"+orderDate);
	for(let i = 0; i < displayShifts.length; ++i){
		displayShifts[i].style.display = "none";
	}
	let text ="";
	for(let j = 0; j < shiftsStore.length;++j){
		document.getElementById("shifts" + shiftsStore[j].value).style.display = "block";
		text += "dsclvtt" + idStore + "_" + orderDate + ", ";
	}
	document.getElementById("ngoaile").innerHTML = text;
}

document.getElementById('orderDate').valueAsDate = new Date();

</script>
</body>
</html>