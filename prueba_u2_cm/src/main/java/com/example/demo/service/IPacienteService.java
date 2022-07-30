package com.example.demo.service;

import com.example.demo.repository.model.Paciente;

public interface IPacienteService {

	public void insertarService(Paciente paci);

	public Paciente buscarService(String cedula);

	public void actualizarService(Paciente paci);

	public void eliminarService(String cedula);

}
