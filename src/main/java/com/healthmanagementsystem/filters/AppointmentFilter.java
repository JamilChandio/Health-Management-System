package com.healthmanagementsystem.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AppointmentFilter
 */
@WebFilter(urlPatterns = { "/Appointment", "/TakeAppointment" })
public class AppointmentFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public AppointmentFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String medicalRecordNo = req.getParameter("medicalRecord");
		String number = req.getParameter("phoneNumber");
		String email = req.getParameter("email");

		if (!validateName(firstName) || !validateName(lastName)) {
			handleError(response,
					"PLEASE ENTER VALID FIRST NAME OR LAST NAME, DO NOT USE ANY SPECIAL CHARACTERS AND SPACES!");
			return;
		}
		if (age < 1) {
			handleError(response, "AGE CANNOT BE LESS THAN 1!");
			return;
		}
		if (address.length() < 3) {
			handleError(response, "PLEASE ENTER THE VALID ADDRESS!");
			return;
		}
		if (medicalRecordNo != null && !medicalRecordNo.isEmpty()) {
			if (Integer.parseInt(medicalRecordNo) < 1) {
				handleError(response, "PLEASE ENTER VALID MEDICAL RECORD NUMBER (IF ANY)!");
				return;
			}
		}
		if (!validateNumber(number)) {
			handleError(response, "PLEASE ENTER VALID NUMBER (e.g. 03012345678)!");
			return;
		}
		if (!validateEmail(email)) {
			handleError(response, "PLEASE ENTER VALID EMAIL ADDRESS (e.g. someone123@example.com)!");
			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private static boolean validateName(String name) {
		if (name.length() < 3)
			return false;

		boolean flag = false;
		for (int i = 0; i < name.length(); i++) {
			if ((int) name.charAt(i) >= 65 && (int) name.charAt(i) <= 90)
				flag = true;
			else if ((int) name.charAt(i) >= 97 && (int) name.charAt(i) <= 122)
				flag = true;
			else
				return false;
		}
		return flag;
	}

	private boolean validateNumber(String number) {
		if (number.length() != 11)
			return false;
		for (char c : number.toCharArray()) {
			if (!(Character.isDigit(c)))
				return false;
		}
		return true;
	}

	private static boolean validateEmail(String email) {
		String dotComPart = email.substring(email.length() - 4, email.length());
		int indexOfChar = email.indexOf('@');

		if (!dotComPart.equals(".com"))
			return false;

		if (email.charAt(0) < 97 || email.charAt(0) > 122)
			return false;

		for (int i = 1; i < indexOfChar; i++) {
			char c = email.charAt(i);

			if ((int) c < 97 || (int) c > 122) {
				if ((int) c < 48 || (int) c > 57)
					return false;
			}
		}

		for (int i = indexOfChar + 1; i < email.length() - 4; i++) {
			char c = email.charAt(i);
			if ((int) c < 97 || (int) c > 122)
				return false;
		}
		return true;
	}

	private void handleError(ServletResponse response, String errorMessage) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('" + errorMessage + "');");
		out.println("history.back();");
		out.println("</script>");
	}

}
