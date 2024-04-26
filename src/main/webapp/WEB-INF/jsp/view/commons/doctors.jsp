<!DOCTYPE html>
<html lang="en">
<head>
<%@page import="com.healthmanagementsystem.dao.DoctorDao"%>
<%@page import="com.healthmanagementsystem.models.Doctor"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/docliststyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
<title>Doctors</title>
</head>
<body>
    <c:set var="doctors" value="${doctors}"></c:set>
    <ul class="doctor-list animate__animated animate__fadeInUp">
        <c:forEach var="doctor" items="${doctors}">
            <li class="doctor-item">
                <img src="images/doctor.png" class="doctor-img" alt="Doctor 1">
                <div class="doctor-info">
                    <h3 class="doctor-name">Dr. ${doctor.getFirst_name()} &nbsp; ${doctor.getLast_name()}</h3>
                    <p class="doctor-intro">${doctor.getDoctorDesc()}</p>
                </div>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
