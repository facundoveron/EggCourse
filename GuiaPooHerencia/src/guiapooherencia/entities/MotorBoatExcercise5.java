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
final public class MotorBoatExcercise5 extends BoatExercise5 {

    private Scanner read = new Scanner(System.in);

    private Integer power;

    /**
     * Default constructer method
     */
    public MotorBoatExcercise5() {
    }

    /**
     * Constructer method
     *
     * @param power
     * @param registration
     * @param length
     * @param yearOfManufacture
     */
    public MotorBoatExcercise5(Integer power, String registration, Integer length, Integer yearOfManufacture) {
        super(registration, length, yearOfManufacture);
        this.power = power;
    }

    //Get and Set
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * Method to create motor boat
     */
    public void createMotorBoat() {
        createBoat();
        do {
            System.out.println("Enter the power");
            this.power = read.nextInt();
        } while (this.power == null || this.power < 0);
    }
}
