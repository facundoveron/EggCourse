/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

//import java.util.Scanner;
import guiapoocolecciones.utilidades.Comparison;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Facundo
 */
public class MovieGuiaPooCollections {
//    private Scanner read = new Scanner(System.in);

    private String title;
    private String manager;
    private Double duration;

    /**
     * Default constructor method
     */
    public MovieGuiaPooCollections() {
    }

    /**
     * Constructor method
     *
     * @param title
     * @param manager
     * @param duration
     */
    public MovieGuiaPooCollections(String title, String manager, Double duration) {
        this.title = title;
        this.manager = manager;
        this.duration = duration;
    }

    //Get and Set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
    
    /**
     * Method of displaying the movies, you sort them in several ways
     * 
     * @param movies 
     */
    public void view(ArrayList<MovieGuiaPooCollections> movies) {
        System.out.println("show all movies");
        movies.forEach((aux) -> {
            System.out.println(" " + aux.getTitle() + " " + aux.getManager() + " " + aux.getDuration());
        });
        System.out.println("display all movies sorted by duration from longest to shortest");
        Collections.sort(movies, Comparison.ordenarPorDuracionMayorMenor);
        System.out.println("display all movies sorted by duration from shortest to longest");
        Collections.sort(movies, Comparison.ordenarPorDuracionMenorMayor);
        System.out.println("show all movies sorted by title");
        Collections.sort(movies, Comparison.ordenarPorTitulo);
        System.out.println("show all movies sorted by director");
        Collections.sort(movies, Comparison.ordenarPorDirector);
    }
}
