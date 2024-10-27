package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsAdmin extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsAdmin frame = new OptionsAdmin();
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
	public OptionsAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(263, 10, 128, 43);
		lblAdmin.setFont(new Font("Century Gothic", Font.BOLD, 26));
		contentPane.add(lblAdmin);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(536, -1, 108, 78);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 47, 439);
		contentPane.add(panel);
		
		JLabel Register = new JLabel("Register a new Doctor");
		Register.setFont(new Font("Tahoma", Font.BOLD, 12));
		Register.setBounds(148, 281, 142, 27);
		contentPane.add(Register);
		
		JLabel lblNewLabel_4 = new JLabel("View Patient Record");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(379, 281, 142, 27);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		         new RegisterDoc().setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\registerdoc.png"));
		btnNewButton.setBounds(148, 155, 142, 105);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		         new ViewPatient().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\x-rays.png"));
		btnNewButton_1.setBounds(369, 152, 142, 111);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
			        new JFrame1().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(552, 349, 85, 21);
		contentPane.add(btnNewButton_2);
	}
}
