import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Import extends JInternalFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField Name;
	private JTextField qty;
	private JTextField kg;
	private JTextField amount;
	private JTextField Description;
	private JButton btnNewButton;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import frame = new Import();
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
	public Import() {
		con = Database.getconnect();
		setClosable(true);
		setTitle("Import Crops");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 548, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Crops ID");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label.setBounds(41, 11, 105, 29);
		contentPane.add(label);
		
		ID = new JTextField();
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ID.setColumns(10);
		ID.setBounds(208, 11, 234, 29);
		contentPane.add(ID);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Name.setColumns(10);
		Name.setBounds(208, 47, 234, 29);
		contentPane.add(Name);
		
		qty = new JTextField();
		qty.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		qty.setColumns(10);
		qty.setBounds(208, 87, 234, 29);
		contentPane.add(qty);
		
		kg = new JTextField();
		kg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		kg.setColumns(10);
		kg.setBounds(208, 127, 234, 29);
		contentPane.add(kg);
		
		amount = new JTextField();
		amount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		amount.setColumns(10);
		amount.setBounds(208, 167, 234, 29);
		contentPane.add(amount);
		
		JLabel label_2 = new JLabel("Total Amount");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_2.setBounds(41, 167, 105, 29);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_3.setBounds(41, 167, 105, 29);
		contentPane.add(label_3);
		
		JLabel lblQuantityInKgq = new JLabel("Quantity in Kg/Q");
		lblQuantityInKgq.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantityInKgq.setBounds(41, 127, 105, 29);
		contentPane.add(lblQuantityInKgq);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantity.setBounds(41, 87, 105, 29);
		contentPane.add(lblQuantity);
		
		JLabel label_6 = new JLabel("Crops Name");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_6.setBounds(41, 47, 105, 29);
		contentPane.add(label_6);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDescription.setBounds(41, 207, 105, 29);
		contentPane.add(lblDescription);
		
		Description = new JTextField();
		Description.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Description.setColumns(10);
		Description.setBounds(208, 207, 234, 129);
		contentPane.add(Description);
		
		btnNewButton = new JButton("Submitt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("INSERT into Import Values(?,?,?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2,Name.getText().toString());
					ps.setString(3, qty.getText().toString());
					ps.setString(4, kg.getText().toString());
					ps.setString(5, amount.getText().toString());
					ps.setString(6, Description.getText().toString());
					ps.execute();
					JOptionPane.showMessageDialog(null,"Crops Import Successfully");					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(180, 355, 105, 29);
		contentPane.add(btnNewButton);
	}

}
