/**
 * @author Daniela Darnea
 */
package modelo;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUser;

/**
 * Represents an User 
 */
public class User {
	private int id;
	private String name;
	private String email;
	/*NOTA: una contraseña no se puede guardar en un modelo 
	 * por la protección de datos
	 * */
	
	/**
	 * Constructor to generate void object of type user
	 * */
	public User() {
		
	}
	
	/**
	 * Constructor to create object from frontend form
	 * @param name Attribute only text
	 * @param email Attribute only text
	 */
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	/**
	 * Constructor for DB
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	/**
	 * Method to add id to the object
	 * @return id of type integer
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method to set id to the object
	 * @param id of type integer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method to add name to the object
	 * @return name of type String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set name to the object
	 * @param name of type String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to add email to the object
	 * @return email of type String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method to set email to object
	 * @param email of type String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method to insert user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insert() throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		dao.insert(this);
	}
	
	/**
	 * Method to get user by id
	 * @param id of type integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void getById(int id) throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		User usr = dao.getById(id);
		
		this.setId(usr.getId());
		this.setName(usr.getName());
		this.setEmail(usr.getEmail());
	}
	
	/**
	 * Method to get data as JSON
	 * @return String
	 */
	public String getJson() {
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this);
		return json;
	}
	
	/**
	 * Method to update users
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void update() throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		dao.update(this);
	}
	
	/**
	 * Method to delete user
	 * @param id of type integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteUser(int id) throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		dao.deleteUser(id);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
