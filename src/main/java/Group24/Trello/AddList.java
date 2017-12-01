package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
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

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBounds(-11, 0, 900, 625);
		panel.setBackground(new Color(250, 240, 230));
		contentPane.add(panel);
		panel.setLayout(null);

		String bnme=Login.board;

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

		JLabel lblBoard = new JLabel("BOARD:");
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblBoard.setBounds(273, 123, 99, 34);
		panel.add(lblBoard);

		JLabel label = new JLabel(bnme);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(377, 123, 165, 34);
		panel.add(label);

		JLabel lblListName = new JLabel("LIST NAME:");
		lblListName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblListName.setBounds(222, 289, 115, 20);
		panel.add(lblListName);

		listname = new JTextField();
		listname.setFont(new Font("Tahoma", Font.BOLD, 20));
		listname.setColumns(10);
		listname.setBounds(358, 282, 239, 34);
		panel.add(listname);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listname.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "All fields are required !");
				else {
					String list_name;
					list_name = listname.getText();
					try {
						Controller c1 = new Controller();
						c1.creatingList(bnme,list_name);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				Login.list=listname.getText();
				dispose();
				ListPage lpa = new ListPage();
				lpa.setVisible(true);

			}
		});
		btnAdd.setForeground(new Color(0, 51, 102));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(324, 432, 176, 48);
		panel.add(btnAdd);

		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setForeground(Color.BLACK);
		lblTeam.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTeam.setBounds(285, 67, 99, 34);
		panel.add(lblTeam);

		String tnm= Login.team;

		JLabel label_1 = new JLabel(tnm);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(377, 63, 165, 34);
		panel.add(label_1);



	}
}