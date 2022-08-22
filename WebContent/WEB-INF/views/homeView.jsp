<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTP-8">
<title>Home page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSSFiles/CSSImage.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
<div class="clearfix"></div>
<br/>
<div class="responsive">
  <div class="gallery">
     <img src="${pageContext.request.contextPath}/images/Hinh5.jpg"
        alt="Trải nghiệm tuyệt vời" width="400" height="400">

    <div class="desc">Trải nghiệm tuyệt vời</div>
  </div>
</div>
<div class="responsive">
  <div class="gallery">
     <img src="${pageContext.request.contextPath}/images/Hinh2.jpg"
        alt="Nhân viên tư vấn tận tình" width="400" height="400">
    <div class="desc">Nhân viên tư vấn tận tình</div>
  </div>
</div>
<div class="responsive">
  <div class="gallery">
     <img src="${pageContext.request.contextPath}/images/Hinh3.jpg"
        alt="Trải nghiệm cái đẹp" width="400" height="400">
    <div class="desc">Trải nghiệm cái đẹp</div>
  </div>
</div>
<div class="responsive">
  <div class="gallery">
     <img src="${pageContext.request.contextPath}/images/Hinh4.jpg"
        alt="Thỏa sức sáng tạo" width="400" height="400">
    <div class="desc">Thỏa sức sáng tạo</div>
  </div>
</div>

<div class="clearfix"></div>
</body>

</html>