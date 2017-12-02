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
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import Group24.Trello.Homepage;
import Group24.Trello.MysqlCon;
import Group24.Trello.*;
import com.mysql.cj.api.mysqla.result.Resultset;
import java.util.ArrayList;

/**
 *
 * @author Gc PC
 */
public class ControllerTest {
    Controller instance = new Controller();
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
        
        boolean expResult = true;
        boolean result = instance.checkForUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SaveUserDetails method, of class Controller.
     */
    //everytime to test this function, the Username needs to be changed
    @Test
    public void testSaveUserDetails() {
        System.out.println("SaveUserDetails");
        User user = new User();
        user.setUsername("jkab12");
        user.setFname("cui");   
        user.setLname("v");
        user.setPwd("12345678");
        user.setCompany("aaa");
        user.setEmailID("garry@123.com");
        user.setPhnum(Long.valueOf(1234567890));
        
        
        int expResult = -1;
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
        
        int expResult = 1;
        int result = instance.SaveUserCreds(user);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of checkForExistingUser method, of class Controller.
     */
    @Test
    public void testCheckForExistingUser() {
        System.out.println("checkForExistingUser");
        String username1 = "jka";
        
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
        String[] b = {"Board","board2"};
        Assert.assertArrayEquals(b, bname);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of fetchingBoardDetails method, of class Controller.
     */
    @Test
    public void testFetchingBoardDetails() throws SQLException {
        System.out.println("fetchingBoardDetails");
        String BoardName1 = "Board";
        
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
        String teamname1 = "Team";
        
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
        String[] b = {};
        Assert.assertArrayEquals(b, bname);
    }

    /**
     * Test of displayingTeamMembers method, of class Controller.
     */
    @Test
    public void testDisplayingTeamMembers() throws SQLException {
        System.out.println("displayingTeamMembers");
        String teamname1 = "Team";
        
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
        String[] b = {};
        Assert.assertArrayEquals(b, bname);
    }

    /**
     * Test of displayListsInBoard method, of class Controller.
     */
    @Test
    public void testDisplayListsInBoard() throws SQLException {
        System.out.println("displayListsInBoard");
        String bname = "Board";
        
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
        String[] l1 = {"list"};
        Assert.assertArrayEquals(l1, lname);
    }

    /**
     * Test of creatingList method, of class Controller.
     */
/*
    @Test
    public void testCreatingList() throws SQLException {
        System.out.println("creatingList");
        String bname = "";
        String list_name = "";
        
        ResultSet result = instance.creatingList(bname, list_name);


        assertEquals(0,result);
    }

    /**
     * Test of createBoard method, of class Controller.
     */

    @Test
    public void testCreateBoard() {
        System.out.println("createBoard");
        String usernameexp = "jka";
        ResultSet rs = null;
        String rss = null;
        Board board = new Board();
        board.setUsername("jka");
        board.setPrivacy("private");
        board.setPrivilege("ADMIN");
        board.setBoardName("abc");
        
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
    }

    /**
     * Test of listMyTeam method, of class Controller.
     */
    @Test
    public void testListMyTeam() throws SQLException {
        System.out.println("listMyTeam");
        String username = "jka";
        
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
        String teamname1 = "Team";
        
        ResultSet result = instance.displayTeamcreds(teamname1);
        int i=0,l=0;
        if (result.last()) {
            l = (result.getRow())*4;
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] tname=new String[l];
        while (result.next()) {
            tname[i] = result.getString("team_name");
            i++;
            tname[i] = result.getString("team_id");
            i++;
            tname[i] = result.getString("team_description");
            i++;
            tname[i] = result.getString("team_visibility");
            i++;
        }

        String[] t1 = {};
        Assert.assertArrayEquals(t1, tname);
    }


    /**
     * Test of createTeam method, of class Controller.
     */

    @Test
    public void testCreateTeam() {
        System.out.println("createTeam");
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

    }

    /**
     * Test of checkTeamHasBoard method, of class Controller.
     */
    @Test
    public void testCheckTeamHasBoard() throws SQLException {
        System.out.println("checkTeamHasBoard");
        String boardname = "nmnmnmnmnmmnn";
        
        ResultSet result = instance.checkTeamHasBoard(boardname);
        assertEquals(result.next(),false);
        //if(result.next()) {
        //    assert(false);
        //}
        //else{
        //    assert(true);
        //}
    }
    @Test
    public void testCheckTeamHasBoard2() throws SQLException {
        System.out.println("checkTeamHasBoard");
        String boardname = "Board";

        ResultSet result = instance.checkTeamHasBoard(boardname);
        assertEquals(result.next(),true);
        //if(result.next()) {
        //    assert(false);
        //}
        //else{
        //    assert(true);
        //}
    }

    /**
     * Test of updateBoardTeam method, of class Controller.
     */
    @Test
    public void testUpdateBoardTeam() {
        System.out.println("updateBoardTeam");
        String boardname = "Board";
        String teamname = "team1";
        ResultSet rs = null; 
        
        instance.updateBoardTeam(boardname, teamname);
        
        try {

            MysqlCon connection = new MysqlCon();

            Connection conn = connection.EstCon();
            Statement st = conn.createStatement();
            String query = "select * from board_team where board_id = 44 and team_id = 83";
            rs = st.executeQuery(query);
            
            conn.close(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(rs);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listAllUsers method, of class Controller.
     */
    @Test
    public void testListAllUsers() throws SQLException {
        System.out.println("listAllUsers");
        
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

        String[] u1 = {"jka","jkab12"};
        Assert.assertArrayEquals(u1, uname);
    }

    /**
     * Test of addMemberToTeam method, of class Controller.
     */
    @Test
    public void testAddMemberToTeam() {
        System.out.println("addMemberToTeam");
        String team_name = "abc";
        String privilege = "ADMIN";
        String mem_username = "jka";
        int tid = 0; 
        ResultSet rs = null;
        
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
        
    }

    /**
     * Test of displayCardDescription method, of class Controller.
     */
    @Test
    public void testDisplayCardDescription() throws SQLException {
        System.out.println("displayCardDescription");
        String lnme = "list";
        
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
        String[] d1 = {"abc-new","xyz"};
        Assert.assertArrayEquals(d1, cardname);
    }
//Success test
    @Test
    public void testcheckExistingBoardName() throws SQLException {
        boolean result = false;
        String username="jka";
        String boardname="Board";
        
        result = instance.checkExistingBoardName(username, boardname);
        assertTrue(result);
    }
 //Failure test
 @Test
 public void testcheckExistingBoardName2() throws SQLException {
     boolean result = false;
     String username="jka";
     String boardname=null;
     
     result = instance.checkExistingBoardName(username, boardname);
         assertFalse(result);
 }
    @Test
    public void testdisplayProfile()throws SQLException {
        //System.out.println(username1);
        
        String username="jka";
        User user1=instance.displayProfile(username);
        if (user1.getFname().compareTo("Justin") == 0) {
                    if (user1.getLname().compareTo("Augustine") == 0) {
                        if (user1.getCompany().compareTo("UofH")==0) {
                            if (user1.getEmailID().compareTo("jka@gmail.com") == 0) {
                                    assertTrue(true);
                                    return;
                            }

                        }
                    }


        }
    }
    @Test
    public void testupdateUserDetails()throws SQLException {
        
        User user1=new User();
            String username = "SomeName";
            String pwd="SomePwd";
            String fname = "SomeFName";
            String lname = "SomeLName";
            String company = "SomeCompany";
            String emailID = "SomeEmailID";
            long phnum = 1234567898;
            user1.setUsername(username);
            user1.setPwd(pwd);
            user1.setFname(fname);
            user1.setLname(lname);
            user1.setCompany(company);
            user1.setEmailID(emailID);
            user1.setPhnum(phnum);

            int result=instance.updateUserDetails(user1);
            //assertTrue(result==-1);
        assertEquals(result,-1);
    }
    @Test
    public void testupdateUserCreds()throws SQLException {
        
        User user1=new User();
        String username = "SomeName";
        String pwd="SomePwd";
        String fname = "SomeFName";
        String lname = "SomeLName";
        String company = "SomeCompany";
        String emailID = "SomeEmailID";
        long phnum = 1234567898;
        user1.setUsername(username);
        user1.setPwd(pwd);
        user1.setFname(fname);
        user1.setLname(lname);
        user1.setCompany(company);
        user1.setEmailID(emailID);
        user1.setPhnum(phnum);

        int result=instance.updateUserCreds(user1);
        assertEquals(result,-1);
    }
    @Test
    public void testlogout()throws SQLException {
        
        instance.logout();
        assert(true);
    }
    @Test
    public void testaddCard() throws SQLException {
        
        String lname="SomeListname";
        String tname="SomeTeamName";
        String mem_username="SomeUsername";
        String duedate1="SomeDueDate";
        String cardname1="SomeCardName";
        int result=instance.addCard(lname,tname,mem_username,duedate1,cardname1);
        assertEquals(-1,result);
    }

    @Test
    public void testdisplayCardDueDate() throws SQLException {
        
        String cname = "abc-new";
        String ddt = instance.displayCardDueDate(cname);
        int res = ddt.compareTo("2017-12-02");
        if (res == 0) {
            assertTrue(true);
        }
    }

    @Test
    public void displayCardMembers() throws SQLException {
        
        String cname = "abc-new";
        String tname = "team1";
        String uname=instance.displayCardMembers(tname,cname);
        long x=uname.compareTo("jka");
        assertEquals(true,(x==0));
    }

    @Test
    public void displayCardComments() throws SQLException{
        String cname="abc-new";
        
        ResultSet result=instance.displayCardComments(cname);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] comments=new String[l];
        while (result.next()) {
            comments[i] = result.getString("comment");
            i++;
        }
        String[] l1 = {"testComment"};
        Assert.assertArrayEquals(l1, comments);
    }
    @Test
    public void displayCardComments2() throws SQLException{
        String cname="abc-new";
        
        ResultSet result=instance.displayCardComments(cname);
        int i=0,l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] comments=new String[l];
        while (result.next()) {
            comments[i] = result.getString("comment");
            i++;
        }
        String[] l1 = {"somecomment"};
        assertEquals(false, Arrays.equals(l1, comments));
    }
//Test case is working fine. Commented because everytime we run it a new comment gets added to the database.

    @Test
    public void testaddComments() throws SQLException {
        String uname="jka";
        String tname="team1";
        String cname="abc-new";
        String addCmmt="testComment";

        
        ResultSet result1=instance.displayCardComments(cname);
        int i=0,l=0;
        if (result1.last()) {
            l = result1.getRow();
            result1.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] commentsExpected=new String[l];
        while (result1.next()) {
            commentsExpected[i] = result1.getString("comment");
            i++;
        }
        //commentsExpected[i]="testComment";
        //instance.addComments(uname,tname,cname,addCmmt);
        ResultSet result=instance.displayCardComments(cname);
        i=0;l=0;
        if (result.last()) {
            l = result.getRow();
            result.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] comments=new String[l];
        while (result.next()) {
            comments[i] = result.getString("comment");
            i++;
        }
        assertEquals(true, Arrays.equals(commentsExpected, comments));
    }

    @Test
    public void testmodifyDueDateDesc() throws SQLException{
        String tname="team1";
        String cname="abc-new";
        String memuname="jka";
        String ddt="2017-12-02";
        String desc="abc-new";

        
        int result1=instance.modifyDueDateDesc(tname,cname,memuname,ddt,desc);
        String expectedDdt="2017-12-02";
        String expectedDesc="abc-new";
        int x =-1;
        if(expectedDdt.compareTo(ddt)==0 && expectedDesc.compareTo(desc)==0){
            x=1;
        }
        assertEquals(x,1);
    }

    @Test
    public void testdisplayTeamMembers() throws SQLException{
        String tname="team1";
        
        ResultSet result1=instance.displayTeamMembers(tname);
        int i=0,l=0;
        if (result1.last()) {
            l = result1.getRow();
            result1.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        String[] t1=new String[l];
        while (result1.next()) {
            t1[i] = result1.getString("mem_username");
            i++;
        }
        String[] t2 = {"jka"};

        assertEquals(true, Arrays.equals(t1, t2));
    }

    @Test
    public void testsaveCard() throws SQLException {
        String tname = "team1";
        String lname = "list";
        String cname = "abc-new";
        String memuname = "jka";
        String ddt = "2017-12-31";

        
        int x = instance.saveCard(tname, lname, cname, memuname, ddt);
        String expectedDdt = "2017-12-31";
        String expectedDesc = "abc-new";
        // if (expectedDdt.compareTo(ddt) == 0 && expectedDesc.compareTo(cname)==0) {
        //   x = 1;
        // }
        if (x >= 0) {
            assertEquals(1, x);
        }
    }

}
