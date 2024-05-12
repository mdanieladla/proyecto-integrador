package modelo;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUser;

public class User {
	private int id;
	private String name;
	private String email;
	/*NOTA: una contraseña no se puede guardar en un modelo 
	 * por la protección de datos
	 * */
	
	/**
	 * Constructor para generar un objeto vacío de tipo usuario
	 * */
	
	public User() {
		
	}
	
	/**
	 * Constructor para creación del objeto desde el formulario.
	 * @param name Atributo solo texto
	 * @param email Atributo solo texto
	 */
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	/**
	 * Constructo para la base de datos
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
	 * Método de inclusión del id en el objeto
	 * @return devuelve el id en tipo entero
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void insert() throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		dao.insert(this);
	}
	
	public void getById(int id) throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		User usr = dao.getById(id);
		
		this.setId(usr.getId());
		this.setName(usr.getName());
		this.setEmail(usr.getEmail());
	}
	
	public String getJson() {
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this);
		return json;
	}
	
	public void update() throws ClassNotFoundException, SQLException {
		DaoUser dao = new DaoUser();
		dao.update(this);
	}
	
	/**
	 * 
	 * @param id
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
