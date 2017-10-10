package com.mycompany.trollo_gary;

public class Trello_Nav {
    public static void main(String[] args) {
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
        }
    }

}
