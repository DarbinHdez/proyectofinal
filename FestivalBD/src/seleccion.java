import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

public class seleccion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private conecta conexionBD = new conecta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seleccion frame = new seleccion();
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
	public seleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona tu escenario y consulta las bandas disponibles para tus conciertos");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 40, 529, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblEscenario = new JLabel("Escenario:");
		lblEscenario.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblEscenario.setBounds(35, 104, 76, 13);
		contentPane.add(lblEscenario);
		
		JLabel lblBandas = new JLabel("Bandas:");
		lblBandas.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblBandas.setBounds(35, 160, 76, 13);
		contentPane.add(lblBandas);
		
		JButton btnNewButton = new JButton("Asignar");
		btnNewButton.setBounds(109, 224, 85, 21);
		contentPane.add(btnNewButton);
		
		JComboBox<String> comboBoxProv = new JComboBox<String>();
		comboBoxProv.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		comboBoxProv.setBounds(121, 101, 122, 21);
		contentPane.add(comboBoxProv);
		
		List<String> listaBandas = conexionBD.obtenerListaDeProveedores();
		DefaultComboBoxModel<String> bandasModel = new DefaultComboBoxModel<>(listaBandas.toArray(new String[0]));
		comboBoxProv.setModel(bandasModel);

		
		JComboBox<String> comboBoxBan = new JComboBox<String>();
		comboBoxBan.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		comboBoxBan.setBounds(121, 157, 122, 21);
		contentPane.add(comboBoxBan);

		comboBoxProv.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String provSeleccionado = (String) comboBoxProv.getSelectedItem();
		        conexionBD.obtenerBandas(provSeleccionado);
		    }
		});
		
		comboBoxProv.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        comboBoxBan.removeAllItems();
		        String proveedorSeleccionado = (String) comboBoxProv.getSelectedItem();
		        List<String> bandas = conexionBD.obtenerBandas(proveedorSeleccionado);
		        for (String banda : bandas) {
		            comboBoxBan.addItem(banda);
		        }
		    }
		});


		
		JList list = new JList();
		list.setBounds(283, 71, 357, 245);
		contentPane.add(list);
	}
}
