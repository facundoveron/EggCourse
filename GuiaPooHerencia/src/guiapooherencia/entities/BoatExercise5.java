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
public class BoatExercise5 {
    private Scanner read = new Scanner(System.in);
    protected String registration;
    protected Integer length;
    protected Integer yearOfManufacture;

    /**
     * Default constructer method
     */
    public BoatExercise5() {
    }

    /**
     * Constructer method
     *
     * @param registration
     * @param length
     * @param yearOfManufacture
     */
    public BoatExercise5(String registration, Integer length, Integer yearOfManufacture) {
        this.registration = registration;
        this.length = length;
        this.yearOfManufacture = yearOfManufacture;
    }

    //Get and Set
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
   
    /**
     * Method for creating the base of a boat
     */
    public void createBoat(){
        do {
            System.out.println("enter the registration number");
            this.registration = read.nextLine();
        } while (this.registration == null || this.registration.isEmpty());
        do {
            System.out.println("enter the length of the boat");
            this.length = read.nextInt();
        } while (this.length == null || this.length < 0);
        do {
            System.out.println("Enter the year of manufacture");
            this.yearOfManufacture = read.nextInt();
        } while (this.yearOfManufacture == null || this.yearOfManufacture < 1900);
    }
}
