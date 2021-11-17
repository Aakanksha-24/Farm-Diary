import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DetailsCrops extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JComboBox cb_type;
	private JLabel val;
	private JLabel lblImageInCrops;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsCrops frame = new DetailsCrops();
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
	public DetailsCrops() {
		con = Database.getconnect();
		setTitle("Crops Deails");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1296, 589);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Crops");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(432, 23, 107, 31);
		contentPane.add(lblNewLabel);
		
		cb_type = new JComboBox();
		cb_type.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_type.setBounds(549, 24, 262, 31);
		contentPane.add(cb_type);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 1260, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header=table.getTableHeader();
		header.setBackground(Color.CYAN);
		header.setForeground(Color.RED);
		header.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Crops ID", "Crops Name", "Season", "Season Time", "Soil", "Organic", "Organic in Kg", "Chemical Name", "Urea/Fasfhet No", "Fasfhet/Urea No"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(Color.ORANGE);
		table.setForeground(Color.BLACK);
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("SELECT * From Crops where Name=?");
					ps.setString(1,cb_type.getSelectedItem().toString());
					ResultSet rs = ps.executeQuery();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.getDataVector().removeAllElements();
					while(rs.next())
					{
						String args[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
						dtm.addRow(args);
					}
					try
					{
						PreparedStatement pst = con.prepareStatement("SELECT * From Crops where Name=?");
						pst.setString(1, cb_type.getSelectedItem().toString());
						ResultSet rst = pst.executeQuery();
						if(rst.next())
						{
							byte[] img = rst.getBytes("image");
							ImageIcon image = new ImageIcon(img);
							Image im = image.getImage();
							Image myImg = im.getScaledInstance(val.getWidth(),val.getHeight(),Image.SCALE_SMOOTH);
							ImageIcon newImage = new ImageIcon(myImg);
							val.setIcon(newImage);							
						}
						else
							JOptionPane.showMessageDialog(null, "Successfully");
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
								
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnNewButton.setBounds(848, 23, 89, 31);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(542, 278, 335, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		val = new JLabel("");
		val.setIcon(null);
		val.setBounds(0, 0, 335, 270);
		panel.add(val);
		
		lblImageInCrops = new JLabel("Image in Crops");
		lblImageInCrops.setForeground(new Color(128, 0, 0));
		lblImageInCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblImageInCrops.setBounds(425, 401, 107, 31);
		contentPane.add(lblImageInCrops);
		Combo();
	}
}
