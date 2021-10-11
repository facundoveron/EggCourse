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
public class PointGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;
    
    /**
     * Default constructor method
     */
    public PointGuiaPoo() {
    }
    
    /**
     * Method constructor
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public PointGuiaPoo(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    //Get and Set
    public Scanner getRead() {
        return read;
    }

    public void setRead(Scanner read) {
        this.read = read;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
    
    
    /**
     * Method for entering values to object attributes
     */
    public void createPoints(){
        Integer point;
        do{
            System.out.println("Enter point X1");
            point = read.nextInt();
        }while(point == null);
        this.x1 = point;
        do{
            System.out.println("Enter point Y1");
            point = read.nextInt();
        }while(point == null);
        this.y1 = point;
        do{
            System.out.println("Enter point X2");
            point = read.nextInt();
        }while(point == null);
        this.x2 = point;
        do{
            System.out.println("Enter point Y2");
            point = read.nextInt();
        }while(point == null);
        this.y2 = point;
    }
    
    /**
     * method that calculates and returns the distance between two points
     * @return Math.sqrt(formula), null
     */
    public Double calculate(){
        if(!(this.x1 == null || this.x2 == null || this.y1 == null || this.y2 == null)){
            return Math.sqrt(Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2));
        }
        return null;
    }
    
    
}
