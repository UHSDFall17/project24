package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddTeamMem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeamMem frame = new AddTeamMem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddTeamMem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBounds(-11, 0, 900, 625);
		panel.setBackground(new Color(60, 179, 113));
		contentPane.add(panel);
		panel.setLayout(null);
<<<<<<< HEAD
		
		String username = Login.uname;
		
=======

		String username = Login.uname;

>>>>>>> Nikhita
		JLabel lblAddTeamMembers = new JLabel("ADD TEAM MEMBERS");
		lblAddTeamMembers.setForeground(Color.WHITE);
		lblAddTeamMembers.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblAddTeamMembers.setBounds(360, 16, 287, 34);
		panel.add(lblAddTeamMembers);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JLabel lblSelectTeam = new JLabel("SELECT TEAM:");
		lblSelectTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelectTeam.setBounds(386, 123, 123, 20);
		panel.add(lblSelectTeam);
<<<<<<< HEAD
		
		JComboBox TeamBox = new JComboBox();
		TeamBox.setBounds(570, 117, 263, 35);
		panel.add(TeamBox);
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	            Statement statement = conn.createStatement();
	            String query="select team.team_name from team where team.team_id IN (select member.team_id from member where member.mem_username='"+username+"');";
	            ResultSet rs=statement.executeQuery(query); 
	            while (rs.next()) {
	            	String teamname = rs.getString("team_name");
	            	TeamBox.addItem(teamname);
	            	}
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
=======

		JComboBox TeamBox = new JComboBox();
		TeamBox.setBounds(570, 117, 263, 35);
		panel.add(TeamBox);

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.listMyTeam(username);
			while (rs.next()) {
				String tname = rs.getString("team_name");
				TeamBox.addItem(tname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

>>>>>>> Nikhita
		JLabel lblSelectTeamMembers = new JLabel("SELECT TEAM MEMBERS:");
		lblSelectTeamMembers.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelectTeamMembers.setBounds(301, 233, 208, 20);
		panel.add(lblSelectTeamMembers);
<<<<<<< HEAD
		
		JComboBox MemberBox = new JComboBox();
		MemberBox.setBounds(570, 227, 263, 35);
		panel.add(MemberBox);
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	            Statement statement = conn.createStatement();
	            String query="SELECT  username from userdetails;";
	            ResultSet rs=statement.executeQuery(query); 
	            while (rs.next()) {
	            	String membername = rs.getString("username");
	            	MemberBox.addItem(membername);
	            	}
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
=======

		JComboBox MemberBox = new JComboBox();
		MemberBox.setBounds(570, 227, 263, 35);
		panel.add(MemberBox);

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.listAllUsers();
			while (rs.next()) {
				String membername = rs.getString("username");
				MemberBox.addItem(membername);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}


>>>>>>> Nikhita
		JLabel lblPrivilege = new JLabel("PRIVILEGE:");
		lblPrivilege.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPrivilege.setBounds(404, 370, 105, 20);
		panel.add(lblPrivilege);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JComboBox priBox = new JComboBox();
		priBox.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "ADMIN"}));
		priBox.setBounds(570, 364, 263, 35);
		panel.add(priBox);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JButton btnAddMember = new JButton("ADD MEMBER");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
<<<<<<< HEAD
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			            Statement statement = conn.createStatement();
			            String query="SELECT  team_id from team where team_name = '" + TeamBox.getSelectedItem()+"';";
			            ResultSet rs=statement.executeQuery(query); 
			            String teamid =null;
			            while (rs.next()) {
			            	teamid = rs.getString("team_id");
			            	}
			            statement.executeUpdate("INSERT INTO member " + "VALUES ('0','"+teamid+"','"+priBox.getSelectedItem()+"','"+MemberBox.getSelectedItem()+"');");
			            JOptionPane.showMessageDialog(null, "MEMBER ADDED !!!");
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        	JOptionPane.showMessageDialog(null, "ALREADY A MEMBER !!!");
		        }
				
				
=======

					String teamname=(String) TeamBox.getSelectedItem();
					String privilege=(String) priBox.getSelectedItem();
					String mem_username=(String) MemberBox.getSelectedItem();

					Controller c1 = new Controller();
					c1.addMemberToTeam(teamname, privilege, mem_username);
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}




				JOptionPane.showMessageDialog(null, "MEMBER ADDED !!!");

>>>>>>> Nikhita
			}
		});
		btnAddMember.setForeground(new Color(0, 51, 102));
		btnAddMember.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnAddMember.setBackground(Color.WHITE);
		btnAddMember.setBounds(350, 465, 208, 48);
		panel.add(btnAddMember);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JButton home = new JButton("HOME");
		home.setFont(new Font("Tahoma", Font.BOLD, 20));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);	
			}
		});
		home.setBounds(19, 47, 115, 75);
		panel.add(home);
<<<<<<< HEAD
		

		


	}
}
=======





	}
}
>>>>>>> Nikhita
