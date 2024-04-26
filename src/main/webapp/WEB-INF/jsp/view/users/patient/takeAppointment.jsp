<!DOCTYPE html>
<html>
<head>
<%@ page import="com.healthmanagementsystem.dao.DoctorDao" %>
<meta charset="UTF-8">
<title>Appointment Form</title>
</head>
<body>
	<div class="container-fluid ">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="form-container">
					<h2 class="mb-4">Appointment Form</h2>
					<c:set var="patient" value="${sessionScope.person }"></c:set>

					<form action="TakeAppointment" method="post">
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="firstName">First Name<span class="required"></span></label>
								<input type="text" name="firstName" value="${patient.getFirst_name() }" class="form-control"
									id="firstName" placeholder="First Name" required>
							</div>
							<div class="form-group col-md-6">
								<label for="lastName">Last Name<span class="required"></span></label>
								<input type="text" name="lastName" value="${patient.getLast_name() }"class="form-control"
									id="lastName" placeholder="Last Name" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="age">Age<span class="required"></span></label> <input
									type="number" name="age" value="${patient.getAge() }" class="form-control" id="age"
									placeholder="Age" required>
							</div>
							<div class="form-group col-md-6">
								<label for="gender">Gender<span class="required"></span></label>
								<select class="form-control" name="gender" id="gender" required>
									<option value="${patient.getAge() }">Select</option>
									<option>Male</option>
									<option>Female</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="address">Address<span class="required"></span></label>
							<input type="text" name="address" value="${patient.getAddress() }" class="form-control"
								id="address" placeholder="Address" required>
						</div>
						<div class="form-group">
							<label for="medicalRecord">Medical Record No.(if any)</label> <input
								type="number" name="medicalRecord"  class="form-control"
								id="medicalRecord">
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="doctor">Appointment For Dr.<span
										class="required"></span></label>
								<select class="form-control" name="appointmentFor" id="doctor"
										required>
										<option value="">Select</option>
										<c:set var="doctors" value="${DoctorDao.doctorsList() }"></c:set>
										<c:forEach var="doctor" items="${doctors}">
											<option>${doctor}</option>
											<br>
										</c:forEach>

									</select>
							</div>
							<div class="form-group col-md-6">
								<label for="aptDate">Appointment Date<span class="required"></span></label>
                                <input type="date" required id="aptDate" name="aptDate" class="form-control">
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="mobileNumber">Mobile Number<span
									class="required"></span></label> <input type="tel" value="${patient.getNumber() }" name="phoneNumber"
									class="form-control" id="mobileNumber"
									placeholder="Mobile Number" required>
							</div>
							<div class="form-group col-md-6">
								<label for="email">Email Address<span class="required"></span></label>
								<input type="email" name="email" value="${patient.getEmail() }" class="form-control" id="email"
									placeholder="Email Address" required>
							</div>
						</div>
						<div class="form-group">
							<label for="comment">Comments</label>
							<textarea class="form-control" name="comments" id="comment"
								rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-success">Take
							Appointment</button>
					</form>
				</div>
			</div>
		</div>
	</div>

    <!-- JavaScript to set minimum date for appointment -->
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var currentDate = new Date();
            var tomorrow = new Date(currentDate);
            tomorrow.setDate(tomorrow.getDate() + 2); // Set minimum date to tomorrow
            var formattedDate = tomorrow.toISOString().slice(0, 10);
            document.getElementById("aptDate").min = formattedDate;
            
            
            // Disable Saturdays and Sundays
            document.getElementById("aptDate").addEventListener("change", function() {
                var selectedDate = new Date(this.value);
                if (selectedDate.getDay() === 0 || selectedDate.getDay() === 6) {
                    alert("Please select a date other than Saturday or Sunday");
                    this.value = "";
                }
            });
        });
    </script>
</body>
</html>
