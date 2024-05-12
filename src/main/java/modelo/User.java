package modelo;
import java.sql.SQLException;

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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
