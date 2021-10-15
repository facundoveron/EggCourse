/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class ListOfDogs1GuiaPooCollections {

    private ArrayList<String> listBreed = new ArrayList<>();
    private Scanner read = new Scanner(System.in);

    /**
     * Default constructor method
     */
    public ListOfDogs1GuiaPooCollections() {
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

    /**
     * method that asks for the name of a race to delete it, if it is in the
     * list, if not a message will be displayed, and then the list will be
     * displayed again.
     */
    public void deleteDog() {
        String breed = "";
        boolean verify = true;
        do {
            System.out.println("Enter the name of the race to be deleted");
            breed = read.next();
        } while (breed.isEmpty() || breed == null);
        Iterator<String> visit = listBreed.iterator();
        while (visit.hasNext()) {
            String breedNext = visit.next();
            if (breedNext.equals(breed)) {
                visit.remove();
                System.out.println("the race" + breed + "has been eliminated");
                verify = false;
                break;
            }
        }
        if (verify) {
            System.out.println("the entered breed could not be found");
        }
        System.out.println("the sorted list will be displayed");
        for (String aux : listBreed) {
            System.out.println(aux);
        }
    }
}
