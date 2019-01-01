import java.net.*;
import java.util.Scanner;
import java.awt.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TicketBooking extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldusr;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblWelcomeToBus;
	private JButton btnAdmin;
	private JButton btnUser;
	//public static DataOutputStream dos = null;
	public static ObjectOutputStream oos = null;
	//public static DataInputStream dis = null;
	public static ObjectInputStream ois = null;
	public Socket s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TicketBooking frame = new TicketBooking();
					frame.setVisible(true);
					
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketBooking() {
		super("Bus Ticket Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200,200,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.DARK_GRAY);
		//frame.setBounds(200, 200, 450, 450);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeToBus = new JLabel("Welcome to Bus Ticket Booking System");
		lblWelcomeToBus.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeToBus.setForeground(Color.WHITE);
		lblWelcomeToBus.setBounds(12, 37, 415, 39);
		contentPane.add(lblWelcomeToBus);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null,"Admin logged in");
				if(textFieldusr.getText().equals("Admin") && new String(passwordField.getPassword()).equals("1234")) {
					Adminframe obj = new Adminframe();
					obj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong username or password");
				}
			}
		});
		btnAdmin.setBounds(57, 337, 117, 25);
		contentPane.add(btnAdmin);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"User logged in");
				if(textFieldusr.getText().equals("User") && new String(passwordField.getPassword()).equals("1234")) {
					UserFrame obj;
					obj = new UserFrame();
					obj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong username or password");
				}
			}
		});
		btnUser.setBounds(274, 337, 117, 25);
		contentPane.add(btnUser);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(57, 157, 105, 30);
		contentPane.add(lblUsername);
		
		textFieldusr = new JTextField();
		textFieldusr.setBounds(260, 158, 131, 30);
		contentPane.add(textFieldusr);
		textFieldusr.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(57, 232, 105, 30);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 233, 131, 30);
		contentPane.add(passwordField);
		
		
		
		try {
			s = new Socket("localhost",3000);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("\nCONNECTED TO SERVER\n");
		try {
		
			
		//DataInputStream dis = new DataInputStream(s.getInputStream());
		//TicketBooking.dos = new DataOutputStream(s.getOutputStream());
		
		TicketBooking.oos = new ObjectOutputStream(s.getOutputStream());
		
		//TicketBooking.dis = new DataInputStream(s.getInputStream());
		
		TicketBooking.ois = new ObjectInputStream(s.getInputStream());
		
		setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		super("Bus Ticket Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200,200,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.DARK_GRAY);
		//frame.setBounds(200, 200, 450, 450);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeToBus = new JLabel("Welcome to Bus Ticket Booking System");
		lblWelcomeToBus.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeToBus.setForeground(Color.WHITE);
		lblWelcomeToBus.setBounds(12, 37, 415, 39);
		contentPane.add(lblWelcomeToBus);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null,"Admin logged in");
				if(textFieldusr.getText().equals("Admin") && new String(passwordField.getPassword()).equals("1234")) {
					Adminframe obj = new Adminframe();
					obj.setVisible(true);
					try {
						TicketBooking.dos.writeInt(1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong username or password");
				}
			}
		});
		btnAdmin.setBounds(57, 337, 117, 25);
		contentPane.add(btnAdmin);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"User logged in");
				if(textFieldusr.getText().equals("User") && new String(passwordField.getPassword()).equals("1234")) {
					UserFrame obj = new UserFrame();
					obj.setVisible(true);
					try {
						TicketBooking.dos.writeInt(2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong username or password");
				}
			}
		});
		btnUser.setBounds(274, 337, 117, 25);
		contentPane.add(btnUser);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(57, 157, 105, 30);
		contentPane.add(lblUsername);
		
		textFieldusr = new JTextField();
		textFieldusr.setBounds(260, 158, 131, 30);
		contentPane.add(textFieldusr);
		textFieldusr.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(57, 232, 105, 30);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 233, 131, 30);
		contentPane.add(passwordField);
	}*/
}
