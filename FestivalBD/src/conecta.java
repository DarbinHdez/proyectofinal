import java.sql.*;

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
	         myRs=  myStmt.executeQuery("SELECT * FROM bandas WHERE ID ="+ id);
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
	
	public boolean Inserta(String nombre,int festival, int repertorio, String genero) {
		 try {
			 Connection MyConn = DriverManager.getConnection(url, user, password);
			 Statement myStmt  = MyConn.createStatement();
			 String sql = "INSERT INTO bandas"
			 +"(Banda, `No.festivales`, `Repertorio de canciones`, Genero)"
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
	
			 String sql = "Delete from bandas Where ID="+id;
		     myStmt.executeUpdate(sql);
		     return true;
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	    }
		
	}


}
