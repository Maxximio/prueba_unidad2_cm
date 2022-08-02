package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Paciente;
import com.example.demo.repository.model.PacienteTo;

@Transactional
@Repository
public class PacienteRepositoryImpl implements IPacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(String cedula) {
		Query jpqlQuery=this.entityManager
				.createQuery("select p from Paciente p Where p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Paciente) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(String cedula) {
		Paciente paciente=this.buscar(cedula);
		this.entityManager.remove(paciente);
	}
	
	@Override
	public List<PacienteTo> buscar(LocalDateTime fechaN,String genero) {
		TypedQuery<PacienteTo>miTypedQuery= this.entityManager
				.createQuery("select NEW com.example.demo.repository.model"
						+ ".PacienteTo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) from Paciente p "
						+ "where p.fechaNacimiento >=:datoFecha and p.genero >=:datoGeneror",PacienteTo.class);
		miTypedQuery.setParameter("datoFecha", fechaN);
		miTypedQuery.setParameter("datoGeneror", genero);
		
		return miTypedQuery.getResultList();
		
	}
	
}
