package com.healthmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthmanagementsystem.helper.ConnectionProvider;
import com.healthmanagementsystem.models.Admin;

public class AdminDao {

	public Admin loginAdmin(String email, String password) {
		String query = "SELECT * FROM admin WHERE email=? AND password=?";
		try {

			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				Admin admin = new Admin();
				admin.setAdminId(result.getString("admin_id"));
				admin.setFirst_name(result.getString("first_name"));
				admin.setLast_name(result.getString("last_name"));
				admin.setAddress(result.getString("address"));
				admin.setUsername(result.getString("username"));
				admin.setEmail(result.getString("email"));
				admin.setPassword(result.getString("password"));
				admin.setNumber(result.getString("number"));
				admin.setAge(result.getString("age"));
				admin.setGender(result.getString("gender"));
				st.close();
				return admin;
			}
			return null;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean updateAdmin(String username, Admin admin) {
		String query = "UPDATE admin SET username=?, password=?, address=?, number=? WHERE admin_id="
				+ admin.getAdminId();

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
			st.setString(3, admin.getAddress());
			st.setString(4, admin.getNumber());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static List<Admin> getAllAdmins() {
		String query = "SELECT * FROM admin";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			List<Admin> list = new ArrayList<Admin>();
			while (result.next()) {
				Admin admin = new Admin();
				admin.setAdminId(result.getString("admin_id"));
				admin.setFirst_name(result.getString("first_name"));
				admin.setLast_name(result.getString("last_name"));
				admin.setAddress(result.getString("address"));
				admin.setUsername(result.getString("username"));
				admin.setEmail(result.getString("email"));
				admin.setPassword(result.getString("password"));
				admin.setNumber(result.getString("number"));
				admin.setAge(result.getString("age"));
				admin.setGender(result.getString("gender"));
				list.add(admin);
			}
			st.close();
			return list;
		}

		catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	public static Admin getAdmin(String id) {
		String query = "SELECT * FROM admin WHERE admin_id=?";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				Admin admin = new Admin();
				admin.setAdminId(result.getString("admin_id"));
				admin.setFirst_name(result.getString("first_name"));
				admin.setLast_name(result.getString("last_name"));
				admin.setAddress(result.getString("address"));
				admin.setUsername(result.getString("username"));
				admin.setEmail(result.getString("email"));
				admin.setPassword(result.getString("password"));
				admin.setNumber(result.getString("number"));
				admin.setAge(result.getString("age"));
				admin.setGender(result.getString("gender"));

				st.close();
				return admin;
			} else {
				st.close();
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
