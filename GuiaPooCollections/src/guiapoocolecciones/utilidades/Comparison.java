/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.utilidades;

import guiapoocolecciones.entities.MovieGuiaPooCollections;
import java.util.Comparator;

/**
 *  Class used to order movies with the class Comparator 
 * 
 * @author Facundo
 */
public class Comparison {
    
    /**
     *
     */
    public static Comparator<MovieGuiaPooCollections> ordenarPorDuracionMayorMenor = new Comparator<MovieGuiaPooCollections>() {
        @Override
        public int compare(MovieGuiaPooCollections t, MovieGuiaPooCollections t1) {
            return t1.getDuration().compareTo(t.getDuration());
        }
    };
    public static Comparator<MovieGuiaPooCollections> ordenarPorDuracionMenorMayor = new Comparator<MovieGuiaPooCollections>() {
        @Override
        public int compare(MovieGuiaPooCollections t, MovieGuiaPooCollections t1) {
            return t.getDuration().compareTo(t1.getDuration());
        }
    };
    public static Comparator<MovieGuiaPooCollections> ordenarPorDirector = new Comparator<MovieGuiaPooCollections>() {
        @Override
        public int compare(MovieGuiaPooCollections t, MovieGuiaPooCollections t1) {
            return t1.getManager().compareTo(t.getManager());
        }
    };
    public static Comparator<MovieGuiaPooCollections> ordenarPorTitulo = new Comparator<MovieGuiaPooCollections>() {
        @Override
        public int compare(MovieGuiaPooCollections t, MovieGuiaPooCollections t1) {
            return t1.getTitle().compareTo(t.getTitle());
        }
    };
}
