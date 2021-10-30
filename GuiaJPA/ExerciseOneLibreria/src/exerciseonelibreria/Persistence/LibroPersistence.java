/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria.Persistence;

import exerciseonelibreria.entities.Libro;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class LibroPersistence extends Persistence {

    /**
     * Method to persistence an Book
     *
     * @param libro
     * @throws Exception
     */
    public void saveLibro(Libro libro) throws Exception {
        try {
            if (libro == null) {
                throw new Exception("Book null");
            }

            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method than searching for a book by isbn
     *
     * @param isbn
     * @return libro
     * @throws Exception
     */
    public Libro searchBookByIsbn(Long isbn) throws Exception {
        try {
            if (isbn == null) {
                throw new Exception("isbn null");
            }
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that updates the objects
     *
     * @param libro
     * @throws Exception
     */
    public void udpate(Libro libro) throws Exception {
        try {
            if (libro == null) {
                throw new Exception("libro null");
            }

            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method searching for a book by title
     *
     * @param titulo
     * @return libro
     * @throws Exception
     */
    public Libro searchBooksByTitle(String titulo) throws Exception {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new Exception("title null or empty");
            }

            Libro libro = (Libro) em.createQuery("SELECT l"
                    + " FROM Libro l"
                    + " WHERE l.titulo = :titulo").
                    setParameter("titulo", titulo).
                    getSingleResult();
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that returns a list of books according to their publisher
     * remaining copies
     *
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Collection<Libro> searchBooksByNameAuthor(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Collection<Libro> books = (Collection<Libro>) em.createNativeQuery("SELECT * FROM libro WHERE AUTOR_ID = " + id).getResultList();
            return books;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /**
     * Method that returns a list of books according to their publisher
     * remaining copies
     *
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Collection<Libro> searchBooksByNamePublisher(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Collection<Libro> books = (Collection<Libro>) em.createNativeQuery("SELECT * FROM libro WHERE EDITORIAL_ID = " + id).getResultList();
            return books;
        } catch (Exception e) {
            throw e;
        }
    }
}
