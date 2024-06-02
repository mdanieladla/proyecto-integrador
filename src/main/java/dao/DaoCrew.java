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

import modelo.Crew;

public class DaoCrew {

	public static Connection con = null;
	
	/**
	 * Method to get connection to DB
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DaoCrew() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	/**
	 * Method to list crew
	 * @return crew of type ArrayList of crew
	 * @throws SQLException
	 */
	private static ArrayList<Crew> list() throws SQLException {
		String sql = "SELECT * FROM crew";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Crew> crew = null;
		
		while (rs.next()) {
			if (crew == null) {
				crew = new ArrayList<Crew>();
			}
			
			crew.add(new Crew(rs.getInt("id"), rs.getString("name"), rs.getString("imageUrl"), rs.getString("role"), rs.getString("bio")));
		}
		return crew;
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
		
		System.out.println("resultado jsontxt CREW");
		System.out.println(jsonTxt);
		return jsonTxt;
	}
}
