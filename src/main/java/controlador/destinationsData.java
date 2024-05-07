package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Destinations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoDestinations;

/**
 * Servlet implementation class destinationsData
 */

public class destinationsData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public destinationsData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("application/json");
		System.out.println("va??");
		try {
			PrintWriter out = response.getWriter();
				
			daoDestinations daoDest = new daoDestinations();
			
			String results = daoDest.listJson();
			
			System.out.println(results);
			
			out.print(results);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*int id = request.getIntHeader("id");
	String name = request.getParameter("name");
	String imageUrl = request.getParameter("imageUrl");
	String description = request.getParameter("description");
	String distance = request.getParameter("distance");
	String travel = request.getParameter("travel");
	
	Destinations d1 =  new Destinations(id, name, imageUrl, description, distance, travel);
	System.out.println(d1.toString());
	
	try {
		d1.list();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		
		
	}

}
