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
public class OperationGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Integer numberOne;
    private Integer numberTwo;

    /**
     * Default constructor method
     */
    public OperationGuiaPoo() {
    }

    /**
     * Constructor Method
     *
     * @param numberOne
     * @param numberTwo
     */
    public OperationGuiaPoo(Integer numberOne, Integer numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    //Get and Set
    public Integer getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Integer numberOne) {
        this.numberOne = numberOne;
    }

    public Integer getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Integer numberTwo) {
        this.numberTwo = numberTwo;
    }

    /**
     * Method a way to assign values to attributes
     */
    public void createOperation() {
        this.numberOne = validateNumber("one");
        this.numberTwo = validateNumber("two");
    }

    /**
     * Method to validate numbers
     *
     * @param number
     * @return numero
     */
    private Integer validateNumber(String number) {
        System.out.println("Enter the number " + number);
        Integer numero;
        do {
            numero = read.nextInt();
        } while (numero == null);
        return numero;
    }

    /**
     * Method to add the two numbers
     *
     * @return numberOner + numberTwo
     */
    public Integer add() {
        if (!(this.numberOne == null || this.numberTwo == null)) {
            return numberOne + numberTwo;
        }
        return null;
    }

    /**
     * Method to subtract
     *
     * @return numberOne - numberTwo
     */
    public Integer subtract() {
        if (!(this.numberOne == null || this.numberTwo == null)) {
            return numberOne - numberTwo;
        }
        return null;
    }

    /**
     * Method to mutiply
     *
     * @return numberOne * numberTwo
     */
    public Integer multiply() {
        if (!(this.numberOne == null || this.numberTwo == null)) {
            if (numberOne == 0 || numberTwo == 0) {
                System.out.println("Err some of the numbers are equal to zero");
                return 0;
            } else {
                return numberOne * numberTwo;
            }
        }
        return null;
    }

    /**
     * Method to divide
     *
     * @return numberOne/numberTwo
     */
    public Integer divide() {
        if (!(this.numberOne == null || this.numberTwo == null)) {
            if (numberTwo == 0) {
                System.out.println("cannot be divided by zero");
                return 0;
            } else {
                return numberOne / numberTwo;
            }
        }
        return null;
    }
}
