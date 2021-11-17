import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.sql.PreparedStatement;

import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class Photo extends JInternalFrame {

	private JPanel contentPane;
	private JLabel nam;
	private JComboBox cb_type;
	String s;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Photo frame = new Photo();
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
	
	public void Combo()
	{
		con = Database.getconnect();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT * From Crops");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cb_type.addItem(rs.getString("Name"));
				cb_type.getSelectedItem();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage=new ImageIcon(ImagePath);
		Image img=MyImage.getImage();
		Image newImg=img.getScaledInstance(nam.getWidth(),nam.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		return image;
	}
	public Photo() {
		con = Database.getconnect();
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 671, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Choose Photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result=file.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					File selectedFile=file.getSelectedFile();
					String path=selectedFile.getAbsolutePath();
					nam.setIcon(ResizeImage(path));
					nam.setPreferredSize(new Dimension(205, 173));
					s=path;
					
				}
				
				else if(result==JFileChooser.CANCEL_OPTION)
				{
					System.out.println("No File Selected");
				}
				JOptionPane.showMessageDialog(null,"Image Upload SuccessFully");
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(496, 207, 130, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select Crops");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 36, 113, 23);
		contentPane.add(lblNewLabel);
		
		cb_type = new JComboBox();
		cb_type.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_type.setBounds(134, 31, 352, 32);
		contentPane.add(cb_type);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 87, 352, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nam = new JLabel("");
		nam.setBounds(0, 0, 352, 267);
		panel.add(nam);
		
		JButton btnNewButton_1 = new JButton("Submitt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("INSERT into Photo Values(?,?)");
					FileInputStream is = new  FileInputStream(new File(s));
					ps.setString(1,cb_type.getSelectedItem().toString());
					ps.setBlob(2,is);
					ps.executeUpdate();					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(285, 371, 77, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSelectPhoto = new JLabel("Select Photo");
		lblSelectPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSelectPhoto.setBounds(10, 170, 113, 23);
		contentPane.add(lblSelectPhoto);
		Combo();
	}
}
