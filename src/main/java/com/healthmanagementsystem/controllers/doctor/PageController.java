package com.healthmanagementsystem.controllers.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.dao.AppointmentDao;
import com.healthmanagementsystem.models.Doctor;

/**
 * Servlet implementation class PageController
 */
@WebServlet("/Doctor")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageController() {
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
			String page = request.getParameter("page");

			if (page.equals("appointments")) {

				Doctor dr = (Doctor) session.getAttribute("person");
				String firstName = dr.getFirst_name();
				String lastName = dr.getLast_name();
				String aptFor = "Dr " + firstName + " " + lastName;
				String date = request.getParameter("date");
				request.setAttribute("aptFor", aptFor);
				if (date == null)
					request.setAttribute("appointmentList", AppointmentDao.appointments(firstName, lastName));
				else
					request.setAttribute("appointmentList", AppointmentDao.appointments(firstName, lastName, date));

				request.getRequestDispatcher("/WEB-INF/jsp/view/users/doctor/appointments.jsp").forward(request,
						response);
			} else
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/doctor/profile.jsp").forward(request, response);
		}
	}

}
