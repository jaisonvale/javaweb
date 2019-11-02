package javaweb;

import   java.sql.Connection ; 
import   java.sql.DriverManager ;
import   java.sql.SQLException ; 


public   class   ConnectionNew  { 
    
public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/jaison", "root", "root");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
public static void main(String[] args) throws SQLException {
			Connection connection = new ConnectionNew().getConnection();
			
			System.out.println("Conection ao Banco");
			connection.close();
	}
}


