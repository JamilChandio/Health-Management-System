package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthmanagementsystem.models.Person;

/**
 * Servlet implementation class AdminPageController
 */
@WebServlet("/admin")
public class AdminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPageController() {
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
		if (person == null) {
			response.sendRedirect("login");
		}

		else {
			String page = request.getParameter("page");
			if (page == null)
				page = "profile";

			switch (page) {
			case "profile":
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/profile.jsp").forward(request, response);
				break;
			case "doctor":
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/doctor.jsp").forward(request, response);
				break;
			case "admin":
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/admin.jsp").forward(request, response);
				break;
			case "patient":
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/patient.jsp").forward(request, response);
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
		doGet(request, response);
	}
}
