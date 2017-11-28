package Group24.Trello;


import java.util.Scanner;

public class User {

private String username;
private String fname, lname;
private char pwd[]; 
private String company;
private String emailID;
private long phnum;

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
public long getPhnum() {
	return phnum;
}
public void setPhnum(long phnum) {
	this.phnum = phnum;
}


public void username () {


    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your username:");
    String username = sc.nextLine();
    setUsername(username);
    
}

public boolean CheckPassword(char[] pwd){
    boolean i = true;
            if(pwd.length > 8 || pwd.length<8) {
            System.out.println("Password should be of 8 characters");
            i=true;
        }
        else {
            System.out.println("Welcome!!");
            i=false;
        }
        return i;
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
    }
	
public long phnumber(long phnum) {
	//Scanner sc = new Scanner(System.in);
	long num=phnum;
	//System.out.println("Enter your 10 digit phone no.");
	//long num = sc.nextLong();

	if(num>999999999 && num<10000000000L) {
	setPhnum(num);
	return num;
	}
	else
		System.out.println("Invalid phone number");
	return -1;

}
}
