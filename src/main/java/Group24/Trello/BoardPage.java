package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class BoardPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardPage frame = new BoardPage();
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
	public BoardPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 639, 424);
		panel.setBackground(new Color(0, 206, 209));
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		
		JLabel lblBoardPageFor = new JLabel("BOARD PAGE FOR:");
		lblBoardPageFor.setForeground(Color.BLACK);
		lblBoardPageFor.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblBoardPageFor.setBounds(173, 16, 197, 34);
		panel.add(lblBoardPageFor);
		
		String bname = Login.board;
		
		JLabel label = new JLabel(bname);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(373, 16, 165, 34);
		panel.add(label);
		
		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setForeground(Color.BLACK);
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTeam.setBounds(173, 64, 76, 34);
		panel.add(lblTeam);
		
		String tname = Login.team;
		
		JLabel label_1 = new JLabel(tname);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(251, 64, 165, 34);
		panel.add(label_1);
		
		JButton btnCreateNewList = new JButton("Create new list");
		btnCreateNewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddList adl = new AddList();
				adl.setVisible(true);
			}
		});
		btnCreateNewList.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnCreateNewList.setBackground(new Color(50, 205, 50));
		btnCreateNewList.setBounds(38, 253, 197, 117);
		panel.add(btnCreateNewList);
		
		JLabel lblLists = new JLabel("LISTS");
		lblLists.setForeground(Color.BLACK);
		lblLists.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblLists.setBounds(509, 165, 95, 34);
		panel.add(lblLists);
		
		 DefaultListModel listModel = new DefaultListModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 219, 313, 340);
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 20));
		list.setModel(listModel);
		
		JButton button = new JButton("GO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.list=list.getSelectedValue().toString();
				dispose();
				ListPage lpg = new ListPage();
				lpg.setVisible(true);
			}
		});
		button.setBounds(738, 343, 95, 49);
		panel.add(button);
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	            Statement statement = conn.createStatement();
	            Statement st2 = conn.createStatement();
	            String quu = "select BoardID from board where BoardName = '"+bname+"';";
	            ResultSet rst = st2.executeQuery(quu);
	            String bdid = null;
	            while(rst.next()) {
	            	String tid = rst.getString("BoardID");
	            	String query="select list_name from list where board_id ='"+tid+"';";
	            	ResultSet rs=statement.executeQuery(query);	           
	            	while (rs.next()) {
		            	bdid = rs.getString("list_name");
		                listModel.addElement(bdid);
	            	}     
	            }	
	        
		}catch(Exception e) {
        	e.printStackTrace();
        }	
		
	}
}
	

