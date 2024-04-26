<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="com.healthmanagementsystem.dao.PatientDao"%>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<section>
		<main>
			<div class="container-sm">

				<div class="mb-3">
					<a href="AddPatientPage" class="btn btn-primary">Add Patient</a> <a
						href="AddRecordPage" class="btn btn-primary">Add New Record</a>
				</div>

			

				<div class="list-group">
					<c:set var="patients" value="${PatientDao.getAllPatients() }"></c:set>
					<c:forEach var="patient" items="${patients }">
						<div>
							<div
								class="list-group-item d-flex justify-content-between align-items-center">
								<label class="list-group-item-action">${fn:toUpperCase(patient.getUsername())}</label>
								<a href="MedicalRecordPage?id=${patient.getPatientId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;">Medical Record</a> <a
									href="ViewPatient?id=${patient.getPatientId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;">View</a> <a
									href="UpdatePatientPage?id=${patient.getPatientId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;">Update</a> <a
									href="DeletePatient?id=${patient.getPatientId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;" onClick=" return confirmDelete();">Delete</a>
							</div>
							<hr>
						</div>
					</c:forEach>

				</div>
			</div>
		</main>
	</section>



	<script>
		function confirmDelete() {
			return confirm("Are you sure you want to delete this Patient?");
		}
	</script>


</body>
</html>