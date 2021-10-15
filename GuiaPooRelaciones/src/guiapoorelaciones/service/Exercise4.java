/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.service;

import guiapoorelaciones.Enum.RaceDogsExcercise1;
import guiapoorelaciones.Enum.SizeDogsExercise1;
import guiapoorelaciones.entities.DogExercise4;
import guiapoorelaciones.entities.PersonExercise4;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class Exercise4 {

    Scanner read = new Scanner(System.in);
    String name = "";
    Integer age = null;
    
    /**
     * method to create a dogmethod to create a dog
     * 
     * @return dog;
     */
    public DogExercise4 createDog() {
        String raza = "";
        RaceDogsExcercise1 race = null;
        String tamaño = "";
        SizeDogsExercise1 size = null;
        do {
            System.out.println("enter the dog's name");
            name = read.nextLine();
        } while (name.isEmpty() || name == null);
        do {
            System.out.println("enter the dog´s race");
            raza = read.nextLine().toUpperCase();
            race = RaceDogsExcercise1.valueOf(raza);
        } while (race == null);
        do {
            System.out.println("enter the dog´s age");
            age = read.nextInt();
        } while (age == null || age < 0);
        do {
            System.out.println("enter the size of the dog");
            tamaño = read.next().toUpperCase();
            size = SizeDogsExercise1.valueOf(tamaño);
        } while (size == null);
        DogExercise4 dog = new DogExercise4(name, race, age, size);
        return dog;
    }
    
    /**
     * method to create a person
     * 
     * @return person
     */
    public PersonExercise4 createPerson() {
        String lastName = "";
        Long dni = null;
        name = null;
        age = null;
        do {
            System.out.println("enter the person`s name");
            name = read.nextLine();
        } while (name.isEmpty() || name == null);
        do {
            System.out.println("enter the person`s last name");
            lastName = read.nextLine();
        } while (lastName.isEmpty() || lastName == null);
        do {
            System.out.println("enter the person`s age");
            age = read.nextInt();
        } while (age == null || age < 0);
        do {
            System.out.println("enter the person´s dni");
            dni = read.nextLong();
        } while (dni == null || dni < 10000000);
        PersonExercise4 person = new PersonExercise4(name, lastName, age, dni);
        return person;
    }
    
    public DogExercise4 adopt(ArrayList<DogExercise4> dogs){
        System.out.println("The dogs are ");
        String nombre = "";
        dogs.forEach(aux ->{
            System.out.println("Name: "+ aux.getName() + " Age: "+  aux.getAge() + " Race: "+ aux.getRace() + " Size: " +aux.getSize());
        });
        System.out.println("Enter the name of the dog you wish to adopt");
        do{
            nombre = read.nextLine();
        }while(nombre.isEmpty() || nombre == null);
        for(DogExercise4 aux : dogs){
            if(aux.getName().equals(nombre)){
                return aux;
            }
        }
        return null;
    }
}
