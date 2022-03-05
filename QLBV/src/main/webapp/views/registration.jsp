<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng Ký</title>
</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth px-0">
				<div class="row w-100 mx-0">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left py-5 px-4 px-sm-5">
							<div class="brand-logo">
								<img src="${pageContext.request.contextPath}/templates/admin/images/logo.svg" alt="logo">
							</div>
							<h4>Đăng Ký Tài Khoản</h4>
							<c:if test="${not empty message}">
									<h6 style="color: red">${message}</h6>
								</c:if>
							<form class="pt-3" action="${pageContext.request.contextPath}/registration?action=registration" method="POST">
								<div class="form-group">
									<input type="text" class="form-control form-control-lg" id="fullName" name="fullName" placeholder="Họ tên người dùng">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="userName" name="userName" placeholder="Tên đăng nhập">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="password" name="password" placeholder="Mật khẩu">
								</div> 
								<div class="mb-4">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> Đồng ý với chính sách & điều khoản bảo mật
										</label>
									</div>
								</div>
								<div class="mt-3">
									<button type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Đăng Ký</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Đã có tài khoản? <a href="${pageContext.request.contextPath}/login?action=login"
										class="text-primary">Đăng Nhập</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
</body>
</html>