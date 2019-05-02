/**
 * 
 */
package learning;
import java.sql.*;
/**
 * @author Amit_triffort
 *
 */
public class Connection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.sql.Connection con = null;		
		Statement stmt;
		String sql_stmt;
		ResultSet rs;
		try {
			Class.forName(ConnectionData.JDBC_DRIVER);
		    con=DriverManager.getConnection(ConnectionData.DB_URL, ConnectionData.USER, ConnectionData.PASS);
		    stmt=con.createStatement();  
		    sql_stmt="Select * from emp_detail";
		    rs=stmt.executeQuery(sql_stmt);
			  if (rs.next() == false) { System.out.println("ResultSet in empty in Java"); }
			  else {
				  while(rs.next())
				  {
					  System.out.println(rs.getString(2)+" "+rs.getString(6));
				  }
			  }
			  
			
		}
		catch(Exception e)
		{
    		System.out.println("Error! "+e.getMessage());

		}
	}
}
