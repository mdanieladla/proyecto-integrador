package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.User;

import java.sql.SQLException;

import dao.DaoUser;
/**
 * Servlet implementation class UserManagement
 */
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		/**
		* Para listar los usuarios
		*/
		DaoUser users;
		
		try {
			users = new DaoUser();
			out.print(users.listJson());

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/**
		 * Para borrar usuarios
		*/
		
		try {
			int id = Integer.parseInt(request.getParameter("id")); //TODO: arreglar errror de "cannot parse null string"
			DaoUser usr = new DaoUser();
			usr.deleteUser(id);
			System.out.println("Borrando " + id);
			out.print(usr.listJson());
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*SI DA TIEMPO PARA EL FRONT response.sendRedirect("listarUsuarios.html");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hola caracola");

		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		
		User user = new User(username, email);

		try {
			if (id == null) {
				/**
				 * Para insertar usuarios
				 */
				DaoUser dao = new DaoUser();
				dao.insert(user);
			} else {
				/**
				 * Para actualizar usuarios
				 */
				int idParsed = Integer.parseInt(id);
				user.setId(idParsed);
				user.update();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
