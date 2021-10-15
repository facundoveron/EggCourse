/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class StoreGuiaPooCollections {

    private String name;
    private Double price;

    /**
     * Default constructor method
     */
    public StoreGuiaPooCollections() {
    }

    /**
     * Constructor method
     *
     * @param name
     * @param price
     */
    public StoreGuiaPooCollections(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
