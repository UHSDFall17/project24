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
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBoard frame = new TeamBoard();
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
	public TeamBoard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		String username = Login.uname;
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 639, 424);
		panel.setBackground(new Color(60, 179, 113));
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

		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblTeam.setBounds(393, 152, 65, 20);
		panel.add(lblTeam);

		JLabel lblBoard = new JLabel("BOARD:");
		lblBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblBoard.setBounds(382, 243, 65, 20);
		panel.add(lblBoard);

		JComboBox teamBox = new JComboBox();
		teamBox.setBounds(474, 146, 205, 35);
		panel.add(teamBox);

		JComboBox boardBox = new JComboBox();
		boardBox.setBounds(474, 241, 205, 35);
		panel.add(boardBox);

		JButton btnAdd = new JButton("ADD ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String teamname = null;
					String boardname = null;

					Controller c1= new Controller();

					boardname=(String) boardBox.getSelectedItem();
					ResultSet rs=c1.checkTeamHasBoard(boardname);


					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Board is already allocated to a Team !!!!!!" );

						return;
					}

					teamname=(String) teamBox.getSelectedItem();
					c1.updateBoardTeam(boardname, teamname);

				}catch(Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ADDED !!!");
				dispose();
				Homepage hmp = new Homepage();
				hmp.setVisible(true);

			}
		});
		btnAdd.setForeground(new Color(0, 51, 102));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(323, 433, 174, 48);
		panel.add(btnAdd);

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.listMyTeam(username);
			while (rs.next()) {
				String tname = rs.getString("team_name");
				teamBox.addItem(tname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			Controller c1 = new Controller();
			ResultSet rs = c1.checkExistingBoard(username);
			while (rs.next()) {
				String bname = rs.getString("BoardName");
				boardBox.addItem(bname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}