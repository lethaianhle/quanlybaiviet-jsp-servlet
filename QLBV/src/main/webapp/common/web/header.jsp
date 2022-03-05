<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/trang_chu">TinTucNhanh.NET</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Trang Chủ</a></li>
				
				<c:if test="${not empty userLoggedIn }">
					<li><a href="#">Xin chào, ${userLoggedIn.fullName}</a></li>
					<li><a href="${pageContext.request.contextPath}/logout?action=logout">Thoát</a></li>
				</c:if>
				
				<c:if test="${empty userLoggedIn }">
					<li><a href="${pageContext.request.contextPath}/login?action=login">Đăng Nhập</a></li>
					<li><a href="${pageContext.request.contextPath}/registration?action=registration">Đăng Ký</a></li>
				</c:if>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>