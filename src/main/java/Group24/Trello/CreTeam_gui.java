package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.List;

public class CreTeam_gui extends JFrame {

	private JPanel contentPane;
	private JTextField teamname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreTeam_gui frame = new CreTeam_gui();
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
	public CreTeam_gui() {
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
		panel.setBackground(new Color(60, 179, 113));
		contentPane.add(panel);
		panel.setLayout(null);

		String usnme = Login.uname;

		JLabel lblNewTeam = new JLabel("NEW TEAM");
		lblNewTeam.setForeground(Color.WHITE);
		lblNewTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewTeam.setBounds(357, 32, 180, 34);
		panel.add(lblNewTeam);

		JLabel lblTeamName = new JLabel("TEAM NAME:");
		lblTeamName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeamName.setBounds(317, 114, 123, 20);
		panel.add(lblTeamName);

		JLabel lblTeamDescription = new JLabel("TEAM DESCRIPTION: ");
		lblTeamDescription.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeamDescription.setBounds(255, 175, 191, 20);
		panel.add(lblTeamDescription);

		JLabel lblTeamVisibility = new JLabel("TEAM VISIBILITY:");
		lblTeamVisibility.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeamVisibility.setBounds(271, 386, 169, 20);
		panel.add(lblTeamVisibility);

		teamname = new JTextField();
		teamname.setFont(new Font("Tahoma", Font.BOLD, 20));
		teamname.setBounds(455, 114, 239, 34);
		panel.add(teamname);
		teamname.setColumns(10);

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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PUBLIC", "TEAM"}));
		comboBox.setBounds(456, 384, 162, 26);
		panel.add(comboBox);

		JTextArea teamdescri = new JTextArea();
		teamdescri.setFont(new Font("Monospaced", Font.BOLD, 20));
		teamdescri.setBounds(455, 169, 387, 162);
		panel.add(teamdescri);

		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (teamname.getText().isEmpty()||teamdescri.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "All fields are required !"); 							
				else{
					Team_cre team1 = new Team_cre();
					team1.setTeam_name(teamname.getText());
					team1.setTeam_description(teamdescri.getText());
					team1.setTeam_visibility((String) comboBox.getSelectedItem());
					String teamname1=teamname.getText();
					try {
						Controller c1 = new Controller();
						ResultSet rs = c1.displayTeamcreds(teamname1);
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Team name already exist" );
							return;
						}
						c1.createTeam(team1,Login.uname);
						JOptionPane.showMessageDialog(null, "TEAM CREATED !!!");
						Login.team = teamname.getText();
						dispose();
						AddTeamMem atm = new AddTeamMem();
						atm.setVisible(true);

					}catch (Exception e1) {
						e1.printStackTrace();
					}			       


				}


			}
		}

				);


		btnCreate.setForeground(new Color(0, 51, 102));
		btnCreate.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnCreate.setBackground(Color.WHITE);
		btnCreate.setBounds(427, 467, 176, 48);
		panel.add(btnCreate);




	}
}