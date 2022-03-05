<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng Nhập</title>
</head>

<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth px-0">
				<div class="row w-100 mx-0">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left py-5 px-4 px-sm-5">
							<div class="brand-logo">
								<img
									src="${pageContext.request.contextPath}/templates/admin/images/logo.svg"
									alt="logo">
							</div>
							<h4>Xin chào, Chúc bạn một ngày mới tốt lành!</h4>
							<h6 class="font-weight-light">Đăng nhập để tiếp tục.</h6>
							<form class="pt-3"
								action="${pageContext.request.contextPath}/login" method="POST">
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputEmail1" name="userName"
										placeholder="Tên đăng nhập">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" name="password"
										placeholder="Mật khẩu">
								</div>
								<input type="hidden" value="login" name="action" />

								<c:if test="${not empty message}">
									<div class="mt-3" style="text-align: center;">
										<span style="color: red;">${message }</span>
									</div>
								</c:if>

								<div class="mt-3">
									<button type="submit"
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Đăng
										Nhập</button>
								</div>
								<div
									class="my-2 d-flex justify-content-between align-items-center">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> Nhớ mật
											khẩu
										</label>
									</div>
									<a href="" class="auth-link text-black">Quên mật khẩu?</a>
								</div>
								<div class="mb-2">
									<button type="button"
										class="btn btn-block btn-facebook auth-form-btn">
										<i class="ti-facebook mr-2"></i>Đăng nhập bằng Facebook
									</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Chưa có tài khoản? <a href="${pageContext.request.contextPath}/registration?action=registration" class="text-primary">Tạo tài
										khoản</a>
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
