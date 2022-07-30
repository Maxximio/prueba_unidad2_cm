package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDoctorRepository;
import com.example.demo.repository.model.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	public void insertarService(Doctor doctor) {
		this.doctorRepository.insertar(doctor);
	}

	@Override
	public Doctor buscarService(String cedula) {
		return this.doctorRepository.buscar(cedula);
	}

	@Override
	public void actualizarService(Doctor doctor) {
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public void eliminarService(String cedula) {
		this.doctorRepository.eliminar(cedula);
	}
	
	

}
