package com.org.asm2.controller;

import java.io.IOException;

import com.org.asm2.model.UserSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignInController
 */
@WebServlet({ "/sign-in" })
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN = "admin";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sign-in.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (ADMIN.equalsIgnoreCase(username) && ADMIN.equalsIgnoreCase(password)) {
			UserSession userSession = new UserSession(ADMIN, ADMIN);
			request.getSession().setAttribute("user", userSession);
			request.getRequestDispatcher("/doctor").forward(request, response);
		} else {
			System.out.println("User not found: " + username);
			request.setAttribute("message", "Invalid username or password");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/sign-in.jsp");
			dispatcher.forward(request, response);
		}
	}

}
