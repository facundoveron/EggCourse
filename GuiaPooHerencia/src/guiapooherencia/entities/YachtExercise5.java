/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
final public class YachtExercise5 extends BoatExercise5 {
    private Scanner read = new Scanner(System.in);
    
    private Integer power;
    private Integer numberOfCabin;

    /**
     * Default constructer method
     */
    public YachtExercise5() {
    }

    /**
     * Constructer method
     *
     * @param power
     * @param numberOfCabin
     * @param registration
     * @param length
     * @param yearOfManufacture
     */
    public YachtExercise5(Integer power, Integer numberOfCabin, String registration, Integer length, Integer yearOfManufacture) {
        super(registration, length, yearOfManufacture);
        this.power = power;
        this.numberOfCabin = numberOfCabin;
    }

    //Get and Set
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getNumberOfCabin() {
        return numberOfCabin;
    }

    public void setNumberOfCabin(Integer numberOfCabin) {
        this.numberOfCabin = numberOfCabin;
    }
    
    /**
     * Method to create yacht
     */
    public void createYacht() {
        createBoat();
        do {
            System.out.println("Enter the power");
            this.power = read.nextInt();
        } while (this.power == null || this.power < 0);
        do {
            System.out.println("Enter the number of cabin");
            this.numberOfCabin = read.nextInt();
        } while (this.numberOfCabin == null || this.numberOfCabin < 0);
    }
}
