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
public class SportsCenterExercise6 extends BuildingExercise6 {

    private String name;
    private Boolean roof;

    /**
     * Default constructer method
     */
    public SportsCenterExercise6() {
    }

    /**
     * Constructer method
     *
     * @param name
     * @param roof
     * @param width
     * @param height
     * @param length
     */
    public SportsCenterExercise6(String name, Boolean roof, Integer width, Integer height, Integer length) {
        super(width, height, length);
        this.name = name;
        this.roof = roof;
    }

    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRoof() {
        return roof;
    }

    public void setRoof(Boolean roof) {
        this.roof = roof;
    }

    @Override
    public void calculateSurface() {
        System.out.println("The surface is " + (this.width * this.length));
    }

    @Override
    public void calculateVolume() {
        System.out.println("the volume is " + (this.width * this.length * this.height));
    }

}
