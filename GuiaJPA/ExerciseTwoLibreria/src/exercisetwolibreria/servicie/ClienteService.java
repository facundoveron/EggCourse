/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.servicie;

import exercisetwolibreria.entities.Cliente;
import exercisetwolibreria.persistence.ClientePersistence;
import javax.persistence.NoResultException;

/**
 *
 * @author Facundo
 */
public class ClienteService {

    private ClientePersistence clientePersistence;

    public ClienteService() {
        this.clientePersistence = new ClientePersistence();
    }

    /**
     * Method to create Customer
     *
     * @param id
     * @param dni
     * @param nombre
     * @param apellido
     * @param telefono
     * @throws Exception
     */
    public void createCustomer(Integer id, Long dni, String nombre, String apellido, String telefono) throws Exception {
        try {
            if (id == null || clientePersistence.searchById(id) != null) {
                throw new Exception("id null or the id is already registered");
            }
            if (dni == null || clientePersistence.searchByDni(dni) != null) {
                throw new Exception("dni null or the dni is already registered");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("name null or empty");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("apellido null or empty");
            }
            if (telefono == null || telefono.trim().isEmpty() || clientePersistence.searchByPhone(telefono) != null) {
                throw new Exception("Phone null or empty or the phone is already registered");
            }

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setDocumento(dni);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTelefono(telefono);

            clientePersistence.saveSearchCustomer(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that searches for and returns a customer by ID number
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
            Cliente cliente = clientePersistence.searchByDni(dni);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
}
