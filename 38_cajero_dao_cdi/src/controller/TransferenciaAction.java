package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cuenta;
import service.CajeroService;

/**
 * Servlet implementation class TransferenciaAction
 */
@WebServlet("/TransferenciaAction")
public class TransferenciaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Inject
	CajeroService cajeroService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		cajeroService.transferencia(((Cuenta)session.getAttribute("cuenta")).getNumeroCuenta(), Integer.parseInt(request.getParameter("destino")), Double.parseDouble(request.getParameter("cantidad")));
	}

}
