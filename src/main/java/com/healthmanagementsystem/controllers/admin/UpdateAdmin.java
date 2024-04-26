package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.dao.AdminDao;
import com.healthmanagementsystem.models.Admin;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/updateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("person");

		if (admin != null) {
			String adminId = admin.getAdminId();
			admin.setAddress(request.getParameter("address"));
			admin.setUsername(request.getParameter("username"));
			admin.setNumber(request.getParameter("number"));
			admin.setPassword(request.getParameter("password"));

			AdminDao dao = new AdminDao();
			if (dao.updateAdmin(adminId, admin)) {
				response.sendRedirect("admin");
			} else {
				response.getWriter().println("<h1> Something went wrong...</h1>");
			}
		}

		else {
			response.sendRedirect("login");
		}
	}

}
