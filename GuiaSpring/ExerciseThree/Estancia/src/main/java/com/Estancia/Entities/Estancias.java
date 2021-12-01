package com.Estancia.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estancias {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@OneToOne
	@JoinColumn
	private Cliente huesped;
	
	@OneToOne
	@JoinColumn
	private Casa casa;
	
	/**
	 * Default constructor method
	 */
	public Estancias() {
		super();
	}

	/**
	 * constructor method
	 * 
	 * @param id
	 * @param huesped
	 * @param casa
	 */
	public Estancias(String id, Cliente huesped, Casa casa) {
		super();
		this.id = id;
		this.huesped = huesped;
		this.casa = casa;
	}

	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cliente getHuesped() {
		return huesped;
	}

	public void setHuesped(Cliente huesped) {
		this.huesped = huesped;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	
	
}
