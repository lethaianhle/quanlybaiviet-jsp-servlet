<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><dec:title default="Trang Chủ" /></title>

	<!-- css -->
	<link href="${pageContext.request.contextPath}/templates/web/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="<c:url value='/templates/web/css/web-homepage.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	
	<div class="container">
		<dec:body />
	</div>
	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->
	
	    <!-- JavaScript -->
    <script type="text/javascript" src="<c:url value='/templates/web/js/jquery-1.10.2.js' />"></script>
    <script type="text/javascript" src="<c:url value='/templates/web/js/bootstrap.js' />"></script>
</body>
</html>