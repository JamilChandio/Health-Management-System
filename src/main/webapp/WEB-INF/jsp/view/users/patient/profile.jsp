<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient</title>
</head>
<body>

	<main>
		<div class="container-sm">
			<form action="UpdatePatientProfile" method="post">

				<div class="form-group">
					<label for="patientID">Patient ID</label> <input type="text"
						disabled value="${sessionScope.person.getPatientId() }"
						class="form-control" id="patientID">
				</div>

				<div class="form-group">
					<label for="firstName">First Name</label> <input type="text"
						disabled value="${sessionScope.person.getFirst_name() }"
						class="form-control" id="firstName" name="firstName">
				</div>

				<div class="form-group">
					<label for="lastName">Last Name</label> <input type="text" disabled
						value="${sessionScope.person.getLast_name() }"
						class="form-control" id="lastName" name="lastName">
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" disabled
						value="${sessionScope.person.getEmail() }" id="exampleInputEmail1"
						name="email" aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="gender">Gender</label> <input disabled type="text"
						value="${sessionScope.person.getGender() }" class="form-control"
						name="gender" id="gender">
				</div>

				<div class="form-group">
					<label for="dateOfBirth">Date of Birth</label> <input disabled
						type="text" value="${sessionScope.person.getDateOfBirth() }"
						class="form-control" name="dateOfBirth" id="dateOfBirth">
				</div>

				<div class="form-group">
					<label for="username">Username</label> <input required type="text"
						class="form-control" name="username"
						value="${sessionScope.person.getUsername() }" id="username"
						aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input required
						type="password" value="${sessionScope.person.getPassword() }"
						class="form-control" name="password" id="exampleInputPassword1">
				</div>

				<div class="form-group">
					<label for="number">Number</label> <input required type="text"
						value="${sessionScope.person.getNumber() }" class="form-control"
						name="number" id="number">
				</div>


				<div class="form-group">
					<label for="address">Address</label> <input required type="text"
						value="${sessionScope.person.getAddress() }" class="form-control"
						name="address" id="address">
				</div>

				<div class="form-group">
					<label for="medicalCondition">Medical Condition</label>
					<textarea required class="form-control" name="medicalCondition"
						id="medicalCondition" rows="3"><c:out
							value="${sessionScope.person.getMedicalCondition()}"></c:out></textarea>
				</div>
				<button type="submit" class="btn btn-success">Update</button>
			</form>
		</div>
	</main>
</body>
</html>