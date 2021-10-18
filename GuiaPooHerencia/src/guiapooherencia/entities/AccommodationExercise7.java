/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

/**
 *
 * @author Facundo
 */
public class AccommodationExercise7 {
    protected String name;
    protected String address;
    protected String location;
    protected String manager; 
    protected Integer price;

    /**
     * Default constructer method
     */
    public AccommodationExercise7() {
    }

    /**
     * Constructer method
     * 
     * @param name
     * @param address
     * @param location
     * @param manager 
     */
    public AccommodationExercise7(String name, String address, String location, String manager) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.manager = manager;
    }

    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
}
