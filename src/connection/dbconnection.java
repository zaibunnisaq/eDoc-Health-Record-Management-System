package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbconnection 
{
      
      public static Connection getcon()
  	  {
  	    try {
  	        Class.forName("com.mysql.jdbc.Driver");
  	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
  	        Statement stmt = con.createStatement();
  	     
  	        return con;
  	        
  	        //System.out.println("Data has been written to the database.");
  	    } catch (Exception e) 
  	    {
  	    	return null;
  	    }
  	 }
}

