package Group24.Trello;

import java.sql.*;  
class MysqlCon{ 
	public static void DbConnect(){  
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
	}  
}