package com.healthmanagementsystem.controllers.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.PatientDao;
import com.healthmanagementsystem.models.Patient;

/**
 * Servlet implementation class UpdatePatientProfile
 */
@WebServlet("/UpdatePatientProfile")
public class UpdatePatientProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePatientProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("person") == null)
			response.sendRedirect("login");
		else {
			Patient patient = (Patient) request.getSession().getAttribute("person");
			patient.setAddress(request.getParameter("address"));
			patient.setMedicalCondition(request.getParameter("medicalCondition"));
			patient.setNumber(request.getParameter("number"));
			patient.setPassword(request.getParameter("password"));
			patient.setPatientId(request.getParameter("patientID"));
			patient.setUsername(request.getParameter("username"));

			if (PatientDao.update(patient))
				response.sendRedirect("PatientProfile?page=profile");
			else
				response.getWriter().println("<h1>something went wrong</h1>");
		}
	}

}
