import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class ImportDetails extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTotal;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportDetails frame = new ImportDetails();
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
	public ImportDetails() {
		con = Database.getconnect();
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1296, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllImportsCrops = new JLabel("All Imports Crops Details In Our Farm");
		lblAllImportsCrops.setForeground(new Color(128, 0, 0));
		lblAllImportsCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAllImportsCrops.setBounds(502, 11, 250, 21);
		contentPane.add(lblAllImportsCrops);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 1260, 305);
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
				"Crops ID", "Crops Name", "Quantity", "Quantity in Kg", "Amount", "Description"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(Color.ORANGE);
		table.setForeground(Color.BLACK);
		table.setRowHeight(30);

		
		JButton button = new JButton("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					PreparedStatement ps = con.prepareStatement("SELECT* From Import");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.getDataVector().removeAllElements();
					while(rs.next())
					{
						String args[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
						dtm.addRow(args);
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(128, 0, 0));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button.setBounds(590, 359, 89, 35);
		contentPane.add(button);
		
		JLabel lblTotalImportCrops = new JLabel("Total Import Crops Collection");
		lblTotalImportCrops.setForeground(new Color(128, 0, 0));
		lblTotalImportCrops.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTotalImportCrops.setBounds(992, 359, 182, 26);
		contentPane.add(lblTotalImportCrops);
		
		txtTotal = new JTextField();
		txtTotal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				int i = 0;
				double sum =0;
				while(table.getRowCount()!=1)
				{
					double amt = Double.parseDouble(table.getValueAt(i,4).toString());
					sum=amt+sum;
					txtTotal.setText(""+sum);
					i++;
					
				}
			}
		});
		txtTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtTotal.setColumns(10);
		txtTotal.setBounds(1184, 359, 86, 26);
		contentPane.add(txtTotal);
	}

}
