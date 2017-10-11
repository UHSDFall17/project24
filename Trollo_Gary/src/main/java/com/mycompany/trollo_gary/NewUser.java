package com.mycompany.trollo_gary;
import java.util.*;

public class NewUser {

	/*public char [] pwd;
	public static void usercreds() {
		boolean i=true;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username:" );
		String username=sc.nextLine();
		
	while(i) {		
			System.out.println("Enter your 8 character password");
			char [] pwd=sc.next().toCharArray();
		
			if(pwd.length > 8) {
			System.out.println("Password should be of 8 characters");
			i=true;
			}
			else {
			System.out.println("Welcome!!");
			i=false;
			}
  		}			
	}
	
	public static void userdetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your first name and last name");
		String fname= sc.nextLine();

		String lname=sc.nextLine();
		
		System.out.println("Enter your emailID");
		String emailID= sc.nextLine();
		
		System.out.println("Enter your Organisation");
		String company= sc.nextLine();
		
		System.out.println("Enter your 10 digit phone no.");
		int phnum= sc.nextInt();
		
		
		
	}
	*/
	public static void main(String []args) {
		user u=new user();
		u.userdetails();
		u.usercreds();
	}	
		
	}

