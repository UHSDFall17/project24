package Group24.Trello;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login {

	public JFrame frame;
	private JTextField username;
	private JPasswordField password;
	public static String uname;
	public static String team = "Team not Selected";
	public static String board = "Board not Selected";
	public static String list = "List not Selected";
	public static String card= "Card is not Created";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 625);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 900, 625);
		panel.setBackground(new Color(60, 179, 113));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uname = username.getText();
				if (username.getText().isEmpty()||password.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please input username and password !");
				else {
				try {
					Controller c1= new Controller();
					User user=new User();
					user.setUsername(uname);
					user.setPwd(password.getText());
					boolean results = c1.checkForUser(user); 

					if(!results) {

						JOptionPane.showMessageDialog(null, "Wrong username and password !");
					}
					else {
						frame.setVisible(false);
						Homepage hmp = new Homepage();
						hmp.setVisible(true);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}

				}

			}
		});
		btnLogin.setForeground(new Color(0, 51, 102));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnLogin.setBounds(572, 505, 176, 48);
		panel.add(btnLogin);

		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				signup sgp = new signup();
				sgp.setVisible(true);
			}
		});
		btnSignup.setForeground(new Color(0, 51, 102));
		btnSignup.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnSignup.setBackground(Color.WHITE);
		btnSignup.setBounds(295, 505, 176, 48);
		panel.add(btnSignup);

		JLabel lblNewToTrello = new JLabel("New to Trello?");
		lblNewToTrello.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblNewToTrello.setBounds(87, 510, 193, 38);
		panel.add(lblNewToTrello);

		JLabel lblWelcomeToTrello = new JLabel("WELCOME TO TRELLO !");
		lblWelcomeToTrello.setForeground(new Color(0, 51, 102));
		lblWelcomeToTrello.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToTrello.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 35));
		lblWelcomeToTrello.setBounds(295, 28, 596, 169);
		panel.add(lblWelcomeToTrello);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 20));
		username.setBounds(447, 313, 328, 38);
		panel.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setBounds(447, 403, 328, 38);
		panel.add(password);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblUsername.setBounds(221, 310, 193, 38);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblPassword.setBounds(221, 399, 193, 38);
		panel.add(lblPassword);
/*
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Group24/Trello/Capture.JPG")));
		label.setBounds(40, 40, 300, 254);
		panel.add(label);*/
	}
}
