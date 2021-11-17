package com.Estancia.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Casa {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	private String calle;
	private Integer numero;
	private String codPostal;
	private String ciudad;
	private String pais;
	private Integer minDias;
	private Integer maxDias;
	private Double precio;
	private String tipoVivienda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDesde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHasta;
	
	/**
	 * Default constructer method
	 */
	public Casa() {
		super();
	}

	/**
	 * Constructer method
	 * 
	 * @param id
	 * @param calle
	 * @param numero
	 * @param codPostal
	 * @param ciudad
	 * @param pais
	 * @param minDias
	 * @param maxDias
	 * @param precio
	 * @param tipoVivienda
	 * @param fechaDesde
	 * @param fechaHasta
	 */
	public Casa(String id, String calle, Integer numero, String codPostal, String ciudad, String pais, Integer minDias,
			Integer maxDias, Double precio, String tipoVivienda, Date fechaDesde, Date fechaHasta) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.codPostal = codPostal;
		this.ciudad = ciudad;
		this.pais = pais;
		this.minDias = minDias;
		this.maxDias = maxDias;
		this.precio = precio;
		this.tipoVivienda = tipoVivienda;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getMinDias() {
		return minDias;
	}

	public void setMinDias(Integer minDias) {
		this.minDias = minDias;
	}

	public Integer getMaxDias() {
		return maxDias;
	}

	public void setMaxDias(Integer maxDias) {
		this.maxDias = maxDias;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
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
	
	
}
