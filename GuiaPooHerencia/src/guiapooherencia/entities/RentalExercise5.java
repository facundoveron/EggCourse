/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class RentalExercise5 {

    private Scanner read = new Scanner(System.in);

    private String name;
    private Long dniCustomer;
    private Integer day;
    private String mooringPosition;
    private Integer basePrice;
    private BoatExercise5 boat;

    /**
     * Default constructer method
     */
    public RentalExercise5() {
    }

    /**
     * Constructer method
     *
     * @param name
     * @param dniCustomer
     * @param day
     * @param mooringPosition
     * @param basePrice
     * @param boat
     */
    public RentalExercise5(String name, Long dniCustomer, Integer day, String mooringPosition, Integer basePrice, BoatExercise5 boat) {
        this.name = name;
        this.dniCustomer = dniCustomer;
        this.day = day;
        this.mooringPosition = mooringPosition;
        this.basePrice = basePrice;
        this.boat = boat;
    }

    //Get and Set
    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDniCustomer() {
        return dniCustomer;
    }

    public void setDniCustomer(Long dniCustomer) {
        this.dniCustomer = dniCustomer;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getMooringPosition() {
        return mooringPosition;
    }

    public void setMooringPosition(String mooringPosition) {
        this.mooringPosition = mooringPosition;
    }

    public BoatExercise5 getBoat() {
        return boat;
    }

    public void setBoat(BoatExercise5 boat) {
        this.boat = boat;
    }

    
    /**
     * Method that creates the customer as well as the ship
     */
    public void createCustomer() {
        Integer opcion = null;
        do {
            System.out.println("Enter the name ");
            this.name = read.next();
        } while (this.name == null || this.name.isEmpty());
        do {
            System.out.println("Enter the dni");
            this.dniCustomer = read.nextLong();
        } while (this.dniCustomer == null || this.dniCustomer < 10000000);
        do {
            System.out.println("enter rental days");
            this.day = read.nextInt();
        } while (this.day == null || this.day < 0);
        do {
            System.out.println("enter the mooring position");
            this.mooringPosition = read.nextLine();
        } while (this.mooringPosition == null || this.mooringPosition.isEmpty());
        do {
            System.out.println("Enter the type of boat you want. 1 for sailboat, 2 for motor boat, 3 for yacht ");
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    SailboatsExercise5 sailboats = new SailboatsExercise5();
                    sailboats.createSailboats();
                    this.boat = sailboats;
                    this.basePrice = sailboats.getNumberOfMasts();
                    break;
                case 2:
                    MotorBoatExcercise5 motorBoat = new MotorBoatExcercise5();
                    motorBoat.createMotorBoat();
                    this.boat = motorBoat;
                    this.basePrice = motorBoat.getPower();
                    break;
                case 3:
                    YachtExercise5 yacht = new YachtExercise5();
                    yacht.createBoat();
                    this.boat = yacht;
                    this.basePrice = yacht.getPower() + yacht.getNumberOfCabin();
                    break;
                default:
                    System.out.println("The option entered is not valid ");
            }
        } while (opcion == null || (opcion != 1 && opcion != 2 && opcion != 3));
    }

}
