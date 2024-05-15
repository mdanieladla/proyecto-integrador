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
	
	public DaoCrew() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
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
			System.out.println("funciona crew");
		}
		return crew;
	}
	
	public static String listJson() throws SQLException {
		String jsonTxt = "";
		
		Gson gson = new Gson();
		
		jsonTxt = gson.toJson(list());
		
		System.out.println("resultado jsontxt");
		System.out.println(jsonTxt);
		return jsonTxt;
	}
}
