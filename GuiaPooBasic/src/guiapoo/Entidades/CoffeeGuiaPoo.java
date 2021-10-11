/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class CoffeeGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Double maximumCapacity;
    private Double currebtQuantity;

    /**
     * Default method constructor
     */
    public CoffeeGuiaPoo() {
    }

    /**
     * Method constructor
     *
     * @param maximumCapacity
     * @param currebtQuantity
     */
    public CoffeeGuiaPoo(Double maximumCapacity, Double currebtQuantity) {
        this.maximumCapacity = maximumCapacity;
        this.currebtQuantity = currebtQuantity;
    }

    //Get and Set
    public Double getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(Double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public Double getCurrebtQuantity() {
        return currebtQuantity;
    }

    public void setCurrebtQuantity(Double currebtQuantity) {
        this.currebtQuantity = currebtQuantity;
    }

    /**
     *  Method to check if the current capacity and quantity values are null
     * @return true or false
     */
    private Boolean verify() {
        return (maximumCapacity == null || currebtQuantity == null);
    }

    /**
     * Method to create the coffee maker by requesting values
     */
    public void createCoffeerMarker(){
        System.out.println("Enter the maximum capacity");
        Double maximaCapacidad;
        do{
            maximaCapacidad = read.nextDouble();
        }while(maximaCapacidad == null || maximaCapacidad < 0);
        this.maximumCapacity = maximaCapacidad;
    }
    
    /**
     * Method to fill coffe maker
     */
    public void fill() {
        if (!(maximumCapacity == null)) {
            this.currebtQuantity = maximumCapacity;
        }
    }
    
    /**
     * Method for filling the cup
     * @param cupSize 
     */
    public void serveCup(Integer cupSize) {
        if (!(cupSize == null)) {
            if (!verify()) {
                if (this.currebtQuantity < cupSize) {
                    System.out.println("not enough, was filled to " + currebtQuantity);
                    this.currebtQuantity = 0.0;
                }else{
                    System.out.println("the cup is filled");
                    this.currebtQuantity -= cupSize;
                }
            }
        }
    }
    
    /**
     * Method to empty coffer marker
     */
    public void emptyCoffeMaker(){
        this.currebtQuantity = 0.0;
    }
    
    /**
     * Method to add coffee to the coffee marker
     * @param coffee 
     */
    public void addCoffee(Integer coffee){
        if(coffee != null || this.maximumCapacity >= coffee + this.currebtQuantity){
            this.currebtQuantity += coffee;
        }else{
            System.out.println("coffe is null or exceeds capacity");
        }
    }
}
