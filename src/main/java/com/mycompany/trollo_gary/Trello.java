package com.mycompany.trollo_gary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Trello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("output.txt"); 
        PrintWriter printer = new PrintWriter("output.txt");
        Scanner in = new Scanner(System.in);
    
        // TODO code application logic here
        System.out.println("Welecome to Trello.");
        
        ArrayList<Integer> task_UI= new ArrayList();
        ArrayList<String> task_US = new ArrayList();
        User u=new User();
		
		u.username();
        
		boolean i=true;
        while(i)
        {
        	System.out.println("Enter your 8 character password");
            Scanner sc = new Scanner(System.in);
            char[] pwd = sc.next().toCharArray();

            i = u.CheckPassword(pwd);
            u.setPwd(pwd);
         }
         
         u.userdetails();

         boolean j=true;
         while(j) 
         {
        	 System.out.println("Enter your 10 digit phone no.");
        	 long num = in.nextLong();
        	 long phnum;
        	 phnum= u.phnumber(num);
             if (phnum==-1) //{ System.out.println("Invalid phone no.");
            	 j= true;
             else {break;}
         }
	
         task_US.add("First Name: " + u.getFname());
         task_US.add("Last Name: " + u.getLname());
         task_US.add("EmailID: " + u.getEmailID());
         task_US.add("Username: " + u.getUsername());
         task_US.add("Pwd:"+ u.getPwd());
         task_US.add("Organisation: " + u.getCompany());
         task_US.add("Phone number: " + u.getPhnum());
         
         for(String str: task_US) 
         {
        	 printer.println(str);
         }
         
         printer.println();
         
//-----------------------------------------------------------------------------

         ArrayList<String> task_B = new ArrayList();
         System.out.println("Enter your choice:");
         choice:
         {
        	 System.out.println("1. Create a Board");
        	 System.out.println("2. Existing Boards");
        	 Board board=new Board();
        	 int key = board.enterInt();
        	 
        	 if(key == 1) 
        	 {
            	 board.CreateBoardTitle();
            	 top:{    String S1=board.SetPrivacy();
            	 		if (S1=="NULL") break top;
            	 		else {board.setPrivacy(S1);
                     }
            	 }
        	 } 

        	 else
        	 {
        		 System.out.println("Enter a valid option!! :");
        		 break choice;
        	 }
        	 
        	 task_B.add("Board Name: " + board.getBoardName());
        	 task_B.add("Privacy: " + board.getPrivacy());
        	 for(String str: task_B) 
        	 {
        		 printer.println(str);
        	 }
         }
         
         printer.println();

//---------------------------------------------------------------------      
                 
         ArrayList<String> task_T = new ArrayList();
         System.out.println("Enter a team name");
         String team_name = in.next();

         System.out.println("Enter description");
         String description = in.next();	

         System.out.println("Team members");
         ArrayList <String> team_members = Update_Team.teammembers();
         Team_cre team_cre1 = new Team_cre(team_name, description, team_members);

         task_T.add("Team Name: " + team_name);
         task_T.add("Team Description: " + description);
         
         for(String str: task_T) 
         {
        	 printer.println(str);
         }
         for(String str: team_members)
         {
        	 printer.println("Member Name: " +str);
         }
         
         printer.println();

//----------------------------------------------------------------------------------  


         System.out.println("Create a Task");
         task new_task = new task();

         System.out.println("Task Name: ");
         String task_name = in.next();
         new_task.setTask_name(task_name);

         System.out.println("Task_Comments : ");
         String task_comment = in.next();
         new_task.setTask_comment(task_comment);

         ArrayList<Integer> task_I = new ArrayList();
         ArrayList<String> task_S = new ArrayList();

         task_S.add("Task Name: " + task_name);
         task_S.add("Task Comment: " + task_comment);
         
         for(String str: task_S) 
         {
        	 printer.println(str);
         }


         writer.close();
         printer.close();
         in.close();
    }

}