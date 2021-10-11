/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class LibroGuiaPoo {

    /**
     * Scanner object to enter data by keyboard
     */
    Scanner leer = new Scanner(System.in);

    private String ISBN;
    private String title;
    private String author;
    private Integer numberOfPages;

    /**
     *
     */
    public LibroGuiaPoo() {
    }

    /**
     *
     * @param ISBN
     * @param title
     * @param author
     * @param numberOfPages
     */
    public LibroGuiaPoo(String ISBN, String title, String author, Integer numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    /* Methods Get and Set*/
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

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

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Method to create a book
     */
    public void createLibro() {
        System.out.println("enter the ISBN");
        String isbn;
        do{
            isbn = leer.next();
        }while(isbn.isEmpty());
        this.ISBN = isbn;
        System.out.println("enter the title");
        String titleOne;
        do{
            titleOne = leer.next();
        }while(titleOne.isEmpty());
        this.title = titleOne;
        System.out.println("enter the author");
        String authorOne;
        do{
            authorOne = leer.next();
        }while(authorOne.isEmpty());
        this.author = authorOne;
        System.out.println("enter the numberOfPages");
        Integer numberOfPagesOne;
        do {
            numberOfPagesOne = leer.nextInt();
        } while(numberOfPagesOne < 1);
        this.numberOfPages = numberOfPagesOne;
    }
}
