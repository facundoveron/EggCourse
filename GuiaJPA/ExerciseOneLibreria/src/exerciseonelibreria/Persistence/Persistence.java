/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseonelibreria.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Facundo
 */
public class Persistence {

    //Responsible for managing all operations with the DB at the object level.
    protected EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ExerciseOneLibreriaPU");

    //Establishes the relationship with the DB
    protected EntityManager em = emf.createEntityManager();
}
