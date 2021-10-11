/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

import java.util.Arrays;

/**
 *
 * @author Facundo
 */
public class ArrayGuiaPoo {

    private Double[] arrayA;
    private Double[] arrayB;
    
    /**
     * Constructor method
     */
    public ArrayGuiaPoo() {
        this.arrayA = new Double[50];
        this.arrayB = new Double[20];
    }
    
    //Get and Set
    public Double[] getArrayA() {
        return arrayA;
    }

    public void setArrayA(Double[] arrayA) {
        this.arrayA = arrayA;
    }

    public Double[] getArrayB() {
        return arrayB;
    }

    public void setArrayB(Double[] arrayB) {
        this.arrayB = arrayB;
    }

    /**
     * Method that gives values to the arrayA
     */
    public void initializeArray() {
        for (int i = 0; i < arrayA.length; i++) {
            this.arrayA[i] = (Math.random() * 10 + 1);
            System.out.print(this.arrayA[i] + " ");
        }
        System.out.println("");
    }

    /**
     * Method that sorts array A from smallest to largest and copies the first 10 sorted numbers to array B of 20 elements.
     * 10 sorted numbers to arrayB, and fills the last 10 elements with the elements with the value 0.5
     */
    public void sortNumbers() {
        Arrays.sort(arrayA);
        for (int i = 0; i < arrayB.length; i++) {
            if (i < 10) {
                arrayB[i] = arrayA[i];
            } else {
                arrayB[i] = 0.5;
            }
            System.out.print(arrayB[i] + " - ");
        }
        System.out.println("");
    }
}
