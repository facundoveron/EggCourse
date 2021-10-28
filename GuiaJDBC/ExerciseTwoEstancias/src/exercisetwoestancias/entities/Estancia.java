/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.entities;

import java.sql.Date;

/**
 *
 * @author Facundo
 */
public class Estancia {
    private Integer id_estancia;
    private Cliente cliente;
    private Casa casa;
    private String nombre_huesped;
    private Date fechaDesde;
    private Date fechaHasta;
    
    /**
     * Default constructer method
     */
    public Estancia() {
    }

    /**
     * Constructer method
     * 
     * @param id_estancia
     * @param cliente
     * @param casa
     * @param nombre_huesped
     * @param fecha_desde
     * @param fecha_hasta 
     */
    public Estancia(Integer id_estancia, Cliente cliente, Casa casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.cliente = cliente;
        this.casa = casa;
        this.nombre_huesped = nombre_huesped;
        this.fechaDesde = fecha_desde;
        this.fechaHasta = fecha_hasta;
    }
    
    //Get and Set
    public Integer getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(Integer id_estancia) {
        this.id_estancia = id_estancia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
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
