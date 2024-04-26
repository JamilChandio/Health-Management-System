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
			<form action="UpdateDoctor" method="post">

				<input type="hidden" value="${requestScope.doctor.getDoctorId() }"
					name="doctorId" class="form-control" id="doctorId">

				<div class="form-group">
					<label for="doctorId">Doctor ID</label> <input disabled type="text"
						value="${requestScope.doctor.getDoctorId() }" name="Id"
						class="form-control" id="doctorId"> <small id="emailHelp"
						class="form-text text-muted">You can't change ID, It's
						auto-generated</small>
				</div>

				<div class="form-group">
					<label for="firstName">First Name</label> <input required
						type="text" value="${requestScope.doctor.getFirst_name()}"
						class="form-control" name="firstName" id="firstName">
				</div>

				<div class="form-group">
					<label for="lastName">Last Name</label> <input required type="text"
						value="${requestScope.doctor.getLast_name() }"
						class="form-control" name="lastName" id="lastName">
				</div>

				<div class="form-group">
					<label for="lastName">Specialization</label> <input required
						type="text" value="${requestScope.doctor.getSpecialization() }"
						class="form-control" name="specialization" id="specialization">
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						required type="email" class="form-control"
						value="${requestScope.doctor.getEmail() }" name="email"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="username">Username</label> <input required type="text"
						class="form-control" name="username"
						value="${requestScope.doctor.getUsername() }" id="username"
						aria-describedby="emailHelp">
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input required
						type="password" value="${requestScope.doctor.getPassword() }"
						class="form-control" name="password" id="exampleInputPassword1">
				</div>

				<div class="form-group">
					<label for="number">Number</label> <input required type="text"
						value="${requestScope.doctor.getNumber() }" class="form-control"
						name="number" id="number">
				</div>


				<div class="form-group">
					<label for="address">Address</label> <input required type="text"
						value="${requestScope.doctor.getAddress() }" class="form-control"
						name="address" id="address">
				</div>

				<div class="form-group">
					<label for="age">Age</label> <input required type="number" min="18"
						max="150" value="${requestScope.doctor.getAge() }"
						class="form-control" name="age" id="age">
				</div>


				<div class="form-group">
					<label for="gender">Gender</label> <input required type="text"
						value="${requestScope.doctor.getGender() }" class="form-control"
						name="gender" id="gender">
				</div>

				<div class="form-group">
					<label for="description">Description</label>
					<textarea required class="form-control" name="description"
						id="description" rows="3"><c:out
							value="${requestScope.doctor.getDoctorDesc()}"></c:out></textarea>
				</div>

				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</main>
</body>
</html>