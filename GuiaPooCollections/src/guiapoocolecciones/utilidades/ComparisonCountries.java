/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.utilidades;

import guiapoocolecciones.entities.CountriesGuiaPooCollections;
import java.util.Comparator;

/**
 *
 * @author Facundo
 */
public class ComparisonCountries {
    
    /**
     * Method to sort by name
     */
    public static Comparator<CountriesGuiaPooCollections> sortByName = new Comparator<CountriesGuiaPooCollections>(){
        @Override
        public int compare(CountriesGuiaPooCollections c, CountriesGuiaPooCollections c1){
            return c.getNombre().compareTo(c1.getNombre());
        }
    };
}
