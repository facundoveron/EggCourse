/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria.Persistence;

import exerciseonelibreria.entities.Autor;

/**
 *
 * @author Facundo
 */
public class AutorPersistence extends Persistence {

    /**
     * Method to persistence an author
     *
     * @param autor
     * @throws Exception
     */
    public void saveAutor(Autor autor) throws Exception {
        try {
            if (autor == null) {
                throw new Exception("autor null");
            }

            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that searches for an author by his id and returns it
     *
     * @param id
     * @return autor
     * @throws Exception
     */
    public Autor searchAutorById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }

            Autor autor = em.find(Autor.class, id);
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method for updating an author
     *
     * @param autor
     * @throws Exception
     */
    public void update(Autor autor) throws Exception {
        try {
            if (autor == null) {
                throw new Exception("autor null");
            }

            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Method that returns authors by name 
     * 
     * @param nombre
     * @return autores
     * @throws Exception 
     */
    public Autor searchAuthorByName(String nombre) throws Exception{
        try {
            if(nombre == null || nombre.isEmpty()){
                throw new Exception("name is null or name empty");
            }
            Autor autor = (Autor) em.createQuery("SELECT a"
                    + " FROM Autor a"
                    + " WHERE a.nombre = :nombre").
                    setParameter("nombre", nombre).
                    getSingleResult(); 
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }
}
