/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Facundo
 */

@Entity
public class Editorial {
    
    @Id
    private Integer id;
    private String nombre;
    private Boolean alta;

    /**
     * Constructer method default
     */
    public Editorial() {
    }

    
    /**
     * Constructer method 
     * 
     * @param id
     * @param nombre
     * @param alta 
     */
    public Editorial(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    
    //Get and Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
    
}
