package com.example.demo.repository.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@Column(name="paci_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paci_id_seq")
	@SequenceGenerator(name = "paci_id_seq",sequenceName = "paci_id_seq",allocationSize = 1)
	private Integer id;
	
	@Column(name="paci_nombre")
	private String nombre;
	
	@Column(name="paci_apellido")
	private String apellido;
	
	@Column(name="paci_cedula")
	private String cedula;
	
	@Column(name="paci_fecha")
	private LocalDateTime fechaNacimiento;
	
	@Column(name="paci_codigo_iess")
	private String codigoIess;
	
	@Column(name="paci_estatura")
	private int estatura;
	
	@Column(name="paci_peso")
	private int peso;
	
	@Column(name="paci_genero")
	private String genero;
	
	@OneToMany(mappedBy = "paciente",fetch = FetchType.EAGER)
	private List<CitaMedica> cita;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCodigoIess() {
		return codigoIess;
	}

	public void setCodigoIess(String codigoIess) {
		this.codigoIess = codigoIess;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<CitaMedica> getCita() {
		return cita;
	}

	public void setCita(List<CitaMedica> cita) {
		this.cita = cita;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + ", codigoIess=" + codigoIess + ", estatura=" + estatura
				+ ", peso=" + peso + ", genero=" + genero + "]";
	}
	
}
