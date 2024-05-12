package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.User;

public class DaoUser {

	public static Connection con = null;
	
	public DaoUser() throws ClassNotFoundException, SQLException {
		this.con = dbConnection.getConnection();
	}
	
	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO users (username, email) VALUES (?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		
		ps.executeUpdate();
		
		ps.close();
	}
}
