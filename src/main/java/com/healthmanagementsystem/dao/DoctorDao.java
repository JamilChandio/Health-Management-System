package com.healthmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthmanagementsystem.helper.ConnectionProvider;
import com.healthmanagementsystem.models.Doctor;

public class DoctorDao {

	public Doctor loginDoctor(String email, String password) {

		String query = "SELECT * FROM doctor WHERE email=? AND password=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				Doctor doc = new Doctor();
				doc.setAddress(result.getString("address"));
				doc.setAge(result.getString("age"));
				doc.setEmail(result.getString("email"));
				doc.setDoctorId(result.getString("doctor_id"));
				doc.setFirst_name(result.getString("first_name"));
				doc.setGender(result.getString("gender"));
				doc.setLast_name(result.getString("last_name"));
				doc.setNumber(result.getString("phone_number"));
				doc.setSpecialization(result.getString("specialization"));
				doc.setUsername(result.getString("username"));
				doc.setPassword(result.getString("password"));
				doc.setDoctorDesc(result.getString("description"));
				st.close();
				return doc;
			}

			return null;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<String> doctorsList() {
		String query = "SELECT first_name , last_name FROM doctor;";
		List<String> list = new ArrayList<String>();
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();

			while (result.next()) {
				list.add("Dr " + result.getString("first_name") + " " + result.getString("last_name"));
			}

			return list;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Doctor> getAllDoctors() {
		List<Doctor> list = new ArrayList<Doctor>();
		String query = "SELECT * FROM doctor";

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while (result.next()) {
				Doctor doc = new Doctor();
				doc.setAddress(result.getString("address"));
				doc.setAge(result.getString("age"));
				doc.setEmail(result.getString("email"));
				doc.setDoctorId(result.getString("doctor_id"));
				doc.setFirst_name(result.getString("first_name"));
				doc.setGender(result.getString("gender"));
				doc.setLast_name(result.getString("last_name"));
				doc.setNumber(result.getString("phone_number"));
				doc.setSpecialization(result.getString("specialization"));
				doc.setUsername(result.getString("username"));
				doc.setPassword(result.getString("password"));
				doc.setDoctorDesc(result.getString("description"));
				list.add(doc);
			}
			st.close();
			return list;
		}

		catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	public static Doctor getDoctor(String id) {
		String query = "SELECT * FROM doctor WHERE doctor_id=" + id;
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				Doctor doc = new Doctor();
				doc.setAddress(result.getString("address"));
				doc.setAge(result.getString("age"));
				doc.setEmail(result.getString("email"));
				doc.setDoctorId(result.getString("doctor_id"));
				doc.setFirst_name(result.getString("first_name"));
				doc.setGender(result.getString("gender"));
				doc.setLast_name(result.getString("last_name"));
				doc.setNumber(result.getString("phone_number"));
				doc.setSpecialization(result.getString("specialization"));
				doc.setUsername(result.getString("username"));
				doc.setPassword(result.getString("password"));
				doc.setDoctorDesc(result.getString("description"));
				st.close();
				return doc;
			}
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	public static boolean deleteDoctor(String id) {
		String query = "DELETE FROM doctor WHERE doctor_id=" + id;

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public static boolean updateDoctor(Doctor doc) {
		String query = "UPDATE doctor " + "SET first_name=?" + " , last_name=? , specialization=? , "
				+ " email=? , phone_number=? , address=? , age=? "
				+ " , gender=? , username=? ,  password=? WHERE doctor_id=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, doc.getFirst_name());
			st.setString(2, doc.getLast_name());
			st.setString(3, doc.getSpecialization());
			st.setString(4, doc.getEmail());
			st.setString(5, doc.getNumber());
			st.setString(6, doc.getAddress());
			st.setString(7, doc.getAge());
			st.setString(8, doc.getGender());
			st.setString(9, doc.getUsername());
			st.setString(10, doc.getPassword());
			st.setString(11, doc.getDoctorId());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public static boolean addDoctor(Doctor doctor) {
		String query = "INSERT INTO doctor(first_name , last_name , "
				+ "specialization , email , phone_number , address"
				+ " , age , gender , username , password , description) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, doctor.getFirst_name());
			st.setString(2, doctor.getLast_name());
			st.setString(3, doctor.getSpecialization());
			st.setString(4, doctor.getEmail());
			st.setString(5, doctor.getNumber());
			st.setString(6, doctor.getAddress());
			st.setString(7, doctor.getAge());
			st.setString(8, doctor.getGender());
			st.setString(9, doctor.getUsername());
			st.setString(10, doctor.getPassword());
			st.setString(11, doctor.getDoctorDesc());
			st.execute();
			st.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
