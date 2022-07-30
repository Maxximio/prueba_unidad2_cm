package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPacienteRepository;
import com.example.demo.repository.model.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public void insertarService(Paciente paci) {
		this.pacienteRepository.insertar(paci);
	}

	@Override
	public Paciente buscarService(String cedula) {
		return this.pacienteRepository.buscar(cedula);
	}

	@Override
	public void actualizarService(Paciente paci) {
		this.pacienteRepository.actualizar(paci);
	}

	@Override
	public void eliminarService(String cedula) {
		this.pacienteRepository.eliminar(cedula);
	}

}
