<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor</title>
</head>
<body>
	<section>
		<main>
			<div class="container-sm">
				<div class="mb-3">
					<a
						href="ConfirmAppointments?status=confirmed&aptFor=${requestScope.aptFor}"
						class="btn btn-success">Confirm All</a> <a
						href="ConfirmAppointments?status=cancelled&aptFor=${requestScope.aptFor }"
						class="btn btn-danger">Cancel All</a>
					<div class="float-right">
						<input type="date" id="aptOn" name="aptOn"
							onchange="filterAppointments()">
					</div>
				</div>
				<div>
					<c:set var="appointmentList"
						value="${requestScope.appointmentList}"></c:set>

					<c:choose>
						<c:when test="${not empty appointmentList}">
							<c:forEach var="apt" items="${appointmentList}">
								<div class="card mb-3">
									<div class="card-header">
										<div class="float-right">Medical Record:
											${apt.getMedicalRecordNo() }</div>
										<h3>${apt.getFirstName() }&nbsp;${apt.getLastName() }</h3>
										<p>
											Appointment for: ${apt.getAppointmentFor() } <br>
											Status: ${apt.getStatus() } <br> On: ${apt.getAptDate() }
										</p>

									</div>
									<div class="card-body">

										<h6>${apt.getComments() }</h6>
										<br>
										<p>
											${apt.getAddress() } <br> ${apt.getPhoneNumber() } <br>
											${apt.getEmail() }
										</p>
										<div class="float-right">
											<a
												href="ConfirmAppointment?status=confirmed&id=${apt.getAptID() }"
												class="btn btn-success">Confirm</a> <a
												href="ConfirmAppointment?status=cancelled&id=${apt.getAptID() }"
												class="btn btn-danger">Cancel</a>
										</div>
									</div>

								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h1>No appointments</h1>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</main>
	</section>

	<!-- JavaScript to filter appointments based on date -->
	<script>
		function filterAppointments() {
			var selectedDate = document.getElementById("aptOn").value;
			window.location.href = "Doctor?page=appointments&date="
					+ selectedDate;
		}
	</script>
</body>
</html>
