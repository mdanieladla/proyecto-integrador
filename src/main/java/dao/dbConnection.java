package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JAVADOC
 */
public class dbConnection {
	
	public static final String url = "jdbc:mysql://localhost:3306/spacetourism";
	public static Connection instance = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			instance = DriverManager.getConnection(url, "root", "");
			if (instance!=null) {
				System.out.println("Se ha conectado de forma correcta");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.printf("error", e);
		}
		
		return instance;
	}
}
