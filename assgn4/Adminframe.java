import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Adminframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAdminServices;
	private JButton btnAddBus;
	private JButton btnCancelBus;
	private JButton btnBack;
	private JButton btnShowBuses;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminframe frame = new Adminframe();
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
	public Adminframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAdminServices = new JLabel("Admin Services");
		lblAdminServices.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdminServices.setBounds(30, 186, 147, 62);
		contentPane.add(lblAdminServices);
		
		btnAddBus = new JButton("Add bus");
		btnAddBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbus ab = new Addbus();
				ab.setVisible(true);
			}
		});
		btnAddBus.setBounds(288, 78, 123, 25);
		contentPane.add(btnAddBus);
		
		btnCancelBus = new JButton("Cancel bus");
		btnCancelBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBus cb = new CancelBus();
				cb.setVisible(true);
			}
		});
		btnCancelBus.setBounds(288, 239, 123, 25);
		contentPane.add(btnCancelBus);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminframe.this.setVisible(false);
			}
		});
		btnBack.setBounds(181, 331, 117, 25);
		contentPane.add(btnBack);
		
		btnShowBuses = new JButton("Show Buses");
		btnShowBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(3);
					String businfo = "Busno" + "\t" + "Source" + "\t" + "Destination" + "\t" + "Date" + "\t" + "Fare" + "\n";
					int n = (int) TicketBooking.ois.readObject();
					//System.out.println(n);
					for(int i = 0 ; i < n; i++) {
						Bus b = (Bus)TicketBooking.ois.readObject();
						businfo += b.busno + "\t" + b.source + "\t" + b.destination + "\t" + b.date + "\t" + b.fare + "\n";
					}
					JOptionPane.showMessageDialog(null,new JTextArea(businfo));
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowBuses.setBounds(288, 162, 123, 25);
		contentPane.add(btnShowBuses);
	
	}
}
