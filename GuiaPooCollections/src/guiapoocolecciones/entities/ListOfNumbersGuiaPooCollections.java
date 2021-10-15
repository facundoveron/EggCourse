/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class ListOfNumbersGuiaPooCollections {

    private Scanner read = new Scanner(System.in);
    private ArrayList<Integer> listNumber = new ArrayList<>();

    /**
     * Default constructor method
     */
    public ListOfNumbersGuiaPooCollections() {
    }

    /**
     * Constructer method
     *
     * @param listNumber
     */
    public ListOfNumbersGuiaPooCollections(ArrayList<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    //Get and Set
    public ArrayList<Integer> getListNumber() {
        return listNumber;
    }

    public void setListNumber(ArrayList<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    /**
     * Method to store numbers in a list
     */
    public void saveNumbers() {
        Integer number = null;
        Boolean exit = true;
        do {
            System.out.println("Enter the number");
            do {
                number = read.nextInt();
            } while (number == null);
            if (!(number == -99)) {
                listNumber.add(number);
            } else {
                exit = false;
            }
        } while (exit);
    }
    
    /**
     * method for displaying all numbers, the sum of the numbers and the average of the numbers
     */
    public void show() {
        System.out.println("the numbers are ");
        Integer summation = 0;
        listNumber.forEach(aux -> {
            System.out.print(aux + " . ");
        });
        System.out.println("");
        for (Integer aux : listNumber) {
            summation += aux;
        }
        System.out.println("the sum of all the numbers is " + summation);
        System.out.println("");
        System.out.println("The avarange is " + (summation/listNumber.size()));
    }

}
