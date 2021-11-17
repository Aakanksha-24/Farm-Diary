import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

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

import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class ExportDetails extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txttotal;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportDetails frame = new ExportDetails();
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
	public ExportDetails() {
		 con = Database.getconnect();
		setTitle("Export Details");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1296, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllExportCrops = new JLabel("All Export Crops Details In Our Farm");
		lblAllExportCrops.setForeground(new Color(128, 0, 0));
		lblAllExportCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAllExportCrops.setBounds(523, 11, 250, 21);
		contentPane.add(lblAllExportCrops);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 1260, 254);
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
				"Crops ID", "Crops Namw","Quantity", "Quantity in Kg/Q", "Quantity Amount", "Total Amount", "Export Company Name", "Photo"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(Color.ORANGE);
		table.setForeground(Color.BLACK);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					PreparedStatement ps = con.prepareStatement("SELECT* From Export");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.getDataVector().removeAllElements();
					while(rs.next())
					{
						String args[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getString(7)};
						dtm.addRow(args);
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(592, 352, 89, 35);
		contentPane.add(btnNewButton);
		
		txttotal = new JTextField();
		txttotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txttotal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				int i =0;
				double sum=0;
				while(table.getRowCount()!=1)
				{
					double amt = Double.parseDouble(table.getModel().getValueAt(i,5).toString());
					sum=amt+sum;
					txttotal.setText(""+sum);
					i++;
					
					
				}
					
			}
		});
		txttotal.setBounds(1184, 308, 86, 26);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblTotalExportCrops = new JLabel("Total Export Crops Collection");
		lblTotalExportCrops.setForeground(new Color(128, 0, 0));
		lblTotalExportCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTotalExportCrops.setBounds(992, 308, 182, 26);
		contentPane.add(lblTotalExportCrops);
	}
}
