import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class registro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private conecta conexionBD = new conecta();
	private JTextField textField_3;
	ResultSet R;
	private JTextField textField_4;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public registro() {
		initialize();
	 
	}
	

	/**
	 * Create the frame.
	 */
	public void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de la banda:");
		lblNombre.setBounds(10, 52, 164, 13);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblNombre);
		
		JLabel lblAsistidos = new JLabel("Conciertos Asistidos:");
		lblAsistidos.setBounds(10, 93, 164, 13);
		lblAsistidos.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblAsistidos);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 135, 143, 13);
		lblGenero.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblGenero);
		
		textField = new JTextField();
		textField.setBounds(184, 50, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 91, 38, 19);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 133, 96, 19);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JButton btnAgregar = new JButton("Registrar");
		btnAgregar.setBounds(112, 241, 129, 35);
		btnAgregar.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    String banda = textField.getText();
				    int conciertos = Integer.parseInt(textField_1.getText());
				    int repertorio = Integer.parseInt(textField_4.getText());
				    String genero = textField_2.getText();

				    
				    boolean r = conexionBD.Inserta(banda, conciertos, repertorio, genero);

				    if (r) {
				        JOptionPane.showMessageDialog(null, "Banda agregada correctamente.");
				    } else {
				        JOptionPane.showMessageDialog(null, "No se pudo agregar la banda. Por favor, verifique los datos e intente nuevamente.");
				    }
				} catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Error al procesar la solicitud. Por favor, inténtelo nuevamente.");
				}
			}

		});
		contentPane.add(btnAgregar);
		
		JButton btnElminiarBanda = new JButton("Descartar Banda");
		btnElminiarBanda.setBounds(509, 241, 129, 35);
		btnElminiarBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id= Integer.parseInt(JOptionPane.showInputDialog(null,"Escribe el ID de la banda resgistrada para descartar"));
				 conexionBD.descartar(id);
				 R	 =conexionBD.getMyRs();	 
			       
			}
		});
		btnElminiarBanda.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		contentPane.add(btnElminiarBanda);
		
		JLabel lblRegistraTuBanda = new JLabel("Registra de banda para el festival");
		lblRegistraTuBanda.setBounds(228, 10, 285, 13);
		lblRegistraTuBanda.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		contentPane.add(lblRegistraTuBanda);
		
		JLabel lblNombre_1_3 = new JLabel("No.Integrantes");
		lblNombre_1_3.setBounds(355, 86, 110, 13);
		lblNombre_1_3.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblNombre_1_3);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(479, 120, 128, 28);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Bateria", "Vocal", "Guitarra", "Bajo", "Teclado"}));
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(479, 84, 55, 19);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel lblNombre_1_3_1 = new JLabel("Rol:");
		lblNombre_1_3_1.setBounds(356, 127, 55, 13);
		lblNombre_1_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblNombre_1_3_1);
		
		JLabel lblRepertorioDeCanciones = new JLabel("Repertorio de canciones:");
		lblRepertorioDeCanciones.setBounds(10, 173, 178, 13);
		lblRepertorioDeCanciones.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		contentPane.add(lblRepertorioDeCanciones);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 171, 38, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
	}
}
