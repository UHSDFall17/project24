package trello;

import java.util.Scanner;

public class user {

private String username;
private String fname, lname;
private char pwd[]; 
private String company;
private String emailID;
private int	phnum;

public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public char[] getPwd() {
	return pwd;
}
public void setPwd(char[] pwd) {
	this.pwd = pwd;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getPhnum() {
	return phnum;
}
public void setPhnum(int phnum) {
	this.phnum = phnum;
}


public void usercreds() {
	boolean i=true;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your username:" );
	String username=sc.nextLine();
	setUsername(username);
	
while(i) {		
		System.out.println("Enter your 8 character password");
		char [] pwd=sc.next().toCharArray();
		setPwd(pwd);
		
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

public void userdetails() {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your first name and last name");
	String fname= sc.nextLine();
	setFname(fname);
	
	String lname=sc.nextLine();
	setLname(lname);
	
	System.out.println("Enter your emailID");
	String emailID= sc.nextLine();
	setEmailID(emailID);
	
	System.out.println("Enter your Organisation");
	String company= sc.nextLine();
	setCompany(company);
	
	boolean i=true;
	
	while(i) {		
		System.out.println("Enter your 10 digit phone no.");
		
		if(sc.hasNextInt()&& sc.nextInt()>999999999) {
			int phnum= sc.nextInt();
			setPhnum(phnum);
		i=false;	
		}
		else {
			System.out.println("Invalid input!");
		    sc.next();
			i=true;
		}
	}		
	
	
	}

}
