import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JCheckBox;

import com.toedter.calendar.JDateChooser;


public class LoginSystem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JDateChooser dateChooer;
	Connection con;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem frame = new LoginSystem();
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
	public LoginSystem() {
		con = Database.getconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Star\\145.jpg"));
		setResizable(false);
		setTitle("LoginSystem\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 285);
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
		lblPassword.setBounds(198, 122, 81, 26);
		contentPane.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setForeground(new Color(0, 0, 0));
		txtusername.setBackground(new Color(248, 248, 255));
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtusername.setBounds(289, 85, 146, 26);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtpassword.setForeground(new Color(0, 0, 0));
		txtpassword.setBackground(new Color(248, 248, 255));
		txtpassword.setEchoChar('#');
		txtpassword.setBounds(289, 122, 146, 26);
		contentPane.add(txtpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtusername.getText();
				String password = txtpassword.getText();			
				try {
					/*try
					{
						SimpleDateFormat sdf = new SimpleDateFormat();
						Calendar cal=new GregorianCalendar(2019,02,25);
						System.out.println("");
						cal.add(Calendar.DAY_OF_MONTH,1);
						System.out.println("after Days add="+sdf.format(cal.getTime()));					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}*/
					PreparedStatement pst=con.prepareStatement("select * from User");
					ResultSet rs=pst.executeQuery();	
					
					while(rs.next())
					{										
								if(username.equals(""+rs.getString("UserName"))&&password.equals(""+rs.getString("Password")))
								{
									JOptionPane.showMessageDialog(null, "Login Successful");
									Home w=new Home();
									w.setExtendedState(MAXIMIZED_BOTH);
									w.setVisible(true);
									dispose();
									
								}
								//else
								//JOptionPane.showMessageDialog(null, "Either username or password is incorrect.");
					}
				
					}
				catch (Exception e) 
					{
						e.printStackTrace();
					}
				
				
			}
		});
		btnLogin.setIcon(null);
		btnLogin.setForeground(new Color(139, 0, 0));
		btnLogin.setBackground(new Color(224, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogin.setBounds(289, 190, 81, 35);
		contentPane.add(btnLogin);
		
		JLabel lblElcomeL = new JLabel("Welcome to Farm DairyPlease Login and Enter ");
		lblElcomeL.setForeground(new Color(139, 0, 139));
		lblElcomeL.setBackground(new Color(100, 149, 237));
		lblElcomeL.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblElcomeL.setBounds(57, 11, 358, 26);
		contentPane.add(lblElcomeL);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Star\\145.jpg"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(0, 56, 194, 197);
		contentPane.add(lblNewLabel);
		
		final JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxShowPassword.isSelected())
				{
					txtpassword.setEchoChar((char)0); 
				}
				else
				{
					txtpassword.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setForeground(new Color(128, 0, 0));
		chckbxShowPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chckbxShowPassword.setBounds(289, 157, 146, 19);
		contentPane.add(chckbxShowPassword);
		
		//JDateChooser dateChooser = new JDateChooser();
		//Date date1 = new Date();
		//dateChooser.setDate(date1);
		//dateChooser.setFont(new Font("Times New Roman",Font.PLAIN,15));
		//dateChooser.setBounds(10, 0, 146, 26);
		//contentPane.add(dateChooser);
	}
}
