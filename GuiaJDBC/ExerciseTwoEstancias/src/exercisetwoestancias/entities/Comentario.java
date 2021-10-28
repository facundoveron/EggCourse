/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.entities;

/**
 *
 * @author Facundo
 */
public class Comentario {
    private Integer idComentario;
    private Casa casa;
    private String comentario;

    /**
     * Default constructer method
     */
    public Comentario() {
    }

    /**
     * Constructer method
     * 
     * @param idComentario
     * @param casa
     * @param comentario 
     */
    public Comentario(Integer idComentario, Casa casa, String comentario) {
        this.idComentario = idComentario;
        this.casa = casa;
        this.comentario = comentario;
    }

    //Get and Set
    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
