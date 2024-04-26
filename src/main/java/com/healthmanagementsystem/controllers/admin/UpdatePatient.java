package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.dao.PatientDao;
import com.healthmanagementsystem.models.Patient;

/**
 * Servlet implementation class UpdatePatient
 */
@WebServlet("/UpdatePatient")
public class UpdatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePatient() {
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

		HttpSession session = request.getSession();

		if (session.getAttribute("person") == null)
			response.sendRedirect("login");

		else {
			Patient patient = new Patient();
			patient.setPatientId(request.getParameter("patientId"));
			patient.setAddress(request.getParameter("address"));
			patient.setDateOfBirth(request.getParameter("dateOfBirth"));
			patient.setEmail(request.getParameter("email"));
			patient.setFirst_name(request.getParameter("firstName"));
			patient.setGender(request.getParameter("gender"));
			patient.setLast_name(request.getParameter("lastName"));
			patient.setNumber(request.getParameter("number"));
			patient.setMedicalCondition(request.getParameter("medicalCondition"));
			patient.setUsername(request.getParameter("username"));
			patient.setPassword(request.getParameter("password"));

			if (PatientDao.updatePatient(patient)) {
				request.setAttribute("patient", patient);
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/viewPatient.jsp").forward(request,
						response);
			}

			else
				response.getWriter().println("<h1> Something went wrong</h1>");
		}
	}

}
