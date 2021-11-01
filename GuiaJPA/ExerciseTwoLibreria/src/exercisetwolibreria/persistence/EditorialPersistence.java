/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.persistence;

import exercisetwolibreria.entities.Editorial;
import javax.persistence.NoResultException;

/**
 * Method to persistence an editorial
 *
 * @author Facundo
 */
public class EditorialPersistence extends Persistence {

    /**
     * Metodo para guardar una editorial
     *
     * @param editorial
     * @throws Exception
     */
    public void saveEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("editorial null");
            }

            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to search for a publisher by id
     *
     * @param id
     * @return editorial
     * @throws Exception
     */
    public Editorial searchEditorialById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Editorial editorial = em.find(Editorial.class, id);
            return editorial;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that updates the objects
     *
     * @param editorial
     * @throws Exception
     */
    public void update(Editorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("editorial null");
            }

            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that looks up a publisher by name and returns it
     *
     * @param nombre
     * @return editorial
     * @throws Exception
     */
    public Editorial searchEditorialByName(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new Exception("name null or empty");
            }
            Editorial editorial = (Editorial) em.createQuery("SELECT e"
                    + " FROM Editorial e"
                    + " WHERE e.nombre = :nombre").
                    setParameter("nombre", nombre).
                    getSingleResult();
            return editorial;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
