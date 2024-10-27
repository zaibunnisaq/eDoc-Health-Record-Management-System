package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class OptionsPatient extends JFrame {

	private JPanel contentPane;
    public String x;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsPatient frame = new OptionsPatient();
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
	public OptionsPatient(String y )
	{
		this.x = y;
	}
	public OptionsPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblNewLabel.setBounds(330, 35, 102, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_3.setBounds(646, 0, 108, 78);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAppointmentScheduling = new JButton("");
		btnAppointmentScheduling.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 setVisible(false);
		         new AppointmentScheduling().setVisible(true);
			}
		});
		btnAppointmentScheduling.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\appointment.png"));
		btnAppointmentScheduling.setBounds(119, 136, 235, 232);
		contentPane.add(btnAppointmentScheduling);
		
		JButton btnHealthcareReminders = new JButton("");
		btnHealthcareReminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
		         new healthcarereminders().setVisible(true);
			}
		});
		btnHealthcareReminders.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\reminders.png"));
		btnHealthcareReminders.setBounds(416, 136, 210, 225);
		contentPane.add(btnHealthcareReminders);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 47, 439);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment Scheduling");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(187, 385, 126, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Healthcare Reminders");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(475, 385, 125, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				   new JFrame1().setVisible(true);
			}
		});
		btnNewButton.setBounds(649, 406, 85, 21);
		contentPane.add(btnNewButton);
	}
}
