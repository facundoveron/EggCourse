/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Facundo
 */
@Entity
public class Cliente {
    
    @Id
    private Integer id;
    private Long documento;
    private String nombre;
    private String apellido;
    private String telefono;
    
    /**
     * Default constructer method
     */
    public Cliente() {
    }

    /**
     * Constructer method
     * 
     * @param id
     * @param documento
     * @param nombre
     * @param apellido
     * @param telefono 
     */
    public Cliente(Integer id, Long documento, String nombre, String apellido, String telefono) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Get and Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
