package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/SignUpServlet")
public class ValidationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String FirstName = request.getParameter("FirstName");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String Gender = request.getParameter("Gender");
		String RegEx = "[a-zA-Z\\sa-zA-Z]+";
		String ERegEx = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z0-9]{2,3}";
		String PRegEx = "[a-zA-Z]+@[0-9]{4}";
		boolean isError = false;
		if(FirstName == null || FirstName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("NError", "Please Enter Name");
		}
		else if(FirstName.matches(RegEx)==false)
		{
			isError = true;
			request.setAttribute("NError", "Please Enter Valid Name");		
		}
		if(Email == null || Email.trim().length()==0)
		{
			isError = true;
			request.setAttribute("EError", "Please Enter Email");
		}
		else if(Email.matches(ERegEx)==false)
		{
			isError = true;
			request.setAttribute("EError", "Please Enter Valid Email");
		}
		if(Password == null || Password.trim().length()==0 )
		{
			isError = true;
			request.setAttribute("PError", "Please Enter Password");
		}
		else if(Password.length()>8)
		{
			isError = true;
			request.setAttribute("PError", "Please Enter Valid Password");
		}
		else if(Password.matches(PRegEx)==false)
		{
			isError = true;
			request.setAttribute("PError", "Please Enter Strong Password");
		}
		if(Gender == null)
		{
			isError = true;
			request.setAttribute("GError", "Please Select Gender");
		}
		if(isError == true)
		{
			System.out.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Sucess");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
