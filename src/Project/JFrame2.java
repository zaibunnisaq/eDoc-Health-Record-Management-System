package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.tables;

import javax.swing.JLabel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JFrame2 extends JFrame {
	
	
	 private String getUsernameInput() 
	 {
	        return UsernameField.getText();
	    }
	 private String getPasswordInput() 
	 {
	       // return passwordField.getPassword();
		 return passwordField.getText();
	    }

	private JPanel contentPane;
	private JTextField UsernameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * 
	 * 
	 */
	public JFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(168, 184, 92, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(168, 225, 92, 13);
		contentPane.add(lblNewLabel_1);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(296, 181, 136, 19);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		JButton LogIn = new JButton("Log in");
		
		LogIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		LogIn.setBounds(323, 313, 85, 21);
		contentPane.add(LogIn);
		
		JLabel lblNewLabel_2 = new JLabel("Log In ");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblNewLabel_2.setBounds(309, 8, 92, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_3.setBounds(0, 0, 108, 78);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JTextField();
		passwordField.setBounds(294, 224, 138, 19);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Patient", "Admin"}));
		comboBox.setBounds(296, 259, 138, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("log in as: ");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(168, 258, 73, 19);
		contentPane.add(lblNewLabel_4);
		LogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				 String selectedItem = (String) comboBox.getSelectedItem();
				// JOptionPane.showMessageDialog(null, selectedItem);
				String Username = getUsernameInput();
	 			//char[] Password = getPasswordInput();
				String Password = getPasswordInput();
				
				System.out.println("User username: " + Username);
				System.out.println("User password: " + Password);
				
				//JOptionPane.showMessageDialog(null,Password.toString());
				
				//String userType = "";
		if(selectedItem == "Patient")
		{
				 String selecting = "select uusername,upassword,uusertype from patient where uusername = '" + Username + "' and upassword ='" + Password + "'";
				 
				 
				// if(Username.equals("") || Password.equals("")  || Password.length == 0)
		        if(Username.equals("") || Password.equals("") )
				 {
					 JOptionPane.showMessageDialog(null, "Every field is required");
				 }
				 else
				 {
					 //String QUERY 
					int selected =   tables.selectdata(selecting, "select");
					if(selected == 1)
					{
						JOptionPane.showMessageDialog(null, "Sucessfuly login");;
					    String id = "";
						try 
						{
							Class.forName("com.mysql.jdbc.Driver");
					  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
						    Statement stmt = con.createStatement();
						
						    String usertypeQuery = "SELECT id FROM patient WHERE uusername = '" + Username + "'";
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

						String InsertingData = "insert into currentpatient(pid) values ('" + id + "');";
						 // only patient can sign up 
							 //String QUERY 
							 int insetion = tables.insertData(InsertingData, "insert");
							 if(insetion == 1)
							 {
								 //JOptionPane.showMessageDialog(null, id);  // patient id
							 }
							 else
							 {
								 JOptionPane.showMessageDialog(null, "couldnt sign up :("); 
							 }	
						/*try 
						{
							Class.forName("com.mysql.jdbc.Driver");
					  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
						    Statement stmt = con.createStatement();
						
						    String usertypeQuery = "SELECT uusertype FROM users WHERE uusername = '" + Username + "'";
						    ResultSet rs = stmt.executeQuery(usertypeQuery);

						    if (rs.next()) 
						    {
						        userType = rs.getString("uusertype");
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
						}*/
						 setVisible(false);
				            new OptionsPatient().setVisible(true);   // goes to patient page 
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "login unsucessful");
					}
				 }
		        //JOptionPane.showMessageDialog(null, "User type is!!!!!: " + userType);
		       // if ("Patient".equals(userType))          
				
		}
		else if(selectedItem == "Doctor")
		{
			String selecting = "select uusername,upassword,uusertype from doctor where uusername = '" + Username + "' and upassword ='" + Password + "'";
			 
			 
			// if(Username.equals("") || Password.equals("")  || Password.length == 0)
	        if(Username.equals("") || Password.equals("") )
			 {
				 JOptionPane.showMessageDialog(null, "Every field is required");
			 }
			 else
			 {
				 //String QUERY 
				int selected =   tables.selectdata(selecting, "select");
				if(selected == 1)
				{
					JOptionPane.showMessageDialog(null, "Sucessfuly login");;
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
							 //JOptionPane.showMessageDialog(null, "Sucessfully sign up");
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null, "couldnt sign up :("); 
						 }	
					
					/*try 
					{
						Class.forName("com.mysql.jdbc.Driver");
				  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
					    Statement stmt = con.createStatement();
					
					    String usertypeQuery = "SELECT uusertype FROM users WHERE uusername = '" + Username + "'";
					    ResultSet rs = stmt.executeQuery(usertypeQuery);

					    if (rs.next()) 
					    {
					        userType = rs.getString("uusertype");
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
					}*/
					 setVisible(false);
			            new OptionsDoctor().setVisible(true);   // goes to patient page 
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "login unsucessful");
				}
			 }
		}
		
		else
		{
			String selecting = "select uusername,upassword,uusertype from admin where uusername = '" + Username + "' and upassword ='" + Password + "'";
			 
			 
			// if(Username.equals("") || Password.equals("")  || Password.length == 0)
	        if(Username.equals("") || Password.equals("") )
			 {
				 JOptionPane.showMessageDialog(null, "Every field is required");
			 }
			 else
			 {
				 //String QUERY 
				int selected =   tables.selectdata(selecting, "select");
				if(selected == 1)
				{
					JOptionPane.showMessageDialog(null, "Sucessfuly login");;
					
					/*try 
					{
						Class.forName("com.mysql.jdbc.Driver");
				  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
					    Statement stmt = con.createStatement();
					
					    String usertypeQuery = "SELECT uusertype FROM users WHERE uusername = '" + Username + "'";
					    ResultSet rs = stmt.executeQuery(usertypeQuery);

					    if (rs.next()) 
					    {
					        userType = rs.getString("uusertype");
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
					}*/
					 setVisible(false);
			         new OptionsAdmin().setVisible(true);   // goes to patient page 
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "login unsucessful");
				}
			 }
		}   // else braxket 
	}
	});
}
}
