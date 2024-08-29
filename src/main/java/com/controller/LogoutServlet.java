package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		Cookie c[] = request.getCookies();
		
		
		for(Cookie x:c)
		{
			x.setMaxAge(0);
			response.addCookie(x);
		}
		request.setAttribute("Logout", "You Logged Out Sucessfully");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);

	}
}
