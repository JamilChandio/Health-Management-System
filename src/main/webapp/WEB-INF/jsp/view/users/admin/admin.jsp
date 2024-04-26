<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="com.healthmanagementsystem.dao.AdminDao"%>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<section>
		<main>
			<div class="container-sm">
				<div class="list-group">
					<c:set var="admins" value="${AdminDao.getAllAdmins() }"></c:set>
					<c:forEach var="admin" items="${admins}">
						<div
							class="list-group-item d-flex justify-content-between align-items-center">
							<label class="list-group-item-action">${fn:toUpperCase(admin.getUsername())}</label>
							<a href="viewAdmin?id=${admin.getAdminId()}" class="btn btn-secondary view-button">View</a>
						</div>
						<hr>
					</c:forEach>
				</div>
			</div>
		</main>
	</section>
</body>
</html>