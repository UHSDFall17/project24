package Group24.Trello;

import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;

import Group24.Trello.Homepage;
import Group24.Trello.MysqlCon;
import Group24.Trello.*;
import com.mysql.cj.api.mysqla.result.Resultset;

public class Controller {


	public boolean checkForUser(User user) {
		boolean result = false;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();

			Statement st = conn.createStatement();
			String sql1;
			String username1 = user.getUsername();
			String pwd1 = user.getPwd();
			sql1 = "Select username from usercreds where username = '" + username1 + "' and pwd='"+pwd1+"'" ;
			ResultSet results = st.executeQuery(sql1); //where ps is Object of PreparedStatement

			result = results.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int SaveUserDetails(User user) {
		int result1=-1;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			String sql1,sql2;
			String username = user.getUsername();
			String fname = user.getFname();
			String lname = user.getLname();
			String pwd = user.getPwd();
			String company = user.getCompany();
			String emailID = user.getEmailID();
			long phnum = user.getPhnum();

			sql1 = "INSERT INTO userdetails(fname,lname,company,emailID,phnum,username)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, company);
			pstmt.setString(4, emailID);
			pstmt.setLong(5, phnum);
			pstmt.setString(6, username);
			result1=pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result1;
	}

	public int SaveUserCreds(User user) {
		int result1=-1;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			String sql1,sql2;
			String username = user.getUsername();
			String pwd = user.getPwd();
			sql1 = "INSERT INTO usercreds(username,pwd)"
					+ "VALUES(?,?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(2, pwd);
			pstmt1.setString(1, username);
			result1=pstmt1.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result1;
	}

	public boolean checkForExistingUser(String username1) {
		boolean result = false;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();

			Statement st = conn.createStatement();
			String sql1;
			sql1 = "Select username from usercreds where username = '" + username1 + "' ;" ;
			ResultSet results = st.executeQuery(sql1); //where ps is Object of PreparedStatement

			result = results.next();
			//   System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public ResultSet checkExistingTeam(String username) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select team.team_name from team where team.team_id IN (select member.team_id from member where member.mem_username='"+username+"');";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	public ResultSet checkExistingBoard(String username) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select BoardName from board where username='"+username+"';";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	public ResultSet fetchingBoardDetails(String BoardName1) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select team_name from team where team_id in (select team_id from board_team where board_id in (select BoardID from board where BoardName = '"+BoardName1+"'));";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet displayingBoardsForTeam(String teamname1) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="SELECT BoardName from board where BoardID in (select board_id from board_team where team_id in (select team_id from team where team_name='"+teamname1+"'));";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet displayingTeamMembers(String teamname) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select mem_username from member where team_id in(select team_id from team where team_name='"+teamname+"');";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet displayListsInBoard(String bname) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select list_name from list where board_id in (select BoardID from board where BoardName = '"+bname+"');";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet creatingList(String bname, String list_name) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1,sql2;


			sql1="select BoardID from board where BoardName = '"+bname+"';";
			rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement
			String tn = null;
			while (rs.next()) {
				tn = rs.getString("BoardID");
			}
			sql2="INSERT INTO list " + "VALUES ('0','" + tn + "','" + list_name + "') ;";
			st.executeUpdate(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void createBoard(Board board) {
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();

			String sql1;
			String username = board.getUsername();
			String privacy = board.getPrivacy();
			String privilege = board.getPrivilege();
			String boardname = board.getBoardName();

			sql1 = "INSERT INTO board(BoardName,BoardID,privacy,username,privilege)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, boardname);
			pstmt.setString(2, "0");
			pstmt.setString(3, privacy);
			pstmt.setString(4, username);
			pstmt.setString(5, privilege);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet listMyTeam(String username) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select team.team_name from team where team.team_id IN (select member.team_id from member where member.mem_username='"+username+"');";   rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement
			rs = st.executeQuery(sql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet displayTeamcreds(String teamname1) {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="SELECT * FROM team where team_name = '" + teamname1 +"';";
			rs = st.executeQuery(sql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void createTeam(Team_cre team1,String username) {
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();

			String sql1,sql2,sql3;
			String team_name=team1.getTeam_name();
			String team_description=team1.getTeam_description();
			List<String> team_members=team1.getTeam_members();
			String team_visibility="PUBLIC";

			sql1 = "INSERT INTO team(team_id,team_name,team_description,team_visibility)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(2, team_name);
			pstmt.setString(3, team_description);
			pstmt.setString(4, team_visibility);
			pstmt.setString(1, "0");
			pstmt.executeUpdate();

			sql2 ="SELECT team_id FROM team where team_name = '" + team_name +"';";
			ResultSet rs1=st.executeQuery(sql2);
			if(rs1.next()) {
				int tid = rs1.getInt("team_id");
				sql3= "INSERT INTO member " + "VALUES ('0','"+tid+"','ADMIN','"+username+"') ;";
				st.executeUpdate(sql3);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet checkTeamHasBoard(String boardname) {
		ResultSet rset = null;
		try{MysqlCon connection = new MysqlCon();
		Connection conn = connection.EstCon();
		Statement st = conn.createStatement();
		String query= "SELECT board_id FROM board_team where board_id in (select BoardID from board where BoardName= '"+boardname+"');";
		rset= st.executeQuery(query);
		//System.out.println(rset.getString("board_id"));
		}catch(Exception e1) {
			e1.printStackTrace();
		}return rset;
	}

	public void updateBoardTeam(String boardname, String teamname) {
		try{
			MysqlCon connection = new MysqlCon();
			Connection conn = connection.EstCon();

			//System.out.println(teamname);
			Statement st1 = conn.createStatement();
			String teamid = null;
			String boardid = null;

			String query= "select BoardID from board where BoardName='"+boardname+"';";
			ResultSet rs=st1.executeQuery(query);

			while (rs.next()) {
				boardid = rs.getString("BoardID");
			}
			String query1= "select team_id from team where team_name= '"+teamname+"';";
			ResultSet rs1=st1.executeQuery(query1);
			if(rs1.next()) {
				teamid = rs1.getString("team_id");
			}
			//  System.out.println(teamid);
			st1.executeUpdate("INSERT INTO board_team " + "VALUES ('"+boardid+"','"+teamid+"') ;");

		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public ResultSet listAllUsers() {
		ResultSet rs=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="SELECT  username from userdetails;";
			rs = st.executeQuery(sql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void addMemberToTeam(String team_name,String privilege, String mem_username) {
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();

			String sql1,sql2;

			sql1 ="SELECT team_id FROM team where team_name = '" + team_name +"';";
			ResultSet rs1=st.executeQuery(sql1);
			if(rs1.next()) {
				int tid = rs1.getInt("team_id");
				sql2= "INSERT INTO member " + "VALUES ('0','"+tid+"','"+privilege+"','"+mem_username+"') ;";
				st.executeUpdate(sql2);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ResultSet displayCardDescription(String lnme) {
		ResultSet rst=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select description from card where car_list_id IN (select list_id from list where list_name = '"+lnme+"');";
			rst = st.executeQuery(sql1);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	public boolean checkExistingBoardName(String username, String boardname) {
		boolean rst=false;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;


			sql1="select BoardName from board where username='"+username+"' and BoardName='"+boardname+"';";
			ResultSet rs = st.executeQuery(sql1); //where ps is Object of PreparedStatement
			rst=rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

	public User displayProfile(String username1) {

		//System.out.println(username1);

		User user= new User();
		ResultSet rst=null;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String sql1;
			String fame=null;
			String lame=null;
			String comp=null;
			String email=null;
			Long phnum=null;




			sql1 = "Select fname,lname,company,emailID,phnum from userdetails where username='"+username1+"';";
			rst = st.executeQuery(sql1);
			while (rst.next()) {
				fame = rst.getString("fname");
				lame = rst.getString("lname");
				comp = rst.getString("company");
				email = rst.getString("emailID");
				phnum = rst.getLong("phnum");
			}
			user.setFname(fame);
			user.setLname(lame);
			user.setCompany(comp);
			user.setEmailID(email);
			user.setPhnum(phnum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int updateUserDetails(User user) {
		int result1=-1;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			String sql1;
			String username = user.getUsername();
			String fname = user.getFname();
			String lname = user.getLname();
			String company = user.getCompany();
			String emailID = user.getEmailID();
			long phnum = user.getPhnum();



			sql1 = "update userdetails set fname = '"+fname+"' , lname = '"+lname+"', company = '"+company+"', emailID = '"+emailID+"', phnum = '"+phnum+"' where username = '"+username+"';";

			/*   PreparedStatement pstmt = conn.prepareStatement(sql1);
            pstmt.setString(6, username);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, company);
            pstmt.setString(4, emailID);
            pstmt.setLong(5, phnum);
            pstmt.executeUpdate();*/




			Statement st = conn.createStatement();
			st.executeUpdate(sql1);
			//  conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result1;
	}


	public int updateUserCreds(User user) {
		int result1=-1;
		try {

			MysqlCon connection = new MysqlCon();

			Connection conn = connection.EstCon();
			String sql1;
			String username = user.getUsername();
			String pwd = user.getPwd();
			sql1 = "update usercreds set pwd = '"+pwd+"'  where username = '"+username+"';";
			Statement st = conn.createStatement();
			st.executeUpdate(sql1);
			//  conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result1;
	}

}







