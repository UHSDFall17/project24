package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class TeamBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBoard frame = new TeamBoard();
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
	public TeamBoard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
<<<<<<< HEAD
		
		String username = Login.uname;
		String teamname = Login.team;
		String boardname = Login.board;
		
=======

		String username = Login.uname;
		String teamname = Login.team;
		String boardname = Login.board;

>>>>>>> Nikhita
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 639, 424);
		panel.setBackground(new Color(60, 179, 113));
		contentPane.add(panel);
		panel.setLayout(null);
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
		
=======

>>>>>>> Nikhita
		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeam.setBounds(393, 152, 65, 20);
		panel.add(lblTeam);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JLabel lblBoard = new JLabel("BOARD:");
		lblBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblBoard.setBounds(382, 243, 65, 20);
		panel.add(lblBoard);
<<<<<<< HEAD
		
		JComboBox teamBox = new JComboBox();
		teamBox.setBounds(474, 146, 205, 35);
		panel.add(teamBox);
		
		JComboBox boardBox = new JComboBox();
		boardBox.setBounds(474, 241, 205, 35);
		panel.add(boardBox);
		
=======

		JComboBox teamBox = new JComboBox();
		teamBox.setBounds(474, 146, 205, 35);
		panel.add(teamBox);

		JComboBox boardBox = new JComboBox();
		boardBox.setBounds(474, 241, 205, 35);
		panel.add(boardBox);

>>>>>>> Nikhita
		JButton btnAdd = new JButton("ADD ");
		btnAdd.addActionListener(new ActionListener() {
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
			            String query= "select BoardID from board where BoardName= '"+boardBox.getSelectedItem()+"';";
			            ResultSet rs=statement.executeQuery(query);
			            String teamid = null;
			            String boardid = null;
			            while (rs.next()) {
			            	boardid = rs.getString("BoardID");
			            	}
			            Statement st = conn.createStatement();
			            String qry="SELECT * FROM board_team where board_id = '" +boardid+"';";
			            ResultSet rset=st.executeQuery(qry); 
			            if (rset.next()) {
			            	JOptionPane.showMessageDialog(null, "Board is already allocated to a Team !!!!!!" );
		                	conn.close();
		                	return;
			            }
			            Statement st1 = conn.createStatement();
			            String query1= "select team_id from team where team_name= '"+teamBox.getSelectedItem()+"';";
 			            ResultSet rs1=st1.executeQuery(query1);
			            if(rs1.next()) {
			            	teamid = rs1.getString("team_id");		            
			            }
				        statement.executeUpdate("INSERT INTO board_team " + "VALUES ('"+boardid+"','"+teamid+"') ;");
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
=======
					String teamname = null;
					String boardname = null;

					Controller c1= new Controller();

					boardname=(String) boardBox.getSelectedItem();
					ResultSet rs=c1.checkTeamHasBoard(boardname);


					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Board is already allocated to a Team !!!!!!" );

						return;
					}

					teamname=(String) teamBox.getSelectedItem();
					c1.updateBoardTeam(boardname, teamname);

				}catch(Exception e1) {
					e1.printStackTrace();
				}
>>>>>>> Nikhita
				JOptionPane.showMessageDialog(null, "ADDED !!!");
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
<<<<<<< HEAD
				
=======

>>>>>>> Nikhita
			}
		});
		btnAdd.setForeground(new Color(0, 51, 102));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(323, 433, 174, 48);
		panel.add(btnAdd);
<<<<<<< HEAD
		
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
		            	String tname = rs.getString("team_name");
		            	teamBox.addItem(tname);
		            	}
			}catch(Exception e) {
	        	e.printStackTrace();
	        }
			
			try {
				String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
		        String dbName = "trello1";//databese name
		        String driver = "com.mysql.cj.jdbc.Driver";
		        String userName = "root";
		        String Password = "trello";// password
		        
		        
		        	Class.forName(driver).newInstance();
		        	Connection conn = DriverManager.getConnection(url,userName,Password);
		            Statement statement = conn.createStatement();
		            String query="select BoardName from board where username= '"+username+"';";
		            ResultSet rs=statement.executeQuery(query);
		            while (rs.next()) {
		            	String tname = rs.getString("BoardName");
		            	boardBox.addItem(tname);
		            	}
			}catch(Exception e) {
	        	e.printStackTrace();
	        }
		}
}
=======

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.listMyTeam(username);
			while (rs.next()) {
				String tname = rs.getString("team_name");
				teamBox.addItem(tname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.checkExistingBoard(username);
			while (rs.next()) {
				String bname = rs.getString("BoardName");
				boardBox.addItem(bname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
>>>>>>> Nikhita
