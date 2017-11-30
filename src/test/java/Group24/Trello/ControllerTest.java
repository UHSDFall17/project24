/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group24.Trello;

<<<<<<< HEAD
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

=======
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.*;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;

import Group24.Trello.Homepage;
import Group24.Trello.MysqlCon;
import Group24.Trello.*;
import com.mysql.cj.api.mysqla.result.Resultset;
import java.util.ArrayList;

>>>>>>> Nikhita
/**
 *
 * @author Gc PC
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkForUser method, of class Controller.
     */
    @Test
    public void testCheckForUser() {
        System.out.println("checkForUser");
        
        User user = new User();
        user.setUsername("jka");
        user.setPwd("12345678");
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.checkForUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SaveUserDetails method, of class Controller.
     */
<<<<<<< HEAD
=======
    //everytime to test this function, the Username needs to be changed
>>>>>>> Nikhita
    @Test
    public void testSaveUserDetails() {
        System.out.println("SaveUserDetails");
        User user = new User();
<<<<<<< HEAD
        user.setUsername("jka");
=======
        user.setUsername("jkab12");
>>>>>>> Nikhita
        user.setFname("cui");   
        user.setLname("v");
        user.setPwd("12345678");
        user.setCompany("aaa");
        user.setEmailID("garry@123.com");
<<<<<<< HEAD
        user.setPhnum(1234567890);
=======
        user.setPhnum(Long.valueOf(1234567890));
>>>>>>> Nikhita
        
        Controller instance = new Controller();
        int expResult = 1;
        int result = instance.SaveUserDetails(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SaveUserCreds method, of class Controller.
     */
<<<<<<< HEAD
=======
    //Need to change the setUsername every time run the test 
>>>>>>> Nikhita
    @Test
    public void testSaveUserCreds() {
        System.out.println("SaveUserCreds");
        User user = new User();
<<<<<<< HEAD
        user.setUsername("jkb");
=======
        user.setUsername("naveen123");
>>>>>>> Nikhita
        user.setPwd("12345678");
        Controller instance = new Controller();
        int expResult = 1;
        int result = instance.SaveUserCreds(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of checkForExistingUser method, of class Controller.
     */
    @Test
    public void testCheckForExistingUser() {
        System.out.println("checkForExistingUser");
        String username1 = "jka";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.checkForExistingUser(username1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of checkExistingTeam method, of class Controller.
     */
    @Test
    public void testCheckExistingTeam() {
        System.out.println("checkExistingTeam");
<<<<<<< HEAD
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkExistingTeam(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        String username = "jka";
        ResultSet expResult = null;
        Controller instance = new Controller();
        
         try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            String sql1;


            sql1="select team.team_name from team where team.team_id IN (select member.team_id from member where member.mem_username='jka');";
            expResult = st.executeQuery(sql1); //where ps is Object of PreparedStatement

        } catch (Exception e) {
            e.printStackTrace();
        }
         
        ResultSet result = instance.checkExistingTeam(username);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
>>>>>>> Nikhita
    }

    /**
     * Test of checkExistingBoard method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testCheckExistingBoard() {
        System.out.println("checkExistingBoard");
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkExistingBoard(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testCheckExistingBoard() throws SQLException {
        System.out.println("checkExistingBoard");
        String username = "jka";
         ResultSet expResult = null;
        Controller instance = new Controller();
        ResultSet result = instance.checkExistingBoard(username);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] bname=new String[l];
        while (result.next()) {
            bname[i] = result.getString("BoardName");
            i++;
        }
        String[] b = {"jka","nav","board1234"};
        Assert.assertArrayEquals(b, bname);
        // TODO review the generated test code and remove the default call to fail.

>>>>>>> Nikhita
    }

    /**
     * Test of fetchingBoardDetails method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testFetchingBoardDetails() {
        System.out.println("fetchingBoardDetails");
        String BoardName1 = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.fetchingBoardDetails(BoardName1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testFetchingBoardDetails() throws SQLException {
        System.out.println("fetchingBoardDetails");
        String BoardName1 = "jka";
        Controller instance = new Controller();
        ResultSet result = instance.fetchingBoardDetails(BoardName1);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] tname=new String[l];
        while (result.next()) {
            tname[i] = result.getString("team_name");
            i++;
        }
        String[] t = {"team1"};
        Assert.assertArrayEquals(t, tname);
>>>>>>> Nikhita
    }

    /**
     * Test of displayingBoardsForTeam method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testDisplayingBoardsForTeam() {
        System.out.println("displayingBoardsForTeam");
        String teamname1 = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayingBoardsForTeam(teamname1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testDisplayingBoardsForTeam() throws SQLException {
        System.out.println("displayingBoardsForTeam");
        String teamname1 = "team1";
        Controller instance = new Controller();
        ResultSet result = instance.displayingBoardsForTeam(teamname1);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] bname=new String[l];
        while (result.next()) {
            bname[i] = result.getString("BoardName");
            i++;
        }
        String[] b = {"jka"};
        Assert.assertArrayEquals(b, bname);
>>>>>>> Nikhita
    }

    /**
     * Test of displayingTeamMembers method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testDisplayingTeamMembers() {
        System.out.println("displayingTeamMembers");
        String teamname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayingTeamMembers(teamname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testDisplayingTeamMembers() throws SQLException {
        System.out.println("displayingTeamMembers");
        String teamname1 = "team1";
        Controller instance = new Controller();
        ResultSet result = instance.displayingTeamMembers(teamname1);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] bname=new String[l];
        while (result.next()) {
            bname[i] = result.getString("mem_username");
            i++;
        }
        String[] b = {"jka","nik123","jka123","qwerty"};
        Assert.assertArrayEquals(b, bname);
>>>>>>> Nikhita
    }

    /**
     * Test of displayListsInBoard method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testDisplayListsInBoard() {
        System.out.println("displayListsInBoard");
        String bname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayListsInBoard(bname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testDisplayListsInBoard() throws SQLException {
        System.out.println("displayListsInBoard");
        String bname = "jka";
        Controller instance = new Controller();
        ResultSet result = instance.displayListsInBoard(bname);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] lname=new String[l];
        while (result.next()) {
            lname[i] = result.getString("list_name");
            i++;
        }
        String[] l1 = {"list1","list2"};
        Assert.assertArrayEquals(l1, lname);
>>>>>>> Nikhita
    }

    /**
     * Test of creatingList method, of class Controller.
     */
    @Test
    public void testCreatingList() {
        System.out.println("creatingList");
        String bname = "";
        String list_name = "";
        Controller instance = new Controller();
<<<<<<< HEAD
        ResultSet expResult = null;
        ResultSet result = instance.creatingList(bname, list_name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        ResultSet result = instance.creatingList(bname, list_name);

>>>>>>> Nikhita
    }

    /**
     * Test of createBoard method, of class Controller.
     */
    @Test
    public void testCreateBoard() {
        System.out.println("createBoard");
<<<<<<< HEAD
        Board board = null;
        Controller instance = new Controller();
        instance.createBoard(board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        String usernameexp = "jka";
        ResultSet rs = null; 
        String rss = null;
        Board board = new Board();
        board.setUsername("jka");
        board.setPrivacy("private");
        board.setPrivilege("ADMIN");
        board.setBoardName("abc");
        Controller instance = new Controller();
        instance.createBoard(board);
        
         try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            rs = st.executeQuery("select username from board where boardname = 'abc'");
            while(rs.next()){
                rss = rs.getString(1);
                //System.out.println(rss);
            }
            
            conn.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals(usernameexp, rss);
>>>>>>> Nikhita
    }

    /**
     * Test of listMyTeam method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testListMyTeam() {
        System.out.println("listMyTeam");
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.listMyTeam(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testListMyTeam() throws SQLException {
        System.out.println("listMyTeam");
        String username = "jka";
        Controller instance = new Controller();
        ResultSet result = instance.listMyTeam(username);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] tname=new String[l];
        while (result.next()) {
            tname[i] = result.getString("team_name");
            i++;
        }
        String[] t1 = {"team1","team2"};
        Assert.assertArrayEquals(t1, tname);
>>>>>>> Nikhita
    }

    /**
     * Test of displayTeamcreds method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testDisplayTeamcreds() {
        System.out.println("displayTeamcreds");
        String teamname1 = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayTeamcreds(teamname1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

=======
    public void testDisplayTeamcreds() throws SQLException {
        System.out.println("displayTeamcreds");
        String teamname1 = "team1";
        Controller instance = new Controller();
        ResultSet result = instance.displayTeamcreds(teamname1);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] tname=new String[l];
        while (result.next()) {
            tname[i] = result.getString("team_name");
            i++;
        }

        String[] t1 = {"team1"};
        Assert.assertArrayEquals(t1, tname);
    }


>>>>>>> Nikhita
    /**
     * Test of createTeam method, of class Controller.
     */
    @Test
    public void testCreateTeam() {
        System.out.println("createTeam");
<<<<<<< HEAD
        Team_cre team1 = null;
        String username = "";
        Controller instance = new Controller();
        instance.createTeam(team1, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        ResultSet rs2 = null; 
        String teamnameexp = "abc";
        String username = "jka";
        String teamname = null;
        int tid = 0;
        
        Team_cre team1 = new Team_cre();
        team1.setTeam_name("abc");
        team1.setTeam_description("abc");
        List<String> team_members = new ArrayList<>();
        team_members.add("jka");
        team1.setTeam_members(team_members);
        team1.setTeam_visibility("PUBLIC");
        
        
        
        Controller instance = new Controller();
        instance.createTeam(team1, username);
         try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            
            String sql2 = "SELECT team_id FROM team where team_name = '" + team1.getTeam_name() +"';";
            ResultSet rs = st.executeQuery(sql2);
            while(rs.next()){
                tid = rs.getInt("team_id");
                System.out.println(tid);
            }
                String sql3= "select team_name from team where team_id =" +tid ;
                rs2 = st.executeQuery(sql3);
            while(rs2.next()){
                teamname = rs2.getString(1);
                System.out.println(teamname);
            }

            conn.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(teamnameexp, teamname);
        
        // TODO review the generated test code and remove the default call to fail.

>>>>>>> Nikhita
    }

    /**
     * Test of checkTeamHasBoard method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testCheckTeamHasBoard() {
        System.out.println("checkTeamHasBoard");
        String boardname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkTeamHasBoard(boardname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testCheckTeamHasBoard() throws SQLException {
        System.out.println("checkTeamHasBoard");
        String boardname = "nmnmnmnmnmmnn";
        Controller instance = new Controller();
        ResultSet result = instance.checkTeamHasBoard(boardname);
        if(result.next()) {
            assert(false);
        }
        else{
            assert(true);
        }
>>>>>>> Nikhita
    }

    /**
     * Test of updateBoardTeam method, of class Controller.
     */
    @Test
    public void testUpdateBoardTeam() {
        System.out.println("updateBoardTeam");
<<<<<<< HEAD
        String boardname = "";
        String teamname = "";
        Controller instance = new Controller();
        instance.updateBoardTeam(boardname, teamname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        String boardname = "jka";
        String teamname = "team1";
        ResultSet rs = null; 
        Controller instance = new Controller();
        instance.updateBoardTeam(boardname, teamname);
        
        try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            String query = "select * from board_team where board_id = 16 and team_id = 61";
            rs = st.executeQuery(query);
            
            conn.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(rs);
        // TODO review the generated test code and remove the default call to fail.
        
>>>>>>> Nikhita
    }

    /**
     * Test of listAllUsers method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testListAllUsers() {
        System.out.println("listAllUsers");
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.listAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testListAllUsers() throws SQLException {
        System.out.println("listAllUsers");
        Controller instance = new Controller();
        ResultSet result = instance.listAllUsers();
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] uname=new String[l];
        while (result.next()) {
            uname[i] = result.getString("username");
            i++;
        }

        String[] u1 = {"jka","jka123","nik123","qwerty"};
        Assert.assertArrayEquals(u1, uname);
>>>>>>> Nikhita
    }

    /**
     * Test of addMemberToTeam method, of class Controller.
     */
    @Test
    public void testAddMemberToTeam() {
        System.out.println("addMemberToTeam");
<<<<<<< HEAD
        String team_name = "";
        String privilege = "";
        String mem_username = "";
        Controller instance = new Controller();
        instance.addMemberToTeam(team_name, privilege, mem_username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
        String team_name = "abc";
        String privilege = "ADMIN";
        String mem_username = "jka";
        int tid = 0; 
        ResultSet rs = null;
        Controller instance = new Controller();
        instance.addMemberToTeam(team_name, privilege, mem_username);
        
        try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            String sql1 ="SELECT team_id FROM team where team_name = '" + team_name +"';";
            ResultSet rs1=st.executeQuery(sql1);
            if(rs1.next()) {
               tid = rs1.getInt("team_id");
            }
            String query2 = "select member_id from member where team_id = "+tid+" and mem_username ='" +mem_username+"'";
            rs = st.executeQuery(query2);
            
            conn.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(rs);
        // TODO review the generated test code and remove the default call to fail.
        
>>>>>>> Nikhita
    }

    /**
     * Test of displayCardDescription method, of class Controller.
     */
    @Test
<<<<<<< HEAD
    public void testDisplayCardDescription() {
        System.out.println("displayCardDescription");
        String lnme = "list1";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayCardDescription(lnme);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
=======
    public void testDisplayCardDescription() throws SQLException {
        System.out.println("displayCardDescription");
        String lnme = "list1";
        Controller instance = new Controller();
        ResultSet result = instance.displayCardDescription(lnme);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] cardname=new String[l];
        while (result.next()) {
            cardname[i] = result.getString("description");
            i++;
        }
        String[] d1 = {"card 3","card1"};
        Assert.assertArrayEquals(d1, cardname);
>>>>>>> Nikhita
    }
    
}
