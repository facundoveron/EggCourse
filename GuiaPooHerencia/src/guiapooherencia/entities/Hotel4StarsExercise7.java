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
public class Hotel4StarsExercise7 extends AccommodationExercise7{

    protected Integer numberOfRooms;
    protected Integer numberOfBeds;
    protected Integer numberOfFloors;
    protected String gym;
    protected String restaurantName;
    protected Integer restaurantCapacity;
    /**
     * Default constructer method
     */
    public Hotel4StarsExercise7() {
    }

    /**
     * Constructer method
     * 
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
    public Hotel4StarsExercise7(Integer numberOfRooms, Integer numberOfBeds, Integer numberOfFloors, String gym, String restaurantName, Integer restaurantCapacity, String name, String address, String location, String manager) {
        super(name, address, location, manager);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.numberOfFloors = numberOfFloors;
        this.gym = gym;
        this.restaurantName = restaurantName;
        this.restaurantCapacity = restaurantCapacity;
        this.price = priceOfRoom();
    }
    
    //Get and Set
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(Integer restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
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
        return acumulator;
    }
}
