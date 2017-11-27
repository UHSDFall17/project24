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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextField;

public class CreBoard extends JFrame {

	private JPanel contentPane;
	private JTextField boardname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreBoard frame = new CreBoard();
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
	public CreBoard() {
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
		
		JLabel lblNewBoard = new JLabel("NEW BOARD");
		lblNewBoard.setForeground(Color.WHITE);
		lblNewBoard.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewBoard.setBounds(357, 32, 180, 34);
		panel.add(lblNewBoard);
		
		JLabel lbBoardName = new JLabel("BOARD NAME:");
		lbBoardName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lbBoardName.setBounds(327, 178, 123, 20);
		panel.add(lbBoardName);
		
		JLabel lblPrivacy = new JLabel("PRIVACY:");
		lblPrivacy.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPrivacy.setBounds(362, 270, 78, 20);
		panel.add(lblPrivacy);
		
		boardname = new JTextField();
		boardname.setFont(new Font("Tahoma", Font.BOLD, 20));
		boardname.setBounds(477, 171, 239, 34);
		panel.add(boardname);
		boardname.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"private", "public", "team"}));
		comboBox.setBounds(477, 268, 162, 34);
		panel.add(comboBox);
		
		JButton button = new JButton("CREATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boardname.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "All fields are required !"); 							
				else{
					Board board=new Board();
					board.setUsername(usnme);
					board.setBoardName(boardname.getText());
					board.setPrivacy((String) comboBox.getSelectedItem());
					board.setPrivilege("ADMIN");

			        try {
						Controller c1 = new Controller();
						c1.createBoard(board);
						}catch (Exception e1) {
			        	e1.printStackTrace();
			        }			       
				    
			        JOptionPane.showMessageDialog(null, "BOARD CREATED !!!");
			        Login.board = boardname.getText();
			        dispose();
					TeamBoard tbo = new TeamBoard();
					tbo.setVisible(true);
				}			
			}
		});
		button.setForeground(new Color(0, 51, 102));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		button.setBackground(Color.WHITE);
		button.setBounds(345, 422, 176, 48);
		panel.add(button);
		
		
	}
}
