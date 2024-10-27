package Project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewPatient extends JFrame {
	

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    static Connection con;
    private JTextField textField;

   // public static void dbconnect(String[] args) 
   // {
    	/*Class.forName("com.mysql.jdbc.Driver");
				  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
					    Statement stmt = con.createStatement();
					
					    String usertypeQuery = "SELECT id FROM doctor WHERE uusername = '" + Username + "'";
					    ResultSet rs = stmt.executeQuery(usertypeQuery);*/
    	public static void dbconnect()
    	{
    	    System.out.println("Connecting to the database...");
    	    try {
    	        Class.forName("com.mysql.jdbc.Driver");
    	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
    	        System.out.println("Connected to the database");
    	    } catch (Exception e) {
    	        System.out.println("Connection failed: " + e.getMessage());
    	        // Handle the exception appropriately
    	    }
    	}
  //  }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPatient frame = new ViewPatient();
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
	public ViewPatient() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 727, 403);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(255, 255, 255));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel_1 = new JLabel("View and Search Patient Record");
	        lblNewLabel_1.setBounds(131, 10, 421, 33);
	        lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 26));
	        contentPane.add(lblNewLabel_1);

	        JButton btnNewButton = new JButton("View");
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\search (2).png"));
	        btnNewButton.setBounds(385, 68, 36, 20);
	        btnNewButton.setForeground(Color.WHITE);
	        btnNewButton.setBackground(new Color(255, 255, 255));
	        btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
	        contentPane.add(btnNewButton);

	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(94, 98, 568, 200);
	        contentPane.add(scrollPane);

	        table = new JTable();
	        scrollPane.setViewportView(table);
	        table.setBackground(Color.LIGHT_GRAY);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 74, 431);
	        panel.setBackground(new Color(0, 0, 0));
	        contentPane.add(panel);

	        textField = new JTextField();
	        textField.setBounds(286, 70, 86, 20);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        JButton Back = new JButton("<< Back");
			Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
			        new OptionsAdmin().setVisible(true);
					
				}
			});
	        
	        JButton btnPrint = new JButton("Print");
	        btnPrint.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\printer.png"));
	        btnPrint.setForeground(Color.WHITE);
	        btnPrint.setFont(new Font("Century Gothic", Font.PLAIN, 11));
	        btnPrint.setBackground(new Color(64, 0, 64));
	        btnPrint.setBounds(600, 326, 62, 23);
	        contentPane.add(btnPrint);
	        
	        JLabel lblNewLabel = new JLabel("Enter Patient ID to view record:");
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblNewLabel.setBounds(96, 72, 180, 14);
	        contentPane.add(lblNewLabel);
	        
	        JLabel lblNewLabel_3 = new JLabel("New label");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
	        lblNewLabel_3.setBounds(598, -6, 108, 78);
	        contentPane.add(lblNewLabel_3);
	        
	        JButton btnNewButton_1 = new JButton("<< Back");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 setVisible(false);
			         new OptionsAdmin().setVisible(true); 
	        	}
	        });
	        btnNewButton_1.setBounds(94, 328, 85, 21);
	        contentPane.add(btnNewButton_1);
	        
	        btnPrint.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Show a dialog box with "Print processing..." message
	                JOptionPane.showMessageDialog(null, "Print processing...", "Printing", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });

	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String patientIdText = textField.getText().trim();

	                if (!patientIdText.isEmpty()) {
	                    try {
	                        int patientId = Integer.parseInt(patientIdText);

	                        if (isPatientExists(patientId)) {
	                            showRegisteredPatients(patientId);
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Record Doesnt exits", "Error", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } catch (NumberFormatException ex) {
	                        JOptionPane.showMessageDialog(null, "Invalid patient ID", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            }
	        });
	}
	 private void showRegisteredPatients(int patientId) {
	        try {
	        	if (con == null) {
	                dbconnect();
	            }
	            String query = "SELECT p.id, p.uname AS patient_name, r.diagnosis, r.treatment, r.registration_date FROM Register r JOIN Patient p ON r.patient_id = p.id WHERE r.patient_id = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, patientId);
	            ResultSet rs = pstmt.executeQuery();

	            DefaultTableModel model = new DefaultTableModel();
	            model.addColumn("Patient ID");
	            model.addColumn("Patient Name");
	            model.addColumn("Diagnosis");
	            model.addColumn("Treatment");
	            model.addColumn("Registration Date");

	            while (rs.next()) {
	                Object[] row = {
	                        rs.getInt("id"), 
	                        rs.getString("patient_name"),
	                        rs.getString("diagnosis"),
	                        rs.getString("treatment"),
	                        rs.getString("registration_date")
	                };
	                model.addRow(row);
	            }

	            table.setModel(model);

	            pstmt.close();
	            rs.close();

	        } catch (Exception ex) {
	            System.out.println("Error: " + ex.getMessage());
	        }
	    }

	    
	    private boolean isPatientExists(int patientId) {
	        try {
	            if (con == null) {
	                dbconnect();
	            }

	            String query = "SELECT COUNT(*) FROM Register WHERE patient_id = ?";
	            try (PreparedStatement pstmt = con.prepareStatement(query)) {
	                pstmt.setInt(1, patientId);
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        return rs.getInt(1) > 0; // Check if the count is greater than 0
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Error checking patient existence: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }

	        return false;
	    }

}
