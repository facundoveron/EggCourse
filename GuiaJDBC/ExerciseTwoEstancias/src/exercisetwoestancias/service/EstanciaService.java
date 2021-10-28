/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import exercisetwoestancias.entities.Cliente;
import exercisetwoestancias.persistence.EstanciaDAO;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class EstanciaService {

    private EstanciaDAO estanciaDAO;
    private ClienteService clienteService;
    private CasaService casaService;

    public EstanciaService() {
        this.estanciaDAO = new EstanciaDAO();
        this.clienteService = new ClienteService();
        this.casaService = new CasaService();
    }

    public void listId() throws Exception {
        try {
            ArrayList<Integer> idCustomer = estanciaDAO.listById("id_cliente");
            ArrayList<Integer> idHouse = estanciaDAO.listById("id_casa");
            ArrayList<Cliente> customers = clienteService.listCustomerRental(idCustomer);
            int i = 0;
            for(Integer aux : idHouse){
                System.out.println("Name: " + customers.get(i).getNombre() + " Country: " + customers.get(i).getPais() + " City: "+ customers.get(i).getCiudad());
                System.out.println("The house I reserve is ");
                casaService.searchById(aux);
                i++;
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }

}
