package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import service.BuscadorService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador2")
public class Buscador2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Item> items=List.of(new Item("Casa del libro","http://casadellibro.es", new String[]{"libros","lectura","ocio"},"Libros y mas cosas"),
			new Item("La web del gamer","http://gamers.es", new String[]{"juegos","ordenadores","ocio"},"Todo sobre video juegos"),
			new Item("My computer","http://computerall.es", new String[]{"informatica","ordenadores"},"Ordenadores al mejor precio"),
			new Item("Fnac","http://fnac.es", new String[]{"juegos","ordenadores","libros"},"Bienvenido al mundo del ocio y la cultura"),
			new Item("Todo pelis","http://filmers.es", new String[]{"cine","peliculas","ocio"},"Entra en el mundo del cine"));		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String tema = request.getParameter("tema");
		
		BuscadorService service = new BuscadorService();
		
		List<Item> items = service.buscarItems(tema);
		
		if(items!=null) {
			//recorremos todos los item de la lista
			for(var item:items) {
				out.println("<h2><a href='"+item.getUrl()+"'>"+item.getTitulo()+"</a><br/>");
			}
			out.println("</body></html>");
		}
		else {
			//transferimos el control a otro servlet 
			//encargado de generar una página de error
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}

}