<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
		<c:set var="patient"	value="${patient}"></c:set>
	<section>
		<main>
			<div class="container-sm">
				<table class="table table-dark" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">${patient.getPatientId()}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>First Name</td>
							<td>${patient.getFirst_name() }</td>
						</tr>
						<tr>
							
							<td>Last Name</td>
							<td>${patient.getLast_name() }</td>
						</tr>
						<tr>
							<td>Medical Condition</td>
							<td>${patient.getMedicalCondition() }</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>${patient.getUsername() }</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>${patient.getEmail() }</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>${patient.getPassword() }</td>
						</tr>
						<tr>
							<td>Address</td>
							<td>${patient.getAddress() }</td>
						</tr>
						<tr>
							<td>Number</td>
							<td>${patient.getNumber() }</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${patient.getGender() }</td>
						</tr>
						
						<tr>
							<td>Date of Birth</td>
							<td>${patient.getDateOfBirth() }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</main>
	</section>
</body>
</html>