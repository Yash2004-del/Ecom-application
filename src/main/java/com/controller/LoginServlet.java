package com.controller;

import java.io.IOException;
import java.net.ResponseCache;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	public void service( HttpServletRequest request , HttpServletResponse response ) throws IOException , ServletException 
	{
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		boolean success = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
			PreparedStatement ptsmt = conn.prepareStatement("select * from user1  where Email=? and Password = ?");
			ptsmt.setString(1, Email);
			ptsmt.setString(2, Password);
			ResultSet rs =  ptsmt.executeQuery();
			if(rs.next())
			{
				success = true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(success)
		{
			response.sendRedirect("Home.jsp");
		}
		else
		{
			request.setAttribute("Error", "Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}
}
