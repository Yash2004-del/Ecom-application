package com.controller;

import java.io.IOException;
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
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet
{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		boolean isError = false;
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
		PreparedStatement ptsmt = conn.prepareStatement("UPDATE user1 SET Password = ? WHERE Email = ?");
		ptsmt.setString(1, Password);
		ptsmt.setString(2, Email);
		ptsmt.executeUpdate();
		if(conn!=null)
		{
			System.out.println("Connection Sucessful");
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
			request.setAttribute("Update", "Password Sucessfully Updated");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		
	}
}
