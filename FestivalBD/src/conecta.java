import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class conecta {
	private String url ;
	private  String user;
	private  String password ;
    private ResultSet myRs;
    //private  Connection MyConn;
    
public conecta() {
	 url = "jdbc:mysql://localhost:3306/festivalbd";
     user = "root";
     password = "";	
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}
	
public ResultSet getMyRs() {
		
		try {
			Connection   MyConn = DriverManager.getConnection(url, user, password);
		     Statement myStmt  = MyConn.createStatement();
	         myRs=  myStmt.executeQuery("SELECT * FROM bandas");
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}
public ResultSet getBandas() {
		
		try {
			Connection   MyConn = DriverManager.getConnection(url, user, password);
		     Statement myStmt  = MyConn.createStatement();
	         myRs=  myStmt.executeQuery("SELECT * FROM bandas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}

public ResultSet getBandas(int id) {
		
		try {
			Connection   MyConn = DriverManager.getConnection(url, user, password);
		     Statement myStmt  = MyConn.createStatement();
	         myRs=  myStmt.executeQuery("SELECT * FROM bandas WHERE ID_Banda ="+ id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return myRs;
	}
	public void setMyRs(ResultSet myRs) {
		this.myRs = myRs;
	}
	
	public List<String> obtenerListaDeProveedores() {
	    List<String> escenario = new ArrayList<>();

	    try (Connection connection = DriverManager.getConnection(url, user, password)) {
	        String sql = "SELECT Escenario FROM proveedores";
	        try (PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                String nombreproveedor = resultSet.getString("Escenario");
	                escenario.add(nombreproveedor);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return escenario;
	}

	
	public boolean Inserta(String nombre,int festival, int repertorio, String genero) {
		 try {
			 Connection MyConn = DriverManager.getConnection(url, user, password);
			 Statement myStmt  = MyConn.createStatement();
			 String sql = "INSERT INTO bandas"
			 +"(Banda, `Conciertos`, `Repertorio de canciones`, Genero)"
			 + "VALUES('"+ nombre +"','"+ festival +"','"+ repertorio +"','"+ genero +"')";
		     myStmt.executeUpdate(sql);
		     return true;
		     
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	     
	}
	

	public boolean descartar(int id) {
		try {
			 Connection MyConn = DriverManager.getConnection(url, user, password);
			 Statement myStmt  = MyConn.createStatement();
	
			 String sql = "Delete from bandas Where ID_Banda="+id;
		     myStmt.executeUpdate(sql);
		     return true;
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	    }
		
	}

	public List<String> obtenerBandas(String provSeleccionado) {
		 List<String> bandasDelProveedor = new ArrayList<>();

		    try (Connection connection = DriverManager.getConnection(url, user, password)) {
		    	String sql = "SELECT bandas.Banda " + "FROM bandas " +
	                     "INNER JOIN proveedores ON bandas.Conciertos >= proveedores.Conciertos " +
	                     "WHERE proveedores.Escenario = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, provSeleccionado);

		            try (ResultSet resultSet = statement.executeQuery()) {
		                while (resultSet.next()) {
		                    String banda = resultSet.getString("Banda");
		                    bandasDelProveedor.add(banda);
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return bandasDelProveedor;
		
	}



}
