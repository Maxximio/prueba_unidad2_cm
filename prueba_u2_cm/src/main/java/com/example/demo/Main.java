package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.model.CitaTo;
import com.example.demo.repository.model.Doctor;
import com.example.demo.repository.model.Paciente;
import com.example.demo.service.IGestorService;

@SpringBootApplication
public class Main implements CommandLineRunner{
	
	private static final Logger log=LogManager.getLogger(Main.class);
	
	@Autowired
	private IGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//funcionalidad 1
		log.info("****************funcionalidad1*************");
		Doctor doc1=new Doctor();
		doc1.setCedula("12111");
		doc1.setNombre("Santiago");
		doc1.setApellido("Moncayo");
		doc1.setFechaNacimiento(LocalDateTime.of(1990, 03, 10, 13, 53));
		doc1.setNumeroConsultorio("3");
		doc1.setTitulo("cardiologo");
		doc1.setSalario(new BigDecimal(1000));
		
		this.gestorService.ingresoDoctor(doc1);
		
		Doctor doc2=new Doctor();
		doc2.setCedula("22212222");
		doc2.setNombre("Sofia");
		doc2.setApellido("Beltran");
		doc2.setFechaNacimiento(LocalDateTime.of(1995, 03, 10, 13, 53));
		doc2.setNumeroConsultorio("8");
		doc2.setTitulo("pediatra");
		doc2.setSalario(new BigDecimal(1500));
		
		this.gestorService.ingresoDoctor(doc2);
		
		//funcionalidad 2
		log.info("****************funcionalidad 2*************");
		Paciente paci1=new Paciente();
		paci1.setCedula("3333343333");
		paci1.setNombre("Juan");
		paci1.setApellido("Perez");
		paci1.setFechaNacimiento(LocalDateTime.of(2000, 03, 10, 13, 53));
		paci1.setCodigoIess("345224a");
		paci1.setEstatura(180);
		paci1.setPeso(80);
		paci1.setGenero("M");
		
		this.gestorService.ingresoPaciente(paci1);
		
		Paciente paci2=new Paciente();
		paci2.setCedula("44445444");
		paci2.setNombre("Juana");
		paci2.setApellido("Gonzales");
		paci2.setFechaNacimiento(LocalDateTime.of(2001, 03, 10, 13, 53));
		paci2.setCodigoIess("234d235");
		paci2.setEstatura(160);
		paci2.setPeso(60);
		paci2.setGenero("F");
		
		this.gestorService.ingresoPaciente(paci2);
		
		//funcionalidad 3
		log.info("****************funcionalidad 3*************");
		
		this.gestorService.agendamientoCita("003", LocalDateTime.of(2021, 03, 10, 13, 53), new BigDecimal(40), "Quito"
				, "22212222", "44445444");

		//funcionalidad 4
		log.info("****************funcionalidad 4*************");
		this.gestorService.actualizacionCita("003", "dolor de cabeza" , "aspirina", LocalDateTime.of(2022, 03, 10, 13, 53));
		
		//funcionalidad 5
		//log.info("****************funcionalidad 5*************");
		//this.gestorService.reporteCitas( LocalDateTime.of(2021, 03, 10, 13, 53), new BigDecimal(40));
		
//		List<CitaTo> lista=this.gestorService.reporteCitas( LocalDateTime.of(2021, 03, 10, 13, 53), new BigDecimal(40));
//		for(CitaTo cime : lista) {
//			log.info("Reporte---"+cime);
//		}
		
	}
}
