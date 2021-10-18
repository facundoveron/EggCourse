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
public class OfficeBuildingExercise6 extends BuildingExercise6{
    private Integer numberOfOffice;
    private Integer numberOfPeoplePerOffice;
    private Integer numberOfFloors;

    /**
     * Default constructer method
     */
    public OfficeBuildingExercise6() {
    }
    
    /**
     * Constructer method
     * 
     * @param numberOfOffice
     * @param numberOfPeoplePerOffice
     * @param numberOfFloors
     * @param width
     * @param height
     * @param length 
     */
    public OfficeBuildingExercise6(Integer numberOfOffice, Integer numberOfPeoplePerOffice, Integer numberOfFloors, Integer width, Integer height, Integer length) {
        super(width, height, length);
        this.numberOfOffice = numberOfOffice;
        this.numberOfPeoplePerOffice = numberOfPeoplePerOffice;
        this.numberOfFloors = numberOfFloors;
    }

    //Get and Set
    public Integer getNumberOfOffice() {
        return numberOfOffice;
    }

    public void setNumberOfOffice(Integer numberOfOffice) {
        this.numberOfOffice = numberOfOffice;
    }

    public Integer getNumberOfPeoplePerOffice() {
        return numberOfPeoplePerOffice;
    }

    public void setNumberOfPeoplePerOffice(Integer numberOfPeoplePerOffice) {
        this.numberOfPeoplePerOffice = numberOfPeoplePerOffice;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public void calculateSurface() {
        System.out.println("The surface is " + (this.width * this.length));
    }

    @Override
    public void calculateVolume() {
        System.out.println("the volume is " + (this.width * this.length * this.height));
    }
    
    /**
     * Method for calculating the number of people that can enter the building
     */
    public void numberOfPeople(){
        System.out.println("The number of people that can enter the building " + (this.numberOfOffice * this.numberOfPeoplePerOffice));
    }
}
