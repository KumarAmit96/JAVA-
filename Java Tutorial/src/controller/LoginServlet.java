package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import learning.ConnectionData;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String name = request.getParameter("name"); 
		String designation = request.getParameter("designation"); 
		String age = request.getParameter("age"); 
		String cellphone = request.getParameter("cellphone"); 
		if((!name.isEmpty()|| name!=null) && (!designation.isEmpty() || designation!=null )&& (!age.isEmpty() || age!=null) && (!cellphone.isEmpty()|| cellphone!=null))
		{
			Connection con=null;
			Statement stmt=null;
			try 
			{
				con=ConnectionData.getConnection();
				if(con!=null)
				{
					stmt=con.createStatement();
					String sql="insert into emp_detail values ("+ConnectionData.i+","+name+","+designation+","+age+","+ConnectionData.generateCode()+","+cellphone+","+ConnectionData.getTime()+")";
					int i=stmt.executeUpdate(sql);
					if(i>0)
					{
						RequestDispatcher req = request.getRequestDispatcher("RegistrationSuccess.jsp");
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
			   out.println(
				         "<html>\n" +
				         "<body bgcolor = \"#f0f0f0\">\n" +
				         "<h1 align = \"center\">" + title + "</h1>\n");
		}
	}

}
