package com.example.demo.repository;

import com.example.demo.repository.model.Paciente;

public interface IPacienteRepository {

	public void insertar(Paciente paci);

	public Paciente buscar(String cedula);

	public void actualizar(Paciente paci);

	public void eliminar(String cedula);

}
