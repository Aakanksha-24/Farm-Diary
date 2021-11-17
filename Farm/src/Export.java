import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Export extends JInternalFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField Name;
	private JTextField no;
	private JTextField kg;
	private JTextField amount;
	private JTextField total_amount;
	String s;
	private JLabel nam;
	private JTextField Com;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Export frame = new Export();
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
	
	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage=new ImageIcon(ImagePath);
		Image img=MyImage.getImage();
		Image newImg=img.getScaledInstance(nam.getWidth(),nam.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		return image;
	}
	
	public Export() {
		con = Database.getconnect();
		setTitle("Export Crops");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 680, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Crops ID");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label.setBounds(27, 11, 105, 29);
		contentPane.add(label);
		
		id = new JTextField();
		id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(194, 11, 207, 29);
		contentPane.add(id);
		
		JLabel label_1 = new JLabel("Crops Name");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_1.setBounds(27, 47, 105, 29);
		contentPane.add(label_1);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Name.setColumns(10);
		Name.setBounds(194, 47, 207, 29);
		contentPane.add(Name);
		
		JLabel label_8 = new JLabel("Choose Photo");
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_8.setBounds(27, 288, 105, 29);
		contentPane.add(label_8);
		
		JButton button = new JButton("Choose");
		button.addActionListener(new ActionListener() {
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
		button.setForeground(new Color(128, 0, 0));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.setBackground(new Color(224, 255, 255));
		button.setBounds(576, 328, 78, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submitt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("INSERT into Export Values(?,?,?,?,?,?,?,?)");
					FileInputStream is = new FileInputStream(new File(s));
					ps.setInt(1, 0);
					ps.setString(2,Name.getText().toString());
					ps.setString(3,no.getText().toString());
					ps.setString(4,kg.getText().toString());
					ps.setString(5, amount.getText().toString());
					ps.setString(6, total_amount.getText().toString());
					ps.setBlob(7, is);
					ps.setString(8, Com.getText().toString());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Saved Successfully");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(128, 0, 0));
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button_1.setBackground(new Color(224, 255, 255));
		button_1.setBounds(276, 606, 94, 29);
		contentPane.add(button_1);
		
		JLabel lblQuantity = new JLabel("Quantity For Sale");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantity.setBounds(27, 87, 105, 29);
		contentPane.add(lblQuantity);
		
		no = new JTextField();
		no.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		no.setColumns(10);
		no.setBounds(194, 87, 207, 29);
		contentPane.add(no);
		
		JLabel lblQuantityAmount = new JLabel("Quantity in Kg/Q");
		lblQuantityAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantityAmount.setBounds(27, 127, 105, 29);
		contentPane.add(lblQuantityAmount);
		
		kg = new JTextField();
		kg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		kg.setColumns(10);
		kg.setBounds(194, 127, 207, 29);
		contentPane.add(kg);
		
		JLabel lblTotalAmount = new JLabel("Quantity Amount");
		lblTotalAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTotalAmount.setBounds(27, 167, 105, 29);
		contentPane.add(lblTotalAmount);
		
		amount = new JTextField();
		amount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		amount.setColumns(10);
		amount.setBounds(194, 167, 207, 29);
		contentPane.add(amount);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(194, 289, 372, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nam = new JLabel("");
		nam.setBounds(0, 0, 372, 306);
		panel.add(nam);
		
		JLabel label_2 = new JLabel("Total Amount");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_2.setBounds(27, 204, 105, 29);
		contentPane.add(label_2);
		
		total_amount = new JTextField();
		total_amount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		total_amount.setColumns(10);
		total_amount.setBounds(194, 204, 207, 29);
		contentPane.add(total_amount);
		
		JLabel lblCompanyNameTo = new JLabel("Company Name To Export");
		lblCompanyNameTo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCompanyNameTo.setBounds(27, 244, 168, 29);
		contentPane.add(lblCompanyNameTo);
		
		Com = new JTextField();
		Com.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Com.setColumns(10);
		Com.setBounds(194, 244, 399, 29);
		contentPane.add(Com);
	}
}
