package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.model.CitaTo;
import com.example.demo.repository.model.Doctor;
import com.example.demo.repository.model.Paciente;

public interface IGestorService {
	
	public void ingresoDoctor(Doctor doctor);
	
	public void ingresoPaciente(Paciente paciente);
	
	public void agendamientoCita(String Numero,LocalDateTime fechacita
			,BigDecimal CostoCita,String LugarCita,String cedulaDoctor
			,String cedulaPaciente);
	
	public void actualizacionCita(String numero,String diagnóstico
			,String receta, LocalDateTime fechaControl);
	
	public List<CitaTo> reporteCitas(LocalDateTime fechaCita,BigDecimal valor);
	
}
