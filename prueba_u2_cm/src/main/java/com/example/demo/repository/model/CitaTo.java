package com.example.demo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaTo {

	private String numero;
	
	private LocalDateTime fechaCita;
	
	private BigDecimal valorCita;
	
	private LocalDateTime fechaControl;
	
	//constructor
	public CitaTo(String numero, LocalDateTime fechaCita, BigDecimal valorCita, LocalDateTime fechaControl) {
		super();
		this.numero = numero;
		this.fechaCita = fechaCita;
		this.valorCita = valorCita;
		this.fechaControl = fechaControl;
	}

	//set y get
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

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	//to string
	@Override
	public String toString() {
		return "CitaTo [numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita + ", fechaControl="
				+ fechaControl + "]";
	}
	
}
