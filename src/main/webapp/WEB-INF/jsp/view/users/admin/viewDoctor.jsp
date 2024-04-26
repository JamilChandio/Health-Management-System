<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
		<c:set var="doctor"	value="${doctor}"></c:set>
	<section>
		<main>
			<div class="container-sm">
				<table class="table table-dark" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">${doctor.getDoctorId()}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>First Name</td>
							<td>${doctor.getFirst_name() }</td>
						</tr>
						<tr>
							
							<td>Last Name</td>
							<td>${doctor.getLast_name() }</td>
						</tr>
						<tr>
							<td>Specialization</td>
							<td>${doctor.getSpecialization() }</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>${doctor.getUsername() }</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>${doctor.getEmail() }</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>${doctor.getPassword() }</td>
						</tr>
						<tr>
							<td>Address</td>
							<td>${doctor.getAddress() }</td>
						</tr>
						<tr>
							<td>Number</td>
							<td>${doctor.getNumber() }</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${doctor.getGender() }</td>
						</tr>
						
						<tr>
							<td>Age</td>
							<td>${doctor.getAge() }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</main>
	</section>
</body>
</html>