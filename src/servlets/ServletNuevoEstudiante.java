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
 * Servlet implementation class ServletNuevoEstudiante
 */
@WebServlet(name="/ServletNuevoEstudiante", urlPatterns = {"/ServletNuevoEstudiante"})
public class ServletNuevoEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNuevoEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				// response.getWriter().append("Served at: ").append(request.getContextPath());
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<body>");
				out.println("Los datos se están mandando por el método post, no por aquí");
				out.println("</body>");
				out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String boton = request.getParameter("crearNuevo");
		String ficheroAdmin = "D:\\estudiantesAdmin.dat";
		ArrayList<Administrador> administradores = ControladorFicheros.leerFicheroAdmin(ficheroAdmin);
		
		for(Administrador ad : administradores) {
			
			if(boton != null && ad.getNombre().equals("admin")) {
				
				String fichero = "D:\\estudiantes.dat";
				ArrayList<Persona> estudiantes = ControladorFicheros.leerFichero(fichero);
				
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombreNuevo");
				String apellido = request.getParameter("apellidoNuevo");
				String edad = request.getParameter("edadNuevo");
				String carrera = request.getParameter("carreraNuevo");
				String semestre = request.getParameter("semestreNuevo");
				String email = request.getParameter("emailNuevo");
				String pass = request.getParameter("passNuevo");
				
				Persona p = new Persona(id, nombre, apellido, edad, carrera, semestre, email, pass);
				
				estudiantes.add(p);
				
				ControladorFicheros.guardarArrayList(estudiantes, fichero);
				
				response.sendRedirect("vistaAdministrador.jsp");
			}
		}
		
		
	}

}
