package com.healthmanagementsystem.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con;
	private static final String URL = "url here";
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	public static Connection getConnection() {

		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				return con;
			}
			return con;
		}

		catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
}
