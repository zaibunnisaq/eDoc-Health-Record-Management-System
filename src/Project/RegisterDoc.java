package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.tables;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class RegisterDoc extends JFrame 
{

	private String getEmailInput() 
	 {
	        return emailField.getText();
	    }
	 private String getUsernameInput() 
	 {
	        return usernameField.getText();
	    }
	 private String getNameInput() 
	 {
	        return nameField.getText();
	    }
	 private String getPhoneInput() 
	 {
	        return phoneField.getText();
	    }
	 private String getPasswordInput() 
	 {
	       // return passwordField.getPassword();
	        return passwordField.getText();
	    }
	 

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterDoc frame = new RegisterDoc();
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
	public RegisterDoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(UIManager.getBorder("Button.border"));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton SignUp = new JButton("Sign up");
		 
	            
		SignUp.setFont(new Font("Calibri", Font.BOLD, 14));
		SignUp.setBounds(347, 309, 79, 27);
		contentPane.add(SignUp);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(221, 99, 59, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(222, 135, 52, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2.setBounds(208, 175, 72, 20);
		contentPane.add(lblNewLabel_2);
		
		usernameField = new JTextField();
		usernameField.setBounds(320, 178, 125, 19);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(320, 98, 125, 19);
		contentPane.add(nameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(320, 138, 125, 19);
		contentPane.add(emailField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(228, 259, 52, 13);
		contentPane.add(lblNewLabel_2_1);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(320, 258, 125, 19);
		contentPane.add(phoneField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(214, 219, 66, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblNewLabel.setBounds(295, 10, 150, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_4.setBounds(556, -2, 105, 80);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JTextField();
		passwordField.setBounds(320, 218, 125, 19);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, -2, 47, 439);
		contentPane.add(panel);
		
		JButton Back = new JButton("<< Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new OptionsAdmin().setVisible(true);
				
			}
		});
		Back.setBounds(57, 374, 85, 21);
		contentPane.add(Back);
		
		SignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 String Name = getNameInput();
				 String Email  = getEmailInput();
				 String Username = getUsernameInput();
				// char[] Password = getPasswordInput();
				 String Password = getPasswordInput();
				 String Phone = getPhoneInput();
				
				 // selectedUserType = usertypeBox.getSelectedItem().toString();
				 
				 
				 //System.out.println("User Email: " + Email);
				 //System.out.println("User username: " + Username);
				// System.out.println("User name: " + Name);
				// System.out.println("User password: " + Password);
				// System.out.println("User phone: " + Phone);
				
				 
				 // first check that user donot exit in the db
				 String checkUserExistsQuery = "SELECT * FROM doctor WHERE uusername = '" + Username + "'";
				 int selected = tables.selectdata(checkUserExistsQuery,"selected sucessfully");
				 
			 if(selected == -1)  // that user doesnot exit 
			  {
					 String InsertingData = "insert into doctor(uname, uemail, uusername, upassword, uphone, uusertype) values ('" + Name + "','" +  Email + "','" + Username + "','" + Password + "','" + Phone +"','Patient');";
					 // only patient can sign up 
					 
					 if(Name.equals("")||Email.equals("")||Username.equals("") || Password.equals("") || Phone.equals(""))
					 {
						 JOptionPane.showMessageDialog(null, "Every field is required");
					 }
					 else
					 {
						 //String QUERY 
						 int insetion = tables.insertData(InsertingData, "insert");
						 if(insetion == 1)
						 {
							 JOptionPane.showMessageDialog(null, "Doctor Registered Succesfully");
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null, "couldnt sign up :("); 
						 }
					 }
				 }
				 else
					 
				 {
					 JOptionPane.showMessageDialog(null, "This username already exists");
				 }
			 
			 
			 // store patients id 
                String id = "";
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
			  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
				    Statement stmt = con.createStatement();
				
				    String usertypeQuery = "SELECT id FROM doctor WHERE uusername = '" + Username + "'";
				    ResultSet rs = stmt.executeQuery(usertypeQuery);

				    if (rs.next()) 
				    {
				        id = rs.getString("id");
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

				String InsertingData = "insert into currentdoctor(did) values ('" + id + "');";
				 // only patient can sign up 
					 //String QUERY 
					 int insetion = tables.insertData(InsertingData, "insert");
					 if(insetion == 1)
					 {
						 //JOptionPane.showMessageDialog(null, id);
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "couldnt sign up :("); 
					 }	
					  
			}
			
			
		});
	}
}
