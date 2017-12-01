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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField companyname;
	private JTextField emailid;
	private JTextField phnumber;
	private JTextField username;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 639, 424);
		panel.setBackground(new Color(60, 179, 113));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("FIRST NAME:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel.setBounds(301, 43, 123, 20);
		panel.add(lblNewLabel);

		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.BOLD, 18));
		firstname.setBounds(485, 35, 357, 39);
		panel.add(firstname);
		firstname.setColumns(10);

		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblLastName.setBounds(307, 99, 117, 20);
		panel.add(lblLastName);

		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lastname.setColumns(10);
		lastname.setBounds(485, 91, 357, 39);
		panel.add(lastname);

		JLabel lblCompanyName = new JLabel("COMPANY NAME:");
		lblCompanyName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCompanyName.setBounds(273, 153, 157, 20);
		panel.add(lblCompanyName);

		companyname = new JTextField();
		companyname.setFont(new Font("Tahoma", Font.BOLD, 18));
		companyname.setColumns(10);
		companyname.setBounds(485, 146, 357, 39);
		panel.add(companyname);

		JLabel lblEmailId = new JLabel("EMAIL ID:");
		lblEmailId.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEmailId.setBounds(319, 206, 105, 20);
		panel.add(lblEmailId);

		emailid = new JTextField();
		emailid.setFont(new Font("Tahoma", Font.BOLD, 18));
		emailid.setColumns(10);
		emailid.setBounds(485, 201, 357, 39);
		panel.add(emailid);

		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER:");
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPhoneNumber.setBounds(273, 271, 157, 20);
		panel.add(lblPhoneNumber);

		phnumber = new JTextField();
		phnumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		phnumber.setColumns(10);
		phnumber.setBounds(485, 256, 357, 39);
		panel.add(phnumber);

		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblUserName.setBounds(307, 322, 123, 20);
		panel.add(lblUserName);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 18));
		username.setColumns(10);
		username.setBounds(485, 314, 357, 39);
		panel.add(username);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPassword.setBounds(307, 375, 123, 20);
		panel.add(lblPassword);

		pwd = new JPasswordField();
		pwd.setFont(new Font("Tahoma", Font.BOLD, 18));
		pwd.setBounds(485, 369, 357, 39);
		panel.add(pwd);

		JButton button = new JButton("SIGNUP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				String pass = pwd.getText();
				if (username.getText().isEmpty()||pwd.getText().isEmpty()||firstname.getText().isEmpty()||lastname.getText().isEmpty()||companyname.getText().isEmpty()||emailid.getText().isEmpty()||phnumber.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "All fields are required !"); 							
				else try {
					long num = Long.parseLong(phnumber.getText());
					if (!(num>999999999 && num<10000000000L)) {
						JOptionPane.showMessageDialog(null, "Invalid phone number" );
					}
					else	if (pass.length()> 8 || pass.length()<8) {
						JOptionPane.showMessageDialog(null, "Password should be of 8 characters" ); 
					}
					else {
						

							User user=new User();
							user.setUsername(username.getText());
							user.setPwd(pwd.getText());
							user.setCompany(companyname.getText());
							user.setEmailID(emailid.getText());
							user.setFname(firstname.getText());
							user.setLname(lastname.getText());
							user.setPhnum(num);
							Controller c1 = new Controller();
							boolean results=c1.checkForExistingUser(username.getText());

							if (results) {
								JOptionPane.showMessageDialog(null, "User name already exist" );
								return;
							}
							c1.SaveUserDetails(user);
							c1.SaveUserCreds(user);



							Login.uname= user.getUsername();
						

						JOptionPane.showMessageDialog(null, "WELCOME !!!");
						setVisible(false);
						Homepage hmp = new Homepage();
						hmp.setVisible(true);
					}	
				}catch (Exception e) {JOptionPane.showMessageDialog(null, "Invalid input !!!");}}
		});
		button.setForeground(new Color(0, 51, 102));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		button.setBackground(Color.WHITE);
		button.setBounds(405, 456, 176, 48);
		panel.add(button);
	}
}