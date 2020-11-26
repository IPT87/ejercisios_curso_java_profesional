package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.AlumnosService;

@Controller
public class AlumnosCursoController {
	@Autowired
	AlumnosService service;

	@PostMapping(value = "doAlumnosCurso")
	public String alumnosCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		request.setAttribute("alumnoscurso", service.alumnosCurso(idCurso));
		return "alumnoscurso";
	}
}
