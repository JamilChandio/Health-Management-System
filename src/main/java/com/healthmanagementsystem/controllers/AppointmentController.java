package com.healthmanagementsystem.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.AppointmentDao;
import com.healthmanagementsystem.models.Appointment;

/**
 * Servlet implementation class AppointmentController
 */
@WebServlet("/Appointment")
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppointmentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String appointmentFor = request.getParameter("appointmentFor");
		String medicalRecordNo = request.getParameter("medicalRecord");
		String comments = request.getParameter("comments");
		String date = request.getParameter("aptDate");

		Appointment apmt = new Appointment();
		apmt.setAddress(address);
		apmt.setAge(age);
		apmt.setAppointmentFor(appointmentFor);
		apmt.setComments(comments);
		apmt.setEmail(email);
		apmt.setFirstName(firstName);
		apmt.setGender(gender);
		apmt.setLastName(lastName);
		apmt.setMedicalRecordNo(medicalRecordNo);
		apmt.setPhoneNumber(phoneNumber);
		apmt.setAptDate(date);

		AppointmentDao dao = new AppointmentDao();

		if (dao.appointment(apmt))
			response.sendRedirect("appointment");
		else
			response.getWriter().println("<h1> Something went wrong ! </h1>");

	}

}
