package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cita")
public class CitaMedica {
	
	@Id
	@Column(name = "cime_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cime_id_seq")
	@SequenceGenerator(name = "cime_id_seq",sequenceName = "cime_id_seq",allocationSize = 1)
	private Integer id;
	
	@Column(name = "cime_numero")
	private String numero;
	
	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;
	
	@Column(name = "cime_valor")
	private BigDecimal valorCita;
	
	@Column(name = "cime_lugar")
	private String lugar;
	
	@Column(name = "cime_diagnostico")
	private String diagnostico;
	
	@Column(name = "cime_receta")
	private String receta;
	
	@Column(name = "cime_fecha_control")
	private LocalDateTime fechaControl;
	
	@ManyToOne
	@JoinColumn(name = "cime_doct_id" )
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "cime_paci_id" )
	private Paciente paciente;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	//to string
	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita
				+ ", lugar=" + lugar + ", diagnostico=" + diagnostico + ", receta=" + receta + ", fechaControl="
				+ fechaControl + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}
	
	
	
	
}
