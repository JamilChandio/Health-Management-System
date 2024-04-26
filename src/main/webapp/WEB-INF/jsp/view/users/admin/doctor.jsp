<!DOCTYPE html>
<html>
<head>
<%@page import="com.healthmanagementsystem.dao.DoctorDao"%>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<section>
		<main>
			<div class="container-sm">

				<div class="mb-3">
					<a href="AddDoctorPage" class="btn btn-primary">Add Doctor</a>
				</div>
				
				<div class="list-group">
					<c:set var="doctors" value="${DoctorDao.getAllDoctors() }"></c:set>
					<c:forEach var="doctor" items="${doctors }">
						<div>
							<div
								class="list-group-item d-flex justify-content-between align-items-center">
								<label class="list-group-item-action">${fn:toUpperCase(doctor.getUsername())}</label>
								<a href="viewDoctor?id=${doctor.getDoctorId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;">View</a> <a
									href="UpdateDoctorPage?id=${doctor.getDoctorId()}"
									class="btn btn-secondary view-button"
									style="margin-right: 5px;">Update</a> <a
									href="deleteDoctor?id=${doctor.getDoctorId()}"
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
			return confirm("Are you sure you want to delete this doctor?");
		}
	</script>


</body>
</html>