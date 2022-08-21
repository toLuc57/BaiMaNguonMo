<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<style>
.top-header {
	display: block;
    height: 82px;
    padding: 8.5px 0;
    border-bottom: 1px solid #e5e5e5;
    width: 100%;
}
.span-font {
	font-size: 40px;
	font-family: "Lucida Handwriting", "Brush Script MT", Cursive;
}
</style>
<header class="top-header">
<div style="background: #E0E0E0; height: 80px; padding: 5px; border-bottom: 1px solid #e5e5e5;">
  <div style="float:left">
    <br/>
    <span class="span-font" onclick="${pageContext.request.contextPath}/order">PHV BARBER</span>
  </div>
  <div style="float: right; padding: 20px 10px; text-align: right;">
     <!-- User store in session with attribute: loginedUser -->
     <c:if test="${not empty loginedUser}">
       Hello <b>${loginedUser.ten}</b>
       <br/>
       <br/>
       <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
     </c:if>
  </div>
</div>
</header>