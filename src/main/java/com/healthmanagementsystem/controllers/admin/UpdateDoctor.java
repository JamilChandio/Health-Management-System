package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.dao.DoctorDao;
import com.healthmanagementsystem.models.Doctor;

/**
 * Servlet implementation class UpdateDoctor
 */
@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDoctor() {
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
			Doctor doc = new Doctor();
			doc.setDoctorId(request.getParameter("doctorId"));
			doc.setAddress(request.getParameter("address"));
			doc.setAge(request.getParameter("age"));
			doc.setEmail(request.getParameter("email"));
			doc.setFirst_name(request.getParameter("firstName"));
			doc.setGender(request.getParameter("gender"));
			doc.setLast_name(request.getParameter("lastName"));
			doc.setNumber(request.getParameter("number"));
			doc.setSpecialization(request.getParameter("specialization"));
			doc.setUsername(request.getParameter("username"));
			doc.setPassword(request.getParameter("password"));
			doc.setDoctorDesc(request.getParameter("description"));

			if (DoctorDao.updateDoctor(doc)) {
				request.setAttribute("doctor", doc);
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/viewDoctor.jsp").forward(request, response);
			}

			else
				response.getWriter().println("<h1> Something went wrong</h1>");
		}
	}

}
