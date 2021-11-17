package com.Estancia.Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

public class Cliente {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	private String nombre;
	private String calle;
	private Integer numero;
	private String codPostal;
	private String ciudad;
	private String pais;
	private String email;
	
	@OneToOne
	private Usuario usuario;

	/**
	 * Default constructer method
	 */
	public Cliente() {
		super();
	}

	/**
	 * Constructer method
	 * 
	 * @param id
	 * @param nombre
	 * @param calle
	 * @param numero
	 * @param codPostal
	 * @param ciudad
	 * @param pais
	 * @param email
	 * @param usuario
	 */
	public Cliente(String id, String nombre, String calle, Integer numero, String codPostal, String ciudad, String pais,
			String email, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;
		this.codPostal = codPostal;
		this.ciudad = ciudad;
		this.pais = pais;
		this.email = email;
		this.usuario = usuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
