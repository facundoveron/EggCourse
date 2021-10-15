/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

/**
 *
 * @author Facundo
 */
public class FilmExercise5 {
    private String title;
    private Double duration;
    private Integer minimumAge;
    private String director;
    
    /**
     * Default constructor method
     */
    public FilmExercise5() {
    }

    /**
     * Constructor method
     * 
     * @param title
     * @param duration
     * @param minimumAge
     * @param director 
     */
    public FilmExercise5(String title, Double duration, Integer minimumAge, String director) {
        this.title = title;
        this.duration = duration;
        this.minimumAge = minimumAge;
        this.director = director;
    }
    
    //Get and Set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
