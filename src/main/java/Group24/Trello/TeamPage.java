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
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TeamPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamPage frame = new TeamPage();
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
	public TeamPage() {
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
		panel.setBackground(new Color(250, 240, 230));
		contentPane.add(panel);
		panel.setLayout(null);

		String tnme = Login.team;

		JLabel lblTeamPage = new JLabel("TEAM PAGE FOR:");
		lblTeamPage.setForeground(new Color(0, 0, 0));
		lblTeamPage.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTeamPage.setBounds(149, 16, 197, 34);
		panel.add(lblTeamPage);

		JButton button = new JButton("Create new board");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreBoard crf =new CreBoard();
				crf.setVisible(true);
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button.setBackground(new Color(50, 205, 50));
		button.setBounds(29, 283, 197, 117);
		panel.add(button);


		JLabel TeamName = new JLabel(tnme);
		TeamName.setFont(new Font("Tahoma", Font.BOLD, 20));
		TeamName.setBounds(346, 16, 165, 34);
		panel.add(TeamName);

		JLabel lblNewLabel = new JLabel("MEMBERS");
		lblNewLabel.setBounds(29, 166, 86, 34);
		panel.add(lblNewLabel);

		JComboBox MemBox = new JComboBox();
		MemBox.setBounds(32, 216, 86, 26);
		panel.add(MemBox);

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

		DefaultListModel listModel = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(418, 168, 315, 342);
		panel.add(scrollPane);
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 20));
		list.setModel(listModel);

		try {
			Controller c1=new Controller();
			ResultSet rs=c1.displayingBoardsForTeam(tnme);
			while (rs.next()) {
				String dis = rs.getString("BoardName");
				listModel.addElement(dis);
			}
			JLabel lblBoards = new JLabel("BOARDS");
			lblBoards.setForeground(Color.BLACK);
			lblBoards.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			lblBoards.setBounds(512, 122, 95, 34);
			panel.add(lblBoards);

			JButton button_1 = new JButton("GO");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if( list.getSelectedValue()!= null){
						Login.board = list.getSelectedValue().toString();
						dispose();
						BoardPage bpge = new BoardPage();
						bpge.setVisible(true);
					}
					else return;
				}

			});
			button_1.setBounds(758, 251, 95, 49);
			panel.add(button_1);
		}catch(Exception e) {
			e.printStackTrace();
		}			

		try {
			Controller c1=new Controller();
			ResultSet rs=c1.displayingTeamMembers(tnme);
			while (rs.next()) {
				String tname = rs.getString("mem_username");
				MemBox.addItem(tname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}