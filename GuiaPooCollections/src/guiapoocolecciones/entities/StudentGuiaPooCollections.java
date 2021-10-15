/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class StudentGuiaPooCollections {
    private Scanner read = new Scanner(System.in);
    private String name;
    private ArrayList<Integer> note;
    
    /**
     * Default constructor method
     */
    public StudentGuiaPooCollections() {
    }
    
    /**
     * Constructor method
     * 
     * @param name
     * @param note 
     */
    public StudentGuiaPooCollections(String name, ArrayList<Integer> note) {
        this.name = name;
        this.note = note;
    }

    
    //Get and Set
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getNote() {
        return note;
    }

    public void setNote(ArrayList<Integer> note) {
        this.note = note;
    }
    
    /**
     * 
     * @param listStudents
     * @return avarage, null;
     */
    public Integer finalNote(ArrayList<StudentGuiaPooCollections> listStudents){
        String nombre = "";
        Integer avarage = null;
        do{
            System.out.println("Enter the student´s name a search");
            nombre = read.next();
        }while(nombre.isEmpty() || nombre == null);
        for(StudentGuiaPooCollections aux : listStudents){
            if(aux.getName().equals(nombre)){
                avarage = (aux.getNote().get(0) + aux.getNote().get(1) + aux.getNote().get(2))/3;
                return avarage;
            }
        }
        System.out.println("The entered student could not be found");
        return null;
    }
}
