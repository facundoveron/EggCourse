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
public class CampingExercise7 extends HotelExtrasExercise7{
    private Integer maximumTentCapacity;
    private Integer numberOfBathroomsAvailable;
    private Boolean restaurant;

    /**
     * Default constructer method
     */
    public CampingExercise7() {
    }

    /**
     * Constructer method
     * 
     * @param maximumTentCapacity
     * @param numberOfBathroomsAvailable
     * @param restaurant
     * @param privado
     * @param numberOfSquareMeters
     * @param name
     * @param address
     * @param location
     * @param manager 
     */
    public CampingExercise7(Integer maximumTentCapacity, Integer numberOfBathroomsAvailable, Boolean restaurant, Boolean privado, Integer numberOfSquareMeters, String name, String address, String location, String manager) {
        super(privado, numberOfSquareMeters, name, address, location, manager);
        this.maximumTentCapacity = maximumTentCapacity;
        this.numberOfBathroomsAvailable = numberOfBathroomsAvailable;
        this.restaurant = restaurant;
    }

    //Get and Set
    public Integer getMaximumTentCapacity() {
        return maximumTentCapacity;
    }

    public void setMaximumTentCapacity(Integer maximumTentCapacity) {
        this.maximumTentCapacity = maximumTentCapacity;
    }

    public Integer getNumberOfBathroomsAvailable() {
        return numberOfBathroomsAvailable;
    }

    public void setNumberOfBathroomsAvailable(Integer numberOfBathroomsAvailable) {
        this.numberOfBathroomsAvailable = numberOfBathroomsAvailable;
    }

    public Boolean getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }
}
