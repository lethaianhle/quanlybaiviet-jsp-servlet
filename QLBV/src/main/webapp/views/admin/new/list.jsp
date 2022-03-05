<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url var="APIurl" value="/api/admin/new"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang Chủ</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/list_new" id="formSubmit" method="get">
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div
			class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
			<a class="navbar-brand brand-logo mr-5" href=""><img
				src="${pageContext.request.contextPath}/templates/admin/images/logo.svg" class="mr-2" alt="logo" /></a> <a
				class="navbar-brand brand-logo-mini" href=""><img
				src="${pageContext.request.contextPath}/templates/admin/images/logo-mini.svg" alt="logo" /></a>
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
					id="profileDropdown"> <img src="${pageContext.request.contextPath}/templates/admin/images/faces/face10.jpg"
						alt="profile" />
				</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
						aria-labelledby="profileDropdown">
						<a class="dropdown-item"> <i class="ti-settings text-primary"></i>
							Settings
						</a> <a href="${pageContext.request.contextPath}/logout?action=logout" class="dropdown-item"> <i
							class="ti-power-off text-primary"></i> Logout
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
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/trang_chu"> <i
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
							<li class="nav-item"><a class="nav-link" href="#">Danh
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
									<h3 class="font-weight-bold">Quản Lý Bài Viết</h3>
								</div>
								<div class="col-12 col-xl-4"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<p class="card-title">Danh Sách Bài Viết</p>
									<a href="${pageContext.request.contextPath}/admin/list_new?type=edit" style="padding: 13px; width: 150px;" class="btn btn-success btn-icon-text">
                                        <i class="ti-file btn-icon-prepend"></i>
                                        Create
                                    </a>
                                    <button id="btnDelete" style="padding: 13px; width: 150px;" type="button" class="btn btn-danger btn-icon-text">
                                        <i class="ti-alert btn-icon-prepend"></i>
                                        Delete
                                    </button>
                                    <p></p>
									<div class="row">
										<div class="col-12">
											<div class="table-responsive">
												<table class="table expandable-table"
													style="width: 100%; text-align: center;">
													<thead>
														<tr>
															<th><input type="checkbox" class="form-check-primary" id="checkAll"></th>
															<th>Tiêu đề</th>
															<th>Mô tả</th>
															<th>Nội dung</th>
															<th>Thể loại</th>
															<th></th>
				
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${model.listResult}" var="model">
														<tr>
															<td>
																<input type="checkbox" class="form-check-primary" id="checkbox_${model.newId}" value="${model.newId}" />
															</td>
															<td>
																<c:set var = "string" value = "${model.title}"/>
																<c:set var = "title" value = "${fn:substring(string, 0, 30)}"/>
																${title}...
															</td>
															<td>
																<c:set var = "string" value = "${model.description}"/>
																<c:set var = "description" value = "${fn:substring(string, 0, 30)}"/>
																${description}...
															</td>
															<td>
																<c:set var = "string" value = "${model.content}"/>
																<c:set var = "content" value = "${fn:substring(string, 0, 30)}"/>
																${content}...
															</td>
															<td>
																${model.categoryId}
															</td>
															<td>
																<a href="${pageContext.request.contextPath}/admin/list_new?type=edit&newId=${model.newId}" style="width: 70px;" class="btn btn-info btn-sm btn-rounded">Edit</a>
															</td>
														</tr>
														
														</c:forEach>
													</tbody>
												</table>
												<!-- Paging -->
												<br>
												<nav aria-label="Page navigation">
													<ul class="pagination" id="pagination"></ul>
												</nav>
												<!-- Hiden input paging -->
												<input type="hidden" id="page" value="" name="page"/>
												<input type="hidden" id="maxPageItem" value="" name="maxPageItem"/>
												<input type="hidden" id="sortName" value="" name="sortName"/>
												<input type="hidden" id="sortBy" value="" name="sortBy"/>
												<input type="hidden" id="type" value="" name="type"/>
											</div>
										</div>
									</div>
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
						© 2021. Premium <a href="" target="_blank">Bootstrap admin
							template</a> from BootstrapDash. All rights reserved.
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
	</form>


	<script type="text/javascript">
		//Pagination
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('DESC');
						$('#type').val('list');
						
						$('#formSubmit').submit();
					}
				}
			});
		});
		
		//delete news function
		$('#btnDelete').click(function () {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
				return $(this).val();
			}).get();
			
			data['ids'] = ids;
			
			deleteNew(data);
		});
		
		function deleteNew(data) {
			$.ajax({
				url: '${APIurl}', 
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (result) {
					window.location.href = '${pageContext.request.contextPath}/admin/list_new?type=list&page=1&maxPageItem=2&sortName=title&sortBy=DESC';
				},
				error: function(error) {
					console.log(error);
				}			
			});
		}
	</script>
</body>


</html>