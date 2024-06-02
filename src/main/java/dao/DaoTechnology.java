/**
 * @author Daniela Darnea
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Technology;

public class DaoTechnology {

	public static Connection con = null;

	/**
	 * Method to get connection to DB
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DaoTechnology() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	/**
	 * Method to list technologies
	 * @return technology of type ArrayList of Technology
	 * @throws SQLException
	 */
	private static ArrayList<Technology> list() throws SQLException {
		String sql = "SELECT * FROM technology";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Technology> technology = null;
		
		while (rs.next()) {
			if (technology == null) {
				technology = new ArrayList<Technology>();
			}
			
			technology.add(new Technology(rs.getInt("id"), rs.getString("name"), rs.getString("imagePortraitUrl"), rs.getString("imageLandscapeUrl"), rs.getString("description")));
		}
		
		return technology;
		
	}
	
	/**
	 * Method to list data as JSON
	 * @return jsonTxt
	 * @throws SQLException
	 */
	public static String listJson() throws SQLException {
		String jsonTxt = "";
		
		Gson gson = new Gson();
		
		jsonTxt = gson.toJson(list());
		
		System.out.println("resultado jsontxt TECHNOLOGY");
		System.out.println(jsonTxt);
		return jsonTxt;
	}
	
}
