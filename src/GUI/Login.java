package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Login {
	
	private String username = "niclas";
	private String password = "hejsan";
	
	private JTextPane user, pass;
	
	HomePage home;
	
	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(KeyEvent e) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblAnvndarnamn = new JLabel("Anv\u00E4ndarnamn");
		lblAnvndarnamn.setBounds(10, 47, 111, 14);
		frame.getContentPane().add(lblAnvndarnamn);
		
		JLabel lblLsenord = new JLabel("L\u00F6senord");
		lblLsenord.setBounds(10, 109, 71, 14);
		frame.getContentPane().add(lblLsenord);
		
		user = new JTextPane();
		user.setBounds(10, 72, 123, 20);
		frame.getContentPane().add(user);
		
		pass = new JTextPane();
		pass.setBounds(10, 134, 123, 20);
		frame.getContentPane().add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.getText();
				pass.getText();
				
				if(user.getText().equals(username) && pass.getText().equals(password)){
					home = new HomePage();
					frame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(frame, "Något blev fel, vänligen testa igen!");
					pass.setText("");
				}
			}
		});
		btnLogin.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
