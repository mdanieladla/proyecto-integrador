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

import modelo.User;

public class DaoUser {

	public static Connection con = null;
	
	/**
	 * Method to get connection do DB
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DaoUser() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	/**
	 * Method to insert to DB user object
	 * @param user Object type user
	 * @throws SQLException
	 */
	
	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
	}
	
	/**
	 * Method to get user by id from DB
	 * @param id of type Int
	 * @return usr of type User
	 * @throws SQLException
	 */
	public User getById(int id) throws SQLException {
		
		String sql = "SELECT * FROM users WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		User usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		
		return usr;
	}
	
	/**
	 * Method login for user to login
	 * @param email of type String
	 * @param password of type String
	 * @return aux of type User
	 * @throws SQLException
	 */
	public User login(String email, String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE email=? AND password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		User aux = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		return aux;
	}
	
	/**
	 * Method to update user in DB
	 * @param usr of type User
	 * @throws SQLException
	 */
	public void update(User usr) throws SQLException {
		String sql = "UPDATE users SET username=?, email=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, usr.getName());
		ps.setString(2, usr.getEmail());
		ps.setInt(3, usr.getId());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Method to delete user in DB
	 * @param id of type Int
	 * @throws SQLException
	 */
	public void deleteUser(int id) throws SQLException {
		String sql = "DELETE FROM users WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Method to list Users
	 * @return listUsers of type Array of User
	 * @throws SQLException
	 */
	public ArrayList<User> list() throws SQLException {
		String sql = "SELECT * FROM users";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<User> listUsers = null;
		
		while (rs.next()) {
			
			if(listUsers == null) {
				listUsers = new ArrayList<User>();
			}
			
			listUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		return listUsers;
		
	}
	
	/**
	 * Method to create json for client
	 * @return json
	 * @throws SQLException 
	 */
	public String listJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.list());
		
		return json;
	}
	
	/**
	 * Method to return a response when user is logged in
	 * @param response of type boolean
	 * @return
	 */
	public String responseLogin(boolean response) {
		String json = "";
		Gson gson = new Gson();
		
		if (response) {
			json = gson.toJson("User logged successfully");
			return json;
		}
		
		json = gson.toJson("Incorrect password or user");
		return json;
	}
	
}
