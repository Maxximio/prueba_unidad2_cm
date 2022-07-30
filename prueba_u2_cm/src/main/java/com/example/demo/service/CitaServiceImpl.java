package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICitaRepository;
import com.example.demo.repository.model.CitaMedica;
import com.example.demo.repository.model.CitaTo;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private ICitaRepository citaRepository;
	
	@Override
	public void insertarService(CitaMedica cita) {
		this.citaRepository.insertar(cita);
	}

	@Override
	public CitaMedica buscarService(int id) {
		return this.citaRepository.buscar(id);
	}

	@Override
	public CitaMedica buscarNumeroService(String numero) {
		return this.citaRepository.buscarNumero(numero);
	}

	@Override
	public void actualizarService(CitaMedica cita) {
		this.citaRepository.actualizar(cita);
	}

	@Override
	public void eliminarService(int id) {
		this.citaRepository.eliminar(id);
	}

	@Override
	public List<CitaTo> buscarCitasFechaCostoService(LocalDateTime fecha, BigDecimal costo) {
		return this.citaRepository.buscarCitasFechaCosto(fecha, costo);
	}

}
