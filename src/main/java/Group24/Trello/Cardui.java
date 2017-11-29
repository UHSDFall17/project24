package Group24.Trello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Cardui extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddDueDate;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cardui frame = new Cardui();
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
	public Cardui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(-11, 0, 139, 124);
		panel.setBackground(new Color(102, 102, 153));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		comboBox.setToolTipText("Add Member");
		comboBox.setBounds(259, 178, 331, 32);
		panel.add(comboBox);
		try {
			MysqlCon connection = new MysqlCon();
			Connection conn = connection.EstCon();
			Statement st = conn.createStatement();
			String queryString = "SELECT mem_username FROM member;";
			ResultSet rs = st.executeQuery(queryString); //where ps is Object of PreparedStatement
			while (rs.next()) {
				String member = rs.getString("mem_username");
				comboBox.addItem(member);
			}
			conn.close();
		//	comboBox.com
		}

		   	catch (Exception e) {
	        	e.printStackTrace();
	        }
		
		JFormattedTextField frmtdtxtfldEnterTheCard = new JFormattedTextField();
		frmtdtxtfldEnterTheCard.setFont(new Font("Century Gothic", Font.BOLD, 13));
		frmtdtxtfldEnterTheCard.setText("Enter the card name...");
		frmtdtxtfldEnterTheCard.setBounds(54, 61, 392, 51);
		panel.add(frmtdtxtfldEnterTheCard);
		
		JLabel lblAddMember = new JLabel("Add Member");
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setBackground(new Color(255, 255, 255));
		lblAddMember.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblAddMember.setBounds(54, 175, 164, 32);
		panel.add(lblAddMember);
		
		JButton btnViewComment = new JButton("View comments");
		btnViewComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					MysqlCon connection = new MysqlCon();

					Connection conn = connection.EstCon();
					Statement st = conn.createStatement();

					String queryString = "SELECT * FROM member;";
					ResultSet rs = st.executeQuery(queryString);


					// It creates and displays the table
					JTable table = new JTable(buildTable(rs));

					// Closes the Connection

					JOptionPane.showMessageDialog(null, new JScrollPane(table));
					conn.close();
				}
				catch (Exception e1) {
		        	e1.printStackTrace();
		        }
			}
		});
		btnViewComment.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnViewComment.setBounds(574, 271, 209, 39);
		panel.add(btnViewComment);
		
		
		
		JButton btnAddChecklist = new JButton("Add checklist");
		btnAddChecklist.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnAddChecklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddChecklist.setBounds(54, 371, 147, 39);
		panel.add(btnAddChecklist);
		
		JFormattedTextField frmtdtxtfldAddDuedate = new JFormattedTextField();
		frmtdtxtfldAddDuedate.setHorizontalAlignment(SwingConstants.LEFT);
		frmtdtxtfldAddDuedate.setFont(new Font("Century Gothic", Font.BOLD, 13));
		frmtdtxtfldAddDuedate.setText("yyyy/mm/dd");
		frmtdtxtfldAddDuedate.setBounds(315, 372, 147, 39);
		panel.add(frmtdtxtfldAddDuedate);
		
		JButton btnAddComment = new JButton("Add comment");
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddComment.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnAddComment.setBounds(354, 271, 147, 39);
		panel.add(btnAddComment);
		
		JFormattedTextField frmtdtxtfldAddComment = new JFormattedTextField();
		frmtdtxtfldAddComment.setText("Add comment...");
		frmtdtxtfldAddComment.setFont(new Font("Century Gothic", Font.BOLD, 13));
		frmtdtxtfldAddComment.setBounds(54, 266, 232, 51);
		panel.add(frmtdtxtfldAddComment);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSave.setBounds(507, 73, 100, 39);
		panel.add(btnSave);
		
		JButton btnAddDueDate = new JButton("Add duedate");
		btnAddDueDate.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnAddDueDate.setBounds(520, 371, 181, 39);
		panel.add(btnAddDueDate);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnOk.setBounds(723, 488, 100, 39);
		panel.add(btnOk);
		
		
	}

public static DefaultTableModel buildTable(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}	
}