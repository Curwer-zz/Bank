package GUI;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.DropMode;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import arrayStuff.ID;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class HomePage {

	private JFrame frame;
	
	private JTabbedPane tabbedPane;
	private JPanel home, tran, peym, saved;
	private JTextArea txtrKr;
	private JLabel lblTillgngligt;
	private JLabel lblTill;
	private JTextArea payID, payName, sendcash;
	private JCheckBox chckbxSpara;
	private JButton btnSkicka;
	private JTextPane txtrhrKanMan, value, nickname;
	
	private String transfer;
	
	private String peymName, peyID;
	
	ID[] titles;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Bank madrassen");
		frame.setBounds(100, 100, 714, 475);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 678, 414);
		frame.getContentPane().add(tabbedPane);
		
		home = new JPanel();
		tran = new JPanel();
		peym = new JPanel();
		peym.setBackground(Color.WHITE);
		saved = new JPanel();
		
		tabbedPane.add("Översikt", home);
		home.setLayout(null);
		
		JLabel lblKonton = new JLabel("Konton:");
		lblKonton.setBounds(10, 11, 46, 14);
		home.add(lblKonton);
		
		txtrhrKanMan = new JTextPane();
		txtrhrKanMan.setText("1111-888.777-4\n2222-759.957-6\n4896-289.789-3");
		txtrhrKanMan.setBounds(102, 36, 132, 147);
		home.add(txtrhrKanMan);
		
		value = new JTextPane();
		value.setText("42 000 kr\n8 000 kr\n0 kr");
		value.setBounds(233, 36, 111, 147);
		home.add(value);
		
		nickname = new JTextPane();
		nickname.setText("Sparkonto\nÖppetkonto\nSparkonto");
		nickname.setBounds(10, 36, 92, 147);
		home.add(nickname);
		
		tabbedPane.add("Betalningar", tran);
		tabbedPane.add("Mottagarista", saved);
		saved.setLayout(null);
		
		JLabel lblOcr = new JLabel("OCR");
		lblOcr.setBounds(10, 11, 46, 14);
		saved.add(lblOcr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 339, 141);
		saved.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblPersoner = new JLabel("Personer");
		lblPersoner.setBounds(10, 193, 46, 14);
		saved.add(lblPersoner);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 218, 339, 122);
		saved.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		
		
		tabbedPane.add("Överföringar", peym);
		peym.setLayout(null);
		
		JLabel lblFrn = new JLabel("Fr\u00E5n:");
		lblFrn.setBounds(10, 15, 46, 14);
		peym.add(lblFrn);
		
		JTextArea txtrKonto = new JTextArea();
		txtrKonto.setText("Konto: 6666-666.666-6 ");
		txtrKonto.setColumns(1);
		txtrKonto.setBackground(Color.LIGHT_GRAY);
		txtrKonto.setEditable(false);
		txtrKonto.setBounds(86, 10, 330, 27);
		peym.add(txtrKonto);
		
		txtrKr = new JTextArea();
		txtrKr.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		txtrKr.setText("15 000 kr");
		txtrKr.setBackground(Color.LIGHT_GRAY);
		txtrKr.setBounds(86, 52, 85, 27);
		peym.add(txtrKr);
		
		lblTillgngligt = new JLabel("Tillg\u00E4ngligt:");
		lblTillgngligt.setBounds(10, 57, 72, 14);
		peym.add(lblTillgngligt);
		
		lblTill = new JLabel("TIll:");
		lblTill.setBounds(10, 108, 46, 14);
		peym.add(lblTill);
		
		payID = new JTextArea();
		payID.setBackground(Color.LIGHT_GRAY);
		payID.setBounds(86, 103, 330, 27);
		peym.add(payID);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(387, 130, 29, 20);
		peym.add(spinner);
		
		chckbxSpara = new JCheckBox("Spara");
		chckbxSpara.setBounds(422, 107, 72, 23);
		chckbxSpara.setSelected(true);
		peym.add(chckbxSpara);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 156, 46, 14);
		peym.add(lblName);
		
		payName = new JTextArea();
		payName.setBackground(Color.LIGHT_GRAY);
		payName.setBounds(86, 151, 330, 27);
		peym.add(payName);
		
		
		btnSkicka = new JButton("Skicka");
		btnSkicka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(chckbxSpara.isSelected()) {
					peyID = payID.getText();
					peymName = payName.getText();
					transfer = sendcash.getText(); 
					
					titles = new ID[]{
						new ID(peyID, peymName, transfer)	
					};
					
					ID.testData();
					
				} else {
					System.out.println("Hej");
				}
			}
	
		});
		btnSkicka.setBounds(574, 352, 89, 23);
		peym.add(btnSkicka);
		
		sendcash = new JTextArea();
		sendcash.setBackground(Color.LIGHT_GRAY);
		sendcash.setBounds(276, 52, 85, 27);
		peym.add(sendcash);
		
		JLabel lblverfra = new JLabel("\u00D6verf\u00F6ra:");
		lblverfra.setBounds(203, 57, 63, 14);
		peym.add(lblverfra);
		
	}
}
