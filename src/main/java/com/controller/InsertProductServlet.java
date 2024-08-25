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

@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet
{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		String ProductName = request.getParameter("ProductName");
		String Price = request.getParameter("Price");
		String Category = request.getParameter("Category");
		String Quantity = request.getParameter("Quantity");
		String ProductImagePath = request.getParameter("ProductImagePath");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost :3306 / ecomapp","root","root");
			PreparedStatement ptsmt = conn.prepareStatement("INSERT INTO products1(product_name,price,category,quantity,productImagePath)values(?,?,?,?,?)");
			ptsmt.setString(1, ProductName);
			ptsmt.setString(2, Price);
			ptsmt.setString(3, Category);
			ptsmt.setString(4, Quantity);
			ptsmt.setString(5, ProductImagePath);
			ptsmt.executeUpdate();
			if(conn!=null)
			{
				System.out.println("Connection Successful");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
