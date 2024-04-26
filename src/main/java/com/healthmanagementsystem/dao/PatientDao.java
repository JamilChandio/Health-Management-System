package com.healthmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthmanagementsystem.helper.ConnectionProvider;
import com.healthmanagementsystem.models.Patient;

public class PatientDao {

	public Patient loginPatient(String email, String password) {

		String query = "SELECT * FROM patient WHERE email=? AND password=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				Patient patient = new Patient();
				patient.setAddress(result.getString("address"));
				patient.setDateOfBirth(result.getString("date_of_birth"));
				patient.setEmail(result.getString("email"));
				patient.setFirst_name(result.getString("first_name"));
				patient.setGender(result.getString("gender"));
				patient.setLast_name(result.getString("last_name"));
				patient.setMedicalCondition(result.getString("medical_conditions"));
				patient.setNumber(result.getString("phone_number"));
				patient.setPassword(result.getString("password"));
				patient.setPatientId(result.getString("patient_id"));
				patient.setUsername(result.getString("username"));
				st.close();
				return patient;

			}

			return null;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Patient> getAllPatients() {
		String query = "SELECT * FROM patient";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			List<Patient> patients = new ArrayList<Patient>();
			while (result.next()) {
				Patient patient = new Patient();
				patient.setAddress(result.getString("address"));
				patient.setDateOfBirth(result.getString("date_of_birth"));
				patient.setEmail(result.getString("email"));
				patient.setFirst_name(result.getString("first_name"));
				patient.setGender(result.getString("gender"));
				patient.setLast_name(result.getString("last_name"));
				patient.setMedicalCondition(result.getString("medical_conditions"));
				patient.setNumber(result.getString("phone_number"));
				patient.setPassword(result.getString("password"));
				patient.setPatientId(result.getString("patient_id"));
				patient.setUsername(result.getString("username"));
				patients.add(patient);
			}
			st.close();
			return patients;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static boolean addPatient(Patient patient) {
		String query = "INSERT INTO patient(first_name , last_name" + " , date_of_birth , address , username , email ,"
				+ " gender , medical_conditions  , phone_number ," + " password) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, patient.getFirst_name());
			st.setString(2, patient.getLast_name());
			st.setString(3, patient.getDateOfBirth());
			st.setString(4, patient.getAddress());
			st.setString(5, patient.getUsername());
			st.setString(6, patient.getEmail());
			st.setString(7, patient.getGender());
			st.setString(8, patient.getMedicalCondition());
			st.setString(9, patient.getNumber());
			st.setString(10, patient.getPassword());
			st.executeUpdate();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static Patient getPatient(String id) {
		String query = "SELECT * FROM patient WHERE patient_id=" + id;
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				Patient patient = new Patient();
				patient.setAddress(result.getString("address"));
				patient.setDateOfBirth(result.getString("date_of_birth"));
				patient.setEmail(result.getString("email"));
				patient.setFirst_name(result.getString("first_name"));
				patient.setGender(result.getString("gender"));
				patient.setLast_name(result.getString("last_name"));
				patient.setMedicalCondition(result.getString("medical_conditions"));
				patient.setNumber(result.getString("phone_number"));
				patient.setPassword(result.getString("password"));
				patient.setPatientId(result.getString("patient_id"));
				patient.setUsername(result.getString("username"));
				st.close();
				return patient;
			}
			st.close();
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static boolean deletePatient(String id) {
		String query = "DELETE FROM patient WHERE patient_id=?";

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			st.executeUpdate();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public static boolean updatePatient(Patient patient) {
		String query = "UPDATE patient " + "SET first_name=?" + " , last_name=? , medical_conditions=? , "
				+ " email=? , phone_number=? , address=? , date_of_birth=? "
				+ " , gender=? , username=? ,  password=? WHERE patient_id=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, patient.getFirst_name());
			st.setString(2, patient.getLast_name());
			st.setString(3, patient.getMedicalCondition());
			st.setString(4, patient.getEmail());
			st.setString(5, patient.getNumber());
			st.setString(6, patient.getAddress());
			st.setString(7, patient.getDateOfBirth());
			st.setString(8, patient.getGender());
			st.setString(9, patient.getUsername());
			st.setString(10, patient.getPassword());
			st.setString(11, patient.getPatientId());
			System.out.print("updated");
			st.executeUpdate();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public static boolean update(Patient patient) {
		String query = "UPDATE patient SET" + " medical_conditions=? , " + "   phone_number=? , address=?  "
				+ " ,  username=? ,  password=? WHERE patient_id=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, patient.getMedicalCondition());
			st.setString(2, patient.getNumber());
			st.setString(3, patient.getAddress());
			st.setString(4, patient.getUsername());
			st.setString(5, patient.getPassword());
			st.setString(6, patient.getPatientId());
			st.executeUpdate();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public static List<String> getPatientIds() {
		String query = "SELECT patient_id FROM patient";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			List<String> patientIDs = new ArrayList<String>();
			while (result.next()) {
				patientIDs.add(result.getString("patient_id"));
			}

			st.close();
			return patientIDs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
