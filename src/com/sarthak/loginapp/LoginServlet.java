package com.sarthak.loginapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarthak.loginapp.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID, password;
		userID = request.getParameter("userID");
		password = request.getParameter("password");
		
		LoginService loginservice = new LoginService();
		boolean result = loginservice.authenticate(userID, password);
		if (result) {
			response.sendRedirect("Success.jsp");
			return;
			
		}
		
		else {
			response.sendRedirect("Login.jsp");
			return;
		}
	
	}

}
