package Group24.Trello;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.*;  
public class MysqlCon{
	/*public static void DbConnect(){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false","root","trello");  
			//here trello1 is database name, root is username and password  
			Statement stmt=con.createStatement(); 
		
			boolean reachable = con.isValid(10);
			
			if (reachable)
			System.out.println("Welecome to Trello!");
			  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	} */
	


	    public Connection EstCon() {
	            String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	            String dbName = "trello1";//databese name
	            String driver = "com.mysql.cj.jdbc.Driver";
	            String userName = "root";
	            String password = "trello";// password
	        Connection conn=null;
	        try {
	            Class.forName(driver).newInstance();
	            conn = DriverManager.getConnection(url, userName, password);
	            Statement st = conn.createStatement();
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	}
