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
public class RectangleGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Integer base;
    private Integer height;

    /**
     * Default constructor method
     */
    public RectangleGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param base
     * @param height
     */
    public RectangleGuiaPoo(Integer base, Integer height) {
        this.base = base;
        this.height = height;
    }

    //Get ahd Set
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

    public void createRectangle() {
        System.out.println("Enter the base");
        Integer baseInteger;
        do {
            baseInteger = read.nextInt();
        } while (baseInteger == null || baseInteger < 0);
        this.base = baseInteger;
        System.out.println("Enter the height");
        Integer altura;
        do {
            altura = read.nextInt();
        } while (altura == null || altura < 0);
        this.height = altura;
    }

    public void calculateArea() {
        if (!(this.base == null || this.height == null)) {
            System.out.println("The area is " + this.base * this.height);
        }
    }

    public void calcutaSurface() {
        if (!(this.base == null || this.height == null)) {
            System.out.println("The surface is " + 2 * (this.base + this.height));
        }
    }

    public void draw() {
        if (!(this.base == null || this.height == null)) {
            System.out.println("the drawing of the rectangle");
            for (int i = 0; i < this.base; i++) {
                for (int j = 0; j < this.height; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}
