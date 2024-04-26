<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Record</title>
</head>
<body>
	<c:set var="record"	value="${record}"></c:set>
	<c:if test="${empty record}"><h4>No Record found on this number</h4></c:if>
	
	<c:if test="${not empty record}">
	<section>
		<main>
			<div class="container-sm">
				<table class="table table-dark" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">Record ID</th>
							<th scope="col">${record.getRecordId()}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Patient ID</td>
							<td>${record.getPatientId() }</td>
						</tr>
						<tr>
							
							<td>Prescribing Provider</td>
							<td>${record.getPrescribingProvider() }</td>
						</tr>
						<tr>
							<td>Reason for Visit</td>
							<td>${record.getReasonForVisit() }</td>
						</tr>
						<tr>
							<td>Date of Visit</td>
							<td>${record.getDateOfVisit() }</td>
						</tr>
						<tr>
							<td>Diagnosis Description</td>
							<td>${record.getDiagnosisDesc() }</td>
						</tr>
						<tr>
							<td>Procedure Description</td>
							<td>${record.getProcedureDesc() }</td>
						</tr>
						<tr>
							<td>Medication Name</td>
							<td>${record.getMedicationName() }</td>
						</tr>
						<tr>
							<td>Dosage</td>
							<td>${record.getDosage() }</td>
						</tr>
						<tr>
							<td>Frequency of Medication</td>
							<td>${record.getFrequency() }</td>
						</tr>
						
						<tr>
							<td>Start of Medication</td>
							<td>${record.getStartDate() }</td>
						</tr>
						
						<tr>
							<td>End of Medication</td>
							<td>${record.getEndDate() }</td>
						</tr>
						
						<tr>
							<td>Lab Test</td>
							<td>${record.getLabTestName() }</td>
						</tr>
						
						<tr>
							<td>Lab Test Results</td>
							<td>${record.getLabTestResult() }</td>
						</tr>
						
						<tr>
							<td>Vital Signs</td>
							<td>${record.getVitalSigns() }</td>
						</tr>
						
						<tr>
							<td>Notes</td>
							<td>${record.getNotes() }</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</main>
	</section>
	</c:if>
</body>
</html>
