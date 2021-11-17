import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Star\\145.jpg"));
		setResizable(false);
		setTitle("LoginSystem\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 284);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtlabel = new JLabel("UserName");
		txtlabel.setForeground(new Color(0, 0, 0));
		txtlabel.setBackground(Color.LIGHT_GRAY);
		txtlabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtlabel.setBounds(198, 85, 81, 26);
		contentPane.add(txtlabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(198, 136, 81, 26);
		contentPane.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setForeground(new Color(0, 0, 0));
		txtusername.setBackground(new Color(192, 192, 192));
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtusername.setBounds(289, 85, 146, 26);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setForeground(new Color(0, 0, 0));
		txtpassword.setBackground(new Color(192, 192, 192));
		txtpassword.setEchoChar('#');
		txtpassword.setBounds(289, 138, 146, 26);
		contentPane.add(txtpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
												
				String username = txtusername.getText();
				String password = txtpassword.getText();
				
				
				 if(username.contains("India") && password.contains("123"))
				{
					txtusername.setText(null);
					txtpassword.setText(null);
										
					Home m1 = new Home();
					m1.setVisible(true);
					m1.setExtendedState(MAXIMIZED_BOTH);
				}
				 //else if(username.contains("Niraj") && password.contains("1234"))
					//{s
					//	txtusername.setText(null);
					//txtpassword.setText(null);
											
						//MainReception m1 = MainReception();
						//m1.setVisible(true);
						//}			 
				 
				// else if(username.contains("india") && password.contains("1234"))
				//	{
					//	txtusername.setText(null);
					//	txtpassword.setText(null);
											
					//	MainReception mr = new MainReception();
					//	mr.setVisible(true);
						//mr.setExtendedState(MAXIMIZED_BOTH);
						
					//}			 
				 
					else
				{
					JOptionPane.showMessageDialog(null, "User_Id and Password not Match","login Error",JOptionPane.ERROR_MESSAGE);
					txtusername.setText(null);
					txtpassword.setText(null);
				}			
			}

			private Login Login_System() {
				// TODO Auto-generated method stub
				return null;
			}			
			
		});
		btnLogin.setIcon(null);
		btnLogin.setForeground(new Color(139, 0, 0));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogin.setBounds(289, 191, 81, 35);
		contentPane.add(btnLogin);
		
		JLabel lblElcomeL = new JLabel("Welcome to Farm Dairy Please Login  ");
		lblElcomeL.setForeground(new Color(139, 0, 139));
		lblElcomeL.setBackground(new Color(100, 149, 237));
		lblElcomeL.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblElcomeL.setBounds(42, 11, 362, 26);
		contentPane.add(lblElcomeL);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Star\\145.jpg"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(0, 56, 194, 197);
		contentPane.add(lblNewLabel);
	}
}
