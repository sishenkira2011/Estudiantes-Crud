package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public List<Estudiante> ListarTodosLosEstudintes() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Estudiante GuardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante ObtenerEstudiantePorId(Long id) {

		return repositorio.findById(id).get();
	}

	@Override
	public Estudiante ActualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

	@Override
	public void EliminarEstudiante(Long id) {
		repositorio.deleteById(id);
	}

}
