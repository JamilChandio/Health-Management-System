package com.healthmanagementsystem.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.dao.AdminDao;
import com.healthmanagementsystem.dao.DoctorDao;
import com.healthmanagementsystem.dao.PatientDao;
import com.healthmanagementsystem.models.Admin;
import com.healthmanagementsystem.models.Doctor;
import com.healthmanagementsystem.models.Patient;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("person");

		if (person == null)
			response.sendRedirect("login");
		else {
			response.sendRedirect("profile");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String person = request.getParameter("person");

		HttpSession session = request.getSession(false);

		switch (person) {

		case "Admin":
			AdminDao dao = new AdminDao();
			Admin admin = dao.loginAdmin(email, password);

			if (admin != null) {
				admin.setPersonType(person);
				session.setAttribute("person", admin);
				request.changeSessionId();
				response.sendRedirect("profile");
			}

			else {
				response.sendRedirect("login");
			}
			break;

		case "Doctor":
			DoctorDao DocDao = new DoctorDao();
			Doctor doc = DocDao.loginDoctor(email, password);
			if (doc != null) {
				doc.setPersonType(person);
				session.setAttribute("person", doc);
				request.changeSessionId();
				response.sendRedirect("profile");
			} else {
				response.sendRedirect("login");
			}
			break;

		case "Patient":
			PatientDao Pdao = new PatientDao();
			Patient patient = Pdao.loginPatient(email, password);
			if (patient != null) {
				patient.setPersonType(person);
				session.setAttribute("person", patient);
				request.changeSessionId();
				response.sendRedirect("profile");
			} else {
				response.sendRedirect("login");
			}
			break;
		}

	}

}
