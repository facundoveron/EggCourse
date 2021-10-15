/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.service;

import guiapoorelaciones.Enum.RaceDogsExcercise1;
import guiapoorelaciones.Enum.SizeDogsExercise1;
import guiapoorelaciones.entities.DogExercise1;
import guiapoorelaciones.entities.PersonExercise1;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class Exercise1 {

    Scanner read = new Scanner(System.in);
    String name = "";
    Integer age = null;
    
    /**
     * method to create a dogmethod to create a dog
     * 
     * @return dog;
     */
    private DogExercise1 createDog() {
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
        DogExercise1 dog = new DogExercise1(name, race, age, size);
        return dog;
    }
    
    /**
     * method to create a person
     * 
     * @return person
     */
    public PersonExercise1 createPerson() {
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
        DogExercise1 dog = createDog();
        PersonExercise1 person = new PersonExercise1(name, lastName, age, dni, dog);
        return person;
    }
}
