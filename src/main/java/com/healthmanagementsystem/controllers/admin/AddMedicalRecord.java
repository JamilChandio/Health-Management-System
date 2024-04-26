package com.healthmanagementsystem.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthmanagementsystem.dao.MedicalRecordDao;
import com.healthmanagementsystem.models.MedicalRecord;

/**
 * Servlet implementation class AddMedicalRecord
 */
@WebServlet("/AddMedicalRecord")
public class AddMedicalRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMedicalRecord() {
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
			MedicalRecord record = new MedicalRecord();
			record.setDateOfVisit(request.getParameter("dateOfVisit"));
			record.setDiagnosisDesc(request.getParameter("diagnosisDescription"));
			record.setDosage(request.getParameter("dosage"));
			record.setEndDate(request.getParameter("endDate"));
			record.setFrequency(request.getParameter("frequency"));
			record.setLabTestName(request.getParameter("labTestName"));
			record.setLabTestResult(request.getParameter("labTestResults"));
			record.setMedicationName(request.getParameter("medicationName"));
			record.setNotes(request.getParameter("notes"));
			record.setPatientId(request.getParameter("patientId"));
			record.setPrescribingProviderId(request.getParameter("prescribingProviderId"));
			record.setPrescribingProvider(request.getParameter("prescribingProvider"));
			record.setProcedureDesc(request.getParameter("procedureDescription"));
			record.setReasonForVisit(request.getParameter("reasonForVisit"));
			record.setStartDate(request.getParameter("startDate"));
			record.setVitalSigns(request.getParameter("vitalSigns"));

			MedicalRecordDao dao = new MedicalRecordDao();

			if (dao.addRecord(record))
				request.getRequestDispatcher("/WEB-INF/jsp/view/users/admin/patient.jsp").forward(request, response);
			else
				response.getWriter().println("<h1> Something went wrong</h1>");
		}
	}

}
