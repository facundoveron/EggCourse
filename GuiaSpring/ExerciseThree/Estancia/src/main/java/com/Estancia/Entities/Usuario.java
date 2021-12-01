package com.Estancia.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.Estancia.Enum.Role;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String alias;
	private String email;
	private String clave;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaBaja;

	/**
	 * Default constructor method
	 */
	public Usuario() {
		super();
	}

	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param alias
	 * @param email
	 * @param clave
	 * @param role
	 * @param fechaAlta
	 * @param fechaBaja
	 */
	public Usuario(String id, String alias, String email, String clave, Role role, Date fechaAlta, Date fechaBaja) {
		super();
		this.id = id;
		this.alias = alias;
		this.email = email;
		this.clave = clave;
		this.role = role;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}


	//Get and Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
