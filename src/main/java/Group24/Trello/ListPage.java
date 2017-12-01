package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class ListPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPage frame = new ListPage();
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
	public ListPage() {
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
		panel.setBackground(SystemColor.activeCaption);
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

		String tnme = Login.team;
		String bnme = Login.board;
		String lnme = Login.list;

		JLabel label = new JLabel("TEAM:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label.setBounds(170, 16, 74, 34);
		panel.add(label);

		JLabel label_1 = new JLabel(tnme);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(249, 16, 165, 34);
		panel.add(label_1);

		JLabel label_2 = new JLabel("BOARD:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label_2.setBounds(452, 16, 99, 34);
		panel.add(label_2);

		JLabel label_3 = new JLabel(bnme);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(550, 16, 165, 34);
		panel.add(label_3);

		JLabel lblList = new JLabel("LIST:");
		lblList.setForeground(Color.BLACK);
		lblList.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblList.setBounds(317, 76, 74, 34);
		panel.add(lblList);

		JLabel label_4 = new JLabel(lnme);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(386, 76, 165, 34);
		panel.add(label_4);

		JButton btnCreateNewCard = new JButton("Create new card");
		btnCreateNewCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cardui crd = new Cardui();
				crd.setVisible(true);
			}
		});
		btnCreateNewCard.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnCreateNewCard.setBackground(new Color(50, 205, 50));
		btnCreateNewCard.setBounds(19, 189, 197, 117);
		panel.add(btnCreateNewCard);

		JLabel lblCards = new JLabel("CARDS");
		lblCards.setForeground(Color.BLACK);
		lblCards.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblCards.setBounds(452, 144, 95, 34);
		panel.add(lblCards);

		DefaultListModel listModel = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 194, 311, 338);
		panel.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 20));
		list.setModel(listModel);


		try {
			String des = null; 
			Controller c1 = new Controller();
			ResultSet rs1 = c1.displayCardDescription(lnme);
			while (rs1.next()) {
				des = rs1.getString("description");		
				listModel.addElement(des);		            	
			}	
			//  System.out.println(rs.getString("description"));

		}catch(Exception e) {
			e.printStackTrace();
		}	
		JButton button = new JButton("GO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null){
					Login.card = list.getSelectedValue().toString();
					dispose();
					ViewCard vcrd = new ViewCard();
					vcrd.setVisible(true);
				}
				else return;
			}
		});
		button.setBounds(732, 336, 95, 49);
		panel.add(button);

		JButton btnModifyOrComment = new JButton("Modify or Comment existing card");
		btnModifyOrComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.card= list.getSelectedValue().toString();
				dispose();
				ViewCard crd = new ViewCard();
				crd.setVisible(true);
			}
		});
		btnModifyOrComment.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnModifyOrComment.setBackground(new Color(50, 205, 50));
		btnModifyOrComment.setBounds(19, 370, 311, 103);
		panel.add(btnModifyOrComment);

	}
}
