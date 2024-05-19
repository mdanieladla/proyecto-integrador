package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Trip;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoTrip;

/**
 * Servlet implementation class Trips
 */
public class Trips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trips() {
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
		
		String id = request.getParameter("userId");
		
		int operationType = Integer.parseInt(request.getParameter("operationType"));
		
		int parsedId = Integer.parseInt(id);
		Trip trip = new Trip(parsedId);
		DaoTrip trips;
		
		try {
			if (operationType == 1) {
			/*Listar trips -READ- - el user ve su viaje contratado*/
				trips = new DaoTrip();
				out.print(trips.listJson(parsedId));
			} else if (operationType == 2) {
			/*CREATE/insertar trip - contratar un viaje*/
				DaoTrip dao = new DaoTrip();
				dao.insertTrip(trip);
			} else if (operationType == 3) {
			/* Borrar (cancelar) trip*/
				trip.deleteTrip(parsedId);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
