package connection;
import java.sql.*;

import javax.swing.JOptionPane;

public class tables 
{
	
	public static int insertData(String query, String msg)
	{
       Connection con = null;
       Statement st = null;
       try {
    	   con = dbconnection.getcon();  // will give connection 
       
    	   st = con.createStatement();
    	   st.executeUpdate(query);
    	   
    	   if(!msg.equals(""))
    	   {
    		   //JOptionPane.showMessageDialog(null, msg);
    		   return 1;
    	   }
    	   else
    	   {
    		  // JOptionPane.showMessageDialog(null, "Insertion unsucessful");
    		   return -1;
    	   }
       
       }
       catch(Exception e)
       {
    	   JOptionPane.showMessageDialog(null, e);
    	   return -1;
       }
       finally {
    	   try 
    	   {
    		   con.close();
        	   st.close();
    	   }
    	   catch(Exception e)
    	   {
    		   
    	   }
       }
       
	}
	// ResultSet rs = stmt.executeQuery(sql);
	
	
	public static int selectdata(String query, String msg)       // selecting data 
	{
       Connection con = null;
       Statement st = null;
       try {
    	   con = dbconnection.getcon();  // will give connection 
       
    	   st = con.createStatement();
    	   ResultSet rs = st.executeQuery(query);
    	   
    	   if(rs.next())
    	   {
    		   //JOptionPane.showMessageDialog(null, msg);
    		   
    		   return 1;   // login sucessfullly 
    	   }
    	   else
    	   {
    		   //JOptionPane.showMessageDialog(null, "Login not successful");
    		   return -1;
    	   }
       
       }
       catch(Exception e)
       {
    	   JOptionPane.showMessageDialog(null, e);
    	   return -1;
       }
       finally {
    	   try 
    	   {
    		   con.close();
        	   st.close();
    	   }
    	   catch(Exception e)
    	   {
    		   
    	   }
       }
       
	}

}
