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
public class PersonExercise4 {
    private String name;
    private String lastName;
    private Integer age;
    private Long dni;
    private DogExercise4 dog;

    /**
     * Default constructer method
     */    
    public PersonExercise4() {
    }
    
    /**
     * Constructer method
     * 
     * @param name
     * @param lastName
     * @param age
     * @param dni
     * @param dog 
     */
    public PersonExercise4(String name, String lastName, Integer age, Long dni) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
    }
    
    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public DogExercise4 getDog() {
        return dog;
    }

    public void setDog(DogExercise4 dog) {
        this.dog = dog;
    }
    
    
}
