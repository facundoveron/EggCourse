/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.persistence;

import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class EstanciaDAO extends DAO {

    /**
     * method that returns the list of some of the ids of the table estancias
     *
     * @return idClientes
     * @throws Exception
     */
    public ArrayList<Integer> listById(String id) throws Exception {
        try {
            if (id.isEmpty() || id == null) {
                throw new Exception("id empty or null");
            }
            String sql = "SELECT " + id + " FROM estancias;";
            consult(sql);
            ArrayList<Integer> idClientes = new ArrayList<>();
            while (resultSet.next()) {
                idClientes.add(resultSet.getInt(1));
            }
            close();
            return idClientes;
        } catch (Exception e) {
            throw e;
        }
    }
}
