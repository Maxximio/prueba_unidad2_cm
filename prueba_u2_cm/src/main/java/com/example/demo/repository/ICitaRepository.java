package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.CitaMedica;
import com.example.demo.repository.model.CitaTo;

public interface ICitaRepository {
	
	public void insertar(CitaMedica cita);

	public CitaMedica buscar(int id);
	
	public CitaMedica buscarNumero(String numero);

	public void actualizar(CitaMedica cita);

	public void eliminar(int id);

	public List<CitaTo> buscarCitasFechaCosto(LocalDateTime fecha, BigDecimal costo);
	
}
