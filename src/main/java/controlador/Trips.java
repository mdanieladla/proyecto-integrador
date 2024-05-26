package controlador;

import jakarta.servlet.ServletException;
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
		
		String userId = request.getParameter("userId");
		String id = request.getParameter("id");
		String destinationsId = request.getParameter("destinationsId");
		
		
		DaoTrip trips;
		
		try {
			if (request.getParameter("operationType") !=null) {
				int operationType = Integer.parseInt(request.getParameter("operationType"));
			
				if (operationType == 1) {
				/*READ - List ALL existing trips */
					trips = new DaoTrip();
					out.print(trips.listJson());
				} else if (operationType == 2) {
				/*READ - List trips - User with his ID can see his trips*/
					int idParsed = Integer.parseInt(userId);
					trips = new DaoTrip();
					out.print(trips.listByIdJson(idParsed));
				}  else if (operationType == 3) {
				/*CREATE - Insert trip - User can buy a trip*/
					Trip trip = new Trip(Integer.parseInt(destinationsId),Integer.parseInt(userId));
					DaoTrip dao = new DaoTrip();
					dao.insertTrip(trip);
					out.print("Created trip to destination with ID: " + destinationsId);
				} else if (operationType == 4) {
				/*DELETE - Delete trip - User can delete trip*/
					Trip trip = new Trip(Integer.parseInt(id));
					trip.deleteTrip(Integer.parseInt(id));
					out.print("Deleted trip with ID: " + id);
					System.out.println("borrando trip: " + id);
				} 
			} else {
				out.print("Error. No es una opción válida");
				System.out.println("No es una opción válida");
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
