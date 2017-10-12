package com.mycompany.trollo_gary;

import java.util.ArrayList;
import java.util.Scanner;

public class Update_Team {
	private static Scanner scan;
	private static Scanner scan2;
	public static ArrayList<String> teammembers(){
	ArrayList <String> team_members = new ArrayList<>(); 
	scan = new Scanner (System.in);
	Start:
		do {System.out.println("Enter team member name");
		String member = scan.next();
		team_members.add(member);
		Start2 : do {System.out.println("Add another member? (Y/N)");
		char x = scan.next().charAt(0);
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
				continue Start2;		
			}
		}
		}while (true) ;
	}while (true) ;
	return team_members;
	}
	
	
	
	/*public static void main(String[] args) {
			System.out.println("Enter a team name");
			scan2 = new Scanner (System.in);
			String team_name = scan2.next();
		
			System.out.println("Enter description");
			String description = scan2.next();	
			// Team members adding
			System.out.println("Team members");
			ArrayList <String> team_members = teammembers();
			Team_cre team_cre1 = new Team_cre(team_name, description, team_members);*/
	}

	
