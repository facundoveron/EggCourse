/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda;

import exerciseOneTienda.services.MainService;

/**
 *
 * @author Facundo
 */
public class Exercise1Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        MainService mainService = new MainService();
        mainService.menu();
    }
    
}
