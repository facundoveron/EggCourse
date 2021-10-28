/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import exercisetwoestancias.entities.Familia;
import exercisetwoestancias.persistence.FamiliaDAO;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class FamiliaService {

    private FamiliaDAO familiaDAO;

    /**
     * Constructer method
     */
    public FamiliaService() {
        this.familiaDAO = new FamiliaDAO();
    }

    /**
     * Method to list those families that have at least 3 children, and with a
     * maximum age of less than 10 years of age years old
     *
     * @throws Exception
     */
    public void listFamiliesBySon() throws Exception {
        try {
            Collection<Familia> families = familiaDAO.listBySon();
            System.out.println("Families are: ");
            families.forEach(aux -> {
                System.out.println("Name : " + aux.getNombre() + " Minimum age: " + aux.getEdadMinima()
                        + " Maximum age: " + aux.getEdadMaxima() + " Number of Children: " + aux.getNumHijos()
                        + " Email: " + aux.getEmail() + " Home id: " + aux.getCasa().getIdCasa() + "/n");
            });
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }

    
    /**
     * Method that displays all the families whose e-mail address is Hotmail.
     */
    public void listFamiliesByEmail() {
        try {
            Collection<Familia> families = familiaDAO.listByEmail();
            System.out.println("Families are: ");
            families.forEach(aux -> {
                System.out.println("Name : " + aux.getNombre() + " Minimum age: " + aux.getEdadMinima()
                        + " Maximum age: " + aux.getEdadMaxima() + " Number of Children: " + aux.getNumHijos()
                        + " Email: " + aux.getEmail() + " Home id: " + aux.getCasa().getIdCasa());
            });
            System.out.println("");
        } catch (Exception e) {
        }
    }
}
