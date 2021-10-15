/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import guiapoorelaciones.Enum.TypeOfCarExercise5;

/**
 *
 * @author Facundo
 */
public class VehicleManagementExercise6 {
    private String brand;
    private Integer model;
    private Integer year;
    private Integer engineNumber;
    private String chassis;
    private String color;
    private TypeOfCarExercise5 type;

    /**
     * Default constructor method
     */
    public VehicleManagementExercise6() {
    }

    /**
     * Constructor method
     * 
     * @param brand
     * @param model
     * @param year
     * @param engineNumber
     * @param chassis
     * @param color
     * @param type 
     */
    public VehicleManagementExercise6(String brand, Integer model, Integer year, Integer engineNumber, String chassis, String color, TypeOfCarExercise5 type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineNumber = engineNumber;
        this.chassis = chassis;
        this.color = color;
        this.type = type;
    }

    //Get and Set
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TypeOfCarExercise5 getType() {
        return type;
    }

    public void setType(TypeOfCarExercise5 type) {
        this.type = type;
    }
    
    
}
