package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Doctor;

@Transactional
@Repository
public class DoctorRepositoryImpl implements IDoctorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		this.entityManager.persist(doctor);
	}

	@Override
	public Doctor buscar(String cedula) {
		Query jpqlQuery=this.entityManager
				.createQuery("select d from Doctor d Where d.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Doctor) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(String cedula) {
		Doctor doctor=this.buscar(cedula);
		this.entityManager.remove(doctor);
	}

	
}
