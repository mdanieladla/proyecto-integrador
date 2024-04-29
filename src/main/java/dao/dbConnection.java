package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
	private String url = "jdbc:mysql://localhost:3306/spacetourism";
	private String user = "root";
	private String password = "";
	public static Connection connect = null;
	
	public dbConnection() {
		
	}
	
	public void connectDb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(url, user, password);
	}
	
	
	public void desconnectDb() throws SQLException {
		if (connect!=null) {
			connect.close();
		}
	}
	
	public void listDestinations() throws SQLException {
		if (connect!=null) {
			String query = "select * from destinations";
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery(query);
			String name;
			String imageUrl;
			String description;
			String distance;
			String travel;
			
			while (rs.next()) {
				name = (String)rs.getObject(1);
				imageUrl = (String)rs.getObject(2);
				description = (String)rs.getObject(3);
				distance = (String)rs.getObject(4);
				travel = (String)rs.getObject(5);
			}
			rs.close();
		} else {
			System.out.println("Conecta primero a la BD!");
		}
	}
}
