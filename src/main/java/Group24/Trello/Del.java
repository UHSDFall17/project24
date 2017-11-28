package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Del extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Del frame = new Del();
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
	public Del() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBounds(-11, 0, 900, 625);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		String username = Login.uname;
		
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
		
		JLabel lblDelete = new JLabel("DELETE TEAM:");
		lblDelete.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDelete.setBounds(234, 150, 139, 20);
		panel.add(lblDelete);
		
		JComboBox teamBox = new JComboBox();
		teamBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		teamBox.setBounds(388, 143, 162, 35);
		panel.add(teamBox);
		
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
		
		JButton TeamDelButton = new JButton("DELETE");
		TeamDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			            Statement statement = conn.createStatement();
			            Statement st = conn.createStatement();
			            Statement st1 = conn.createStatement();
			            Statement st2 = conn.createStatement();
			        	String pri = null;
			        	Statement st4 = conn.createStatement();
			        	String qu = "select privilege from member where mem_username='"+username+"' and team_id in( select team_id from team where team_name='"+teamBox.getSelectedItem()+"');";
			        	ResultSet res = st4.executeQuery(qu);
			        	while (res.next()) {
			        		pri = res.getString("privilege");			        		
			        	}
			        	if (pri.equals("ADMIN")) {
			            String query="SELECT team_id FROM team where team_name = '" +teamBox.getSelectedItem()+"';";
			            ResultSet rs=statement.executeQuery(query);
			            while (rs.next()) {
			            	String tname = rs.getString("team_id");
			            	st.executeUpdate("delete from member where team_id= '" +tname+"';");
			            	st1.executeUpdate("delete from board_team where team_id= '" +tname+"';");
			            	}
			            st2.executeUpdate("delete from team where team_name= '" +teamBox.getSelectedItem()+"';");
			            JOptionPane.showMessageDialog(null, "TEAM DELETED !!!");}
			        	else {
			        		JOptionPane.showMessageDialog(null, "Only Admin can delete the team !!!");
			        	}
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
			}
		});
		TeamDelButton.setBounds(613, 143, 115, 35);
		panel.add(TeamDelButton);
		
		JLabel lblDeleteBoard = new JLabel("DELETE BOARD:");
		lblDeleteBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDeleteBoard.setBounds(222, 227, 139, 20);
		panel.add(lblDeleteBoard);
		
		JComboBox boardBox = new JComboBox();
		boardBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		boardBox.setBounds(388, 220, 162, 35);
		panel.add(boardBox);
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	            Statement statement = conn.createStatement();
	            String query="select BoardName from board where username='"+username+"';";
	            ResultSet rs=statement.executeQuery(query);
	            while (rs.next()) {
	            	String bname = rs.getString("BoardName");
	            	boardBox.addItem(bname);
	            	}
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		
		JButton button = new JButton("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			        	String pri = null;
			        	Statement st = conn.createStatement();
			        	String qu = "select privilege from board where username='"+username+"' and BoardName='"+boardBox.getSelectedItem()+"';";
			        	ResultSet res = st.executeQuery(qu);
			        	while (res.next()) {
			        		pri = res.getString("privilege");			        		
			        	}
			        	if (pri.equals("ADMIN")) {
			            Statement statement = conn.createStatement();
			            statement.executeUpdate("delete from board where BoardName='"+boardBox.getSelectedItem()+"' and username='"+username+"';") ;
			            JOptionPane.showMessageDialog(null, "REMOVED !!!");
			            }	else {
			            	JOptionPane.showMessageDialog(null, "Only Admin can delete Board !!!");
			            }        	
			       
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
			
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
			
				
			}
		});
		button.setBounds(613, 220, 115, 35);
		panel.add(button);
		
		JLabel lblRemoveMember = new JLabel("SELECT TEAM:");
		lblRemoveMember.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblRemoveMember.setBounds(19, 315, 146, 20);
		panel.add(lblRemoveMember);
		
		JComboBox tbox = new JComboBox();
		tbox.setFont(new Font("Tahoma", Font.BOLD, 18));
		tbox.setBounds(166, 308, 162, 35);
		panel.add(tbox);
		
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
	            String tname = null;
	            while (rs.next()) {
	            	tname = rs.getString("team_name");
	            	tbox.addItem(tname);
	            	           }	        		       
		}catch(Exception e) {
        	e.printStackTrace();
        }	

		
		JComboBox mbox = new JComboBox();
		mbox.setFont(new Font("Tahoma", Font.BOLD, 18));
		mbox.setBounds(349, 387, 162, 35);
		panel.add(mbox);
					
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	        	String ttid = null;
	        	Statement st = conn.createStatement();
	        	String qu = "select team_id from team where team_name = '"+tbox.getSelectedItem()+"';";
	        	ResultSet res = st.executeQuery(qu);
	        	while (res.next()) {
	        		ttid = res.getString("team_id");
	        	}
	            Statement statement = conn.createStatement();
	            String query= "SELECT mem_username from member where team_id = '"+ttid+"';";
	            ResultSet rs=statement.executeQuery(query);
	            String ame = null;
	            while (rs.next()) {
	            	ame = rs.getString("mem_username");
	            	mbox.addItem(ame);
	            	           }	        	
	       
		}catch(Exception e1) {
        	e1.printStackTrace();
        }
	
		
		
		
		JLabel lblMember = new JLabel("SELECT MEMBER:");
		lblMember.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMember.setBounds(166, 394, 154, 20);
		panel.add(lblMember);
	
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			        	String pri = null;
			        	Statement st = conn.createStatement();
			        	String qu = "select privilege from member where mem_username='"+username+"' and team_id in( select team_id from team where team_name='"+tbox.getSelectedItem()+"');";
			        	ResultSet res = st.executeQuery(qu);
			        	while (res.next()) {
			        		pri = res.getString("privilege");			        		
			        	}
			        	if (pri.equals("ADMIN")) {
			            Statement statement = conn.createStatement();
			            statement.executeUpdate("delete from member where team_id in( select team_id from team where team_name='"+tbox.getSelectedItem()+"') and  mem_username='"+mbox.getSelectedItem()+"';") ;
			            JOptionPane.showMessageDialog(null, "REMOVED !!!");
			            }	else {
			            	JOptionPane.showMessageDialog(null, "Only Admin can delete member !!!");
			            }        	
			       
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
			
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
			}
		});
		btnRemove.setBounds(597, 388, 115, 35);
		panel.add(btnRemove);
		
		JLabel lblSelectBoard = new JLabel("SELECT BOARD:");
		lblSelectBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelectBoard.setBounds(181, 484, 139, 20);
		panel.add(lblSelectBoard);
		
		JComboBox bBox = new JComboBox();
		bBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		bBox.setBounds(349, 471, 162, 35);
		panel.add(bBox);
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	        	String bname = null;
	        	Statement st = conn.createStatement();
	        	String qu = "select BoardName from board where BoardID in (select board_id from board_team where team_id in (select team_id from team where team_name='"+tbox.getSelectedItem()+"'));";
	        	ResultSet res = st.executeQuery(qu);
	        	while (res.next()) {
	        		bname = res.getString("BoardName");	        	
	            	bBox.addItem(bname);
	            	           }	        	
	       
		}catch(Exception e1) {
        	e1.printStackTrace();
        }
		
		JButton button_1 = new JButton("REMOVE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			        	String pri = null;
			        	Statement st = conn.createStatement();
			        	String qu = "select privilege from board where username='"+username+"' and BoardName='"+bBox.getSelectedItem()+"';";
			        	ResultSet res = st.executeQuery(qu);
			        	while (res.next()) {
			        		pri = res.getString("privilege");			        		
			        	}
			        	if (pri.equals("ADMIN")) {
			            Statement statement = conn.createStatement();
			            statement.executeUpdate("delete from board_team where board_id in (select BoardID from board where BoardName='"+bBox.getSelectedItem()+"') and team_id in (select team_id from team where team_name='"+tbox.getSelectedItem()+"');") ;
			            JOptionPane.showMessageDialog(null, "REMOVED !!!");
			            }	else {
			            	JOptionPane.showMessageDialog(null, "Only Admin can delete Board !!!");
			            }        	
			       
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
			
				
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
				
			}
		});
		button_1.setBounds(597, 475, 115, 35);
		panel.add(button_1);
	}
}
