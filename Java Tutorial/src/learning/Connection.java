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
		//Statement stmt;
		String sql_stmt;
		//ResultSet rs;
		try {
			Class.forName(ConnectionData.JDBC_DRIVER);
		    con=DriverManager.getConnection(ConnectionData.DB_URL, ConnectionData.USER, ConnectionData.PASS);
		    //stmt=con.createStatement();
		    PreparedStatement stmt=con.prepareStatement("insert into emp_detail values(?,?,?,?,?,?)");  
		    String temp=ConnectionData.generateCode();
		    stmt.setInt(1,3);  
		    stmt.setString(2,"Ashish");  
		    stmt.setString(3,"SE");  
		    stmt.setInt(4,4556);  
		    stmt.setInt(5,21);  
		    stmt.setString(6,temp);  

		    
		    //sql_stmt="Insert into emp_detail values('Amit','SE',8808625500,28,"+ConnectionData.generateCode()+")";
		    int i=stmt.executeUpdate();
		    if(i>0)
		    System.out.println("Databasse is updated...");
		    else
			    System.out.println("Databasse isn't updated...");

		    /*
			 * if (rs.next() == false) { System.out.println("ResultSet in empty in Java"); }
			 * else System.out.println("ResultSet is full...");
			 */
		}
		catch(Exception e)
		{
    		System.out.println("Error! "+e.getMessage());

		}
		
	}

}
