import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class GUICON extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICON frame = new GUICON();
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
	public GUICON() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONCIERTOSMID");
		lblNewLabel.setBounds(224, 29, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RECINTO:");
		lblNewLabel_1.setBounds(52, 134, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(149, 130, 181, 22);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"FORO GNP", "CARLOS ITURRALDE", "LA ISLA", "POLIFORUM ZAMNA"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("CAPACIDAD:");
		lblNewLabel_2.setBounds(52, 178, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(149, 175, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA:");
		lblNewLabel_3.setBounds(57, 223, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(149, 219, 86, 22);
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"DIC 01-10", "DIC 11-20", "DIC 21-30"}));
		contentPane.add(comboBox_1);
		conecta conexion = new conecta();
		JLabel lblNewLabel_4 = new JLabel("BANDA:");
		lblNewLabel_4.setBounds(52, 87, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(149, 83, 106, 22);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"BANDA S", "BANDA Y"}));
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Bandas Disponibles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet resultSet = conexion.getBandas();

		        datos cartelera = new datos(resultSet);
		        cartelera.setVisible(true);
			}
		});
		btnNewButton.setBounds(392, 134, 142, 38);
		contentPane.add(btnNewButton);
	}
}
