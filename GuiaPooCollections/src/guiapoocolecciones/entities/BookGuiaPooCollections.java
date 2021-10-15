/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class BookGuiaPooCollections {

    private Scanner read = new Scanner(System.in);
    private String title;
    private String author;
    private Integer numberOfCopies;
    private Integer numberOfCopiesBorrowedCopies;

    /**
     * Default constructor method
     */
    public BookGuiaPooCollections() {
    }

    /**
     * Constructor metod
     *
     * @param title
     * @param author
     * @param numberOfCopies
     */
    public BookGuiaPooCollections(String title, String author, Integer numberOfCopies) {
        this.title = title;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        this.numberOfCopiesBorrowedCopies = 0;
    }

    //Get and Set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getNumberOfCopiesBorrowedCopies() {
        return numberOfCopiesBorrowedCopies;
    }

    public void setNumberOfCopiesBorrowedCopies(Integer numberOfCopiesBorrowedCopies) {
        this.numberOfCopiesBorrowedCopies = numberOfCopiesBorrowedCopies;
    }

    /**
     * Method in which the name of the book is entered to search for it in the
     * list, returns true if the book has been found and 1 is added to the
     * borrowed copies attribute and false otherwise.
     *
     * @param books
     * @return true, false;
     */
    public Boolean loan(HashSet<BookGuiaPooCollections> books) {
        String titulo = "";
        do {
            System.out.println("Enter the title of the book you are looking for");
            titulo = read.nextLine();
        } while (titulo.isEmpty() || titulo == null);
        for (BookGuiaPooCollections aux : books) {
            if (aux.getTitle().equals(titulo) && aux.getNumberOfCopiesBorrowedCopies() <= aux.getNumberOfCopies()) {
                aux.setNumberOfCopiesBorrowedCopies((aux.getNumberOfCopiesBorrowedCopies() + 1));
                return true;
            }
        }
        System.out.println("The book was not found");
        return false;
    }
   
    /**
     * method that asks for the title of the book, and looks for the book, verifies that it is on loan, and returns it. Returns true if it does. Otherwise false
     * 
     * @param books
     * @return true, false; 
     */
    public Boolean returnTo(HashSet<BookGuiaPooCollections> books){
        String titulo = "";
        
        do {
            System.out.println("Enter the title of the book you are looking for");
            titulo = read.nextLine();
        } while (titulo.isEmpty() || titulo == null);
        for (BookGuiaPooCollections aux : books) {
            if (aux.getTitle().equals(titulo) && aux.getNumberOfCopiesBorrowedCopies() > 0) {
                aux.setNumberOfCopiesBorrowedCopies((aux.getNumberOfCopiesBorrowedCopies() - 1));
                return true;
            }
        }
        System.out.println("The book was not found");
        return false;
    }
    
    public void toString(HashSet<BookGuiaPooCollections> books){
        books.forEach(aux -> {
            System.out.println("The title of the book : " + aux.getTitle() + " The author : " + aux.getAuthor() + " copies  : " + aux.getNumberOfCopies() + " borrowed copies  : " + aux.getNumberOfCopiesBorrowedCopies());
        });
    }
}
