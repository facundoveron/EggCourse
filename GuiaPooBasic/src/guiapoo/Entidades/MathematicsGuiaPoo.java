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
public class MathematicsGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Double numberOne;
    private Double numberTwo;

    /**
     * Default constructor method
     */
    public MathematicsGuiaPoo() {
    }

    /**
     * Contructor method
     *
     * @param numberOne
     * @param numberTwo
     */
    public MathematicsGuiaPoo(Double numberOne, Double numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    //Get and Set
    public Scanner getRead() {
        return read;
    }

    public void setRead(Scanner read) {
        this.read = read;
    }

    public Double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Double numberOne) {
        this.numberOne = numberOne;
    }

    public Double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Double numberTwo) {
        this.numberTwo = numberTwo;
    }

    /**
     * Method that returns the greater number
     *
     * @return
     */
    public Double returnGreater() {
        if(!(this.numberOne == null || this.numberTwo == null)){
            return Math.max(this.numberOne, this.numberTwo);
        }
        return null;
    }
    
    /**
     * Method that calculates the power of the largest value raised to the smallest value 
     * @return 0.0, Math.pow(this.numberOne, this.numberTwo), Math.pow(this.numberTwo, this.numberOne);
     */
    public Double calculatePower() {
        if(!(this.numberOne == null || this.numberTwo == null)){
            return Math.pow(Math.max(this.numberOne, this.numberTwo), Math.min(this.numberOne, this.numberTwo));        
        }
        return null;
    }
    
    /**
     * method for calculating the square root of the smallest 
     * @return 
     */
    public Double calculateRoot(){
        Double number = Math.min(this.numberOne, this.numberTwo);
        if(number < 0){
            return null;
        }else{
            return Math.sqrt(number);
        }
    }

}
