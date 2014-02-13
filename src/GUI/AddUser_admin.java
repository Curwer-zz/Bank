package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import DB.database_Reader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser_admin {
	
	private String userName;
	private String passWord;
	private JFrame frame;
	database_Reader dbr;
	
	JTextPane firstName, lastName, username, password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser_admin window = new AddUser_admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser_admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create a new user");
		lblCreateANew.setBounds(10, 11, 136, 14);
		frame.getContentPane().add(lblCreateANew);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(10, 36, 88, 14);
		frame.getContentPane().add(lblFirstname);
		
		firstName = new JTextPane();
		firstName.setBounds(10, 61, 136, 20);
		frame.getContentPane().add(firstName);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(174, 36, 81, 14);
		frame.getContentPane().add(lblLastname);
		
		lastName = new JTextPane();
		lastName.setBounds(173, 61, 136, 20);
		frame.getContentPane().add(lastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 92, 88, 14);
		frame.getContentPane().add(lblUsername);
		
		username = new JTextPane();
		username.setBounds(10, 117, 136, 20);
		frame.getContentPane().add(username);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(174, 92, 81, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextPane();
		password.setBounds(174, 117, 135, 20);
		frame.getContentPane().add(password);
		
		JLabel lblStartBalance = new JLabel("Start balance");
		lblStartBalance.setBounds(10, 148, 88, 14);
		frame.getContentPane().add(lblStartBalance);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(10, 173, 136, 20);
		frame.getContentPane().add(textPane_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = username.getText();
				passWord = password.getText();
				System.out.println(userName + " " + passWord);
				dbr = new database_Reader();
				dbr.AddUser(userName, passWord);
			}
		});
		btnSave.setBounds(485, 427, 89, 23);
		frame.getContentPane().add(btnSave);
	}
}
