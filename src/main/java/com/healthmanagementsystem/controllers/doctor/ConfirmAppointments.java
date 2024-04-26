package com.healthmanagementsystem.controllers.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.AppointmentDao;

/**
 * Servlet implementation class ConfirmAppointments
 */
@WebServlet("/ConfirmAppointments")
public class ConfirmAppointments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmAppointments() {
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
			String status = request.getParameter("status");
			String aptFor = request.getParameter("aptFor");

			AppointmentDao dao = new AppointmentDao();
			if (dao.confirmAll(status, aptFor))
				request.getRequestDispatcher("/Doctor?page=appointments").forward(request, response);
			else
				response.getWriter().print("<h1>something went wrong </h1>");

		}
	}

}
