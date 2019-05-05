package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learning.ConnectionData;
import learning.PasswordUtils;

/**
 * Servlet implementation class LoginPasswordSetup
 */
@WebServlet("/Password")
public class LoginPasswordSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public LoginPasswordSetup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		PrintWriter pr=response.getWriter();
		String username = request.getParameter("username"); 
		String password = request.getParameter("Password"); 
		if((!username.isEmpty() || username!=null )&& (!password.isEmpty() || password!=null))
		{
			
			java.sql.Connection con=null;
			Statement stmt=null; 
			ResultSet rs=null;
			String _Password="";
			try {
				 _Password=PasswordUtils.getCode(password);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try 
			{
				con= ConnectionData.getConnection();
				if(con!=null)
				{
					String sql="select user_name from ecommerce.user_info where user_name='"+username+"' and user_password='"+_Password+"'";    
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						response.sendRedirect("products.html");  

					}
										
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					con.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		else
		{
			String title="Error in data submission!";
			pr.println(
				         "<html>\n" +
				         "<body bgcolor = \"#f0f0f0\">\n" +
				         "<h1 align = \"center\">" + title + "</h1>\n");
		}


	}

}
