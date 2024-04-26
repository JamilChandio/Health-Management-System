package com.healthmanagementsystem.models;

public class Patient extends Person {

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", username=" + username + ", medicalCondition=" + medicalCondition
				+ ", password=" + password + ", dateOfBirth=" + dateOfBirth + "]";
	}

	private String patientId;
	private String username;
	private String medicalCondition;
	private String password;
	private String dateOfBirth;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
