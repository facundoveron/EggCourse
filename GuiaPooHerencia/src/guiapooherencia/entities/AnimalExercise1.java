/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

/**
 *
 * @author Facundo
 */
public abstract class AnimalExercise1 {
    protected String name;
    protected String food;
    protected Integer age;
    protected String breed;

    /**
     * Default constructer method
     */
    public AnimalExercise1() {
    }

    /**
     * Constructer method
     * 
     * @param name
     * @param food
     * @param age
     * @param breed 
     */
    public AnimalExercise1(String name, String food, Integer age, String breed) {
        this.name = name;
        this.food = food;
        this.age = age;
        this.breed = breed;
    }

    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    /**
     * Method showing what each animal is fed with
     */
    public abstract void feed();
    
}
