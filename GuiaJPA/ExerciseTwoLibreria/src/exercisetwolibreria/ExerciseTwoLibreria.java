/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria;

import exercisetwolibreria.servicie.LibroService;
import exercisetwolibreria.servicie.PrestamoService;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Facundo
 */
public class ExerciseTwoLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

//        ClienteService clienteService = new ClienteService();
//        clienteService.createCustomer(4, 41004912L, "facundo", "veron", "2612065830");
//        LibroService libroService = new LibroService();
//        libroService.createLibro(15000000000L, "El principe ", 1999, 200, "Facundo", "mendocina");
        PrestamoService prestamoService = new PrestamoService();
//        
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
//        Date loanDate;
//        Date dateOfReturn;
//        loanDate = formato.parse("2020/02/20");
//        dateOfReturn = formato.parse( "20/03/2020");
//        prestamoService.createLoan(1232, loanDate,dateOfReturn,15000000000L, 41004912L);
//        
//        prestamoService.returnABook(15000000000L);
        
    }

}
