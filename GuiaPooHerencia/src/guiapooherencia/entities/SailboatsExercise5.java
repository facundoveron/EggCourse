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
final public class SailboatsExercise5 extends BoatExercise5{
    private Scanner read = new Scanner(System.in);
    private Integer numberOfMasts;
    
    /**
     * Default constructer method
     */
    public SailboatsExercise5() {
    }
    
    /**
     * Constructer method
     * 
     * @param numberOfMasts
     * @param registration
     * @param length
     * @param yearOfManufacture 
     */
    public SailboatsExercise5(Integer numberOfMasts, String registration, Integer length, Integer yearOfManufacture) {
        super(registration, length, yearOfManufacture);
        this.numberOfMasts = numberOfMasts;
    }   

    //Get and Set
    public Integer getNumberOfMasts() {
        return numberOfMasts;
    }

    public void setNumberOfMasts(Integer numberOfMasts) {
        this.numberOfMasts = numberOfMasts;
    }
    
    /**
     * Method to create sail boats
     */
    public void createSailboats(){
        createBoat();
        do {
            System.out.println("Enter the number of masts");
            this.numberOfMasts = read.nextInt();
        } while (this.numberOfMasts == null || this.numberOfMasts < 0);
    }
    
}
