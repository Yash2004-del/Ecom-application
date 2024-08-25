package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Dbconnection 
{
	static void addUser()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con = 	DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO users4(first_name , email, password , gender , role)values(?,?,?,?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter NAME EMAIL PASSWORD GENDER");
		String name = sc.next();
		String email = sc.next();
		String password = sc.next();
		String gender = sc.next();
		
		
		pstmt.setString(1,name);
		pstmt.setString(2,email);
		pstmt.setString(3,password);
		pstmt.setString(4,gender);
		pstmt.setString(5,"Customer");
		
		pstmt.executeUpdate();
			if(con!=null)
			{
				System.out.println("Sucessful connection");
			}
			
			
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	public static void main(String args[])
	{
		Dbconnection.addUser();
	}
		

}
