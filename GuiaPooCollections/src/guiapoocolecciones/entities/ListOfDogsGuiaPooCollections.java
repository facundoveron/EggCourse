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
public class ListOfDogsGuiaPooCollections {

    private ArrayList<String> listBreed = new ArrayList<>();
    private Scanner read = new Scanner(System.in);

    /**
     * Default constructor method
     */
    public ListOfDogsGuiaPooCollections() {
    }

    //Get and Set
    public ArrayList<String> getListBreed() {
        return listBreed;
    }

    public void setListBreed(ArrayList<String> listBreed) {
        this.listBreed = listBreed;
    }

    /**
     * Method will ask for a dog breed, the dog will be saved in the list and
     * the user will be asked if he/she wants to save another dog or if he/she
     * wants to exit. wants to exit. If he/she decides to exit, all dogs saved
     * in the ArrayList will be displayed.
     */
    public void saveDogs() {
        String election = "";
        String breed = "";
        do {
            do {
                System.out.println("enter a dog breed");
                breed = read.next();
            } while (breed == null || breed.isEmpty());
            listBreed.add(breed);
            System.out.println("Do you want to keep another dog? yes to leave, no to continue keeping (any other letter is taken as no)");
            election = read.next();
        } while (election == null || !(election.equals("yes")) || election.isEmpty());
        System.out.println("the breeds entered are");
        for (String aux : listBreed) {
            System.out.println(aux);
        }
    }
}
