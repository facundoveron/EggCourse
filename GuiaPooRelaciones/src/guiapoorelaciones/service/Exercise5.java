/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.service;

import guiapoorelaciones.entities.FilmExercise5;
import guiapoorelaciones.entities.ViewerExercise5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class Exercise5 {

    private Scanner read = new Scanner(System.in);

    /**
     * Method to create a viewer by requesting the attributes via keyboard
     *
     * @return ViewerExercise5
     */
    private ViewerExercise5 createViewer() {
        String name = "";
        Integer age = null;
        Double money = 0.0;

        do {
            System.out.println("Enter the viewer´s name");
            name = read.nextLine();
        } while (name.isEmpty() || name == null);
        do {
            System.out.println("Enter the viewer´s age");
            age = read.nextInt();
        } while (age == null || age < 0 || age > 100);
        do {
            System.out.println("Enter the viewer´s money");
            money = read.nextDouble();
        } while (money == null || money < 0.0);
        ViewerExercise5 viewer = new ViewerExercise5(name, age, money);
        return viewer;
    }

    /**
     * method that creates a list of viewers by calling another method that
     * creates the viewer and in this method the following is stored and
     * returned
     *
     * @return ArrayList<ViewerExcercise5> listVierwers
     */
    public ArrayList<ViewerExercise5> listViewers() {
        String decide = null;
        ArrayList<ViewerExercise5> listViewer = new ArrayList<>();
        do {
            listViewer.add(createViewer());
            System.out.println("if you wish to enter another viewer enter \"yes\". Otherwise it will be taken as no and no more viewers will be entered.");
            decide = read.next();
        } while (decide.equals("yes"));
        return listViewer;
    }

    /**
     * method to create a movie, asking by keyboard for the attributes and
     * returns a movie object
     *
     * @return filmExercise5;
     */
    public FilmExercise5 createFilm() {
        String title = "";
        Double duration = 0.0;
        Integer minimumAge = 0;
        String director = "";
        do {
            System.out.println("Enter the film´s title");
            title = read.nextLine();
        } while (title.isEmpty() || title == null);
        do {
            System.out.println("Enter the length of the movie in hours");
            duration = read.nextDouble();
        } while (duration == null || duration < 0 || duration > 5);
        do {
            System.out.println("Enter the film´s minimum age");
            minimumAge = read.nextInt();
        } while (minimumAge == null || minimumAge < 0 || minimumAge > 22);
        do {
            System.out.println("Enter the film´s director ");
            director = read.nextLine();
        } while (director.isEmpty() || director == null);
        FilmExercise5 filmExercise5 = new FilmExercise5(title, duration, minimumAge, director);
        return filmExercise5;
    }

    /**
     * method that displays the movie theater and assigns seats and displays the
     * theater on the screen.
     *
     * @param viewers
     * @param precie
     */
    public void viewerLocation(ArrayList<ViewerExercise5> viewers, Integer precie) {
        String[] letter = {"A", "B", "C", "D", "E", "F"};
        System.out.println("the movie theater");
        String column = "";
        Integer row = 0;
        for (int i = 8; i > 0; i--) {
            for (int j = 6; j > 0; j--) {
                System.out.print(i + letter[j - 1] + " | ");
            }
            System.out.println("");
        }
        for (ViewerExercise5 aux : viewers) {
            if (aux.getMoney() > precie) {
                System.out.println("enter the column ");
                row = read.nextInt();
                System.out.println("enter the row");
                column = read.next();
                salon(column, row);
            }
        }

    }

    /**
     * Method that is dedicated to assigning locations
     *
     * @param a
     * @param b
     */
    public void salon(String a, Integer b) {
        String[] letter = {"A", "B", "C", "D", "E", "F"};
        System.out.println("the movie theater");
        for (int i = 8; i > 0; i--) {
            for (int j = 6; j > 0; j--) {
                if (b == i && letter[j - 1].equals(a)) {
                    System.out.println(i + letter[j - 1] + "X|");
                } else {
                    System.out.print(i + letter[j - 1] + " | ");
                }
            }
            System.out.println("");
        }
    }

}
