import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class User extends JInternalFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField Pass;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		con = Database.getconnect();
		setClosable(true);
		setTitle("Set UserID & Password");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 578, 282);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User_ID");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label.setBounds(141, 93, 74, 29);
		contentPane.add(label);
		
		ID = new JTextField();
		ID.setForeground(Color.BLACK);
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ID.setColumns(10);
		ID.setBounds(234, 93, 175, 29);
		contentPane.add(ID);
		
		Pass = new JTextField();
		Pass.setForeground(Color.BLACK);
		Pass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Pass.setColumns(10);
		Pass.setBounds(234, 137, 175, 29);
		contentPane.add(Pass);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_1.setBounds(141, 137, 74, 29);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Set User_ID , Password & Use this Software");
		label_2.setForeground(new Color(128, 0, 0));
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_2.setBounds(141, 23, 317, 29);
		contentPane.add(label_2);
		
		JButton button = new JButton("Submitt");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("INSERT into User Values(?,?)");
					ps.setString(1,ID.getText().toString());
					ps.setString(2,Pass.getText().toString());
					ps.execute();
					JOptionPane.showMessageDialog(null,"User add Successfully");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		button.setForeground(new Color(128, 0, 0));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button.setBackground(new Color(224, 255, 255));
		button.setBounds(234, 188, 89, 34);
		contentPane.add(button);
	}
}
