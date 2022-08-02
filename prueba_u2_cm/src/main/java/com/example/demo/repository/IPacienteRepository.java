package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.Paciente;
import com.example.demo.repository.model.PacienteTo;

public interface IPacienteRepository {

	public void insertar(Paciente paci);

	public Paciente buscar(String cedula);

	public void actualizar(Paciente paci);

	public void eliminar(String cedula);

	public List<PacienteTo> buscar(LocalDateTime fechaN, String genero);

}
