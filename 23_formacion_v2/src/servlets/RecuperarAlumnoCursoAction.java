package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.FormacionService;

/**
 * Servlet implementation class RecuperarAlumnoCursoAction
 */
@WebServlet("/RecuperarAlumnoCursoAction")
public class RecuperarAlumnoCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FormacionService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("curso");
		
		List<Alumno> alumnos = service.buscarPorCurso(curso);
		
		request.setAttribute("alumnosCurso", alumnos);
	}

}
