package co.previo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.previo.dao.CiclistaDao;
import co.previo.modelo.Ciclista;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CiclistaServlet
 */
@WebServlet("/")
public class CiclistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CiclistaDao ciclistaDao;
	
    public CiclistaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.ciclistaDao = new CiclistaDao();
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
					insertarCiclista(request, response);
					break;
				case "/delete":
					eliminarCiclista(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					actualizarCiclista(request, response);
					break;
				default:
					listCiclista(request, response);
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ciclista.jsp");
		dispatcher.forward(request, response);
	}

	public void insertarCiclista(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String birthdate= request.getParameter("birthdate");
		String country= request.getParameter("country");
		String team= request.getParameter("team");
		
		Ciclista ciclista= new Ciclista(name, email, birthdate, country, team);
		
		ciclistaDao.insert(ciclista);
		
		response.sendRedirect("list");
	}
	
	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int id= Integer.parseInt(request.getParameter("id"));
		Ciclista ciclistaActual= ciclistaDao.select(id);
		
		request.setAttribute("ciclista",ciclistaActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ciclista.jsp");
		dispatcher.forward(request, response);
	}
	
	public void actualizarCiclista(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		int id= Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String birthdate= request.getParameter("birthdate");
		String country= request.getParameter("country");
		String team= request.getParameter("team");
		
		
		Ciclista ciclista= new Ciclista(id, name, email, birthdate, country, team);
		
		ciclistaDao.update(ciclista);
		
		response.sendRedirect("list");
	}

	public void eliminarCiclista(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
		int id= Integer.parseInt(request.getParameter("id"));
	
		ciclistaDao.delete(id);
		
		response.sendRedirect("list");
	}
	
	public void listCiclista(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException{
				
		List <Ciclista> listCiclistas = ciclistaDao.selectAll();
		request.setAttribute("listCiclistas", listCiclistas);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("ciclistalist.jsp");
		dispatcher.forward(request, response);
	}

}
