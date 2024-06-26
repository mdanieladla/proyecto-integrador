package controlador;

import jakarta.servlet.ServletException;
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
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		int operationType = Integer.parseInt(request.getParameter("operationType"));

		User user = new User(username, email, password);
		DaoUser users;
		try {
			if (operationType == 1) {
				/* List users */
				
				users = new DaoUser();
				out.print(users.listJson());
		
			} else if (operationType == 2) {
				/* Insert users */
				DaoUser dao = new DaoUser();
				dao.insert(user);
				out.print("User created");
			
			} else if (operationType == 3) {
				/* Update users */
				int idParsed = Integer.parseInt(id);
				user.setId(idParsed);
				user.update();
				out.print("Updated user with ID:" + idParsed);
			} else if (operationType == 4) {
				/* Delete user */
				int idParsed = Integer.parseInt(id);
				user.deleteUser(idParsed);
				out.print("Deleted user with ID: "  + id);

			} else {
				out.print("Error. No es una opción válida");
				System.out.println("No es una opción válida");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*TO DO: SI DA TIEMPO PARA EL FRONT response.sendRedirect("listarUsuarios.html");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
