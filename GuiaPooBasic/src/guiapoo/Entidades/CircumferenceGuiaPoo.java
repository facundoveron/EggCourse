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
public class CircumferenceGuiaPoo {

    /**
     * Scanner object to enter data by keyboard
     */
    private Scanner read = new Scanner(System.in);
    private Double radio;

    /**
     * Default constructor method
     */
    public CircumferenceGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param radio
     */
    public CircumferenceGuiaPoo(Double radio) {
        this.radio = radio;
    }

    //Get and Set
    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    /**
     * Method to create Circumference
     */
    public void createCircumference() {
        System.out.println("Enter the radio");
        Double radioDouble;
        do {
            radioDouble = read.nextDouble();
        } while (radioDouble == null || radioDouble < 0);
        this.radio = radioDouble;
    }

    /**
     * Method to calculate Area
     */
    public void calculateArea() {
        if (this.radio == null || this.radio.isNaN()) {
            System.out.println("null radio");
        } else {
            System.out.println("The area " + Math.PI * Math.pow(this.radio, 2));
        }
    }

    /**
     * Method to calculate Perimeter
     */
    public void calculatePerimeter() {
        if (this.radio == null || this.radio.isNaN()) {
            System.out.println("null radio");
        } else {
            System.out.println("The perimeter " + 2 * Math.PI * radio);
        }
    }
}
