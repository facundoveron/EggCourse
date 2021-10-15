/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class CinemaExercise5 {
    private FilmExercise5 film;
    private ArrayList<ViewerExercise5> viewers;
    private Integer price;
    
    /**
     * Default constructor method
     */
    public CinemaExercise5() {
    }
    
    /**
     * Constructor method
     * 
     * @param film
     * @param viewers
     * @param price 
     */
    public CinemaExercise5(FilmExercise5 film, ArrayList<ViewerExercise5> viewers, Integer price) {
        this.film = film;
        this.viewers = viewers;
        this.price = price;
    }
    
    //Get and Set
    public FilmExercise5 getFilm() {
        return film;
    }

    public void setFilm(FilmExercise5 film) {
        this.film = film;
    }

    public ArrayList<ViewerExercise5> getViewers() {
        return viewers;
    }

    public void setViewers(ArrayList<ViewerExercise5> viewers) {
        this.viewers = viewers;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
}
