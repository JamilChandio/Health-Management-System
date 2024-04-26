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
 * Servlet Filter implementation class AddFilter
 */
@WebFilter(urlPatterns = { "/AddDoctor", "/AddPatient" })
public class AddFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public AddFilter() {
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
		String username = req.getParameter("username");
		String number = req.getParameter("number");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (!validateName(firstName) || !validateName(lastName)) {
			handleError(response,
					"PLEASE ENTER VALID FIRST NAME OR LAST NAME, DO NOT USE ANY SPECIAL CHARACTERS AND SPACES!");
			return;
		}

		if (!validateEmail(email)) {
			handleError(response, "PLEASE ENTER VALID EMAIL ADDRESS (e.g. someone123@example.com)!");
			return;
		}

		if (!validateUsername(username)) {
			handleError(response, "Please enter valid username, do not use any special characrer or space!");
			return;
		}

		if (!validatePassword(password)) {
			handleError(response, "Please enter valid password: length should be 5-10 characters");
			return;
		}
		if (!validateNumber(number)) {
			handleError(response, "Please enter valid number (e.g.03012345678)");
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

	private static boolean validateNumber(String number) {
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

	private static boolean validatePassword(String password) {
		if (!(password.length() >= 5 && password.length() <= 10))
			return false;
		String disallowedChars = " '\"\\/;,.<>?[]{}()&%$#!~-=_+|*^";
		for (char c : password.toCharArray()) {
			if (disallowedChars.contains(Character.toString(c))) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateUsername(String username) {
		if (username.length() < 3)
			return false;

		for (char c : username.toCharArray()) {
			if (!(Character.isLetterOrDigit(c)))
				return false;
		}
		return true;
	}

	private static void handleError(ServletResponse response, String errorMessage) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('" + errorMessage + "');");
		out.println("history.back();");
		out.println("</script>");
	}

}
