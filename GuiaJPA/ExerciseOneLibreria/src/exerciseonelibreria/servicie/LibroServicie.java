/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria.servicie;

import exerciseonelibreria.Persistence.AutorPersistence;
import exerciseonelibreria.Persistence.EditorialPersistence;
import exerciseonelibreria.Persistence.LibroPersistence;
import exerciseonelibreria.entities.Editorial;
import exerciseonelibreria.entities.Libro;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class LibroServicie {

    private EditorialPersistence editorialPersistence = new EditorialPersistence();
    private LibroPersistence libroPersistence;

    /**
     * Constructer method
     */
    public LibroServicie() {
        this.libroPersistence = new LibroPersistence();
    }

    /**
     * Method to create book
     *
     * @param isbn
     * @param titulo
     * @param anio
     * @param ejemplares
     * @throws Exception
     */
    public void createLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, String nombreAutor, String nombreEditorial) throws Exception {
        try {
            AutorPersistence autorPersistence = new AutorPersistence();

            if (isbn == null || libroPersistence.searchBookByIsbn(isbn) != null) {
                throw new Exception("isbn null or this isbn is already registered");
            }
            if (titulo == null || titulo.isEmpty()) {
                throw new Exception("titulo null or titulo empty or this title is already registered");
            }
            if (anio == null || anio < 1900) {
                throw new Exception("Year null or year less than 1900");
            }
            if (ejemplares == null || ejemplares < 0) {
                throw new Exception("copies null or copies negative");
            }
            if (nombreAutor == null || nombreAutor.isEmpty()) {
                throw new Exception("author´s name null or empty");
            }
            if (nombreEditorial == null || nombreEditorial.isEmpty()) {
                throw new Exception("name of the publisher null or empty");
            }

            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setEjemplaresRestantes(ejemplares);
            libro.setAlta(true);
            libro.setAutor(autorPersistence.searchAuthorByName(nombreAutor));
            libro.setEditorial(editorialPersistence.searchEditorialByName(nombreEditorial));

            libroPersistence.saveLibro(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method of deregistering a book
     *
     * @param isbn
     * @throws Exception
     */
    public void cancelABook(Long isbn) throws Exception {
        try {
            if (isbn == null) {
                throw new Exception("isbn null");
            }

            Libro book = libroPersistence.searchBookByIsbn(isbn);
            book.setAlta(false);
            libroPersistence.udpate(book);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that searches and displays a book by its title
     *
     * @param title
     * @throws Exception
     */
    public void searchBook(String title) throws Exception {
        try {
            if (title == null || title.isEmpty()) {
                throw new Exception("title null or empty");
            }
            Libro libro = libroPersistence.searchBooksByTitle(title);
            if (libro.getAlta()) {
                System.out.println("Isbn: " + libro.getIsbn() + " Title: " + libro.getTitulo() + " Year: " + libro.getAnio()
                        + " Copies: " + libro.getEjemplares() + " Borrowed copies: " + libro.getEjemplaresPrestados() + " Remaining copies: " + libro.getEjemplaresRestantes()
                        + " Author : " + libro.getAutor().getNombre()
                        + " Publisher: " + libro.getEditorial().getNombre());
            } else {
                System.out.println("The book has been withdrawn");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchListBooks(String nombre) throws Exception {
        try {
            Editorial editorial = editorialPersistence.searchEditorialByName(nombre);
            if(editorial == null){
                throw new Exception("publisher not found");
            }
            Collection<Libro> books = libroPersistence.searchBooksByNameAuthor(editorial.getId());
            if(books.size() > 0){
                books.forEach(aux ->{
                    System.out.println("Titulo: " + aux.getTitulo());
                });
            }else{
                System.out.println("no");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
