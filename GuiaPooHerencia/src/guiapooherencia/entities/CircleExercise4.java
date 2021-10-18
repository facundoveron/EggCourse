/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

import guiapooherencia.entities.interfaces.CalculationsFormsExercise4;

/**
 *
 * @author Facundo
 */
public class CircleExercise4 implements CalculationsFormsExercise4 {

    private Integer radio;

    /**
     * Default constructer method
     */
    public CircleExercise4() {
    }

    //Get and Set
    public CircleExercise4(Integer radio) {
        this.radio = radio;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    //Method Override
    @Override
    public void area() {
        if (this.radio == null) {
            System.out.println("uninitialized attributes ");
        } else {
            System.out.println((Math.PI * Math.pow(this.radio, 2)));
        }
    }

    @Override
    public void perimetre() {
        if (this.radio == null) {
            System.out.println("uninitialized attributes ");
        } else {
            System.out.println((Math.PI * (radio *2)));
        }
    }

}
