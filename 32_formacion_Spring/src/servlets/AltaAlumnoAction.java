package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Alumno;
import service.FormacionService;

/**
 * Servlet implementation class AltaAlumnoAction
 */
@WebServlet("/AltaAlumnoAction")
public class AltaAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	FormacionService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno alumno = new Alumno(request.getParameter("usuario"),
									Integer.parseInt(request.getParameter("edad")),
									request.getParameter("email"),
									request.getParameter("nombre"),
									request.getParameter("password"));
		
		service.altaAlumno(alumno);
	}

}
