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
public class Hotel5StartsExercise7 extends Hotel4StarsExercise7{
    private Integer numberOfConferenceRooms;
    private Integer numberOfSuites;
    private Integer numberOfLimousines;

    /**
     * Default constructer method 
     */
    public Hotel5StartsExercise7() {
    }

    /**
     * Constructer method
     * 
     * @param numberOfConferenceRooms
     * @param numberOfSuites
     * @param numberOfLimousines
     * @param numberOfRooms
     * @param numberOfBeds
     * @param numberOfFloors
     * @param gym
     * @param restaurantName
     * @param restaurantCapacity
     * @param name
     * @param address
     * @param location
     * @param manager 
     */
    public Hotel5StartsExercise7(Integer numberOfConferenceRooms, Integer numberOfSuites, Integer numberOfLimousines, Integer numberOfRooms, Integer numberOfBeds, Integer numberOfFloors, String gym, String restaurantName, Integer restaurantCapacity, String name, String address, String location, String manager) {
        super(numberOfRooms, numberOfBeds, numberOfFloors, gym, restaurantName, restaurantCapacity, name, address, location, manager);
        this.numberOfConferenceRooms = numberOfConferenceRooms;
        this.numberOfSuites = numberOfSuites;
        this.numberOfLimousines = numberOfLimousines;
        this.price = priceOfRoom();
    }

    

    //Get and Set
    public Integer getNumberOfConferenceRooms() {
        return numberOfConferenceRooms;
    }

    public void setNumberOfConferenceRooms(Integer numberOfConferenceRooms) {
        this.numberOfConferenceRooms = numberOfConferenceRooms;
    }

    public Integer getNumberOfSuites() {
        return numberOfSuites;
    }

    public void setNumberOfSuites(Integer numberOfSuites) {
        this.numberOfSuites = numberOfSuites;
    }

    public Integer getNumberOfLimousines() {
        return numberOfLimousines;
    }

    public void setNumberOfLimousines(Integer numberOfLimousines) {
        this.numberOfLimousines = numberOfLimousines;
    }
    
    private Integer priceOfRoom(){
        Integer acumulator = 0;
        acumulator = 50 + (1 * (this.numberOfFloors * this.numberOfRooms * this.numberOfBeds));
        if(this.restaurantCapacity < 30){
            acumulator += 10;
        }else if(this.restaurantCapacity > 30 && this.restaurantCapacity <= 50){
            acumulator += 30;
        }else if(this.restaurantCapacity > 50){
            acumulator += 50;
        }
        if(this.gym.equals("A")){
            acumulator += 50;
        }else{
            acumulator += 30;
        }
        acumulator += (15 * numberOfLimousines);
        return acumulator;
    }
}
