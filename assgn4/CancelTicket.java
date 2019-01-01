import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblEnterBusNumber;
	private JLabel lblEnterNumberOf;
	private JLabel lblNewLabel;
	private JLabel lblEnterPassengerAadhar;
	private JButton btnSubmit;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelTicket frame = new CancelTicket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CancelTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEnterBusNumber = new JLabel("Enter bus number");
		lblEnterBusNumber.setBounds(51, 53, 177, 15);
		contentPane.add(lblEnterBusNumber);
		
		lblEnterNumberOf = new JLabel("Enter number of tickets");
		lblEnterNumberOf.setBounds(51, 144, 177, 15);
		contentPane.add(lblEnterNumberOf);
		
		lblNewLabel = new JLabel("Enter booking number");
		lblNewLabel.setBounds(51, 227, 177, 15);
		contentPane.add(lblNewLabel);
		
		lblEnterPassengerAadhar = new JLabel("Enter passenger Aadhar number");
		lblEnterPassengerAadhar.setBounds(51, 301, 237, 15);
		contentPane.add(lblEnterPassengerAadhar);
		
		textField = new JTextField();
		textField.setBounds(324, 51, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 142, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 225, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(324, 296, 114, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cancel tickets of requested passengers
				//loop to be executed for number of passengers
			}
		});
		btnSubmit.setBounds(296, 355, 117, 25);
		contentPane.add(btnSubmit);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelTicket.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(82, 355, 117, 25);
		contentPane.add(btnNewButton);
	}

}
