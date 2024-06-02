/**
 * @author Daniela Darnea
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	/**
	 * Define url for connection to DB
	 */
	public static final String url = "jdbc:mysql://localhost:3306/spacetourism";
	public static Connection instance = null;
	
	/**
	 * Method to get connection to DB
	 * @return instance
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
