/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.servicie;

import exercisetwolibreria.entities.Cliente;
import exercisetwolibreria.entities.Libro;
import exercisetwolibreria.entities.Prestamo;
import exercisetwolibreria.persistence.PrestamoPersistence;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Facundo
 */
public class PrestamoService {

    private PrestamoPersistence prestamoPersistence;
    private LibroService libroService;
    private ClienteService clienteService;

    /**
     * Constructer method
     */
    public PrestamoService() {
        this.prestamoPersistence = new PrestamoPersistence();
        this.libroService = new LibroService();
        this.clienteService = new ClienteService();
    }

    /**
     * Method to create loan
     *
     * @param id
     * @param loanDate
     * @param dateOfReturn
     * @param isbn
     * @param dni
     * @throws Exception
     */
    public void createLoan(Integer id, Date loanDate, Date dateOfReturn, Long isbn, Long dni) throws Exception {
        try {
            if (id == null || prestamoPersistence.searchById(id) != null) {
                throw new Exception("id null or the id is already registered");
            }
            if (isbn == null || libroService.searchBookByIsbn(isbn) == null) {
                throw new Exception("isbn null or the isbn you entered is not registered");
            }
            if (dni == null || clienteService.searchByDni(dni) == null) {
                throw new Exception("dni null or unregistered customer");
            }
            if (dateOfReturn.before(dateOfReturn)) {
                throw new Exception("date or return before date of return");
            }
            if (dateOfReturn == null) {
                throw new Exception("date of return null");
            }
            if (loanDate == null) {
                throw new Exception("loan date null");
            }

            Libro libro = libroService.searchBookByIsbn(isbn);
            if (libro.getEjemplaresRestantes() > 0 && libro.getAlta()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(id);
                prestamo.setFechaPrestamo(loanDate);
                prestamo.setFechaDevolucion(dateOfReturn);
                prestamo.setLibro(libroService.searchBookByIsbn(isbn));
                prestamo.setCliente(clienteService.searchByDni(dni));

                prestamoPersistence.saveLoan(prestamo);
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
                libroService.updateBook(libro);
            } else {
                System.out.println("there are no more specimens to lend or the book has been withdrawn.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that searches for the loan according to the book's isbn, deletes
     * the loan, and updates the book's statu
     *
     * @param isbn
     * @throws Exception
     */
    public void returnABook(Long isbn) throws Exception {
        try {
            if (isbn == null) {
                throw new Exception("isbn null");
            }
            Prestamo loan = (Prestamo) prestamoPersistence.searchLoanByIsbn(isbn);
            prestamoPersistence.deleteLoan(loan);

            Libro libro = libroService.searchBookByIsbn(isbn);
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
            libroService.updateBook(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Method that searches for loans per customer
     * 
     * @param dni
     * @throws Exception 
     */
    public void searchLoanByCustomer(Long dni) throws Exception{
        try {
            if(dni == null){
                throw new Exception("dni null");
            }
            
            Cliente customer = clienteService.searchByDni(dni);
            Collection<Prestamo> customers = prestamoPersistence.listLoanByCustomer(dni);
            for(Prestamo aux : customers){
                System.out.println("title: " + aux.getLibro().getTitulo());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
