package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.tables;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class pay extends JFrame {
	 private String getamt() 
	 {
	        return textField.getText();
	        
	    }

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay frame = new pay();
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
	public pay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(372, 0, 108, 78);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, -151, 47, 496);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Youe Fee:       1000Rs");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(83, 65, 125, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel_1.setBounds(92, 94, 59, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String amt = getamt();
				
				// get patient id

				String pid = "";  // patient id
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
			  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
				    Statement stmt = con.createStatement();
				
				    String usertypeQuery = "SELECT pid FROM currentpatient ORDER BY id DESC LIMIT 1";
				    ResultSet rs = stmt.executeQuery(usertypeQuery);

				    if (rs.next()) 
				    {
				    	pid = rs.getString("pid");
				      // JOptionPane.showMessageDialog(null, "User type jehfwkis: " + userType);
				    }
				    else
				    {
				        JOptionPane.showMessageDialog(null, "User not found or password incorrect.");
				    }
				} 
				catch (Exception ex1) 
				{
				    System.out.println("kksksk" + ex1);
				}
				int intamt =  Integer.parseInt(amt);  // amount in int
				int returnamt = intamt - 1000;
				int patientid = Integer.parseInt(pid);
				if(returnamt >= 0)
				{
					printreturn(String.valueOf(returnamt) + " Rs");
		        
					 String InsertingData = "insert into payment (patient_id,payamt,returnamt)values('" + patientid + "','" +  intamt + "','" + returnamt + "');";
					 
				     int insetion = tables.insertData(InsertingData, "insert");
				     if(insetion == 1)
					 {
						 JOptionPane.showMessageDialog(null, "Thank you for always trusting us with your health. Get well soon <3");
						 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "error:("); 
					 }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Amount is not sufficient");
				}
				
			}
		});
		enter.setBounds(134, 177, 85, 21);
		contentPane.add(enter);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				   new JFrame1().setVisible(true);
			}
		});
		logout.setBounds(372, 263, 85, 21);
		contentPane.add(logout);
		
		JLabel lblNewLabel_2 = new JLabel("Your Return:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel_2.setBounds(75, 132, 76, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(161, 92, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel returnamounthehe = new JLabel("");
		returnamounthehe.setFont(new Font("Century Gothic", Font.BOLD, 12));
		returnamounthehe.setBounds(163, 133, 68, 13);
		contentPane.add(returnamounthehe);
	}
	
	void printreturn(String returnamt) {
	    JLabel returnamounthehe = new JLabel(String.valueOf(returnamt));
	    returnamounthehe.setFont(new Font("Century Gothic", Font.BOLD, 12));
	    returnamounthehe.setBounds(163, 133, 100, 13); // Adjusted the width to accommodate larger numbers
	    contentPane.add(returnamounthehe);
	    contentPane.revalidate();
	    contentPane.repaint();
	}
}
