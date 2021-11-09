package com.Libreria.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	private Boolean alta;
	
	@Temporal(TemporalType.DATE)
	private Date fechaPrestamo;
	@Temporal(TemporalType.DATE)
	private Date fechaDevolucion;
	
	@OneToOne
	private Libro libro;
	@OneToOne
	private Cliente cliente;
	
	
	/**
	 * Default constructer method
	 */
	public Prestamo() {
		super();
	}

	/**
	 * Constructer method
	 * 
	 * @param id
	 * @param alta
	 * @param fechaPrestamo
	 * @param fechaDevolucion
	 * @param libro
	 * @param cliente
	 */
	public Prestamo(String id, Boolean alta, Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) {
		super();
		this.id = id;
		this.alta = alta;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.libro = libro;
		this.cliente = cliente;
	}
	
	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
