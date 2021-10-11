/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

/**
 *
 * @author Facundo
 */
public class SongGuiaPoo {
    private String title;
    private String author;
    
    /**
     * Default constructor method
     */
    public SongGuiaPoo() {
    }
    
    /**
     * Constructor method
     * 
     * @param title
     * @param author 
     */
    public SongGuiaPoo(String title, String author) {
        this.title = title;
        this.author = author;
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
    
    
}
