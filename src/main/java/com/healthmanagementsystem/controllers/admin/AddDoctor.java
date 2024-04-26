package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.DoctorDao;
import com.healthmanagementsystem.models.Doctor;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("person") == null)
			response.sendRedirect("login");
		else
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

			Doctor doctor = new Doctor();

			doctor.setAddress(request.getParameter("address"));
			doctor.setAge(request.getParameter("age"));
			doctor.setEmail(request.getParameter("email"));
			doctor.setFirst_name(request.getParameter("firstName"));
			doctor.setGender(request.getParameter("gender"));
			doctor.setLast_name(request.getParameter("lastName"));
			doctor.setNumber(request.getParameter("number"));
			doctor.setPassword(request.getParameter("password"));
			doctor.setSpecialization(request.getParameter("specialization"));
			doctor.setUsername(request.getParameter("username"));

			if (DoctorDao.addDoctor(doctor)) {
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/doctor.jsp").forward(request, response);
			}

			else {
				response.getWriter().println("<h1> Something went wrong </h1>");
			}

		}
	}

}
