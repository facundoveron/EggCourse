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
public class ApplianceExercise2 {

    private Scanner read = new Scanner(System.in);
    protected Double price;
    protected String color;
    protected String energyConsumption;
    protected Integer weight;

    /**
     * Defualt constructer method
     */
    public ApplianceExercise2() {
    }

    /**
     * Constructer method
     *
     * @param price
     * @param color
     * @param energyConsumption
     * @param weight
     */
    public ApplianceExercise2(Double price, String color, String energyConsumption, Integer weight) {
        this.price = price;
        this.color = color;
        this.energyConsumption = energyConsumption;
        this.weight = weight;
    }

    //Get and Set
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Method checks that the letter is correct, otherwise it will use the
     * default letter F.
     *
     * @param energy
     * @return energy, "F";
     */
    private String checkEnergyConsumption(String energy) {
        if (energy.equals("A") || energy.equals("B") || energy.equals("C") || energy.equals("D") || energy.equals("E") || energy.equals("F")) {
            return energy;
        }
        return "F";
    }

    /**
     * Method check that the color is correct, and if it is not, use the default
     * white color.
     *
     * @param color
     * @return color, "white";
     */
    private String checkColor(String color) {
        if (color.equals("white") || color.equals("black") || color.equals("red") || color.equals("blue") || color.equals("gray")) {
            return color;
        }
        return "white";
    }

    /**
     * Method that gives values to the object's attributes
     */
    public void createAppliance() {
        String colorS = "";
        String energia = "";
        Integer peso = 0;
        this.price = 1000.0;
        do {
            System.out.println("enter the color of the appliance");
            colorS = read.next();
        } while (colorS.isEmpty() || colorS == null);
        this.color = checkColor(colorS);
        do {
            System.out.println("enter the energy consumption of the appliance");
            energia = read.next().toUpperCase();
        } while (energia.isEmpty() || energia == null);
        this.energyConsumption = checkEnergyConsumption(energia);
        do {
            System.out.println("enter the weight");
            peso = read.nextInt();
        } while (peso == null || peso < 0);
        this.weight = peso;
        finalPrice();
    }

    /**
     * Method that, depending on the energy consumption and its size, will
     * increase the value of the price
     */
    public void finalPrice() {
        switch (this.energyConsumption) {
            case "A":
                this.price += 1000.0;
                break;
            case "B":
                this.price += 800.0;
                break;
            case "C":
                this.price += 600.0;
                break;
            case "D":
                this.price += 500.0;
                break;
            case "E":
                this.price += 300.0;
                break;
            case "F":
                this.price += 100.0;
                break;
        }
        if(this.weight > 1 && this.weight <= 19){
            this.price += 100;
        }else if(this.weight >= 20 && this.weight <= 49){
            this.price += 500;
        }else if(this.weight >= 50 && this.weight <= 79){
            this.price += 800;
        }else if(this.weight > 80){
            this.price += 1000;
        }
    }

}
