package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.model.CitaMedica;
import com.example.demo.repository.model.CitaTo;
import com.example.demo.repository.model.Doctor;
import com.example.demo.repository.model.Paciente;

@Service
public class GestorServiceImpl implements IGestorService{

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaService citaService;
	
	@Override
	public void ingresoDoctor(Doctor doctor) {
		this.doctorService.insertarService(doctor);
	}

	@Override
	public void ingresoPaciente(Paciente paciente) {
		this.pacienteService.insertarService(paciente);
	}

	@Override
	public void agendamientoCita(String numero, LocalDateTime fechacita, BigDecimal CostoCita, String LugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		
		Doctor doc=this.doctorService.buscarService(cedulaDoctor);
		Paciente paci=this.pacienteService.buscarService(cedulaPaciente);
		
		CitaMedica cime=new CitaMedica();
		
		cime.setNumero(numero);
		cime.setFechaCita(fechacita);
		cime.setValorCita(CostoCita);
		cime.setLugar(LugarCita);
		
		cime.setDoctor(doc);
		cime.setPaciente(paci);
		
		this.citaService.insertarService(cime);
	}

	@Override
	public void actualizacionCita(String numero, String diagnóstico, String receta, LocalDateTime fechaControl) {
		CitaMedica cime=this.citaService.buscarNumeroService(numero);
		
		cime.setDiagnostico(diagnóstico);
		cime.setReceta(receta);
		cime.setFechaControl(fechaControl);
		
		this.citaService.actualizarService(cime);
	}

	@Override
	public List<CitaTo> reporteCitas(LocalDateTime fechaCita, BigDecimal valor) {
		
		return this.citaService.buscarCitasFechaCostoService(fechaCita, valor);
	}

}
