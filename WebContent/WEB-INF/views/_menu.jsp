<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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

@media screen and (max-width: 600px) {
  ul.topnav li.right, 
  ul.topnav li {float: none;}
}
</style>

<ul class="topnav">
  <li class="">
    <a href="${pageContext.request.contextPath}/">Trang chủ</a>	
  </li>
  <li>
    <a href="${pageContext.request.contextPath}/order">Đặt lịch</a> 
  </li>
  <li class="right">
    <a href="${pageContext.request.contextPath}/">Thông tin cá nhân</a>
  </li>
</ul>
