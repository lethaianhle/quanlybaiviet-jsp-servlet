<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><dec:title default="Trang Chủ" /></title>

    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/vendors/feather/feather.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/vendors/ti-icons/css/themify-icons.css">
    <!-- endinject -->

    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/vertical-layout-light/style.css">
    <!-- endinject -->

    <!-- Paging -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>


</head>
<body>
	<dec:body/>
    <!-- plugins:js -->
    <script src="${pageContext.request.contextPath}/templates/admin/vendors/js/vendor.bundle.base.js"></script>
    <script src="${pageContext.request.contextPath}/templates/paging/jquery.twbsPagination.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js" type="text/javascript"></script>
    <!-- endinject -->

    <!-- inject:js -->
    <script src="${pageContext.request.contextPath}/templates/admin/js/template.js"></script>
    <script src="${pageContext.request.contextPath}/templates/admin/js/settings.js"></script>
    <!-- endinject -->
	</body>
</html>