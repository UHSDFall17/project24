package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class Coporate extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coporate frame = new Coporate();
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
	public Coporate() {
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
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 20));
		username.setColumns(10);
		username.setBounds(430, 310, 328, 38);
		panel.add(username);
		
		password = new JPasswordField();
		password.setBounds(430, 399, 328, 38);
		panel.add(password);
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.uname = username.getText();
				if (username.getText().isEmpty()||password.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please input username and password !");
				else {
				try {
					Controller c1= new Controller();
					User user=new User();
					user.setUsername(username.getText());
					user.setPwd(password.getText());
					ResultSet rs = c1.checkForCopuser(username.getText());			
					while (rs.next()) {
						String iscop = rs.getString("is_corp");
						if (!(iscop.equals("Y"))) {
							JOptionPane.showMessageDialog(null, "Not a Co-oporate User !");
							return;
						}
							
					}
					boolean results = c1.checkForCop(user); 

					if(!results) {

						JOptionPane.showMessageDialog(null, "Wrong username and password !");
					}
					else {
						ResultSet res = c1.team();
						while(res.next()) {
							String ttm = res.getString("team_name");
							Login.team = ttm;
						}
						ResultSet res1 = c1.board();
						while(res1.next()) {
							String bbm = res1.getString("BoardName");
							Login.board = bbm;
						}
						dispose();
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
		btnLogin.setBounds(447, 511, 176, 48);
		panel.add(btnLogin);

		JLabel lblWelcomeToTrello = new JLabel("CO-OPERATE USERS !!!");
		lblWelcomeToTrello.setForeground(new Color(0, 51, 102));
		lblWelcomeToTrello.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToTrello.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.BOLD, 35));
		lblWelcomeToTrello.setBounds(118, 0, 596, 169);
		panel.add(lblWelcomeToTrello);

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
		
		

	}
}
