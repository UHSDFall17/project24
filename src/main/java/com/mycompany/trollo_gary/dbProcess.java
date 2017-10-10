/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trollo_gary;
import java.io.PrintWriter;
import java.sql.*;  

/**
 *
 * @author Gc PC
 */
public class dbProcess {

    protected Connection con;
    protected PrintWriter sqloutput;
    
    public void connect(){
        try{  
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
            //step2 create  the connection object  
            con = DriverManager.getConnection(  
            "jdbc:oracle:thin:system/19910331@localhost:1521:xe");  
  
            //step3 create the statement object  
            //Statement stmt=con.createStatement();  
  
            //step4 execute query  
//            ResultSet rs=stmt.executeQuery("select * from A");  
//            while(rs.next())  
//            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
  
            //step5 close the connection object  
            //con.close();  
  
            }catch(Exception e){ System.out.println(e);}  
  
    }
    
    public void insertTask(String task_name,String task_comment){
//        SELECT MAX(TASK_ID) FROM TRELLO_TASK;
//        );
        int task_Id = findId("TASK_ID","TRELLO_TASK");
        //System.out.println(task_Id);
        String insert_Task_sql = "INSERT INTO TRELLO_TASK (TASK_ID,TASK_NAME) VALUES (" + task_Id + ",'"+ task_name +"')";
        //System.out.println(insert_Task_sql);
        int comment_Id = findId("COMMENT_ID","TRELLO_COMMENT");
        String insert_Comment_sql = "INSERT INTO TRELLO_COMMENT (COMMENT_ID,COMMENT_COMMENT) VALUES (" + comment_Id + ",'"+ task_comment +"')";
        String insert_Task_Comment_sql = "INSERT INTO TRELLO_TASK_COMMENT (TASK_ID,COMMENT_ID) VALUES (" + task_Id + "," + comment_Id + ")";
        //System.out.println(insert_Task_Comment_sql);
        executeQuery(insert_Task_sql);
        executeQuery(insert_Comment_sql);
        executeQuery(insert_Task_Comment_sql);
        
        
    }
    
    public int findId(String ID_type, String table_name){
        int Id = 0;
        try{
        String findId_sql = "SELECT MAX(" + ID_type +") FROM " + table_name;
        //System.out.println(findId_sql);
        ResultSet Ids = executeCreateQuery(findId_sql);

        Ids.next();
        
//        String a = Ids.getString(1);
//        System.out.println(a);
        Id = Ids.getInt(1);
        //System.out.println(Id);
        Id ++;
        //System.out.println(Id);

        } catch(Exception e){
            System.out.println(e);
            System.exit(0);  
        }
        return Id;
    }
    
    public ResultSet executeCreateQuery(String query) {
        ResultSet rs = null;
        try {

                        Statement statement = con.createStatement();
                        //sqloutput.println(query);
                        //sqloutput.println();
                        rs = statement.executeQuery(query);
//                            while(rs.next())  
//                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  


            } catch (Exception e) {
                    System.out.println("Error while executing query " + query);
                    System.out.println(e);
                    System.exit(0);
            }
            return rs;
    }
        
    public void executeQuery(String query) {
            try {
                    Statement statement = con.createStatement();
                    //sqloutput.println(query);
                    //sqloutput.println();
                    statement.executeUpdate(query);



            } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Error while executing query " + query);
            }

    }
}
