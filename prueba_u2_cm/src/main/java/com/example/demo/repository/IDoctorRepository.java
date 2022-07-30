package com.example.demo.repository;

import com.example.demo.repository.model.Doctor;

public interface IDoctorRepository {

	public void insertar(Doctor doctor) ;
	
	public Doctor buscar(String cedula);
	
	public void actualizar(Doctor doctor);
	
	public void eliminar(String cedula);
}
