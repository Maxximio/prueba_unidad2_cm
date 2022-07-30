package com.example.demo.service;

import com.example.demo.repository.model.Doctor;

public interface IDoctorService {

	public void insertarService(Doctor doctor) ;
	
	public Doctor buscarService(String cedula);
	
	public void actualizarService(Doctor doctor);
	
	public void eliminarService(String cedula);

}
