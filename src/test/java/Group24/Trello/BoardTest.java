package Group24.Trello;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BoardTest {
    //privacy test
    @Test
    public void testinputoutput1(){
        Board b1= new Board();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Public", b1.setPrivacy());
    }

    //privacy test
    @Test
    public void testinputoutput2(){
        Board b1= new Board();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Team", b1.setPrivacy());
    }

    //privacy test
    @Test
    public void testinputoutput3(){
        Board b1= new Board();
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Private", b1.setPrivacy());
    }

    //privacy test
    @Test
    public void testinputoutput4(){
        Board b1= new Board();
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("NULL", b1.setPrivacy());
    }

    //Title test
    @Test
    public void testinputoutput12(){
        Board b1= new Board();
        String input = "Group24";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Group24", b1.createBoardTitle());
    }

    @Test
    public void getterSetterTest(){
        Board b1= new Board();
        String Bname = "BeerusSama";
        String Privacy = "PUBLIC";
        String Privilege = "ADMIN";
        String username = "WhisSama";
        int bid = 1;
        b1.setPrivilege(Privilege);
        b1.setPrivacy(Privacy);;
        b1.setBoardName(Bname);
        b1.setBoardID(bid);
        b1.setUsername(username);
        boolean i=false;
        if(b1.getBoardName().compareTo(Bname)==0) {
            if (b1.getPrivacy().compareTo(Privacy) == 0) {
                if (b1.getPrivilege().compareTo(Privilege) == 0) {
                    if (b1.getUsername().compareTo(username) == 0) {
                        if (b1.getBoardID() == (bid)){
                        	i=true;
                        	
                        }
                    }
                }
            }
        }
    
    assertTrue(i);}

}