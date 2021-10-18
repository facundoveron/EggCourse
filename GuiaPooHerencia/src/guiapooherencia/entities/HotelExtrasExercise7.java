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
public class HotelExtrasExercise7 extends AccommodationExercise7{
    protected Boolean privado;
    protected Integer numberOfSquareMeters;

    /**
     * Default constructer method
     */
    public HotelExtrasExercise7() {
    }

    /**
     * Constructer method
     * 
     * @param privado
     * @param numberOfSquareMeters
     * @param name
     * @param address
     * @param location
     * @param manager 
     */
    public HotelExtrasExercise7(Boolean privado, Integer numberOfSquareMeters, String name, String address, String location, String manager) {
        super(name, address, location, manager);
        this.privado = privado;
        this.numberOfSquareMeters = numberOfSquareMeters;
    }

    //Get and Set
    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    public Integer getNumberOfSquareMeters() {
        return numberOfSquareMeters;
    }

    public void setNumberOfSquareMeters(Integer numberOfSquareMeters) {
        this.numberOfSquareMeters = numberOfSquareMeters;
    }
}
