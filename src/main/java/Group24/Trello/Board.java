package Group24.Trello;

import java.util.*;
import java.lang.*;
public class Board {

	private String BoardName;
	private int BoardID;
	private String privilege;
	private String username;
	private String privacy;



	public String getBoardName() {
		return BoardName;
	}
	public void setBoardName(String boardName) {
		BoardName = boardName;
	}
	public int getBoardID() {
		return BoardID;
	}
	public void setBoardID(int boardID) {
		BoardID = boardID;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String enterString() {
		Scanner in1 = new Scanner(System.in);
		String S1 = in1.nextLine();

		return S1;
	}
	public String CreateBoardTitle() {
		System.out.println("Enter your Board Title:");
		String tempS1 = enterString();
		setBoardName(tempS1);
		System.out.println(tempS1);
		return getBoardName();
	}
	public int enterInt() {
		Scanner in = new Scanner(System.in);
		int key1 = in.nextInt();

		return key1;
	}

	public String SetPrivacy() {
		System.out.println("Choose the privacy settings:");
		System.out.println("1. Public:");
		System.out.println("2. Team:");
		System.out.println("3. Private:");
		String tempS3 = enterString();
		String tempS2;
		switch (tempS3) {
			case "1":
				tempS2 = "Public";System.out.println("Success!!! Board created");
				break;
			case "2":
				tempS2 = "Team";System.out.println("Success!!! Board created");
				break;
			case "3":
				tempS2 = "Private";System.out.println("Success!!! Board created");
				break;
			default:
				tempS2="NULL";
				System.out.println("Error!! Enter a valid option:");
				break;

		}
		return tempS2;
	}
}