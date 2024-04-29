package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class principal {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/spacetourism";
		Connection connect = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, "root", "");
			if (connect!=null) {
			System.out.println("Se ha conectado de forma correcta");
			}
			
			String query = "select * from destinations";
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//Se supone que el rs esta lleno de datos
			while (rs.next()) {
				//Tambien se puede coger así: rs.getObject("idpersona") poniendo tal cual es nombre de la columna
				System.out.println(" Nombre:" + rs.getObject(1));
				System.out.println(" imageurl:" + rs.getObject(2));
				System.out.println(" description:" + rs.getObject(3));
				System.out.println(" distance:" + rs.getObject(4));
				System.out.println(" travel:" + rs.getObject(5));
				System.out.println("-------------------------");
			}
			rs.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		dbConnection myConnection = new dbConnection();
		myConnection.connectDb();
		myConnection.listDestinations();
	}
}
