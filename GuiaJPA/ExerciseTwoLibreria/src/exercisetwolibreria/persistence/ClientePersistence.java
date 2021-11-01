/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.persistence;

import exercisetwolibreria.entities.Cliente;
import java.util.Collection;
import javax.persistence.NoResultException;

/**
 *
 * @author Facundo
 */
public class ClientePersistence extends Persistence {

    /**
     * This method searches for the client by id
     *
     * @param id
     * @return cliente
     * @throws Exception
     */
    public Cliente searchById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Cliente cliente = em.find(Cliente.class, id);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * This method searches for the client by dni
     *
     * @param dni
     * @return cliente
     * @throws Exception
     */
    public Cliente searchByDni(Long dni) throws Exception {
        try {
            if (dni == null) {
                throw new Exception("dni null");
            }
            Cliente cliente = null;
            cliente = (Cliente) em.createQuery(
                    "SELECT c"
                    + " FROM Cliente c"
                    + " WHERE c.documento = :dni").
                    setParameter("dni", dni).
                    getSingleResult();
            return cliente;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * This method searches for the client by phone
     *
     * @param phone
     * @return cliente
     * @throws Exception
     */
    public Cliente searchByPhone(String phone) throws Exception {
        try {
            if (phone == null || phone.isEmpty()) {
                throw new Exception("phone null or empty");
            }
            Cliente cliente = (Cliente) em.createNativeQuery("SELECT *"
                    + " FROM cliente"
                    + " WHERE telefono = " + phone + ";").getSingleResult();
            return cliente;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to persistence an Customer
     *
     * @param cliente
     * @throws Exception
     */
    public void saveSearchCustomer(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("customer not found");
            }
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

}
