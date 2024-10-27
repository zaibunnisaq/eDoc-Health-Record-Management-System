package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
//file handling
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddRecord extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    static Connection con;

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

    public static void main(String[] args) {
        dbconnect();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddRecord frame = new AddRecord();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddRecord() {
    	//showAllPatientsData();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 753, 532);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Select Patient ID");
        lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(122, 106, 117, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Add New Record");
        lblNewLabel.setBounds(263, 28, 215, 25);
        lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 19));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("Date");
        lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblNewLabel_1_1.setBounds(223, 248, 54, 14);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Diagnosis");
        lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblNewLabel_1_2.setBounds(122, 157, 117, 14);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Treatment");
        lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblNewLabel_1_3.setBounds(122, 231, 117, 14);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Rx");
        lblNewLabel_1_4.setFont(new Font("Segoe Script", Font.PLAIN, 12));
        lblNewLabel_1_4.setBounds(122, 249, 117, 14);
        contentPane.add(lblNewLabel_1_4);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(409, 119, 311, 287);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1_5 = new JLabel("Patients Data");
        lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblNewLabel_1_5.setBounds(465, 95, 117, 14);
        contentPane.add(lblNewLabel_1_5);

        textField = new JTextField();
        textField.setBounds(263, 247, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(122, 267, 227, 126);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(122, 127, 86, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(122, 176, 227, 34);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("Save Record");
        btnNewButton.setBounds(110, 403, 127, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("View");
        btnNewButton_1.setBounds(568, 95, 65, 17);
        contentPane.add(btnNewButton_1);
        
        JButton btnSaveRecordIn = new JButton("Save Record in file");
        btnSaveRecordIn.setBounds(247, 403, 134, 23);
        contentPane.add(btnSaveRecordIn);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 10, 74, 475);
        contentPane.add(panel);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
        lblNewLabel_3.setBounds(631, 5, 108, 78);
        contentPane.add(lblNewLabel_3);
        
        JButton btnNewButton_2 = new JButton("<< Back");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 setVisible(false);
		            new OptionsDoctor().setVisible(true); 
        	}
        });
        btnNewButton_2.setBounds(86, 464, 85, 21);
        contentPane.add(btnNewButton_2);
        
        btnSaveRecordIn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            	String dateText = textField.getText();
                String diagnosis = textField_1.getText();
                String patientIdText = textField_2.getText();
                String treatment = textField_3.getText();
                int patientId = Integer.parseInt(patientIdText);
                saveRecordToFile(patientId, dateText, diagnosis, treatment);
                JOptionPane.showMessageDialog(null, "Record saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dateText = textField.getText();
                String diagnosis = textField_1.getText();
                String patientIdText = textField_2.getText();
                String treatment = textField_3.getText();

                if (!patientIdText.isEmpty()) {
                    try {
                        int patientId = Integer.parseInt(patientIdText);
                        insertRecord(patientId, dateText, diagnosis, treatment);
                        JOptionPane.showMessageDialog(null, "Record saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        //showAllPatientsData();
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid patient ID");
                    }
                }
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllPatientsData();
            }
        });
    }

    private void insertRecord(int patientId, String date, String diagnosis, String treatment) {
        try {
        	if (con == null) {
                dbconnect();
            }
            String query = "INSERT INTO Register (patient_id, registration_date, diagnosis, treatment) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, patientId);
                pstmt.setDate(2, Date.valueOf(date)); 
                pstmt.setString(3, diagnosis);
                pstmt.setString(4, treatment);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Record saved successfully");
                    //System.out.println("Record saved successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Could not save the record");
                   // System.out.println("Failed to save the record");
                }
            }
        } catch (Exception ex) {
            //System.out.println("Error inserting record: " + ex.getMessage());
        }
    }


    private void showAllPatientsData() {
        try {
        	if (con == null) {
                dbconnect();
            }
            String query = "SELECT * FROM Patient";
            try (PreparedStatement pstmt = con.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Patient Name");
                model.addColumn("Email");
                model.addColumn("Contact Number");

                while (rs.next()) {
                    Object[] row = {
                            rs.getInt("id"),
                            rs.getString("uname"),
                            rs.getString("uemail"),
                            rs.getString("uphone")
                    };
                    model.addRow(row);
                }

                table.setModel(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveRecordToFile(int patientId, String date, String diagnosis, String treatment) {
        String fileName = "registration_data.txt";

        try {
            Path filePath = Paths.get(fileName);

            // Create the file if it doesn't exist
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(Date.valueOf(date));

                String record = String.format("Patient ID: %d, Date: %s, Diagnosis: %s, Treatment: %s%n",
                        patientId, formattedDate, diagnosis, treatment);

                writer.write(record);
              //  System.out.println("Record saved to file successfully");
            }
        } catch (IOException e) {
           // System.out.println("Error saving record to file: " + e.getMessage());
        }
    }

}
