package com.healthmanagementsystem.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.models.Person;

/**
 * Servlet implementation class RedirectController
 */
@WebServlet("/profile")
public class RedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		if (person == null)
			response.sendRedirect("login");

		else {
			switch (person.getPersonType()) {
			case "Admin":
				forwardToAdminProfilePage(request, response);
				break;
			case "Doctor":
				forwardToDoctorProfilePage(request, response);
				break;
			case "Patient":
				forwardToPatientProfilePage(request, response);
				break;

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		if (person == null)
			response.sendRedirect("login");
		else {
			switch (person.getPersonType()) {
			case "Admin":
				forwardToAdminProfilePage(request, response);
				break;
			case "Doctor":
				forwardToDoctorProfilePage(request, response);
				break;
			case "Patient":
				forwardToPatientProfilePage(request, response);
				break;
			}
		}
	}

	private void forwardToAdminProfilePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/admin.jsp").forward(request, response);
	}

	private void forwardToDoctorProfilePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/view/users/doctor/profile.jsp").forward(request, response);
	}

	private void forwardToPatientProfilePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/view/users/patient/profile.jsp").forward(request, response);
	}

}
