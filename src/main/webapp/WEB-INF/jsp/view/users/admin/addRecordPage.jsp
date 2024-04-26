<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<c:set var="patientIds" value="${patientIds}"></c:set>
	<c:set var="doctors" value="${doctors}"></c:set>

	<!-- Main content -->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Add a New Record</h5>

						<form action="AddMedicalRecord" method="post">

							<div class="form-row">

								<div class="form-group col-md-6">
									<label for="patientId">Patient ID:</label> <select
										class="form-control" id="patientId" name="patientId" required>
										<option value="">Select</option>
										<c:forEach var="patientId" items="${patientIds }">
											<option>${patientId}</option>
											<br>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-6">
									<label for="prescribingProvider">Prescribing Provider:</label>
									<select class="form-control" id="prescribingProvider"
										name="prescribingProvider" required>
										<option value="">Select</option>
										<c:forEach var="doctor" items="${doctors }">
											<option>${doctor.getUsername()}</option>
											<br>
										</c:forEach>
									</select>
								</div>

							</div>

							<div class="form-row">

								<div class="form-group col-md-6">
									<label for="prescribingProviderId">Prescribing Provider
										ID:</label> <select class="form-control" id="prescribingProviderId"
										name="prescribingProviderId" required>
										<option value="">Select</option>
										<c:forEach var="doctor" items="${doctors }">
											<option>${doctor.getDoctorId()}</option>
											<br>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-6">
									<label for="dateOfVisit">Date of Visit:</label> <input
										type="date" class="form-control" id="dateOfVisit"
										name="dateOfVisit" required>
								</div>

							</div>

							<div class="form-row">


								<div class="form-group col-md-6">
									<label for="reasonForVisit">Reason for Visit:</label> <input
										type="text" class="form-control" id="reasonForVisit"
										name="reasonForVisit" maxlength="255" required>
								</div>

								<div class="form-group col-md-6">
									<label for="medicationName">Medication Name:</label> <input
										type="text" class="form-control" id="medicationName"
										name="medicationName" maxlength="100" required>
								</div>
							</div>

							<div class="form-row">


								<div class="form-group col-md-6">
									<label for="dosage">Dosage:</label> <input type="text"
										class="form-control" id="dosage" name="dosage" maxlength="50"
										required>
								</div>

								<div class="form-group col-md-6">
									<label for="frequency">Medicine Timings:</label> <input
										type="text" class="form-control" id="frequency"
										name="frequency" maxlength="50" required>
								</div>
							</div>

							<div class="form-row">


								<div class="form-group col-md-6">
									<label for="startDate">Medicine Start Date:</label> <input
										type="date" class="form-control" id="startDate"
										name="startDate" required>
								</div>

								<div class="form-group col-md-6">
									<label for="endDate">Medicine End Date:</label> <input
										type="date" class="form-control" id="endDate" name="endDate"
										required>
								</div>

							</div>

							<div class="form-row">


								<div class="form-group col-md-6">
									<label for="diagnosisDescription">Diagnosis
										Description:</label> <input type="text" class="form-control"
										id="diagnosisDescription" name="diagnosisDescription" required>
								</div>

								<div class="form-group col-md-6">
									<label for="procedureDescription">Procedure
										Description:</label> <input type="text" class="form-control"
										id="procedureDescription" name="procedureDescription" required>
								</div>

							</div>

							<div class="form-row">


								<div class="form-group col-md-6">
									<label for="labTestName">Lab Test Name:</label> <input
										type="text" class="form-control" id="labTestName"
										name="labTestName" required>
								</div>

								<div class="form-group col-md-6">
									<label for="labTestResults">Lab Test Results:</label> <input
										class="form-control" id="labTestResults" name="labTestResults"
										required>
								</div>

							</div>

							<div class="form-row">


								<div class="form-group col-md-12">
									<label for="vitalSigns">Vital Signs:</label> <input type="text"
										class="form-control" id="vitalSigns" name="vitalSigns"
										required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="notes">Notes:</label>
									<textarea class="form-control" id="notes" name="notes" rows="3"
										required></textarea>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-12">
									<button type="submit" class="btn btn-primary">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		document.getElementById('dateOfVisit').addEventListener('change',
				function() {
					var inputDate = new Date(this.value);
					var today = new Date();
					if (inputDate > today) {
						this.value = '';
						alert("Visit Date cannot be in the future!");
					}
				});

		document
				.getElementById('startDate')
				.addEventListener(
						'change',
						function() {
							var visitDate = new Date(document
									.getElementById('dateOfVisit').value);
							var startDate = new Date(this.value);
							if (startDate < visitDate) {
								this.value = '';
								alert("Start Date of Medicine cannot be before the Visiting Date!");
							}
						});

		document
				.getElementById('endDate')
				.addEventListener(
						'change',
						function() {
							var startDate = new Date(document
									.getElementById('startDate').value);
							var endDate = new Date(this.value);
							if (endDate < startDate) {
								this.value = '';
								alert("End Date of Medicine cannot be before the Start Date!");
							}
						});
	</script>

</body>
</html>
