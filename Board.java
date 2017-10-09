import java.util.*;
import java.lang.*;
public class Board {

    private String BoardName;
    private int BoardID;
    private int TeamID;
    private int ListID;
    private int TeamFlag;
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

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getListID() {
        return ListID;
    }

    public void setListID(int listID) {
        ListID = listID;
    }

    public int getTeamFlag() {
        return TeamFlag;
    }

    public void setTeamFlag(int teamFlag) {
        TeamFlag = teamFlag;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
/*

    public String getBoardName() {
        return BoardName;
    }

    public void setBoardName(String boardName) {
        this.BoardName = boardName;
    }

    public int getBoardID() {
        return BoardID;
    }

    public void setBoardID(int boardID) {
        this.BoardID = boardID;
    }

    public int getTeamFlag() {
        return TeamFlag;
    }

    public void setTeamFlag(int teamFlag) {
        this.TeamFlag = teamFlag;
    }

    public String getprivacy() {
        return privacy;
    }

    public void setprivacy(String privacy) {
        this.privacy = privacy;
    }*/

    /*
        public Board(String BoardName, String privacy) {
            this.BoardName = BoardName;
            this.privacy = privacy;
        }

        public static void main(String[] args) {

            System.out.println("Enter your choice:");
            choice:
            {
            System.out.println("1. Create a Board");
            System.out.println("2. Existing Boards");
            int key = enterInt();
            if(key == 1) {
                CreateBoard();
            } /*else if (key == 2) {
                ExistingBoards();
            }
            else if (key == 3) {
                DeleteBoard();
            }*/
/*
        else{
            System.out.println("Enter a valid option!! :");break choice;
        }
        }
    }
*/
    public static int enterInt() {
        Scanner in = new Scanner(System.in);
        int key1 = in.nextInt();
        //in.close();
        return key1;
    }

    public String enterString() {
        Scanner in1 = new Scanner(System.in);
        String S1 = in1.nextLine();
        //in.close();
        return S1;
    }

    public void CreateBoard() {
        System.out.println("Enter your Board Title:");
        String tempS1 = enterString();
        setBoardName(tempS1);
        System.out.println(tempS1);

        System.out.println("Choose the privacy settings:");
        top:
        {
            System.out.println("1. Public:");
            System.out.println("2. Team:");
            System.out.println("3. Private:");
            int tempS2 = enterInt();
            String tempS3;
            switch (tempS2) {
                case 1:
                    tempS3 = "Public"; break;
                case 2:
                    tempS3 = "Team"; break;
                case 3:
                    tempS3 = "Private"; break;
                default:
                    System.out.println("Error!! Enter a valid option:");
                    break top;
            }
            setPrivacy(tempS3);
            System.out.println(tempS3);}
        System.out.println("Success!!! Board created");
top1:{  System.out.println("Enter your choice:");
        int tempS4 = enterInt();
        switch (tempS4) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Error!! Enter a valid option:");
                break top1;}
        }

        }
    }
