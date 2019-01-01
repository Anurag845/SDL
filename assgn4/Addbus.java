import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Addbus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldbno;
	private JTextField textFieldsrc;
	private JTextField textFielddest;
	private JLabel lblEnterBusNumber;
	private JLabel lblEnterSource;
	private JLabel lblEnterDestination;
	private JButton btnNewButton;
	private JButton btnBack;
	private JTextField textFielddt;
	private JTextField textFieldfr;
	private JLabel lblEnterDate;
	private JLabel lblEnterFare;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbus frame = new Addbus();
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
	public Addbus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEnterBusNumber = new JLabel("Enter bus number");
		lblEnterBusNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterBusNumber.setBounds(31, 45, 172, 27);
		contentPane.add(lblEnterBusNumber);
		
		textFieldbno = new JTextField();
		textFieldbno.setBounds(289, 50, 114, 19);
		contentPane.add(textFieldbno);
		textFieldbno.setColumns(10);
		
		lblEnterSource = new JLabel("Enter source");
		lblEnterSource.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterSource.setBounds(31, 93, 172, 15);
		contentPane.add(lblEnterSource);
		
		textFieldsrc = new JTextField();
		textFieldsrc.setBounds(289, 92, 114, 19);
		contentPane.add(textFieldsrc);
		textFieldsrc.setColumns(10);
		
		lblEnterDestination = new JLabel("Enter destination");
		lblEnterDestination.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDestination.setBounds(31, 136, 161, 27);
		contentPane.add(lblEnterDestination);
		
		textFielddest = new JTextField();
		textFielddest.setFont(new Font("Dialog", Font.PLAIN, 12));
		textFielddest.setBounds(289, 141, 114, 19);
		contentPane.add(textFielddest);
		textFielddest.setColumns(10);
		
		//Booking bk = new Booking();
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(1);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int bno = Integer.parseInt(textFieldbno.getText());
				String src = textFieldsrc.getText();
				String dest = textFielddest.getText();
				String dt = textFielddt.getText();
				int fare = Integer.parseInt(textFieldfr.getText());
				Bus b = new Bus(bno,src,dest,dt,fare);
				try {
					TicketBooking.oos.writeObject(b);
					JOptionPane.showMessageDialog(null,"Bus added successfully");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//bk.addbus(bno,src,dest);
				//create new object of bus and add to HashSet buses
			}
		});
		btnNewButton.setBounds(248, 359, 117, 25);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbus.this.setVisible(false);
			}
		});
		btnBack.setBounds(86, 359, 117, 25);
		contentPane.add(btnBack);
		
		lblEnterDate = new JLabel("Enter date");
		lblEnterDate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDate.setBounds(31, 202, 172, 15);
		contentPane.add(lblEnterDate);
		
		textFielddt = new JTextField();
		textFielddt.setBounds(289, 201, 114, 19);
		contentPane.add(textFielddt);
		textFielddt.setColumns(10);
		
		lblEnterFare = new JLabel("Enter fare");
		lblEnterFare.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterFare.setBounds(31, 260, 161, 15);
		contentPane.add(lblEnterFare);
		
		textFieldfr = new JTextField();
		textFieldfr.setBounds(289, 259, 114, 19);
		contentPane.add(textFieldfr);
		textFieldfr.setColumns(10);
	}
}
