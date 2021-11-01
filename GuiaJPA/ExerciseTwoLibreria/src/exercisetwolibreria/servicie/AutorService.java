/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.servicie;

import exercisetwolibreria.persistence.AutorPersistence;
import exercisetwolibreria.entities.Autor;

/**
 *
 * @author Facundo
 */
public class AutorService {

    AutorPersistence autorPersistence;

    /**
     * Cosntructer method
     */
    public AutorService() {
        this.autorPersistence = new AutorPersistence();
    }

    /**
     * Method to create an author
     *
     * @param id
     * @param name
     * @throws Exception
     */
    public void create(Integer id, String name) throws Exception {
        try {
            if (id == null || autorPersistence.searchAutorById(id) != null) {
                throw new Exception("id null or the id is already registered");
            }
            if (name == null || name.isEmpty() || autorPersistence.searchAuthorByName(name) != null) {
                throw new Exception("name null or name empty or the name is already registered");
            }

            Autor autor = new Autor();
            autor.setId(id);
            autor.setNombre(name);
            autor.setAlta(true);

            autorPersistence.saveAutor(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to unsubscribe an author
     *
     * @param id
     * @throws Exception
     */
    public void cancelAutor(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }

            Autor autor = autorPersistence.searchAutorById(id);
            autor.setAlta(false);
            autorPersistence.update(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method showing authors by name
     *
     * @param name
     * @throws Exception
     */
    public void authorByName(String name) throws Exception {
        try {
            if (name == null || name.isEmpty()) {
                throw new Exception("name null or name empty");
            }
            Autor autor = autorPersistence.searchAuthorByName(name);
            if (autor.getAlta()) {
                System.out.println("Id: " + autor.getId() + " Name: " + autor.getNombre());
            }else{
                System.out.println("This author is unsubscribed");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
