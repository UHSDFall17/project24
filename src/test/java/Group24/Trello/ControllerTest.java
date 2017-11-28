/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group24.Trello;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        user.setPhnum(1234567890);
        
        Controller instance = new Controller();
        int expResult = 1;
        int result = instance.SaveUserDetails(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SaveUserCreds method, of class Controller.
     */
    @Test
    public void testSaveUserCreds() {
        System.out.println("SaveUserCreds");
        User user = new User();
        user.setUsername("jkb");
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
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkExistingTeam(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistingBoard method, of class Controller.
     */
    @Test
    public void testCheckExistingBoard() {
        System.out.println("checkExistingBoard");
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkExistingBoard(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetchingBoardDetails method, of class Controller.
     */
    @Test
    public void testFetchingBoardDetails() {
        System.out.println("fetchingBoardDetails");
        String BoardName1 = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.fetchingBoardDetails(BoardName1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayingBoardsForTeam method, of class Controller.
     */
    @Test
    public void testDisplayingBoardsForTeam() {
        System.out.println("displayingBoardsForTeam");
        String teamname1 = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayingBoardsForTeam(teamname1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayingTeamMembers method, of class Controller.
     */
    @Test
    public void testDisplayingTeamMembers() {
        System.out.println("displayingTeamMembers");
        String teamname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayingTeamMembers(teamname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayListsInBoard method, of class Controller.
     */
    @Test
    public void testDisplayListsInBoard() {
        System.out.println("displayListsInBoard");
        String bname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayListsInBoard(bname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        ResultSet expResult = null;
        ResultSet result = instance.creatingList(bname, list_name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testListMyTeam() {
        System.out.println("listMyTeam");
        String username = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.listMyTeam(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTeamcreds method, of class Controller.
     */
    @Test
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
    public void testCheckTeamHasBoard() {
        System.out.println("checkTeamHasBoard");
        String boardname = "";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.checkTeamHasBoard(boardname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testListAllUsers() {
        System.out.println("listAllUsers");
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.listAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testDisplayCardDescription() {
        System.out.println("displayCardDescription");
        String lnme = "list1";
        Controller instance = new Controller();
        ResultSet expResult = null;
        ResultSet result = instance.displayCardDescription(lnme);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
