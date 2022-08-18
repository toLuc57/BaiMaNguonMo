<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<style>
ul.topnav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

ul.topnav li.right {float: right;}

.modal{
	display:none;
	position:fixed;
	z-index:999;
	padding-top:150px;
	left:0;
	top:0;
	width:100%;
	height:100%;
	overflow:auto;
	background-color: hsl(0, 0%, 71%);
}
.modal-content{
		display:block;
		margin-left:auto;
		margin-right:auto;
		width:32%;
		min-width:150px;
		height:200px;
		background-color: hsl(0, 0%, 100%);
		border-style: groove;
	}
.close{
	position:absolute;
	top:15px;
	right:35px;
	color:white;
	font-size:40px;
	font-weight:bold;
	transition: 1s;
}
.close:hover,
.close:focus{
	text-decoration:underline;
	cursor: pointer;
}	

.btn {
  background-color: white;
  color: black;
  border: 2px solid #e7e7e7;
  float:right;
  padding: 10px 24px;
  margin :5px;
}

.btn:hover {background-color: #e7e7e7;}

@media screen and (max-width: 600px) {
  ul.topnav li.right, 
  ul.topnav li {float: none;}
  .modal-content {
  	width: 100%;
  }
}
</style>

<ul class="topnav">
  <li class="">
    <a href="${pageContext.request.contextPath}/">Trang chủ</a>	
  </li>
  <li>
    <a href="${pageContext.request.contextPath}/order">Đặt lịch</a> 
  </li>
  <c:if test="${not empty loginedUser}">
	  <li>
	    <a href="${pageContext.request.contextPath}/order">Đặt lịch</a> 
	  </li>
	  <li class="right">
	    <a href="${pageContext.request.contextPath}/">Thông tin cá nhân</a>
	  </li>
  </c:if>
  <c:if test="${empty loginedUser}">
  	<li class="right">
	    <a href="javascript:void(0)" id="btnLogin">Đăng nhập</a>
	  </li>
  </c:if>
</ul>

<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <div class="modal-content" id="modalLogin">
    <p style="font-size: 20px; text-align:center;">Đăng nhập</p>
    <form method="POST" action="${pageContext.request.contextPath}/home">
      <table>
        <tr>
          <td style="margin:7px"> Số điện thoại: </td>
          <td> <input type="tel" name="phone"> </td>
        </tr>
        <tr>
          <td style="margin:7px"> Mật khẩu (nếu có): </td>
          <td> <input type="password" name="password"> </td>
        </tr>
        <tr>
          <td colspan ="2">
            <input type="submit" value="Submit" class="btn"/>
            <a href="javascript:void(0)" id="btnClose" class="btn">Cancel</a>
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>
<script type="text/javascript">
var modal= document.getElementById('myModal');

var btnLogin = document.getElementById('btnLogin');
var modalLogin = document.getElementById('modalLogin');

var btnClose = document.getElementById('btnClose');

btnLogin.onclick = function() {
	modal.style.display = "block";
}
var span = document.getElementsByClassName("close")[0];
btnClose.onclick = span.onclick = function() {
	modal.style.display = "none";
}
</script>
