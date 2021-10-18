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
public abstract class BuildingExercise6 {
    protected Integer width; 
    protected Integer height;
    protected Integer length;

    /**
     * Default constructer method
     */
    public BuildingExercise6() {
    }

    /**
     * Constructer method
     * 
     * @param width
     * @param height
     * @param length 
     */
    public BuildingExercise6(Integer width, Integer height, Integer length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }
    
    //Get and Set
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
    
    /**
     * method for calculating the surface area
     */
    public abstract void calculateSurface();
    
    /**
     * Method for calculating volume
     */
    public abstract void calculateVolume();
}
