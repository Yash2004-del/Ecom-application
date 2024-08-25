package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dbconnection_practice 
{
	public static void main(String args[])
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecomapp","root","root");
			PreparedStatement ptsmt  = con.prepareStatement("INSERT INTO categories(category_name , description)values(?,?)");
			ptsmt.setString(1, "Electronics");
			ptsmt.setString(2, "All types of electronic items");
			ptsmt.executeUpdate();
			if(con!=null)
			{
				System.out.println("Succesfully connected");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
