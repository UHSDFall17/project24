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
			MysqlCon connection = new MysqlCon();
			Connection conn = connection.EstCon();
	            Statement statement = conn.createStatement();
	            String query="select team.team_name from team where team.team_id IN (select member.team_id from member where member.mem_username='"+username+"');";
	            ResultSet rs=statement.executeQuery(query);
	            while (rs.next()) {
	            	String tname = rs.getString("team_name");
	            	teamBox.addItem(tname);
	            	}
	            	conn.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		JButton TeamDelButton = new JButton("DELETE");
		TeamDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MysqlCon connection = new MysqlCon();
					Connection conn = connection.EstCon();
			            Statement statement = conn.createStatement();
			            Statement st = conn.createStatement();
			            Statement st1 = conn.createStatement();
			            Statement st2 = conn.createStatement();
			            String query="SELECT team_id FROM team where team_name = '" +teamBox.getSelectedItem()+"';";
			            ResultSet rs=statement.executeQuery(query);
			            while (rs.next()) {
			            	String tname = rs.getString("team_id");
			            	st.executeUpdate("delete from member where team_id= '" +tname+"';");
			            	st1.executeUpdate("delete from board_team where team_id= '" +tname+"';");
			            	}
			            st2.executeUpdate("delete from team where team_name= '" +teamBox.getSelectedItem()+"';");
			            conn.close();
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
				JOptionPane.showMessageDialog(null, "TEAM DELETED !!!");
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
			MysqlCon connection = new MysqlCon();
			Connection conn = connection.EstCon();
	            Statement statement = conn.createStatement();
	            String query="select BoardName from board where username='"+username+"');";
	            ResultSet rs=statement.executeQuery(query);
	            while (rs.next()) {
	            	String bname = rs.getString("BoardName");
	            	boardBox.addItem(bname);
	            	}
	            	conn.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		
		JButton button = new JButton("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MysqlCon connection = new MysqlCon();
					Connection conn = connection.EstCon();
			            Statement statement = conn.createStatement();
			            Statement st = conn.createStatement();
			            Statement st1 = conn.createStatement();
			            Statement st2 = conn.createStatement();
			            String query="SELECT BoardID FROM board where BoardName = '" +boardBox.getSelectedItem()+"';";
			            ResultSet rs=statement.executeQuery(query);
			            while (rs.next()) {
			            	String bname = rs.getString("BoardID");
			            	st1.executeUpdate("delete from board_team where BoardID= '" +bname+"';");
			            	}
			            st2.executeUpdate("delete from board where BoardName= '" +boardBox.getSelectedItem()+"';");
			            conn.close();
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
				JOptionPane.showMessageDialog(null, "BOARD DELETED !!!");
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);				
			}
		});
		button.setBounds(613, 220, 115, 35);
		panel.add(button);
		
		JLabel lblRemoveMember = new JLabel("REMOVE MEMBER FROM TEAM:");
		lblRemoveMember.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblRemoveMember.setBounds(115, 322, 282, 20);
		panel.add(lblRemoveMember);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_1.setBounds(110, 358, 162, 35);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_2.setBounds(418, 358, 162, 35);
		panel.add(comboBox_2);
		
		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeam.setBounds(28, 366, 60, 20);
		panel.add(lblTeam);
		
		JLabel lblMember = new JLabel("MEMBER:");
		lblMember.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMember.setBounds(317, 365, 86, 20);
		panel.add(lblMember);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(649, 359, 115, 35);
		panel.add(btnRemove);
	}

}
