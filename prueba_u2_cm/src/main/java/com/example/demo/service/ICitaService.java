package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.CitaMedica;
import com.example.demo.repository.model.CitaTo;



public interface ICitaService {

	public void insertarService(CitaMedica cita);

	public CitaMedica buscarService(int id);
	
	public CitaMedica buscarNumeroService(String numero);

	public void actualizarService(CitaMedica cita);

	public void eliminarService(int id);

	public List<CitaTo> buscarCitasFechaCostoService(LocalDateTime fecha, BigDecimal costo);
}
