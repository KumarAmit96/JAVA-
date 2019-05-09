package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import learning.ConnectionData;
import learning.PasswordUtils;

import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Logins")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String Name = request.getParameter("Name"); 
		String Email = request.getParameter("Email"); 
		String Mobile = request.getParameter("Mobile"); 
		String Password = request.getParameter("Password"); 
		Exception e=(Exception)request.getAttribute("javax.servlet.jsp.jspException");

		if((!Name.isEmpty()|| Name!=null) && (!Email.isEmpty() || Email!=null )&& (!Mobile.isEmpty() || Mobile!=null) && (!Password.isEmpty()|| Password!=null))
		{
			java.sql.Connection con=null;
			PreparedStatement stmt=null; 
			String _Password="";
			try {
				 _Password=PasswordUtils.getCode(Password);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try 
			{
				java.util.Date d=new java.util.Date();
				con= ConnectionData.getConnection();
				if(con!=null)
				{
					String sql="insert into ecommerce.user_info (user_name,user_email,user_mobile,user_password,user_join_date) values (?,?,?,?,?)";    
					stmt=con.prepareStatement(sql);
					stmt.setString(1, Name);
					stmt.setString(2, Email);
					stmt.setString(3, Mobile);
					stmt.setString(4,_Password );
					stmt.setDate(5, new java.sql.Date(d.getTime()));
					int i=stmt.executeUpdate(); 
					if(i>0)
					{
						response.sendRedirect("products.html");  

					}
					else
					{
						response.sendRedirect("ErrorPage.jsp");  

					}
					
				}
				
			}
			catch(Exception ee)
			{
				e.getMessage();
			}
			finally
			{
				try {
					con.close();
					stmt.close();
				} catch (SQLException ee) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else
		{
			String title="Error in data submission!";
			   out.println(
				         "<html>\n" +
				         "<body bgcolor = \"#f0f0f0\">\n" +
				         "<h1 align = \"center\">" + title + "</h1>\n");
		}
	}

}
