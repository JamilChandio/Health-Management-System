package com.healthmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthmanagementsystem.helper.ConnectionProvider;
import com.healthmanagementsystem.models.Appointment;

public class AppointmentDao {

	public boolean appointment(Appointment apmt) {
		String query = "INSERT INTO appointment(first_name,last_name,email,age,gender,address,medical_record,number,comments,appointment_for, appointment_on)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, apmt.getFirstName());
			st.setString(2, apmt.getLastName());
			st.setString(3, apmt.getEmail());
			st.setString(4, apmt.getAge());
			st.setString(5, apmt.getGender());
			st.setString(6, apmt.getAddress());
			st.setString(7, apmt.getMedicalRecordNo());
			st.setString(8, apmt.getPhoneNumber());
			st.setString(9, apmt.getComments());
			st.setString(10, apmt.getAppointmentFor());
			st.setString(11, apmt.getAptDate());
			st.execute();
			st.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static List<Appointment> appointments(String firstName, String lastName, String date) {
		try {
			String query = "SELECT * FROM appointment where appointment_for=? AND appointment_on=?";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, "Dr " + firstName + " " + lastName);
			st.setString(2, date);
			ResultSet result = st.executeQuery();
			List<Appointment> list = new ArrayList<>();
			while (result.next()) {
				Appointment apt = new Appointment();
				apt.setAddress(result.getString("address"));
				apt.setFirstName(result.getString("first_name"));
				apt.setLastName(result.getString("last_name"));
				apt.setPhoneNumber(result.getString("number"));
				apt.setComments(result.getString("comments"));
				apt.setAppointmentFor(result.getString("appointment_for"));
				apt.setAge(result.getString("age"));
				apt.setMedicalRecordNo(result.getString("medical_record"));
				apt.setGender(result.getString("gender"));
				apt.setEmail(result.getString("email"));
				apt.setStatus(result.getString("status"));
				apt.setAptID(result.getString("appointment_id"));
				apt.setAptDate(result.getString("appointment_on"));

				list.add(apt);
			}
			st.close();
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Appointment> appointments(String firstName, String lastName) {
		try {
			String query = "SELECT * FROM appointment where appointment_for=?";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, "Dr " + firstName + " " + lastName);
			ResultSet result = st.executeQuery();
			List<Appointment> list = new ArrayList<>();
			while (result.next()) {
				Appointment apt = new Appointment();
				apt.setAddress(result.getString("address"));
				apt.setFirstName(result.getString("first_name"));
				apt.setLastName(result.getString("last_name"));
				apt.setPhoneNumber(result.getString("number"));
				apt.setComments(result.getString("comments"));
				apt.setAppointmentFor(result.getString("appointment_for"));
				apt.setAge(result.getString("age"));
				apt.setMedicalRecordNo(result.getString("medical_record"));
				apt.setGender(result.getString("gender"));
				apt.setEmail(result.getString("email"));
				apt.setStatus(result.getString("status"));
				apt.setAptID(result.getString("appointment_id"));
				apt.setAptDate(result.getString("appointment_on"));

				list.add(apt);
			}
			st.close();
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Appointment> appointmentList(String firstName, String lastName, String email) {
		try {
			String query = "SELECT * FROM appointment where first_name=? AND last_name=? AND email=?";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, firstName);
			st.setString(2, lastName);
			st.setString(3, email);
			ResultSet result = st.executeQuery();
			List<Appointment> list = new ArrayList<>();
			while (result.next()) {
				Appointment apt = new Appointment();
				apt.setAddress(result.getString("address"));
				apt.setFirstName(result.getString("first_name"));
				apt.setLastName(result.getString("last_name"));
				apt.setPhoneNumber(result.getString("number"));
				apt.setComments(result.getString("comments"));
				apt.setAppointmentFor(result.getString("appointment_for"));
				apt.setAge(result.getString("age"));
				apt.setMedicalRecordNo(result.getString("medical_record"));
				apt.setGender(result.getString("gender"));
				apt.setEmail(result.getString("email"));
				apt.setStatus(result.getString("status"));
				apt.setAptID(result.getString("appointment_id"));
				apt.setAptDate(result.getString("appointment_on"));
				list.add(apt);
			}
			st.close();
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean confirmAll(String status, String aptFor) {
		try {
			String query = "UPDATE appointment SET status=? WHERE appointment_for=?";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, status);
			st.setString(2, aptFor);
			st.executeUpdate();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean confirmApt(String id, String status) {
		try {
			String query = "UPDATE appointment SET status=? WHERE appointment_id=?";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, status);
			st.setString(2, id);
			st.executeUpdate();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
