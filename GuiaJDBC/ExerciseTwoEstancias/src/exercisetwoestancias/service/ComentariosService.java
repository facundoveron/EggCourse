/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import exercisetwoestancias.persistence.ComentariosDAO;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class ComentariosService {

    private ComentariosDAO comentariosDAO;

    public ComentariosService() {
        this.comentariosDAO = new ComentariosDAO();
    }

    public void viewComments() throws Exception {
        try {
            ArrayList<String> comments = comentariosDAO.listComments();
            if(comments == null || comments.size() == 0){
                throw new Exception("comments not found");
            }else{
                comments.forEach(aux ->{
                    System.out.println(aux);
                });
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }
}
