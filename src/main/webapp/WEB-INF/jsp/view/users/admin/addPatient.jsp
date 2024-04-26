<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
</head>
<body>
	<!-- Main content -->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Add Patient</h5>
						
						<form action="AddPatient" method="post">
						
							<div class="form-row">
								<div class="col-md-6 mb-3">
									<input type="text" class="form-control" id="firstName"
										name="firstName" placeholder="First Name" required>
								</div>
								<div class="col-md-6 mb-3">
									<input type="text" class="form-control" id="lastName"
										name="lastName" placeholder="Last Name" required>
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="Username" required>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Email Address" required>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password" required>
							</div>
							<div class="form-row">
								<div class="col-md-6 mb-3">
									<input type="text" class="form-control" id="medicalCondition"
										name="medicalCondition" placeholder="Medical Condition">
								</div>
								<div class="col-md-6 mb-3">
									<input type="text" class="form-control" id="number"
										name="number" placeholder="Number">
								</div>
							</div>
							<div class="form-group">
								<textarea class="form-control" id="address" name="address"
									rows="3" placeholder="Address"></textarea>
							</div>
							<div class="form-row align-items-center">
								<div class="col-md-6 mb-3">

									<table>
										<tr>
											<td><label for="dateOfBirth">Date of Birth</label> &nbsp;</td>
											<td><input type="date" class="form-control"
												id="dateOfBirth" name="dateOfBirth"></td>
										</tr>
									</table>

								</div>
								<div class="col-md-6 mb-3">
									<select class="custom-select" id="gender" name="gender">
										<option value="Male">Gender</option>
										<option value="Female">Male</option>
										<option value="Other">Female</option>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		// JavaScript code to restrict future dates in date of birth field
		document.getElementById('dateOfBirth').addEventListener('change', function() {
			var inputDate = new Date(this.value);
			var today = new Date();
			if (inputDate > today) {
				this.value = '';
				alert("Date of birth cannot be in future. Please select today's date or any previous date.");
			}
		});
	</script>
</body>
</html>
