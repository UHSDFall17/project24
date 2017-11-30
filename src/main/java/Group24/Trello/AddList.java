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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddList extends JFrame {

	private JPanel contentPane;
	private JTextField listname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddList frame = new AddList();
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
	public AddList() {
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
		panel.setBackground(new Color(250, 240, 230));
		contentPane.add(panel);
		panel.setLayout(null);
<<<<<<< HEAD
		
		String bnme=Login.board;
		
=======

		String bnme=Login.board;

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
		JLabel lblBoard = new JLabel("BOARD:");
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblBoard.setBounds(273, 123, 99, 34);
		panel.add(lblBoard);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JLabel label = new JLabel(bnme);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(377, 123, 165, 34);
		panel.add(label);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JLabel lblListName = new JLabel("LIST NAME:");
		lblListName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblListName.setBounds(222, 289, 115, 20);
		panel.add(lblListName);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		listname = new JTextField();
		listname.setFont(new Font("Tahoma", Font.BOLD, 20));
		listname.setColumns(10);
		listname.setBounds(358, 282, 239, 34);
		panel.add(listname);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listname.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "All fields are required !");
<<<<<<< HEAD
				else
				try {
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);
			            Statement st = conn.createStatement();
			            Statement st1 = conn.createStatement();			  
			            	String qu = "select BoardID from board where BoardName = '"+bnme+"';";
			            	ResultSet res = st.executeQuery(qu);		
			            	String tn = null;
			            	while (res.next()) {
			            		tn = res.getString("BoardID");			            	
			            	}
			            	st1.executeUpdate("INSERT INTO list " + "VALUES ('0','"+tn+"','"+listname.getText()+"') ;");
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
=======
				else {
					String list_name;
					list_name = listname.getText();
					try {
						Controller c1 = new Controller();
						ResultSet rs = c1.creatingList(bnme,list_name);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
>>>>>>> Nikhita
				Login.list=listname.getText();
				dispose();
				ListPage lpa = new ListPage();
				lpa.setVisible(true);
<<<<<<< HEAD
				
=======

>>>>>>> Nikhita
			}
		});
		btnAdd.setForeground(new Color(0, 51, 102));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(324, 432, 176, 48);
		panel.add(btnAdd);
<<<<<<< HEAD
		
=======

>>>>>>> Nikhita
		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setForeground(Color.BLACK);
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTeam.setBounds(285, 67, 99, 34);
		panel.add(lblTeam);
<<<<<<< HEAD
		
		String tnm= Login.team;
		
=======

		String tnm= Login.team;

>>>>>>> Nikhita
		JLabel label_1 = new JLabel(tnm);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(377, 63, 165, 34);
		panel.add(label_1);
<<<<<<< HEAD
		

		
	}
}
=======



	}
}
>>>>>>> Nikhita
