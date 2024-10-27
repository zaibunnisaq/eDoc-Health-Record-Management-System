package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connection.tables;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class AppointmentScheduling extends JFrame 
{
	
	public String patientid1;
	
	
	
	 private String getDoctorInput() 
	 {
	        return doctorfield.getText();
	    }
	 private String getDateInput() 
	 {
	        return datefield.getText();
	    }

	private JPanel contentPane;
	private JTable table;
	private JTextField doctorfield;
	private JTextField datefield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentScheduling frame = new AppointmentScheduling();
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
	public AppointmentScheduling() 
	{
		 patientid1 = "";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, -51, 47, 496);
		contentPane.add(panel);
		
		table = new JTable(); 
		JScrollPane scrollPane = new JScrollPane(table); // Wrap the table in a JScrollPane
		scrollPane.setBounds(410, 160, 346, 185);// Adjust bounds as needed
	    //scrollPane.setBounds(100, 130, 580, 300);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_3.setBounds(658, 0, 108, 78);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Make and Appointment ");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 19));
		lblNewLabel.setBounds(67, 5, 233, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Patient Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 77, 123, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Id:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(134, 115, 74, 13);
		contentPane.add(lblNewLabel_2);
		
		doctorfield = new JTextField();
		doctorfield.setBounds(225, 114, 96, 19);
		contentPane.add(doctorfield);
		doctorfield.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(167, 145, 40, 13);
		contentPane.add(lblNewLabel_4);
		
		datefield = new JTextField();
		datefield.setColumns(10);
		datefield.setBounds(227, 143, 96, 19);
		contentPane.add(datefield);
		
		JButton Enterbutton = new JButton("Enter");
		Enterbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)           // store data in the appointment table 
			{
				 String doctorID = getDoctorInput();
				 String Date  = getDateInput();
				 int doctorIdInt = Integer.parseInt(doctorID);
				 int patientidint = Integer.parseInt(patientid1);
				 
				 // inserting data in database
				 
				 String InsertingData = "insert into appointmentscheduling (pid,date,did)values('" + patientidint + "','" +  Date + "','" + doctorIdInt + "');";
				 
			     int insetion = tables.insertData(InsertingData, "insert");
			     if(insetion == 1)
				 {
					 JOptionPane.showMessageDialog(null, "Appoint has been schedule sucessfully");
					 
				
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "could not scedule the appointment:("); 
				 }
			     
			     setVisible(false);
			     new patientpayment().setVisible(true);
					
				 
			}
		});
		Enterbutton.setBounds(207, 187, 85, 21);
		contentPane.add(Enterbutton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\appointment 2.png"));
		lblNewLabel_5.setBounds(54, 255, 123, 112);
		contentPane.add(lblNewLabel_5);
		
	   here();
	   displayallpatients();
		
		
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
		JLabel patientidd = new JLabel(pid);
		patientid1 = pid;
		patientidd.setFont(new Font("Century Gothic", Font.BOLD, 14));
		patientidd.setBounds(227, 85, 87, 16);
		contentPane.add(patientidd);
		
		JLabel lblNewLabel_1 = new JLabel("Doctors");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(545, 123, 74, 27);
		contentPane.add(lblNewLabel_1);
		
		
	}
	
	void displayallpatients() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
	        Statement stmt = con.createStatement();

	        String query = "SELECT id, uname, uemail FROM doctor";
	        ResultSet rs = stmt.executeQuery(query);

	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Doctor ID");
	        model.addColumn("Doctor Name");
	        model.addColumn("Doctor Email");

	        while (rs.next()) {
	            model.addRow(new Object[]{
	                rs.getInt("id"),
	                rs.getString("uname"),
	                rs.getString("uemail")
	            });
	        }

	        table.setModel(model);
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	    }
	}
}
