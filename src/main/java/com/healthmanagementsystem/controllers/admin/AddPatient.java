package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.PatientDao;
import com.healthmanagementsystem.models.Patient;

/**
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPatient() {
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
			Patient patient = new Patient();
			patient.setAddress(request.getParameter("address"));
			patient.setAge(request.getParameter("age"));
			patient.setDateOfBirth(request.getParameter("dateOfBirth"));
			patient.setEmail(request.getParameter("email"));
			patient.setFirst_name(request.getParameter("firstName"));
			patient.setGender(request.getParameter("gender"));
			patient.setLast_name(request.getParameter("lastName"));
			patient.setMedicalCondition(request.getParameter("medicalCondition"));
			patient.setNumber(request.getParameter("number"));
			patient.setPassword(request.getParameter("password"));
			patient.setUsername(request.getParameter("username"));

			if (PatientDao.addPatient(patient))
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/patient.jsp").forward(request, response);
			else
				response.getWriter().println("<h1> Something went wrong </h1>");
		}
	}

}
