package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Homepage extends JFrame {

	private JPanel contentPane;
	Controller c1= new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTeam = new JMenu("TEAM");
		mnTeam.setForeground(Color.BLACK);
		mnTeam.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnTeam);

		JMenuItem mntmCreateTeam = new JMenuItem("Create Team");
		mntmCreateTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreTeam_gui cte = new CreTeam_gui();
				cte.setVisible(true);
			}
		});
		mnTeam.add(mntmCreateTeam);

		JMenuItem mntmAddMemeber = new JMenuItem("Add Memeber");
		mntmAddMemeber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddTeamMem atm = new AddTeamMem();
				atm.setVisible(true);
			}
		});
		mnTeam.add(mntmAddMemeber);

		JSeparator separator_1 = new JSeparator();
		mnTeam.add(separator_1);

		JMenuItem mntmDeleteTeam = new JMenuItem("Delete Team");
		mntmDeleteTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Del dd = new Del();
				dd.setVisible(true);
			}
		});
		mnTeam.add(mntmDeleteTeam);

		JMenuItem mntmRemoveMember = new JMenuItem("Remove Member");
		mntmRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Del dd = new Del();
				dd.setVisible(true);				
			}
		});
		mnTeam.add(mntmRemoveMember);

		JMenu mnNewMenu = new JMenu("BOARD");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);

		JMenuItem mntmCreateBoard = new JMenuItem("Create Board");
		mntmCreateBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CreBoard crb = new CreBoard();
				crb.setVisible(true);
			}
		});
		mnNewMenu.add(mntmCreateBoard);

		JMenuItem mntmAddMember = new JMenuItem("Add Board to Team");
		mntmAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TeamBoard tbrd = new TeamBoard();
				tbrd.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAddMember);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mntmDeleteBoard = new JMenuItem("Delete Board");
		mntmDeleteBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Del dd = new Del();
				dd.setVisible(true);
			}
		});
		mnNewMenu.add(mntmDeleteBoard);

		JMenuItem mntmRemoveMember_1 = new JMenuItem("Remove Board from Team");
		mntmRemoveMember_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Del dd = new Del();
				dd.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRemoveMember_1);

		JMenu mnProfile = new JMenu("PROFILE");
		mnProfile.setForeground(Color.BLACK);
		mnProfile.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnProfile);

		JMenuItem mntmViewOrEdit = new JMenuItem("View or Edit");
		mntmViewOrEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Profile prf = new Profile();
				prf.setVisible(true);
			}
		});

		mnProfile.add(mntmViewOrEdit);
		JSeparator separator_2 = new JSeparator();
		mnProfile.add(separator_2);

		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c1.logout();
					JOptionPane.showMessageDialog(null, "Successfully LOGOUT !");
					dispose();
					Login lgn = new Login();
					lgn.frame.setVisible(true);

				}catch(Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		mnProfile.add(mntmLogOut);


		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 900, 600);
		panel.setBackground(SystemColor.windowBorder);
		getContentPane().add(panel);
		panel.setLayout(null);


		String username = Login.uname;

		JLabel lblMyTeams = new JLabel("MY TEAMS:");
		lblMyTeams.setForeground(SystemColor.menu);
		lblMyTeams.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblMyTeams.setBounds(166, 62, 126, 20);
		panel.add(lblMyTeams);


		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblDashboard.setBounds(333, 0, 180, 34);
		panel.add(lblDashboard);

		JLabel lblMyBoards = new JLabel("MY BOARDS:");
		lblMyBoards.setForeground(SystemColor.menu);
		lblMyBoards.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblMyBoards.setBounds(554, 62, 126, 20);
		panel.add(lblMyBoards);


		DefaultListModel listModel = new DefaultListModel();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(115, 96, 267, 332);
		panel.add(scrollPane_1);
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 18));
		list.setModel(listModel);

		try {

			ResultSet rs=c1.checkExistingTeam(username);
			while (rs.next()) {
				String tname = rs.getString("team_name");
				listModel.addElement(tname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedValue()!=null) {
					Login.team = list.getSelectedValue().toString();
					dispose();
					TeamPage tpge = new TeamPage();
					tpge.setVisible(true);}
				else return;
			}
		});
		btnGo.setBounds(177, 460, 115, 29);
		panel.add(btnGo);

		DefaultListModel listModel1 = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(505, 96, 267, 332);
		panel.add(scrollPane);
		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
		list_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		list_1.setModel(listModel1);

		try {

			ResultSet rs=c1.checkExistingBoard(username);
			while (rs.next()) {
				String bname = rs.getString("BoardName");
				listModel1.addElement(bname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		JButton button = new JButton("GO");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("1");
				if(list_1.getSelectedValue()!=null) {
					Login.board = list_1.getSelectedValue().toString();
					try {
						String tn=null;

						//System.out.println("1");
						ResultSet rs = c1.fetchingBoardDetails(username);
						while (rs.next()) {
							//System.out.println(rs.next());
							tn = rs.getString("team_name");
						}
						Login.team = tn;
					}catch(Exception e1) {
						e1.printStackTrace();
					}

					dispose();
					BoardPage bpage = new BoardPage();
					bpage.setVisible(true);
				}else return;
			}
		});
		button.setBounds(582, 460, 115, 29);
		panel.add(button);


	}
}
