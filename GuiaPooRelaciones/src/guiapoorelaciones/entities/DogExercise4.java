/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import guiapoorelaciones.Enum.RaceDogsExcercise1;
import guiapoorelaciones.Enum.SizeDogsExercise1;

/**
 *
 * @author Facundo
 */
public class DogExercise4 {
    private String name;
    private RaceDogsExcercise1 race;
    private Integer age;
    private SizeDogsExercise1 size;
    
    /**
     * Default constructer method
     */
    public DogExercise4() {
    }
    
    /**
     * Constructer method
     * 
     * @param name
     * @param race
     * @param age
     * @param size 
     */
    public DogExercise4(String name, RaceDogsExcercise1 race, Integer age, SizeDogsExercise1 size) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.size = size;
    }
    
    //Get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RaceDogsExcercise1 getRace() {
        return race;
    }

    public void setRace(RaceDogsExcercise1 race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SizeDogsExercise1 getSize() {
        return size;
    }

    public void setSize(SizeDogsExercise1 size) {
        this.size = size;
    }
    
    
}
