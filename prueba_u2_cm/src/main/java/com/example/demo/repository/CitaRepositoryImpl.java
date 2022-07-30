package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.CitaMedica;
import com.example.demo.repository.model.CitaTo;

@Transactional
@Repository
public class CitaRepositoryImpl implements ICitaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public CitaMedica buscar(int id) {
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void eliminar(int id) {
		CitaMedica cime=this.buscar(id);
		this.entityManager.remove(cime);
	}

	@Override
	public CitaMedica buscarNumero(String numero) {
		Query jpqlQuery=this.entityManager
				.createQuery("select c from CitaMedica c Where c.numero = :datoNumero");
		jpqlQuery.setParameter("datoNumero", numero);
		
		return (CitaMedica) jpqlQuery.getSingleResult();
	}

	@Override
	public List<CitaTo> buscarCitasFechaCosto(LocalDateTime fecha, BigDecimal costo) {
		TypedQuery<CitaTo>miTypedQuery= this.entityManager
				.createQuery("select NEW com.example.demo.repository.model"
						+ ".CitaTo(c.numero,c.fechaCita,c.valorCita,c.fechaControl) from CitaMedica c "
						+ "where c.fechaCita >=:datoFecha and c.valorCita >=:datoValor",CitaTo.class);
		miTypedQuery.setParameter("datoFecha", fecha);
		miTypedQuery.setParameter("datoValor", costo);
		
		return miTypedQuery.getResultList();
	}
	
}
