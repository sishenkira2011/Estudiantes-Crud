package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Estudiante;

public interface EstudianteServicio {
	
	public List<Estudiante> ListarTodosLosEstudintes();
	
	public Estudiante GuardarEstudiante(Estudiante estudiante);
	
	public Estudiante ObtenerEstudiantePorId(Long id);
	
	public Estudiante ActualizarEstudiante(Estudiante estudiante);
	
	public void EliminarEstudiante(Long id);
	
}
