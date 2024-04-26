package com.healthmanagementsystem.controllers.patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.AppointmentDao;
import com.healthmanagementsystem.dao.MedicalRecordDao;
import com.healthmanagementsystem.models.Appointment;
import com.healthmanagementsystem.models.MedicalRecord;
import com.healthmanagementsystem.models.Patient;

/**
 * Servlet implementation class PatientProfile
 */
@WebServlet("/PatientProfile")
public class PatientProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientProfile() {
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
		else {
			String page = request.getParameter("page");
			String dispatchTo = "/WEB-INF/jsp/view/users/patient/";
			Patient patient = (Patient) request.getSession().getAttribute("person");

			switch (page) {
			case "medicalRecord":
				MedicalRecordDao dao = new MedicalRecordDao();
				MedicalRecord record = dao.getRecord(patient.getPatientId());
				request.setAttribute("record", record);
				request.getRequestDispatcher(dispatchTo + "medicalRecord.jsp").forward(request, response);
				break;

			case "takeAppointment":
				request.getRequestDispatcher(dispatchTo + "takeAppointment.jsp").forward(request, response);
				break;

			case "appointmentStatus":
				List<Appointment> list = AppointmentDao.appointmentList(patient.getFirst_name(), patient.getLast_name(),
						patient.getEmail());

//				for (Appointment apt : list)
//					System.out.println(apt.getStatus());

				request.setAttribute("aptList", list);
				request.getRequestDispatcher(dispatchTo + "appointmentStatus.jsp").forward(request, response);
				break;

			default:
				request.getRequestDispatcher(dispatchTo + "profile.jsp").forward(request, response);
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
