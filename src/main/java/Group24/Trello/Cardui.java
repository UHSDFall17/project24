package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Cardui extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddDueDate;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cardui frame = new Cardui();
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
	public Cardui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 139, 124);
		panel.setBackground(new Color(102, 102, 153));
		contentPane.add(panel);
		panel.setLayout(null);
		
		String lname = Login.list;
		String tname = Login.team;
		
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		comboBox.setToolTipText("Add Member");
		comboBox.setBounds(380, 231, 331, 32);
		panel.add(comboBox);
		try {
			
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
		
			Class.forName(driver).newInstance();
		   	Connection conn = DriverManager.getConnection(url,userName,Password);
		   	Statement st = conn.createStatement();
		   	String queryString = "SELECT member.mem_username FROM member where member.team_id IN (select team.team_id from team where team.team_name = '"+tname+"');";
		   	ResultSet rs = st.executeQuery(queryString); //where ps is Object of PreparedStatement

		   	while(rs.next()) {
		   		
		   		String member = rs.getString("mem_username");
		   		comboBox.addItem(member);
		   	}
		   	
		   //	comboBox.com
		}
		   	catch (Exception e) {
	        	e.printStackTrace();
	        }
		
		JFormattedTextField cardname = new JFormattedTextField();
		cardname.setFont(new Font("Century Gothic", Font.BOLD, 13));
		cardname.setText("Enter the card description...");
		cardname.setBounds(301, 61, 392, 51);
		panel.add(cardname);
		
		JLabel lblAddMember = new JLabel("Assign Member:");
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setBackground(new Color(255, 255, 255));
		lblAddMember.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblAddMember.setBounds(95, 228, 204, 32);
		panel.add(lblAddMember);
		
		JFormattedTextField duedate = new JFormattedTextField();
		duedate.setHorizontalAlignment(SwingConstants.LEFT);
		duedate.setFont(new Font("Century Gothic", Font.BOLD, 13));
		duedate.setText("yyyy/mm/dd");
		duedate.setBounds(424, 349, 147, 39);
		panel.add(duedate);
		
		String uname= Login.uname;
		String cname = Login.card;		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cardname.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter the Card description !!!");
				else {try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			            Statement st = conn.createStatement();
			            Statement st1 = conn.createStatement();			  
			            	String qu = "select list_id from list where list_name = '"+lname+"';";
			            	ResultSet res = st.executeQuery(qu);		
			            	String lid = null;
			            	String mid = null;
			            	String tid = null;
			            	while (res.next()) {
			            		lid = res.getString("list_id");			            	
			            	}
			            	Statement st3 = conn.createStatement();
			            	String qu3 = "select team_id from team where team_name = '"+tname+"';";
			            	ResultSet res3 = st3.executeQuery(qu3);
			            	while (res3.next()) {
			            		tid = res3.getString("team_id");
			            	}
			            	Statement st2 = conn.createStatement();
			            	String qu2 = "select member_id from member where mem_username = '"+comboBox.getSelectedItem()+"' and team_id = '"+tid+"';";
			            	ResultSet res2 = st2.executeQuery(qu2);
			            	while (res2.next()) {
			            		mid = res2.getString("member_id");
			            	}
			            	st1.executeUpdate("INSERT INTO card " + "VALUES ('"+lid+"','0','"+duedate.getText()+"','"+mid+"','"+cardname.getText()+"') ;");
			            	JOptionPane.showMessageDialog(null, "Card is Created !!!");
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        	JOptionPane.showMessageDialog(null, "Card with the same description is already exist or due date is not correct !!!");
		        }
				
				}
				Login.card=cardname.getText();

			}
		});
		btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSave.setBounds(301, 488, 100, 39);
		panel.add(btnSave);
		
		JButton btnOk = new JButton("BACK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListPage lpg = new ListPage();
				lpg.setVisible(true);
			}
		});
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnOk.setBounds(723, 488, 100, 39);
		panel.add(btnOk);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueDate.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblDueDate.setBackground(Color.WHITE);
		lblDueDate.setBounds(236, 348, 204, 32);
		panel.add(lblDueDate);
		
		
	}

public static DefaultTableModel buildTable(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}	
}