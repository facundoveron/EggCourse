/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import exercisetwoestancias.entities.Cliente;
import exercisetwoestancias.persistence.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class ClienteService {

    private ClienteDAO clienteDao;

    /**
     * Constructer method
     */
    public ClienteService() {
        this.clienteDao = new ClienteDAO();
    }

    /**
     * Method that lists all the clients who at some point made a stay and the
     * description of the house where they stayed. and the description of the
     * house where they stayed.
     *
     * @throws Exception
     */
    public void listCustomer() throws Exception {
        try {
            ArrayList<Cliente> customers = clienteDao.listCustomers();
            if (customers == null || customers.size() == 0) {
                throw new Exception("customers null or no customers found");
            } else {
                customers.forEach(aux -> {
                    System.out.println("Name: " + aux.getNombre() + " Calle: " + aux.getCalle() + " Number: " + aux.getNumero() + " Zip code: " + aux.getCodigoPostal()
                            + " City: " + aux.getCiudad() + " Country: " + aux.getPais() + " Email: " + aux.getEmail());
                });
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Cliente> listCustomerRental(ArrayList<Integer> id) throws Exception {
        try {
            if(id == null || id.size() == 0){
                throw new Exception("id null");
            }
            ArrayList<Cliente> customers = clienteDao.listCustomers(id);
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }
}
