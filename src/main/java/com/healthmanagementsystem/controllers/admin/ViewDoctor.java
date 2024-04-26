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
 * Servlet implementation class ViewDoctor
 */
@WebServlet("/viewDoctor")
public class ViewDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewDoctor() {
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
		if (session.getAttribute("person") == null)
			response.sendRedirect("login");
		else {
			String id = request.getParameter("id");
			Doctor doc = DoctorDao.getDoctor(id);
			request.setAttribute("doctor", doc);
			request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/viewDoctor.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
