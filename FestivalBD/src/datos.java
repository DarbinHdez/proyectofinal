import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class datos extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaDatos;

    public datos(ResultSet datos) {
      
        setTitle("Datos de Bandas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

     
        DefaultTableModel modeloTabla = new DefaultTableModel();

   
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Festivales Asistidos");
        modeloTabla.addColumn("Repertorio de canciones");
        modeloTabla.addColumn("Genero");

     
        try {
            while (datos.next()) {
                modeloTabla.addRow(new Object[]{
                        datos.getInt("ID"),
                        datos.getString("Banda"),
                        datos.getInt("No.Festivales"),
                        datos.getInt("Repertorio de canciones"),
                        datos.getString("Genero")
                        
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
        tablaDatos = new JTable(modeloTabla);

        
        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
