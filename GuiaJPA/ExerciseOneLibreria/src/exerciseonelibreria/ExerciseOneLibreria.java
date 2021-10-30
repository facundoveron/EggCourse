/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria;

import exerciseonelibreria.servicie.AutorService;
import exerciseonelibreria.servicie.EditorialService;
import exerciseonelibreria.servicie.LibroServicie;

/**
 *
 * @author Facundo
 */
public class ExerciseOneLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        
//        AutorService autorService = new AutorService();
//        autorService.create(1, "Facundo");
//        EditorialService editorialService = new EditorialService();
//        editorialService.createEditorial(2, "mendocina");
        LibroServicie libroServicie = new LibroServicie();
//        libroServicie.createLibro(15000000000L, "El principe ", 1999, 200, "Facundo", "mendocina");
        libroServicie.searchListBooks("mendocina");
        libroServicie.searchListBooksByAuthor("Facundo");

    }

}
