package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class EliminarCandidato
 */
@WebServlet("/EliminarCandidatoAction")
public class EliminarCandidatoAction extends HttpServlet {
	@Autowired
	CandidatosService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCandidato=Integer.parseInt(request.getParameter("idCandidato"));
		
		service.eliminarCandidato(idCandidato);
	}

}
