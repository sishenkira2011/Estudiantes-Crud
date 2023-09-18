package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/estudiantes", "/" })
	public String ListarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.ListarTodosLosEstudintes());
		return "estudiantes";
	}

	@GetMapping("/estudiantes/nuevo")
	public String MostrarFormularioDeRegistrarEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}

	@PostMapping("/estudiantes")
	public String GuardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {

		servicio.GuardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String MostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.ObtenerEstudiantePorId(id));
		return "editar_estudiante";

	}

	@PostMapping("/estudiantes/{id}")
	public String ActualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante EstudianteExistente = servicio.ObtenerEstudiantePorId(id);
		EstudianteExistente.setId(id);
		EstudianteExistente.setNombre(estudiante.getNombre());
		EstudianteExistente.setApellido(estudiante.getApellido());
		EstudianteExistente.setEmail(estudiante.getEmail());

		servicio.ActualizarEstudiante(EstudianteExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String EliminarEstudiante(@PathVariable Long id) {
		servicio.EliminarEstudiante(id);
		return "redirect:/estudiantes";
	}

}
