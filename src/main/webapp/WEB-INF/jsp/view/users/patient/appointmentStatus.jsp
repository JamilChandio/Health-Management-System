<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Status</title>

<style>
.card-header {
	background-color: black;
	color: white;
	padding: 10px;
}

.card-body {
	padding: 10px;
	background-color: rgba(0, 0, 0, 0.5); /* 50% opacity black */
}
</style>
</head>
<body>
	<main>
		<section>
			<div class="container-sm">
				<c:set var="list" value="${requestScope.aptList }"></c:set>
				<c:choose>
					<c:when test="${not empty list }">
						<c:forEach var="apt" items="${list }">
							<div class="mb-3">
								<div class="card-header">
									<div class="float-right">Appoinment ID: ${apt.getAptID() }</div>
									<h3>
										Status: <span style="color: green">${apt.getStatus() }</span>
									</h3>
								</div>

								<div class="card-body">
									<h5>Doctor: ${apt.getAppointmentFor() }</h5>
									<h5>Date: ${apt.getAptDate() }</h5>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h2>No Appointments</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</section>
	</main>
</body>
</html>
