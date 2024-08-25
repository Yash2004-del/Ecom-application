package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
			PreparedStatement pstmt = conn.prepareStatement("delete from user1 where user_id = ?");
			String UserId = request.getParameter("userid");
			Integer User = Integer.parseInt(UserId);
		
			pstmt.setInt(1,User);
			pstmt.executeUpdate();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
