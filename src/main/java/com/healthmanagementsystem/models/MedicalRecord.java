package com.healthmanagementsystem.models;

public class MedicalRecord {
	private String recordId;
	private String patientId;
	private String dateOfVisit;
	private String reasonForVisit;
	private String diagnosisDesc;
	private String procedureDesc;
	private String medicationName;
	private String dosage;
	private String frequency;
	private String startDate;
	private String endDate;
	private String prescribingProvider;
	private String prescribingProviderId;

	public String getPrescribingProviderId() {
		return prescribingProviderId;
	}

	public void setPrescribingProviderId(String prescribingProviderId) {
		this.prescribingProviderId = prescribingProviderId;
	}

	private String labTestName;
	private String labTestResult;
	private String vitalSigns;
	private String notes;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getDiagnosisDesc() {
		return diagnosisDesc;
	}

	public void setDiagnosisDesc(String diagnosisDesc) {
		this.diagnosisDesc = diagnosisDesc;
	}

	public String getProcedureDesc() {
		return procedureDesc;
	}

	public void setProcedureDesc(String procedureDesc) {
		this.procedureDesc = procedureDesc;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrescribingProvider() {
		return prescribingProvider;
	}

	public void setPrescribingProvider(String prescribingProvider) {
		this.prescribingProvider = prescribingProvider;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}

	public String getLabTestResult() {
		return labTestResult;
	}

	public void setLabTestResult(String labTestResult) {
		this.labTestResult = labTestResult;
	}

	public String getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(String vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
