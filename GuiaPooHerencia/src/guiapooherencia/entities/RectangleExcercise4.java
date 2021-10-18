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
public class RectangleExcercise4 implements CalculationsFormsExercise4 {

    private Integer base;
    private Integer height;

    /**
     * Default constructer method
     */
    public RectangleExcercise4() {
    }

    /**
     * Constructer method
     *
     * @param base
     * @param height
     */
    public RectangleExcercise4(Integer base, Integer height) {
        if (base < 0) {
            this.base = (-1) * base;
        } else {
            this.base = base;
        }
        if (height < 0) {
            this.height = (-1) * height;
        } else {
            this.height = height;
        }
    }

    //Get and Set
    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    //Method Override
    @Override
    public void area() {
        if (this.base == null || this.height == null) {
            System.out.println("uninitialized attributes ");
        } else {
            System.out.println(this.base * this.height);
        }
    }

    @Override
    public void perimetre() {
        if (this.base == null || this.height == null) {
            System.out.println("uninitialized attributes ");
        } else {
            System.out.println(((this.base + this.height)*2));
        }
    }

}
