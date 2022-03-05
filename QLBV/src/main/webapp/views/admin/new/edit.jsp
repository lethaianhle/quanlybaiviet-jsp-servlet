<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="APIurl" value="/api/admin/new" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${model.newId != null}">
	<title>Chỉnh sửa bài viết</title>
</c:if>
<c:if test="${model.newId == null}">
	<title>Thêm mới bài viết</title>
</c:if>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div
			class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
			<a class="navbar-brand brand-logo mr-5" href=""><img
				src="${pageContext.request.contextPath}/templates/admin/images/logo.svg"
				class="mr-2" alt="logo" /></a> <a class="navbar-brand brand-logo-mini"
				href=""><img
				src="${pageContext.request.contextPath}/templates/admin/images/logo-mini.svg"
				alt="logo" /></a>
		</div>
		<div
			class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
			<button class="navbar-toggler navbar-toggler align-self-center"
				type="button" data-toggle="minimize">
				<span class="icon-menu"></span>
			</button>
			<ul class="navbar-nav mr-lg-2">
				<li class="nav-item nav-search d-none d-lg-block">
					<div class="input-group">
						<div class="input-group-prepend hover-cursor"
							id="navbar-search-icon">
							<span class="input-group-text" id="search"> <i
								class="icon-search"></i>
							</span>
						</div>
						<input type="text" class="form-control" id="navbar-search-input"
							placeholder="Search now" aria-label="search"
							aria-describedby="search">
					</div>
				</li>
			</ul>
			<ul class="navbar-nav navbar-nav-right">
				<li class="nav-item dropdown"><a
					class="nav-link count-indicator dropdown-toggle"
					id="notificationDropdown" href="#" data-toggle="dropdown"> <i
						class="icon-bell mx-0"></i> <span class="count"></span>
				</a>
					<div
						class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
						aria-labelledby="notificationDropdown">
						<p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
						<a class="dropdown-item preview-item">
							<div class="preview-thumbnail">
								<div class="preview-icon bg-success">
									<i class="ti-info-alt mx-0"></i>
								</div>
							</div>
							<div class="preview-item-content">
								<h6 class="preview-subject font-weight-normal">Application
									Error</h6>
								<p class="font-weight-light small-text mb-0 text-muted">
									Just now</p>
							</div>
						</a> <a class="dropdown-item preview-item">
							<div class="preview-thumbnail">
								<div class="preview-icon bg-warning">
									<i class="ti-settings mx-0"></i>
								</div>
							</div>
							<div class="preview-item-content">
								<h6 class="preview-subject font-weight-normal">Settings</h6>
								<p class="font-weight-light small-text mb-0 text-muted">
									Private message</p>
							</div>
						</a> <a class="dropdown-item preview-item">
							<div class="preview-thumbnail">
								<div class="preview-icon bg-info">
									<i class="ti-user mx-0"></i>
								</div>
							</div>
							<div class="preview-item-content">
								<h6 class="preview-subject font-weight-normal">New user
									registration</h6>
								<p class="font-weight-light small-text mb-0 text-muted">2
									days ago</p>
							</div>
						</a>
					</div></li>
				<li class="nav-item nav-profile dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
					id="profileDropdown"> <img
						src="${pageContext.request.contextPath}/templates/admin/images/faces/face10.jpg"
						alt="profile" />
				</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
						aria-labelledby="profileDropdown">
						<a class="dropdown-item"> <i class="ti-settings text-primary"></i>
							Settings
						</a> <a class="dropdown-item"
							href="${pageContext.request.contextPath}/logout?action=logout">
							<i class="ti-power-off text-primary"></i> Logout
						</a>
					</div></li>
				<li class="nav-item nav-settings d-none d-lg-flex"><a
					class="nav-link" href="#"> <i class="icon-ellipsis"></i>
				</a></li>
			</ul>
			<button
				class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
				type="button" data-toggle="offcanvas">
				<span class="icon-menu"></span>
			</button>
		</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<div class="theme-setting-wrapper">
				<div id="settings-trigger">
					<i class="ti-settings"></i>
				</div>
				<div id="theme-settings" class="settings-panel">
					<i class="settings-close ti-close"></i>
					<p class="settings-heading">SIDEBAR SKINS</p>
					<div class="sidebar-bg-options selected" id="sidebar-light-theme">
						<div class="img-ss rounded-circle bg-light border mr-3"></div>
						Light
					</div>
					<div class="sidebar-bg-options" id="sidebar-dark-theme">
						<div class="img-ss rounded-circle bg-dark border mr-3"></div>
						Dark
					</div>
					<p class="settings-heading mt-2">HEADER SKINS</p>
					<div class="color-tiles mx-0 px-4">
						<div class="tiles success"></div>
						<div class="tiles warning"></div>
						<div class="tiles danger"></div>
						<div class="tiles info"></div>
						<div class="tiles dark"></div>
						<div class="tiles default"></div>
					</div>
				</div>
			</div>
			<div id="right-sidebar" class="settings-panel">
				<i class="settings-close ti-close"></i>
			</div>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/trang_chu"> <i
						class="icon-grid menu-icon"></i> <span class="menu-title">Trang
							Chủ</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#auth" aria-expanded="false" aria-controls="auth"> <i
						class="icon-head menu-icon"></i> <span class="menu-title">Tài
							Khoản</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="auth">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link" href=""> Login
							</a></li>
							<li class="nav-item"><a class="nav-link" href="">
									Register </a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
						<i class="icon-layout menu-icon"></i> <span class="menu-title">Thể
							Loại</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="ui-basic">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link" href="">Buttons</a></li>
							<li class="nav-item"><a class="nav-link" href="">Dropdowns</a></li>
							<li class="nav-item"><a class="nav-link" href="">Typography</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#form-elements" aria-expanded="false"
					aria-controls="form-elements"> <i
						class="icon-columns menu-icon"></i> <span class="menu-title">Bình
							Luận</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="form-elements">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link" href="">Basic
									Elements</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#charts" aria-expanded="false" aria-controls="charts"> <i
						class="icon-paper menu-icon"></i> <span class="menu-title">Bài
							Viết</span> <i class="menu-arrow"></i>
				</a>
					<div class="collapse" id="charts">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/admin/list_new?type=list&page=1&maxPageItem=2&sortName=title&sortBy=DESC"">Danh
									sách bài viết</a></li>
						</ul>
					</div></li>
			</ul>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-md-12 grid-margin">
							<div class="row">
								<div class="col-12 col-xl-8 mb-4 mb-xl-0">
									<c:if test="${model.newId != null}">
										<h3 class="font-weight-bold">Cập nhập thông tin bài viết</h3>
									</c:if>
									<c:if test="${model.newId == null}">
										<h3 class="font-weight-bold">Thêm mới bài viết</h3>
									</c:if>
								</div>
								<div class="col-12 col-xl-4"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<form class="forms-sample" id="formSubmit">
										<div class="form-group">
											<label for="title">Tiêu đề</label> <input type="text"
												class="form-control" id="title" name="title"
												placeholder="Tiêu đề" value="${model.title }">
										</div>

										<div class="form-group">
											<label for="categoryCode">Thể loại</label>
											<c:if test="${model.newId == null}">
												<select class="form-control" id="categoryCode"
													name="categoryCode">
													<option value="">Chọn loại bài viết</option>
													<c:forEach items="${listCategory }" var="category">
														<option value="${category.categoryCode}">${category.categoryName }</option>
													</c:forEach>
												</select>
											</c:if>
											<c:if test="${model.newId != null}">
												<select class="form-control" id="categoryCode"
													name="categoryCode">
													<c:forEach items="${listCategory }" var="category">
														<option value="${category.categoryCode}"
															<c:if test="${model.categoryId == category.categoryId}">
																		selected="selected"</c:if>>
															${category.categoryName }</option>
													</c:forEach>
												</select>

											</c:if>
										</div>
										<div class="form-group">
											<label for="description">Mô tả</label> <input
												name="description" type="text" class="form-control"
												id="description" placeholder="Mô tả"
												value="${model.description }">
										</div>
										<div class="form-group">
											<label for="thumbnail">Hình đại diện</label> <input
												type="text" id="thumbnail" name="thumbnail"
												class="file-upload-default" value="">
											<div class="input-group col-xs-12">
												<input type="text" class="form-control file-upload-info"
													disabled placeholder="Upload Image"> <span
													class="input-group-append">
													<button class="file-upload-browse btn btn-primary"
														type="button">Upload</button>
												</span>
											</div>
										</div>
										<div class="form-group">
											<label for="content">Nội dung</label>
											<textarea class="form-control" name="content" id="content"
												rows="4">${model.content }</textarea>
										</div>
										<input type="hidden" id="newId" name="newId"
											value="${model.newId}" />

										<c:if test="${model.newId != null}">
											<input type="button" class="btn btn-primary mr-2"
												value="Cập Nhập" id="btnSubmit"></input>
										</c:if>
										<c:if test="${model.newId == null}">
											<input type="button" class="btn btn-primary mr-2"
												value="Tạo Mới" id="btnSubmit"></input>
										</c:if>

										<button type="button" onclick="javascript:history.go(-1)"
											class="btn btn-light">Quay Lại</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<footer class="footer">
				<div
					class="d-sm-flex justify-content-center justify-content-sm-between">
					<span
						class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
						© 2021. Premium <a href="https://www.bootstrapdash.com/"
						target="_blank">Bootstrap admin template</a> from BootstrapDash.
						All rights reserved.
					</span> <span
						class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted
						& made with <i class="ti-heart text-danger ml-1"></i>
					</span>
				</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->



	<script>
	// setting ckeditor
	var editor = '';
	$(document).ready(function() {
		editor = CKEDITOR.replace('content');
	});
	
	
	// button submit data(delete or update)
		$('#btnSubmit').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data['content'] = editor.getData();

			var newId = $('#newId').val();
			if (newId == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});

		function addNew(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					console.log(result);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}

		function updateNew(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					console.log(result);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>



























