import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JComboBox;

import java.awt.Color;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;


public class Addcrops extends JInternalFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField ID;
	private JLabel lblCropsId;
	private JLabel lblSeason;
	private JLabel lblSoil;
	private JComboBox Soil;
	private JLabel lblOrganic;
	private JTextField organic;
	private JLabel lblChemical;
	private JComboBox chemical;
	private JComboBox nu;
	private JComboBox no;
	private JButton btnSubmitt;
	private JLabel lblSetTheCrops;
	private JLabel lblCroping;
	private JComboBox Season;
	private JTextField kg;
	private JLabel nam;
	String s;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcrops frame = new Addcrops();
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
	public Addcrops() {
		con = Database.getconnect();
		setTitle("Crops");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 613, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCropsName = new JLabel("Crops Name");
		lblCropsName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCropsName.setBounds(49, 61, 105, 29);
		contentPane.add(lblCropsName);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Name.setBounds(164, 62, 207, 29);
		contentPane.add(Name);
		Name.setColumns(10);
		
		ID = new JTextField();
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ID.setColumns(10);
		ID.setBounds(164, 26, 207, 29);
		contentPane.add(ID);
		
		lblCropsId = new JLabel("Crops ID");
		lblCropsId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCropsId.setBounds(49, 25, 105, 29);
		contentPane.add(lblCropsId);
		
		lblSeason = new JLabel("Season Time");
		lblSeason.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSeason.setBounds(49, 135, 105, 29);
		contentPane.add(lblSeason);
		
		JComboBox Time = new JComboBox();
		Time.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Time.setModel(new DefaultComboBoxModel(new String[] {"July To Octobar", "November To March", "May To Jun"}));
		Time.setBounds(164, 136, 207, 29);
		contentPane.add(Time);
		
		lblSoil = new JLabel("Soil");
		lblSoil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoil.setBounds(49, 175, 105, 29);
		contentPane.add(lblSoil);
		
		Soil = new JComboBox();
		Soil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Soil.setModel(new DefaultComboBoxModel(new String[] {"Alluvial Soil", "Red Soil", "Regur Soil", "Other"}));
		Soil.setBounds(164, 175, 207, 29);
		contentPane.add(Soil);
		
		lblOrganic = new JLabel("Organic");
		lblOrganic.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblOrganic.setBounds(49, 210, 105, 29);
		contentPane.add(lblOrganic);
		
		organic = new JTextField();
		organic.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		organic.setColumns(10);
		organic.setBounds(164, 210, 207, 29);
		contentPane.add(organic);
		
		lblChemical = new JLabel("Chemical");
		lblChemical.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChemical.setBounds(49, 281, 105, 29);
		contentPane.add(lblChemical);
		
		chemical = new JComboBox();
		chemical.setModel(new DefaultComboBoxModel(new String[] {"Urea & Fasphet", "Fasphet & Urea", "Other"}));
		chemical.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chemical.setBounds(164, 282, 207, 29);
		contentPane.add(chemical);
		
		nu = new JComboBox();
		nu.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		nu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nu.setBounds(394, 281, 49, 29);
		contentPane.add(nu);
		
		no = new JComboBox();
		no.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		no.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		no.setBounds(473, 281, 49, 29);
		contentPane.add(no);
		
		btnSubmitt = new JButton("Submitt");
		btnSubmitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					PreparedStatement ps = con.prepareStatement("INSERT into Crops Values(?,?,?,?,?,?,?,?,?,?,?)");
					FileInputStream is = new  FileInputStream(new File(s));
					ps.setInt(1, 0);
					ps.setString(2,Name.getText().toString());
					ps.setString(3,Season.getSelectedItem().toString());
					ps.setString(4,chemical.getSelectedItem().toString());
					ps.setString(5,Soil.getSelectedItem().toString());
					ps.setString(6,organic.getText().toString());
					ps.setString(7, kg.getText().toString());
					ps.setString(8,chemical.getSelectedItem().toString());
					ps.setString(9,nu.getSelectedItem().toString());
					ps.setString(10,no.getSelectedItem().toString());
					ps.setBlob(11,is);					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Crops Add Successfully");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnSubmitt.setForeground(new Color(128, 0, 0));
		btnSubmitt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSubmitt.setBackground(new Color(224, 255, 255));
		btnSubmitt.setBounds(217, 572, 94, 29);
		contentPane.add(btnSubmitt);
		
		lblSetTheCrops = new JLabel("Set the Crops Details");
		lblSetTheCrops.setForeground(new Color(128, 0, 0));
		lblSetTheCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSetTheCrops.setBounds(226, 0, 217, 29);
		contentPane.add(lblSetTheCrops);
		
		lblCroping = new JLabel("Crops Season");
		lblCroping.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCroping.setBounds(49, 96, 105, 29);
		contentPane.add(lblCroping);
		
		Season = new JComboBox();
		Season.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Season.setModel(new DefaultComboBoxModel(new String[] {"Kharif", "Rabi", "Other"}));
		Season.setBounds(164, 97, 207, 29);
		contentPane.add(Season);
		
		JLabel lblOrganicInKg = new JLabel("Organic In Kg/Q");
		lblOrganicInKg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblOrganicInKg.setBounds(49, 241, 105, 29);
		contentPane.add(lblOrganicInKg);
		
		kg = new JTextField();
		kg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		kg.setColumns(10);
		kg.setBounds(164, 246, 207, 29);
		contentPane.add(kg);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblX.setBounds(453, 281, 22, 29);
		contentPane.add(lblX);
		
		JPanel panel = new JPanel();
		panel.setBounds(164, 322, 313, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nam = new JLabel("");
		nam.setBounds(0, 0, 313, 239);
		panel.add(nam);
		
		JLabel lblChoosePhoto = new JLabel("Choose Photo");
		lblChoosePhoto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChoosePhoto.setBounds(49, 410, 105, 29);
		contentPane.add(lblChoosePhoto);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
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
		btnChoose.setForeground(new Color(128, 0, 0));
		btnChoose.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnChoose.setBackground(new Color(224, 255, 255));
		btnChoose.setBounds(493, 410, 94, 29);
		contentPane.add(btnChoose);
	}

	}
