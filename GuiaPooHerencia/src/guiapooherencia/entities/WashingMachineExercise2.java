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
public class WashingMachineExercise2 extends ApplianceExercise2 {

    private Integer load;
    private Scanner read = new Scanner(System.in);

    /**
     * Default constructer method
     */
    public WashingMachineExercise2() {
    }

    /**
     * Constructer method
     *
     * @param load
     * @param price
     * @param color
     * @param energyConsumption
     * @param weight
     */
    public WashingMachineExercise2(Integer load, Double price, String color, String energyConsumption, Integer weight) {
        super(price, color, energyConsumption, weight);
        this.load = load;
    }

    //Get and Set
    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    /**
     * Method to create washing machine
     */
    public void createWashingMachine() {
        ApplianceExercise2 appliance = new ApplianceExercise2();
        appliance.createAppliance();
        this.color = appliance.getColor();
        this.energyConsumption = appliance.getEnergyConsumption();
        this.price = appliance.getPrice();
        this.weight = appliance.getWeight();
        Integer carga = 0;
        do {
            System.out.println("enter the load supported by the washing machine");
            carga = read.nextInt();
        } while (carga == null || carga < 0 || carga > 100);
        this.load = carga;
        finalPriceWashingMachine();
    }
    
    /**
     * Method to increase the price if the load is greater than 30 kg
     */
    public void finalPriceWashingMachine(){
        if(this.load > 30){
            this.weight += 500;
        }
    }
}
