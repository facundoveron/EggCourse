/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.persistence;

import exercisetwolibreria.entities.Prestamo;
import java.util.Collection;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Facundo
 */
public class PrestamoPersistence extends Persistence {

    /**
     * This method searches for the loan by id
     *
     * @param id
     * @return prestamo
     * @throws Exception
     */
    public Prestamo searchById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Prestamo prestamo = em.find(Prestamo.class, id);
            return prestamo;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to save Loan
     *
     * @param prestamo
     * @throws Exception
     */
    public void saveLoan(Prestamo prestamo) throws Exception {
        try {
            if (prestamo == null) {
                throw new Exception("Loan null");
            }
            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method seeking the loan according to the isbn of the book
     *
     * @param isbn
     * @return loan
     * @throws Exception
     */
    public Prestamo searchLoanByIsbn(Long isbn) throws Exception {
        try {
            if (isbn == null) {
                throw new Exception("isbn null");
            }
            String isbnString = String.valueOf(isbn);
            isbnString = isbnString.substring(0, isbnString.length() - 1);
            Long newIsbn = Long.parseLong(isbnString);
            Query nativeQuery = em.createNativeQuery("SELECT ID FROM Prestamo WHERE LIBRO_ISBN = " + newIsbn, Prestamo.class);
            nativeQuery.setParameter("isbn", isbn);
            return (Prestamo) nativeQuery.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    /**
     * Method to delete loan
     *
     * @param loan
     * @throws Exception
     */
    public void deleteLoan(Prestamo loan) throws Exception {
        try {
            if (loan == null) {
                throw new Exception("loan null");
            }

            em.getTransaction().begin();
            em.remove(loan);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Prestamo> listLoanByCustomer(Long dni) throws Exception {
        try {
            if (dni == null) {
                throw new Exception("dni null");
            }
            String isbnString = String.valueOf(dni);
            isbnString = isbnString.substring(0, isbnString.length() - 1);
            Long newDni = Long.parseLong(isbnString);
            Query nativeQuery = em.createNativeQuery("SELECT ID FROM Prestamo WHERE LIBRO_ISBN = " + newDni, Prestamo.class);
            nativeQuery.setParameter("isbn", newDni);
            
            Collection<Prestamo> loans = nativeQuery.getResultList();
            return loans;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
