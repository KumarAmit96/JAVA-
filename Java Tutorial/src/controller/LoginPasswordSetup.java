package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learning.ConnectionData;

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
		String auth_id =  request.getParameter("auth_id");
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		if((!auth_id.isEmpty()|| auth_id!=null) && (!username.isEmpty() || username!=null )&& (!password.isEmpty() || password!=null))
		{
			
			java.sql.Connection con=null;
			PreparedStatement stmt=null; 
			try 
			{
				con= ConnectionData.getConnection();
				if(con!=null)
				{
					String sql="insert into emp_login (emp_auth_id,emp_auth_password,emp_user_id) values (?,?,?)";    
					stmt=con.prepareStatement(sql);
					stmt.setString(1, auth_id);
					stmt.setString(2, password);
					stmt.setString(3, username);
					int i=stmt.executeUpdate(); 
					if(i>0)
					{
						RequestDispatcher req = request.getRequestDispatcher("RegistrationSuccess.jsp");
						request.setAttribute("name", username);
						req.include(request, response);
					}
					else
					{
						RequestDispatcher req=request.getRequestDispatcher("ErrorPage.jsp");
						req.include(request, response);
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
