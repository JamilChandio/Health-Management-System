<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<c:set var="admin"	value="${currentAdmin }"></c:set>
	<section>
		<main>
			<div class="container-sm">
				<table class="table table-dark" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">${admin.getAdminId()}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>First Name</td>
							<td>${admin.getFirst_name() }</td>
						</tr>
						<tr>
							
							<td>Last Name</td>
							<td>${admin.getLast_name() }</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>${admin.getUsername() }</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>${admin.getEmail() }</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>${admin.getPassword() }</td>
						</tr>
						<tr>
							<td>Address</td>
							<td>${admin.getAddress() }</td>
						</tr>
						<tr>
							<td>Number</td>
							<td>${admin.getNumber() }</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${admin.getGender() }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</main>
	</section>
</body>
</html>