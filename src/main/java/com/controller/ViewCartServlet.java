package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet
{
	public void service(HttpServletRequest request , HttpServletResponse response)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp","root","root");
		PreparedStatement pstmt = conn.prepareStatement("select * from cart3 NATURAL JOIN products1");
		ResultSet rs=  pstmt.executeQuery();
		request.setAttribute("rs", rs);
		RequestDispatcher rd= request.getRequestDispatcher("ViewCart.jsp");
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
