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
public class NifGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Long dni;
    private String letter;

    /**
     * Default constructor method
     */
    public NifGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param dni
     * @param letter
     */
    public NifGuiaPoo(Long dni, String letter) {
        this.dni = dni;
        this.letter = letter;
    }

    //Get and Set
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String createNif() {
        Long DNI;
        do {
            System.out.println("Enter the DNI");
            DNI = read.nextLong();
        } while (DNI == null || DNI < 9000000);
        return verify(DNI);
    }

    private String verify(Long dnii) {
        int resto = (int) (dnii % 23);
        switch (resto) {
            case 0:
                return "T";
            case 1:
                return "R";
            case 2:
                return "W";
            case 3:
                return "A";
            case 4:
                return "G";
            case 5:
                return "M";
            case 6:
                return "Y";
            case 7:
                return "F";
            case 8:
                return "P";
            case 9:
                return "D";
            case 10:
                return "X";
            case 11:
                return "B";
            case 12:
                return "N";
            case 13:
                return "J";
            case 14:
                return "Z";
            case 15:
                return "S";
            case 16:
                return "T";
            case 17:
                return "V";
            case 18:
                return "19";
            case 20:
                return "C";
            case 21:
                return "K";
            case 22:
                return "E";
        }
        return null;    
    }
}
