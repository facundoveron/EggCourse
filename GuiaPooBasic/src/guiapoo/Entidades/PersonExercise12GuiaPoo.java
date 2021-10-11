/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class PersonExercise12GuiaPoo {

    private Scanner read = new Scanner(System.in);
    private String name;
    private Date dateOfBirth;

    /**
     * Default constructor method
     */
    public PersonExercise12GuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param name
     * @param dateOfBirth
     */
    public PersonExercise12GuiaPoo(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //Get and Set
    public Scanner getRead() {
        return read;
    }

    public void setRead(Scanner read) {
        this.read = read;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Method for creating assigning values to the object
     */
    public void createAPerson() {
        System.out.println("Enter the name");
        String nombre = "";
        Integer year;
        Integer month;
        Integer day;
        Date date;
        do {
            nombre = read.next();
        } while (nombre.isEmpty() || nombre == null);
        this.name = nombre;
        do {
            do {
                System.out.println("Enter year");
                year = read.nextInt();
            } while (year < 0 || year == null);

            if (year > 1900) {
                year = year - 1900;
            } else {
                year = 1900 - year;
            }

            do {
                System.out.println("Enter month");
                month = read.nextInt();
            } while (month < 0 || month > 12 || month == null);

            do {
                System.out.println("Enter day");
                day = read.nextInt();
            } while (day < 0 || day > 31 || day == null);
            date = new Date(year, month, day);
        } while (date == null);
        this.dateOfBirth = date;
    }
    
    /**
     * Method for calculating and displaying age
     */
    public Long calculateYears(){
        if(!(this.dateOfBirth == null)){
            Date currentDate = new Date();
            Long different;
            if(this.dateOfBirth.after(currentDate)){
                different = this.dateOfBirth.getTime() - currentDate.getTime();
            }else{
                different = currentDate.getTime() - this.dateOfBirth.getTime();
            }
            different = different/312768000;
            different = different/100;
            return different;
        }
        return null;
    }
    
    /**
     * Methid to compares the age of the object with that passed by parameter
     * @param age 
     */
    public Boolean lessThan(Integer age){
        return calculateYears() < age;
    }
    
    /**
     * Method that displays the created person
     */
    public void showPerson(){
        System.out.println("The name is " + this.getName());
        System.out.println("The age is " + calculateYears());
    }
}
