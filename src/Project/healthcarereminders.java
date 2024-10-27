package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;

public class healthcarereminders extends JFrame {

	int patientidagain;
	private JPanel contentPane;
	private JTable table11111111111111;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					healthcarereminders frame = new healthcarereminders();
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
	public healthcarereminders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, -95, 47, 496);
		contentPane.add(panel);

		 table11111111111111 = new JTable();
		 JScrollPane scrollPane = new JScrollPane(table11111111111111); // Add table to JScrollPane
		 scrollPane.setBounds(250, 200, 400, 200); // Set bounds as required
		 contentPane.add(scrollPane);
		
		JLabel lblHealthcareReminders = new JLabel("HealthCare Reminders");
		lblHealthcareReminders.setFont(new Font("Century Gothic", Font.BOLD, 19));
		lblHealthcareReminders.setBounds(198, 10, 229, 60);
		contentPane.add(lblHealthcareReminders);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_3.setBounds(537, 5, 108, 78);
		contentPane.add(lblNewLabel_3);
		
		JButton Back = new JButton("<< Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new OptionsPatient().setVisible(true);
			}
		});
		Back.setBounds(57, 357, 85, 21);
		contentPane.add(Back);
		
		JLabel patientid = new JLabel("Patient ID:");
		patientid.setFont(new Font("Century Gothic", Font.BOLD, 12));
		patientid.setBounds(71, 106, 71, 27);
		contentPane.add(patientid);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\medicine100.png"));
		lblNewLabel_1.setBounds(92, 206, 156, 126);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Reminder");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(411, 170, 144, 13);
		contentPane.add(lblNewLabel_2);
		here();
		displayallreminders();
	}
	
	void here()
	{
		
		String pid = "";
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
		JLabel patientidddddddd = new JLabel(pid);
		patientidddddddd.setFont(new Font("Century Gothic", Font.BOLD, 12));
		patientidddddddd.setBounds(135, 109, 71, 21);
		contentPane.add(patientidddddddd);
		patientidagain = Integer.parseInt(pid);
		
	}
	
	void displayallreminders() 
	{
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
	        Statement stmt = con.createStatement();

	        String query = "SELECT registration_date, diagnosis, treatment FROM Register where patient_id = '" + patientidagain + "'";
	        ResultSet rs = stmt.executeQuery(query);

	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Date");
	        model.addColumn("Cause");
	        model.addColumn("Treatment/Prescription");

	        while (rs.next()) {
	            model.addRow(new Object[]{
	                rs.getString("registration_date"), // Assuming it's a String
	                rs.getString("diagnosis"),
	                rs.getString("treatment")
	            });
	        }

	        table11111111111111.setModel(model);
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	    }
	}
}
