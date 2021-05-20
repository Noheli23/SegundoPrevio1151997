package co.previo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.previo.dao.EquipoDao;
import co.previo.modelo.Equipo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EquipoServlet
 */
@WebServlet("/")
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EquipoDao equipoDao;
    public EquipoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.equipoDao = new EquipoDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
				switch(action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertarEquipo(request, response);
					break;
				case "/delete":
					eliminarEquipo(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					actualizarEquipo(request, response);
					break;
				default:
					listEquipo(request, response);
					break;
			}	
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("equipo.jsp");
		dispatcher.forward(request, response);
	}

	public void insertarEquipo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String birthdate= request.getParameter("birthdate");
		String country= request.getParameter("country");
		String team= request.getParameter("team");
		
		Equipo equipo= new Equipo(name, email, birthdate, country, team);
		
		equipoDao.insert(equipo);
		
		response.sendRedirect("list");
	}
	
	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int id= Integer.parseInt(request.getParameter("id"));
		Equipo equipoActual= equipoDao.select(id);
		
		request.setAttribute("equipo",equipoActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("equipo.jsp");
		dispatcher.forward(request, response);
	}
	
	public void actualizarEquipo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		int id= Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String birthdate= request.getParameter("birthdate");
		String country= request.getParameter("country");
		String team= request.getParameter("team");
		
		
		Equipo equipo= new Equipo(id, name, email, birthdate, country, team);
		
		equipoDao.update(equipo);
		
		response.sendRedirect("list");
	}

	public void eliminarEquipo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		int id= Integer.parseInt(request.getParameter("id"));
	
		equipoDao.delete(id);
		
		response.sendRedirect("list");
	}
	
	public void listEquipo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
				
		List <Equipo> listEquipos = equipoDao.selectAll();
		request.setAttribute("listEquipos", listEquipos);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("equipolist.jsp");
		dispatcher.forward(request, response);
	}

}
