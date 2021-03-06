package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.ControladorFicheros;
import model.Administrador;
import model.Persona;

/**
 * Servlet implementation class ServletLoguear
 */
@WebServlet(name = "/ServletLoguear", urlPatterns = { "/ServletLoguear" })
public class ServletLoguear extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLoguear() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Los datos se est�n mandando por el m�todo post, no por aqu�");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter out = response.getWriter();

		Boolean logueado = false;
		Boolean administrador = false;
		Boolean normal = false;

		String fichero = "D:\\estudiantes.dat";
		String ficheroAdmin = "D:\\estudiantesAdmin.dat";

		ArrayList<Persona> estudiantes = ControladorFicheros.leerFichero(fichero);
		ArrayList<Administrador> administradores = ControladorFicheros.leerFicheroAdmin(ficheroAdmin);

		for (Persona estudiante : estudiantes) {
			if (estudiante.getNombre().equals(request.getParameter("usuario")) && estudiante.getPassword().equals(request.getParameter("pass"))) {
				logueado = true;
				//response.sendRedirect("vistaLogueo.jsp");
				normal = true;
			}
				

		}

		for (Administrador admi : administradores) {
			if (admi.getNombre().equals(request.getParameter("usuario")) && admi.getPass().equals(request.getParameter("pass"))) {
				logueado = true;
				administrador = true;
				//response.sendRedirect("vistaAdministrador.jsp");
				
			}
		}
		if (!logueado) {
			response.sendRedirect("index.jsp");

		}

		else if(administrador == true){
			request.getSession().setAttribute("logueado", request.getParameter("usuario"));
			response.sendRedirect("vistaAdministrador.jsp");
			 
				
		}else if(normal == true) {
			request.getSession().setAttribute("logueado", request.getParameter("usuario"));
			response.sendRedirect("vistaLogueo.jsp");
			}
		
	}
}
