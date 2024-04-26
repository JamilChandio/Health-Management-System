<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<main>
		<div class="container-sm">
			<form action="UpdatePatient" method="post">

				<input type="hidden" value="${requestScope.patient.getPatientId() }"
					name="patientId" class="form-control" id="patientId">

				<div class="form-group">
					<label for="patientId">Patient ID</label> <input disabled type="text"
						value="${requestScope.patient.getPatientId() }" name="Id"
						class="form-control" id="patientId"> <small id="idHelp"
						class="form-text text-muted">You can't change ID, It's
						auto-generated</small>
				</div>

				<div class="form-group">
					<label for="firstName">First Name</label> <input required
						type="text" value="${requestScope.patient.getFirst_name()}"
						class="form-control" name="firstName" id="firstName">
				</div>

				<div class="form-group">
					<label for="lastName">Last Name</label> <input required type="text"
						value="${requestScope.patient.getLast_name() }"
						class="form-control" name="lastName" id="lastName">
				</div>

				<div class="form-group">
					<label for="lastName">Medical Condition</label> <input required
						type="text" value="${requestScope.patient.getMedicalCondition() }"
						class="form-control" name="medicalCondition" id="medicalCondition">
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						required type="email" class="form-control"
						value="${requestScope.patient.getEmail() }" name="email"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="username">Username</label> <input required type="text"
						class="form-control" name="username"
						value="${requestScope.patient.getUsername() }" id="username"
						aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input required
						type="password" value="${requestScope.patient.getPassword() }"
						class="form-control" name="password" id="exampleInputPassword1">
				</div>

				<div class="form-group">
					<label for="number">Number</label> <input required type="text"
						value="${requestScope.patient.getNumber() }" class="form-control"
						name="number" id="number">
				</div>


				<div class="form-group">
					<label for="address">Address</label> <input required type="text"
						value="${requestScope.patient.getAddress() }" class="form-control"
						name="address" id="address">
				</div>

				<div class="form-group">
					<label for="age">Date of Birth</label> <input required type="date"
						value="${requestScope.patient.getDateOfBirth() }" class="form-control"
						name="dateOfBirth" id="age">
				</div>

				<div class="form-group">
					<label for="gender">Gender</label> <input required type="text"
						value="${requestScope.patient.getGender() }" class="form-control"
						name="gender" id="gender">
				</div>

				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</main>
	
	<script>
		// JavaScript code to restrict future dates in date of birth field
		document.getElementById('age').addEventListener('change', function() {
			var inputDate = new Date(this.value);
			var today = new Date();
			if (inputDate > today) {
				this.value = '';
				alert("Date of birth cannot be in future. Please select valid Date of Birth!.");
			}
		});
	</script>
</body>
</html>