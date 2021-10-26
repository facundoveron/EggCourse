/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.services;

import exerciseOneTienda.entities.Fabricante;
import exerciseOneTienda.persistence.FabricanteDAO;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class ManufacturerService {
    private Scanner read = new Scanner(System.in);
    private FabricanteDAO fabricanteDao;

    /**
     * Constructer method
     */
    public ManufacturerService() {
        this.fabricanteDao = new FabricanteDAO();
    }
    
    /**
     * Method to create manufacturer
     * @throws Exception 
     */
    public void createManufacturer() throws Exception{
        try {
            Integer code = null;
            String name = null;
            do {
                System.out.println("Enter the manufacturar code");
                code = read.nextInt();
            } while (code == null);
            do {
                System.out.println("Enter the manucfacturar name");
                name = read.nextLine();
            } while (name == null || name.isEmpty());
            saveManufacturer(code, name);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /**
     * Method to save manufacturer
     *
     * @param code
     * @param name
     * @throws Exception
     */
    public void saveManufacturer(Integer code, String name) throws Exception {
        try {
            if (code == null || fabricanteDao.searchByCode(code) != null) {
                throw new Exception("code null or this code is already registered");
            }
            if (name == null || name.isEmpty()) {
                throw new Exception("name null or name empty");
            }
            Fabricante fabricante = new Fabricante(code, name);
            fabricanteDao.saveManufacturer(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

}
