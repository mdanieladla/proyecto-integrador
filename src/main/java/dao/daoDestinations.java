package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Destinations;

public class daoDestinations {
	
	public static Connection con = null;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		daoDestinations.con = dbConnection.getConnection();
		
		listJson();
	}
	
	private static ArrayList<Destinations> list() throws SQLException {
		String sql = "SELECT * FROM destinations";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Destinations> destinations = null;
		
		while (rs.next()) {
			if (destinations == null) {
				destinations = new ArrayList<Destinations>();
			}
			
			destinations.add(new Destinations(rs.getInt("id"), rs.getString("name"), rs.getString("imageUrl"), rs.getString("description"), rs.getString("distance"), rs.getString("travel")));
			System.out.println("funciona");
		}
		
		return destinations;
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
