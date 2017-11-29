/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group24.Trello;

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
    @Test
    public void testSaveUserDetails() {
        System.out.println("SaveUserDetails");
        User user = new User();
        user.setUsername("jka");
        user.setFname("cui");   
        user.setLname("v");
        user.setPwd("12345678");
        user.setCompany("aaa");
        user.setEmailID("garry@123.com");
        user.setPhnum(Long.valueOf(1234567890));
        
        Controller instance = new Controller();
        int expResult = 1;
        int result = instance.SaveUserDetails(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SaveUserCreds method, of class Controller.
     */
    //Need to change the setUsername every time run the test 
    @Test
    public void testSaveUserCreds() {
        System.out.println("SaveUserCreds");
        User user = new User();
        user.setUsername("naveen123");
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
    }

    /**
     * Test of checkExistingBoard method, of class Controller.
     */
    @Test
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

    }

    /**
     * Test of fetchingBoardDetails method, of class Controller.
     */
    @Test
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
    }

    /**
     * Test of displayingBoardsForTeam method, of class Controller.
     */
    @Test
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
    }

    /**
     * Test of displayingTeamMembers method, of class Controller.
     */
    @Test
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
        String[] b = {"jka","nik123","jka123"};
        Assert.assertArrayEquals(b, bname);
    }

    /**
     * Test of displayListsInBoard method, of class Controller.
     */
    @Test
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
        ResultSet result = instance.creatingList(bname, list_name);

    }

    /**
     * Test of createBoard method, of class Controller.
     */
    @Test
    public void testCreateBoard() {
        System.out.println("createBoard");
        Board board = null;
        Controller instance = new Controller();
        instance.createBoard(board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMyTeam method, of class Controller.
     */
    @Test
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
    }

    /**
     * Test of displayTeamcreds method, of class Controller.
     */
    @Test
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


    /**
     * Test of createTeam method, of class Controller.
     */
    @Test
    public void testCreateTeam() {
        System.out.println("createTeam");
        Team_cre team1 = null;
        String username = "";
        Controller instance = new Controller();
        instance.createTeam(team1, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTeamHasBoard method, of class Controller.
     */
    @Test
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
    }

    /**
     * Test of updateBoardTeam method, of class Controller.
     */
    @Test
    public void testUpdateBoardTeam() {
        System.out.println("updateBoardTeam");
        String boardname = "";
        String teamname = "";
        Controller instance = new Controller();
        instance.updateBoardTeam(boardname, teamname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllUsers method, of class Controller.
     */
    @Test
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
    }

    /**
     * Test of addMemberToTeam method, of class Controller.
     */
    @Test
    public void testAddMemberToTeam() {
        System.out.println("addMemberToTeam");
        String team_name = "";
        String privilege = "";
        String mem_username = "";
        Controller instance = new Controller();
        instance.addMemberToTeam(team_name, privilege, mem_username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayCardDescription method, of class Controller.
     */
    @Test
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
    }
    
}
