package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsDoctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsDoctor frame = new OptionsDoctor();
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
	public OptionsDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblDoctor.setBounds(250, 10, 101, 43);
		contentPane.add(lblDoctor);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(202, 28, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\logo.jpeg"));
		lblNewLabel_3.setBounds(547, -1, 108, 78);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 47, 439);
		contentPane.add(panel);
		
		JButton Payment = new JButton("");
		Payment.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)                // goes to view and print record option 
			{
				navigateToViewPrintRecord();            // encalpulasion 
				//setVisible(false);
		        // new ViewandPrintRecord().setVisible(true);
				
			}
		});
		Payment.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\records.png"));
		Payment.setFont(new Font("Tahoma", Font.BOLD, 10));
		Payment.setBounds(97, 149, 178, 127);
		contentPane.add(Payment);
		
		JLabel lblNewLabel_1 = new JLabel("View/Print Record");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(137, 286, 108, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton Payment_1 = new JButton("");
		Payment_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)       // goes to add record option 
			{
				navigateToAddRecord();
				//setVisible(false);
		        // new AddRecord().setVisible(true);
			}
		});
		Payment_1.setIcon(new ImageIcon("C:\\Users\\kissa zahra\\Desktop\\SDA_Project\\addrecords.png"));
		Payment_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		Payment_1.setBounds(368, 149, 159, 127);
		contentPane.add(Payment_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add a new record");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(407, 286, 93, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("log out");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 logout();
				//setVisible(false);                   // logout 
				//   new JFrame1().setVisible(true);
			}
		});
		btnNewButton.setBounds(560, 330, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	private void navigateToViewPrintRecord() {
        setVisible(false);
        new ViewandPrintRecord().setVisible(true);
    }

    private void navigateToAddRecord() {
        setVisible(false);
        new AddRecord().setVisible(true);
    }

    private void logout() {
        setVisible(false);
        new JFrame1().setVisible(true);
    }
}
