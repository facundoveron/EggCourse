package com.Estancia.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Familia {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String nombre;
	private Integer edadMin;
	private Integer edadMax;
	private Integer numHijos;
	
	@OneToOne
	@JoinColumn
	private Usuario usuario;

	@OneToOne
	@JoinColumn
	private Casa casa;

	/**
	 * Default constructor method
	 */
	public Familia() {
		super();
	}

	/**
	 * Constructer method
	 * 
	 * @param id
	 * @param nombre
	 * @param edadMin
	 * @param edadMax
	 * @param numHijos
	 * @param usuario
	 * @param casa
	 */
	public Familia(String id, String nombre, Integer edadMin, Integer edadMax, Integer numHijos, Usuario usuario,
			Casa casa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edadMin = edadMin;
		this.edadMax = edadMax;
		this.numHijos = numHijos;
		this.usuario = usuario;
		this.casa = casa;
	}

	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(Integer edadMin) {
		this.edadMin = edadMin;
	}

	public Integer getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(Integer edadMax) {
		this.edadMax = edadMax;
	}

	public Integer getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(Integer numHijos) {
		this.numHijos = numHijos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	
}
