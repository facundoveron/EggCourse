/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.persistence;

import exercisetwoestancias.entities.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class ClienteDAO extends DAO {

    private EstanciaDAO estanciaDAO;

    /**
     * Constructer method
     */
    public ClienteDAO() {
        this.estanciaDAO = new EstanciaDAO();
    }

    /**
     * Method that returns the list of clients according to the ids found.
     *
     * @return customer
     * @throws Exception
     */
    public ArrayList<Cliente> listCustomers() throws Exception {
        try {
            ArrayList<Integer> idClientes = estanciaDAO.listById("id_cliente");
            ArrayList<Cliente> customers = new ArrayList<>();
            String sql = "";
            Cliente cliente = null;
            for (Integer aux : idClientes) {
                sql = "SELECT * FROM clientes WHERE id_cliente = " + aux;
                consult(sql);
                while (resultSet.next()) {
                    cliente = new Cliente();
                    cliente.setId_cliente(resultSet.getInt(1));
                    cliente.setNombre(resultSet.getString(2));
                    cliente.setCalle(resultSet.getString(3));
                    cliente.setNumero(resultSet.getInt(4));
                    cliente.setCodigoPostal(resultSet.getString(5));
                    cliente.setCiudad(resultSet.getString(6));
                    cliente.setPais(resultSet.getString(7));
                    cliente.setEmail(resultSet.getString(8));
                    customers.add(cliente);
                }
                close();
            }
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Cliente> listCustomers(ArrayList<Integer> id) throws Exception {
        try {
            ArrayList<Cliente> customers = new ArrayList<>();
            String sql = "";
            Cliente cliente = null;
            for (Integer aux : id) {
                sql = "SELECT * FROM clientes WHERE id_cliente = " + aux;
                consult(sql);
                while (resultSet.next()) {
                    cliente = new Cliente();
                    cliente.setId_cliente(resultSet.getInt(1));
                    cliente.setNombre(resultSet.getString(2));
                    cliente.setCalle(resultSet.getString(3));
                    cliente.setNumero(resultSet.getInt(4));
                    cliente.setCodigoPostal(resultSet.getString(5));
                    cliente.setCiudad(resultSet.getString(6));
                    cliente.setPais(resultSet.getString(7));
                    cliente.setEmail(resultSet.getString(8));
                    customers.add(cliente);
                }
                close();
            }
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }
}
