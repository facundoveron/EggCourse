package com.Estancia.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@OneToOne
	@JoinColumn
	private Casa casa;
	
	@Column(name = "descripcion", length = 4000)
	private String descripcion;

	/**
	 * Default constructor method
	 */
	public Comentario() {
		super();
	}

	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param casa
	 * @param descripcion
	 */
	public Comentario(String id, Casa casa, String descripcion) {
		super();
		this.id = id;
		this.casa = casa;
		this.descripcion = descripcion;
	}
	
	
	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
