package com.Estancia.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estancias {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	private String huesped;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDesde;	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHasta;
	
	@OneToOne
	private Casa casa;
	@OneToOne
	private Cliente cliente;
	
	/**
	 * Default constructer method
	 */
	public Estancias() {
		super();
	}

	/**
	 * Constructer method
	 * 
	 * @param id
	 * @param huesped
	 * @param fechaDesde
	 * @param fechaHasta
	 * @param casa
	 * @param cliente
	 */
	public Estancias(String id, String huesped, Date fechaDesde, Date fechaHasta, Casa casa, Cliente cliente) {
		super();
		this.id = id;
		this.huesped = huesped;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.casa = casa;
		this.cliente = cliente;
	}

	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHuesped() {
		return huesped;
	}

	public void setHuesped(String huesped) {
		this.huesped = huesped;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
