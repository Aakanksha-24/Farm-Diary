import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuItem;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel center_panel;
	private JPanel center_panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Farm\\GEHU.jpg"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null,"you want to exit this Project ?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
				if(response==JOptionPane.OK_OPTION)
				{
					dispose();
				}
					else
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
		});
		
		setTitle("Farm Dairy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 463);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Master");
		mnNewMenu.setForeground(new Color(128, 0, 0));
		mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAddCrops = new JMenuItem("Add Crops");
		mntmAddCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addcrops ac = new Addcrops();
				ac.setVisible(true);
				center_panel.add(ac);
				center_panel.repaint();
				center_panel.revalidate();
				ac.setLocation(0, 0);
			
			}
		});
		mntmAddCrops.setForeground(new Color(128, 0, 0));
		mntmAddCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(mntmAddCrops);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add User");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u2 = new User();
				u2.setVisible(true);
				center_panel.add(u2);
				center_panel.repaint();
				center_panel.revalidate();
				u2.setLocation(0, 0);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_1.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int response = JOptionPane.showConfirmDialog(Home.this,"are you sure to Exit in this project","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
				if(response==JOptionPane.OK_OPTION)
				{
					dispose();
				}
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crops Photo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Photo p = new Photo();
				p.setVisible(true);
				p.setLocation(0,0);
				center_panel.add(p);
				center_panel.repaint();
				center_panel.revalidate();
			}
		});
		mntmNewMenuItem_3.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		mntmExit.setForeground(new Color(128, 0, 0));
		mntmExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(mntmExit);
		
		JMenu mnNewMenu_1 = new JMenu("Crops");
		mnNewMenu_1.setForeground(new Color(128, 0, 0));
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crops Details");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetailsCrops dc = new  DetailsCrops();
				dc.setVisible(true);
				center_panel.add(dc);
				center_panel.repaint();
				center_panel.revalidate();
				dc.setLocation(0, 0);
			}
		});
		mntmNewMenuItem_2.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnImport = new JMenu("Import");
		mnImport.setForeground(new Color(128, 0, 0));
		mnImport.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnImport);
		
		JMenuItem mntmImport = new JMenuItem("Import Crops");
		mntmImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Import ic = new Import();
				ic.setVisible(true);
				ic.setLocation(0, 0);
				center_panel.add(ic);
				center_panel.repaint();
				center_panel.revalidate();
			}
		});
		mntmImport.setForeground(new Color(128, 0, 0));
		mntmImport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mnImport.add(mntmImport);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Import Details");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ImportDetails id =new ImportDetails();
			id.setVisible(true);
			id.setLocation(0, 0);
			center_panel.add(id);
			center_panel.repaint();
			center_panel.revalidate();
			}
		});
		mntmNewMenuItem_5.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnImport.add(mntmNewMenuItem_5);
		
		JMenu mnExport = new JMenu("Export");
		mnExport.setForeground(new Color(128, 0, 0));
		mnExport.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnExport);
		
		JMenuItem mntmExportCrops = new JMenuItem("Export Crops");
		mntmExportCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Export e = new Export();
				e.setVisible(true);
				center_panel.add(e);
				e.setLocation(0, 0);
				center_panel.repaint();
				center_panel.revalidate();				
			}
		});
		mntmExportCrops.setForeground(new Color(128, 0, 0));
		mntmExportCrops.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mnExport.add(mntmExportCrops);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Export Details");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExportDetails ed = new ExportDetails();
				ed.setVisible(true);
				ed.setLocation(0, 0);
				center_panel.add(ed);
				center_panel.repaint();
				center_panel.revalidate();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnExport.add(separator_3);
		mntmNewMenuItem_4.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mnExport.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("LogOut");
		mnNewMenu_2.setForeground(new Color(128, 0, 0));
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("LogOut");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int response = JOptionPane.showConfirmDialog(Home.this,"are you sure to LogOut","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
				if(response==JOptionPane.OK_OPTION)
				{
					dispose();
				}
				else
				{
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}}
		});
		mntmNewMenuItem.setForeground(new Color(128, 0, 0));
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		center_panel = new JPanel()
		{			
					 public void paintComponent(Graphics g) 
					 {
			
						Image icon=new ImageIcon("C:\\Farm\\GEHU.jpg").getImage();
						g.drawImage(icon , 0, 0, getWidth(), getHeight(), this);
						 		
								}
					 ;
		};
		contentPane.add(center_panel, BorderLayout.CENTER);
		center_panel.setLayout(null);
	}
}
