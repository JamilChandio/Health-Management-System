package com.healthmanagementsystem.models;

public class Doctor extends Person {

	private String doctorId;
	private String specialization;
	private String username;
	private String password;
	private String doctorDesc;

	public String getDoctorDesc() {
		return doctorDesc;
	}

	public void setDoctorDesc(String doctorDesc) {
		this.doctorDesc = doctorDesc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
