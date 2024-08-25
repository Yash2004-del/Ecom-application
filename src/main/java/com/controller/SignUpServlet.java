package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet
{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://  localhost:3306 / ecomapp","root","root");
			PreparedStatement ptsmt = con.prepareStatement("INSERT INTO user1(Firstname , Email , Password , Gender , Role)values(?,?,?,?,?)");
			
			String Name = request.getParameter("FirstName");
			String Email = request.getParameter("Email");
			String Password = request.getParameter("Password");
			String Gender = request.getParameter("Gender");
			ptsmt.setString(1, Name);
			ptsmt.setString(2, Email);
			ptsmt.setString(3, Password);
			ptsmt.setString(4, Gender);
			ptsmt.setString(5, "Consumer");
			
			ptsmt.executeUpdate();
			if(con!=null)
			{
				System.out.println("Connection Sucessful");
			}
			response.sendRedirect("Login.jsp");
			
	

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
