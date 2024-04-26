package com.healthmanagementsystem.controllers.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.AppointmentDao;

/**
 * Servlet implementation class ConfirmAppointment
 */
@WebServlet("/ConfirmAppointment")
public class ConfirmAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("person") == null)
			response.sendRedirect("login");

		else {
			String status = request.getParameter("status");
			String id = request.getParameter("id");
			AppointmentDao dao = new AppointmentDao();
			if (dao.confirmApt(id, status))
				request.getRequestDispatcher("/Doctor?page=appointments").forward(request, response);
			else
				response.getWriter().print("<h1>Something went wrong </h1>");
		}
	}

}
