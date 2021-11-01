/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwolibreria.servicie;

import exercisetwolibreria.persistence.EditorialPersistence;
import exercisetwolibreria.entities.Editorial;

/**
 *
 * @author Facundo
 */
public class EditorialService {
 
    private EditorialPersistence editorialPersistence;

    /**
     * Constructer method
     */
    public EditorialService() {
        this.editorialPersistence = new EditorialPersistence();
    }
    
    /**
     * Method to create an editorial
     * 
     * @param id
     * @param name
     * @throws Exception 
     */
    public void createEditorial(Integer id, String name) throws Exception{
        try {
            if(id == null || editorialPersistence.searchEditorialById(id) != null){
                throw new Exception("id null or the id is already registered");
            }
            if(name.isEmpty() || name == null || editorialPersistence.searchEditorialByName(name) != null){
                throw new Exception("name empty or name null or the name is already registered");
            }
            
            Editorial editorial = new Editorial();
            editorial.setId(id);
            editorial.setNombre(name);
            editorial.setAlta(true);
            
            editorialPersistence.saveEditorial(editorial);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Method for deregistering a publishing house
     * 
     * @param id
     * @throws Exception 
     */
    public void cancelEditorial(Integer id) throws Exception{
        try {
            if(id == null){
                throw new Exception("id null");
            }
            
            Editorial editorial = editorialPersistence.searchEditorialById(id);
            editorial.setAlta(false);
            editorialPersistence.update(editorial);
        } catch (Exception e) {
            throw e;
        }
    }
}
