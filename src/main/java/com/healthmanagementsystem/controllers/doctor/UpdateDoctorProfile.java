package com.healthmanagementsystem.controllers.doctor;

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
 * Servlet implementation class UpdateDoctorProfile
 */
@WebServlet("/UpdateDoctorProfile")
public class UpdateDoctorProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDoctorProfile() {
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
		Doctor doctor = (Doctor) session.getAttribute("person");
		doctor.setUsername(request.getParameter("username"));
		doctor.setPassword(request.getParameter("password"));
		doctor.setSpecialization(request.getParameter("specialization"));
		doctor.setDoctorDesc(request.getParameter("description"));
		doctor.setNumber(request.getParameter("number"));
		doctor.setAddress(request.getParameter("address"));

		if (DoctorDao.updateDoctor(doctor))
			request.getRequestDispatcher("WEB-INF/jsp/view/users/doctor/profile.jsp").forward(request, response);
		else
			response.getWriter().println("<h1>Something went wrong!</h1>");
	}

}
