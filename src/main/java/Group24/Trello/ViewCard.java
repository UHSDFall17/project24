package Group24.Trello;

import com.mysql.cj.api.mysqla.result.Resultset;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;

public class ViewCard extends JFrame {

	private JPanel contentPane;
	Controller c1= new Controller();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCard frame = new ViewCard();
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
	public ViewCard() {
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
		panel.setBackground(new Color(204, 204, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		String uname = Login.uname;
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 32, 513, 174);
		panel.add(scrollPane);
		
		JTextPane description = new JTextPane();
		scrollPane.setViewportView(description);
		description.setFont(new Font("Segoe Print", Font.BOLD, 19));
		
		JLabel lblDescription = new JLabel(" DESCRIPTION: ");
		lblDescription.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDescription.setBounds(154, 85, 147, 20);
		panel.add(lblDescription);
		
		JLabel lblDueDate = new JLabel("DUE DATE: ");
		lblDueDate.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblDueDate.setBounds(33, 256, 100, 20);
		panel.add(lblDueDate);
		
		JTextPane duedate = new JTextPane();
		duedate.setFont(new Font("Segoe Print", Font.BOLD, 18));
		duedate.setBounds(148, 244, 170, 47);
		panel.add(duedate);
		
		JLabel lblMemberAssigned = new JLabel("MEMBER ASSIGNED: ");
		lblMemberAssigned.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMemberAssigned.setBounds(374, 256, 178, 20);
		panel.add(lblMemberAssigned);
		
		JTextPane member = new JTextPane();
		member.setFont(new Font("Segoe Print", Font.BOLD, 18));
		member.setBounds(609, 244, 214, 47);
		panel.add(member);
		
		 DefaultListModel listModel = new DefaultListModel();
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(54, 351, 478, 129);
        panel.add(scrollPane_1);
        
        JList list = new JList();
        list.setFont(new Font("Segoe Print", Font.BOLD, 19));
        scrollPane_1.setViewportView(list);
        list.setModel(listModel);
		
		JLabel lblComments = new JLabel("COMMENTS: ");
		lblComments.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblComments.setBounds(34, 315, 122, 20);
		panel.add(lblComments);
		
		String cname = Login.card;
		String tname = Login.team;	
		String lname = Login.list;
		try {
			String ddt=c1.displayCardDueDate(cname);
			String memn=c1.displayCardMembers(tname,cname);
			ResultSet res6= c1.displayCardComments(cname);
			String comm = null;

	            	while (res6.next()) {
	            		comm = res6.getString("comment");
	            		listModel.addElement(comm);
	            	}
	            description.setText(cname);
	            duedate.setText(ddt);
	            member.setText(memn);
	            
	            
		}catch(Exception e1) {
        	e1.printStackTrace();
        	JOptionPane.showMessageDialog(null, "Card with the same description is already exist !!!");
        }
	            
	            JButton btnClose = new JButton("CLOSE");
	            btnClose.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	            		dispose();
	            		ListPage pld = new ListPage();
	            		pld.setVisible(true);
	            	}
	            });
	            btnClose.setForeground(new Color(0, 51, 102));
	            btnClose.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
	            btnClose.setBackground(Color.WHITE);
	            btnClose.setBounds(557, 495, 176, 48);
	            panel.add(btnClose);
	            
	            JFormattedTextField addcom = new JFormattedTextField();
	            addcom.setText("Add comment...");
	            addcom.setFont(new Font("Century Gothic", Font.BOLD, 13));
	            addcom.setBounds(602, 336, 232, 51);
	            panel.add(addcom);
	            
	            JButton button = new JButton("Add comment");
	            button.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	    				if (addcom.getText().isEmpty())
	    					JOptionPane.showMessageDialog(null, "Please enter the Comments !!!");
	    				else {try {
	    					String addCmmt=addcom.getText();
	    					c1.addComments(uname,tname,cname,addCmmt);
	    			            	setVisible(false);
	    			            	ViewCard vcd = new ViewCard();
	    			            	vcd.setVisible(true);
	    			            	JOptionPane.showMessageDialog(null, "Comment added !!!");
	    				}catch(Exception e1) {
	    		        	e1.printStackTrace();
	    		        }
	    			
	    				}
	    				
	    			
	    				
	    			
	            	}
	            });
	            button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	            button.setBounds(619, 419, 147, 39);
	            panel.add(button);
	            
	            JButton btnModify = new JButton("Modify Description and Due Date");
	            btnModify.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
						String memuname=member.getText();
						String ddt=duedate.getText();
						String desc=description.getText();
	    				try {
	    					c1.modifyDueDateDesc(tname,cname,memuname,ddt,desc);

	    				}catch(Exception e1) {
	    		        	e1.printStackTrace();
	    		        	JOptionPane.showMessageDialog(null, "Card with the same description is already exist !!!");
	    		        }
	    				JOptionPane.showMessageDialog(null, "Card is Modified !!!");
					}
	            });
	            btnModify.setForeground(new Color(0, 51, 102));
	            btnModify.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
	            btnModify.setBackground(Color.WHITE);
	            btnModify.setBounds(88, 495, 340, 48);
	            panel.add(btnModify);
	}
}
