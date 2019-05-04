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
@WebServlet("/Logins")
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
			java.sql.Connection con=null;
			PreparedStatement stmt=null; 
			String auth_id=ConnectionData.generateCode();
			try 
			{
				java.util.Date d=new java.util.Date();
				con= ConnectionData.getConnection();
				if(con!=null)
				{
					String sql="insert into emp_detail (emp_id,emp_name,emp_designation,emp_age,emp_auth_id,emp_cell,emp_join) values (?,?,?,?,?,?,?)";    
					stmt=con.prepareStatement(sql);
					stmt.setInt(1, ConnectionData.a);
					stmt.setString(2, name);
					stmt.setString(3, designation);
					stmt.setInt(4,Integer.parseInt(age));
					stmt.setString(5,auth_id );
					stmt.setString(6, cellphone);
					stmt.setDate(7, new java.sql.Date(d.getTime()));
					int i=stmt.executeUpdate(); 
					if(i>0)
					{
						RequestDispatcher req = request.getRequestDispatcher("LoginUser.jsp");
						request.setAttribute("auth_id",auth_id);
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
