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
public class RootsGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Integer a;
    private Integer b;
    private Integer c;

    /**
     * Constructer method
     *
     * @param a
     * @param b
     * @param c
     */
    public RootsGuiaPoo(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Get and Set
    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    /**
     * *
     * Method that returns the value of the discriminant
     *
     * @return (Math.pow(this.b, 2) - 4 * this.a * this.c), null;
     */
    public Double discriminant() {
        if (!(this.a == null || this.b == null || this.c == null)) {
            return (Math.pow(this.b, 2) - 4 * this.a * this.c);
        }
        return null;
    }

    /**
     * Method that returns a boolean if it has 2 solutions
     *
     * @return true, false, null;
     */
    public Boolean hasRoots() {
        if (!(this.a == null || this.b == null || this.c == null)) {
            if (discriminant() >= 0.0) {
                return true;
            } else {
                return false;
            }
        }
        return null;
    }

    /**
     * Method that returns a boolean if it has a solution
     *
     * @return true, false, null;
     */
    public Boolean hasRoot() {
        if (!(this.a == null || this.b == null || this.c == null)) {
            if (discriminant() == 0.0) {
                return true;
            } else {
                return false;
            }
        }
        return null;
    }

    /**
     * Method that calls has roots and prints the 2 solutions 
     */
    public void getRoots() {
        if (hasRoots()) {
            System.out.println(((-this.b) - discriminant())/(2*this.a));
            System.out.println(((-this.b) + discriminant())/(2*this.a));
        }
    }
    
    /**
     * Method calls root and if true returns true prints the solutions 
     */
    public void getRoot(){
        if(hasRoot()){
            System.out.println((discriminant())/(2*this.a));
        }
    }
    
    /**
     * Method showing the roots
     */
    public void calculate(){
        if(hasRoots()){
            getRoots();
        }else if(hasRoot()){
            getRoot();
        }else{
            System.out.println("there is no solution");
        }
    }
}
