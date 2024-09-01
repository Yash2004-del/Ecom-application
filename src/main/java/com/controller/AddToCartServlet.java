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
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			String ProductId = request.getParameter("productId");
			Integer productId = Integer.parseInt(ProductId);
			System.out.println(productId);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp","root","root");
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cart3(productId,Qty)values(?,?)");
		pstmt.setInt(1, productId);
		pstmt.setInt(2, 1);
		
		pstmt.executeUpdate();
		response.sendRedirect("Product.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
