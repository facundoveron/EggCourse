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
public class DogExercise1 extends AnimalExercise1{

    /**
     * Constructer method
     * 
     * @param name
     * @param food
     * @param age
     * @param breed 
     */
    public DogExercise1(String name, String food, Integer age, String breed) {
        super(name, food, age, breed);
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
     * Overwritten method 
     */
    @Override
    public void feed() {
        System.out.println("is fed with " + food);
    }
    
    
}
