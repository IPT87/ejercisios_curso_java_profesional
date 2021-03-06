package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.MatriculasService;

@Controller
public class MatriculasRangoController {
	@Autowired
	MatriculasService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaInicio = null;
	Date fechaFin = null;
	
	@PostMapping(value = "doConsultarMatriculas")
	public String matriculasRango(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin,
			HttpServletRequest request) {
		try {
			this.fechaInicio = sdf.parse(fechaInicio);
			this.fechaFin = sdf.parse(fechaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("matriculasRango", service.matriculasRangoFecha(this.fechaInicio, this.fechaFin));
		
		return "verMatriculasRango";
	}

}
