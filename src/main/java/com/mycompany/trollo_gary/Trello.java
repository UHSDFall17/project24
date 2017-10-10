/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trollo_gary;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Gc PC
 */
public class Trello {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("output.txt"); 
        PrintWriter printer = new PrintWriter("output.txt");
        Scanner in = new Scanner(System.in);

        dbProcess process = new dbProcess();
        // TODO code application logic here
       System.out.println("Welecome to Trello.");
//       Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Please select the action: %/n ");
//        int a = reader.nextInt(); // Scans the next token of the input as an int.
        //once finished
        

        
        
//        switch(a){
//            case 1:
                ArrayList<Integer> task_UI= new ArrayList();
                ArrayList<String> task_US = new ArrayList();
                user u=new user();
		u.userdetails();
		u.usercreds();
                 task_US.add("First Name: " + u.getFname());
                task_US.add("Last Name: " + u.getLname());
                task_US.add("EmailID: " + u.getEmailID());
                task_US.add("Username: " + u.getUsername());
                task_US.add("Pwd:"+ u.getPwd());
                task_US.add("Organisation: " + u.getCompany());
                task_US.add("Phone number: " + u.getPhnum());
                        for(String str: task_US) {
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
            if(key == 1) {
                board.CreateBoard();
            } /* else if (key == 2) {
            board.ExistingBoards();
        }
        else if (key == 3) {
            board.DeleteBoard();
        }*/
            
        else{
            System.out.println("Enter a valid option!! :");break choice;
        }
            task_B.add("Board Name: " + board.getBoardName());
                task_B.add("Privacy: " + board.getPrivacy());
                for(String str: task_B) {
                    printer.println(str);
                }
        }
        printer.println();
        
        //---------------------------------------------------------------------      
        ArrayList<String> task_T = new ArrayList();
                System.out.println("Enter a team name");
		//	Scanner scan = new Scanner (System.in);
			String team_name = in.next();
			List <String> team_members = new ArrayList<>(); // Creating array for storing team members
			System.out.println("Enter description");
			String description = in.next();	
			// Team members adding
			System.out.println("Team members");
			Start:
				do {System.out.println("Enter team member name");
				String member = in.next();
				team_members.add(member);
				System.out.println("Add another member? (Y/N)");
				char x = in.next().charAt(0);
				if (x=='Y'||x=='y')
				{
					continue Start;
				}
					else{
					if (x=='N'||x=='n'){
						break Start;
					}
					else {
						System.out.println("Wrong input");
						continue Start;
					}
				}
				
			}while (true) ;
			
                        Team_cre team_cre1 = new Team_cre(team_name, description, team_members);
                        
                task_T.add("Team Name: " + team_name);
                task_T.add("Team Description: " + description);
                for(String str: task_T) {
                    printer.println(str);
                }
                for(String str: team_members){
                    printer.println("Member Name: " +str);
                }
                printer.println();
                
//----------------------------------------------------------------------------------                
                 System.out.println("Create a Task");
                 task new_task = new task();
                 

                 System.out.println("Task Name: ");
                 String task_name = in.nextLine();
                 new_task.setTask_name(task_name);
                 //System.out.println(new_task.getTask_name());
                
//                 System.out.println("List Name : ");
//                 String list_name = in.nextLine();
//                 new_task.setList_name(list_name);
                 //System.out.println(new_task.getList_name());
                 
                 System.out.println("Task_Comments : ");
                 String task_comment = in.nextLine();
                 new_task.setTask_comment(task_comment);
                 //System.out.println(new_task.getTask_comment()); 
                 //reader.close();
                 

                 
                // process.connect();
                 //String test = "SELECT MAX(APPID) FROM A";
                 //process.executeCreateQuery(test);
                 //process.findId("SID", "A");
                // process.insertTask(task_name, task_comment);
                 
                ArrayList<Integer> task_I = new ArrayList();
                ArrayList<String> task_S = new ArrayList();
                
                task_S.add("Task Name: " + task_name);
                task_S.add("Task Comment: " + task_comment);
                for(String str: task_S) {
                    printer.println(str);
                }

                 
                 //dbProcess.insertTask(new_task.getTask_name(),new_task.getTask_comment());
                 
                //break;
                
           // case 2: 
                
              //  break;
                
         //   case 3:
                
         
           //     break;
                
        //    case 4:

                
         //       break;
        
        
        
               
        
    

        writer.close();
        printer.close();
        in.close();
    }
    
}