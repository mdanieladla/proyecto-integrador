package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.destinations;
/**
 * JAVADDOC
 */
public class daoDestinations {
	
	public static Connection con = null;

	public daoDestinations() throws SQLException, ClassNotFoundException {
		
		this.con = dbConnection.getConnection();
 		
	}
	
	private static ArrayList<destinations> list() throws SQLException {
		String sql = "SELECT * FROM destinations";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<destinations> destinations = null;
		
		while (rs.next()) {
			if (destinations == null) {
				destinations = new ArrayList<destinations>();
			}
			
			destinations.add(new destinations(rs.getInt("id"), rs.getString("name"), rs.getString("imageUrl"), rs.getString("description"), rs.getString("distance"), rs.getString("travel")));
		}
		
		return destinations;
	}
	
	public static String listJson() throws SQLException {
		String jsonTxt = "";
		
		Gson gson = new Gson();
		
		jsonTxt = gson.toJson(list());
		System.out.println("resultado jsontxt DESTINATIONS");
		System.out.println(jsonTxt);
		return jsonTxt;
	}

}
