/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import guiapoocolecciones.utilidades.ComparisonCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class CountriesGuiaPooCollections {
    private Scanner read = new Scanner(System.in);
    private String nombre;
    
    /**
     * Default constructer method
     */
    public CountriesGuiaPooCollections() {
    }
    
    /**
     * Constructor method
     * 
     * @param nombre 
     */
    public CountriesGuiaPooCollections(String nombre) {
        this.nombre = nombre;
    }
    
    //Get and Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @param countries 
     */
    public void addCountrie(HashSet<CountriesGuiaPooCollections> countries){
        String pais = "";
        String decide = "";
        do{
            do{
                System.out.println("Add country name");
                pais = read.next();
            }while(pais.isEmpty() || pais == null);
            CountriesGuiaPooCollections countriesGuiaPooCollections = new CountriesGuiaPooCollections(pais);
            countries.add(countriesGuiaPooCollections);
            System.out.println("if you wish to enter one more country, enter yes. Otherwise any other word will be taken as no.");
            decide = read.next().toLowerCase();
        }while(decide.equals("yes"));
        System.out.println("The countries are ");
        countries.forEach(aux ->{
            System.out.print(aux.getNombre() + " - ");
        });
    }
        
    /**
     * Method to sort by name
     * @param countries 
     */
    public void sortByName(HashSet<CountriesGuiaPooCollections> countries){
        System.out.println("Sort by name ");
        List<CountriesGuiaPooCollections> paises = new ArrayList<>(countries);
        Collections.sort(paises, ComparisonCountries.sortByName);
        countries.forEach(aux ->{
            System.out.print(aux.getNombre() + " - ");
        });
    }
}
