/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.entities;

/**
 *
 * @author Facundo
 */
public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String calle;
    private Integer numero;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private String email;

    /**
     * Default constructer method
     */
    public Cliente() {
    }

    /**
     * Constructer method
     * 
     * @param id_cliente
     * @param nombre
     * @param calle
     * @param numero
     * @param codigo_postal
     * @param ciudad
     * @param pais
     * @param email 
     */
    public Cliente(Integer id_cliente, String nombre, String calle, Integer numero, String codigo_postal, String ciudad, String pais, String email) {
        this.idCliente = id_cliente;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
    }

    //Get and Set
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setId_cliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
    
    
    
}
