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

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet 
{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException 
	{
		try 
		{
			String category = request.getParameter("Option");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
			PreparedStatement ptsmt = conn.prepareStatement("select * from products1 where category = ?");
			ptsmt.setString(1, category);
			ResultSet rs =  ptsmt.executeQuery();
			request.setAttribute("rs", rs);
			RequestDispatcher rd = request.getRequestDispatcher("ListProduct.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
