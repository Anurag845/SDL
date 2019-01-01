import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7541216398235741159L;
	
	private JPanel contentPane;
	private JLabel lblWelcomeUser;
	private JButton btnSeeBuses;
	private JButton btnBookTicket;
	private JButton btnCancelTicket;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeUser = new JLabel("Welcome User");
		lblWelcomeUser.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcomeUser.setBounds(35, 186, 137, 33);
		contentPane.add(lblWelcomeUser);
		
		btnSeeBuses = new JButton("See buses");
		btnSeeBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(3);
					String businfo = "Busno" + "\t" + "Source" + "\t" + "Destination" + "\t" + "Date" + "\t" + "Fare" + "\n";
					int n = (int) TicketBooking.ois.readObject();
					System.out.println(n);
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
		btnSeeBuses.setBounds(282, 77, 117, 25);
		contentPane.add(btnSeeBuses);
		
		btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTicket bt = new BookTicket();
				bt.setVisible(true);
			}
		});
		btnBookTicket.setBounds(282, 179, 127, 25);
		contentPane.add(btnBookTicket);
		
		btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelTicket ct = new CancelTicket();
				ct.setVisible(true);
			}
		});
		btnCancelTicket.setBounds(282, 285, 127, 25);
		contentPane.add(btnCancelTicket);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrame.this.setVisible(false);
			}
		});
		btnBack.setBounds(164, 351, 117, 25);
		contentPane.add(btnBack);
	}
}
