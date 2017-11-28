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
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
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
		
		String uname = Login.uname;
		
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
		
		JLabel lblFirstName = new JLabel("FIRST NAME: ");
		lblFirstName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblFirstName.setBounds(191, 37, 121, 20);
		panel.add(lblFirstName);
		
		JTextPane fname = new JTextPane();
		fname.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		fname.setBounds(315, 26, 451, 52);
		panel.add(fname);
		
		JLabel lblLastName = new JLabel("LAST NAME: ");
		lblLastName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblLastName.setBounds(199, 117, 113, 20);
		panel.add(lblLastName);
		
		JTextPane lname = new JTextPane();
		lname.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lname.setBounds(315, 106, 451, 52);
		panel.add(lname);
		
		JLabel lblCompany = new JLabel("COMPANY: ");
		lblCompany.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCompany.setBounds(217, 204, 95, 20);
		panel.add(lblCompany);
		
		JTextPane company = new JTextPane();
		company.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		company.setBounds(315, 188, 451, 52);
		panel.add(company);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER: ");
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPhoneNumber.setBounds(165, 352, 147, 20);
		panel.add(lblPhoneNumber);
		
		JTextPane pnumber = new JTextPane();
		pnumber.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		pnumber.setBounds(315, 340, 451, 52);
		panel.add(pnumber);
		
		JTextPane emailt = new JTextPane();
		emailt.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		emailt.setBounds(315, 266, 451, 52);
		panel.add(emailt);
		
		
		JLabel lblPassword = new JLabel("PASSWORD: ");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPassword.setBounds(191, 430, 109, 20);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 21));
		password.setBounds(315, 413, 451, 52);
		panel.add(password);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					long num = Integer.parseInt(pnumber.getText());					
					if (!(num>999999999 && num<10000000000L)) {
					JOptionPane.showMessageDialog(null, "Invalid phone number" );
						}
					String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
			        String dbName = "trello1";//databese name
			        String driver = "com.mysql.cj.jdbc.Driver";
			        String userName = "root";
			        String Password = "trello";// password
			        
			        
			        	Class.forName(driver).newInstance();
			        	Connection conn = DriverManager.getConnection(url,userName,Password);			        	
			        	Statement st = conn.createStatement();
			        	st.executeUpdate("update userdetails set fname = '"+fname.getText()+"' , lname = '"+lname.getText()+"', company = '"+company.getText()+"', emailID = '"+emailt.getText()+"', phnum = '"+pnumber.getText()+"' where username = '"+uname+"';");     	
			        	JOptionPane.showMessageDialog(null, "Profile Modified" ); 
				}catch(Exception e1) {
		        	e1.printStackTrace();
		        }
			
				
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);
				
			
				
				
			}
		});
		btnEdit.setForeground(new Color(0, 51, 102));
		btnEdit.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(249, 481, 147, 48);
		panel.add(btnEdit);
		
		JLabel lblEmailid = new JLabel("EMAIL ID:");
		lblEmailid.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEmailid.setBounds(217, 283, 95, 20);
		panel.add(lblEmailid);		
		
		try {
			String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	        String dbName = "trello1";//databese name
	        String driver = "com.mysql.cj.jdbc.Driver";
	        String userName = "root";
	        String Password = "trello";// password
	        
	        
	        	Class.forName(driver).newInstance();
	        	Connection conn = DriverManager.getConnection(url,userName,Password);
	            Statement st1 = conn.createStatement();	  
	            			
	            	String fame = null;
	            	String lame = null;
	            	String comp = null;
	            	String email = null;
	            	String phnum = null;
	            	Statement st3 = conn.createStatement();
	            	String qu3 = "select fname from userdetails where username = '"+uname+"';";
	            	ResultSet res3 = st3.executeQuery(qu3);
	            	while (res3.next()) {
	            		fame = res3.getString("fname");
	            	}
	            	Statement st2 = conn.createStatement();
	            	String qu2 = "select lname from userdetails where username = '"+uname+"';";
	            	ResultSet res2 = st2.executeQuery(qu2);
	            	while (res2.next()) {
	            		lame = res2.getString("lname");
	            	}
	            	Statement st5 = conn.createStatement();
	            	String qu5 = "select company from userdetails where username = '"+uname+"';";
	            	ResultSet res5 = st5.executeQuery(qu5);
	            	while (res5.next()) {
	            		comp = res5.getString("company");
	            	}
	            	Statement st4 = conn.createStatement();
	            	String qu4 = "select emailID from userdetails where username = '"+uname+"';";
	            	ResultSet res4 = st4.executeQuery(qu4);
	            	while (res4.next()) {
	            		email = res4.getString("emailID");
	            	}
	            	Statement st7 = conn.createStatement();
	            	String qu7 = "select phnum from userdetails where username = '"+uname+"';";
	            	ResultSet res7 = st7.executeQuery(qu7);
	            	while (res7.next()) {
	            		phnum = res7.getString("phnum");
	            	}            	
	            	
	            fname.setText(fame);
	            lname.setText(lame);
	            company.setText(comp);
	            emailt.setText(email);
	            pnumber.setText(phnum);	            
	            
	            JButton btnChangePassword = new JButton("CHANGE PASSWORD");
	            btnChangePassword.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	            		String pass = password.getText();
	            		if (pass.length()> 8 || pass.length()<8) {
	    					JOptionPane.showMessageDialog(null, "Password should be of 8 characters" ); 
	    				}
	    				else {
	    					try {
	    						String url = "jdbc:mysql://35.192.76.117:3306/trello1?useSSL=false";// url
	    				        String dbName = "trello1";//databese name
	    				        String driver = "com.mysql.cj.jdbc.Driver";
	    				        String userName = "root";
	    				        String Password = "trello";// password
	    				        
	    				        
	    				        	Class.forName(driver).newInstance();
	    				        	Connection conn = DriverManager.getConnection(url,userName,Password);			        	
	    				        	Statement st = conn.createStatement();
	    				        	st.executeUpdate("update usercreds set pwd = '"+password.getText()+"'  where username = '"+uname+"';");     	
	    				        	JOptionPane.showMessageDialog(null, "Password updated" ); 
	    					}catch(Exception e1) {
	    			        	e1.printStackTrace();
	    			        }
	    				
	    					
	    					dispose();
	    					Homepage hmp = new Homepage();
	    					hmp.setVisible(true);
	    					
	    				
	    					
	    					
	    				
	    					
	    				}
	            	}
	            });
	            btnChangePassword.setForeground(new Color(0, 51, 102));
	            btnChangePassword.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	            btnChangePassword.setBackground(Color.WHITE);
	            btnChangePassword.setBounds(485, 481, 226, 48);
	            panel.add(btnChangePassword);
	            
	            	
	            
		}catch(Exception e1) {
        	e1.printStackTrace();
        	JOptionPane.showMessageDialog(null, "Card with the same description is already exist !!!");
        }
	}
}
