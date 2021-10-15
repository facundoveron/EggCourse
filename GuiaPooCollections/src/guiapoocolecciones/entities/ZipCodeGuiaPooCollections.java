/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class ZipCodeGuiaPooCollections {
    private Scanner read = new Scanner(System.in);
    private String zip;
    private String country;

    public ZipCodeGuiaPooCollections() {
    }

    public ZipCodeGuiaPooCollections(String zip, String country) {
        this.zip = zip;
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private ZipCodeGuiaPooCollections createZipCode() {
        String zip = "";
        String country = "";
        do {
            System.out.println("Enter the zip code");
            zip = read.nextLine();
        } while (zip.isEmpty() || zip == null);
        do {
            System.out.println("Enter the relevant country");
            country = read.nextLine();
        } while (country.isEmpty() || country == null);
        ZipCodeGuiaPooCollections zipCodeGuiaPooCollections = new ZipCodeGuiaPooCollections(zip, country);
        return zipCodeGuiaPooCollections;
    }
    
    public void addZipCountries(HashMap<String,String> zipCode){
        for (int i = 0; i < 10; i++) {
            ZipCodeGuiaPooCollections paises = createZipCode();
            zipCode.put(paises.getZip(), paises.getCountry());
        }
    }
    
    public Boolean showCountry(HashMap<String,String> zipCode){
        Boolean confirm = true;
        String codigo = "";
        do {
            System.out.println("Enter the zip code of the country you are looking for");
            codigo = read.nextLine();
        } while (codigo.isEmpty() || codigo == null);
        for (Map.Entry<String, String> entry : zipCode.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals(codigo)){
                System.out.println(" The country is "+ value);
                confirm = false;
            }
        }
        return confirm;
    }
    
    public void addZipCounty(HashMap<String,String> zipCode){
        ZipCodeGuiaPooCollections paises = createZipCode();
        zipCode.put(paises.getZip(), paises.getCountry());
    }
    
    public void deleteCountries(HashMap<String,String> zipCode){
        String codigo = "";
        for (int i = 0; i < 3; i++) {
            System.out.println("enter zip code to delete");
            codigo = read.nextLine();
            if(zipCode.containsKey(codigo)){
                zipCode.remove(zipCode.containsKey(codigo));
            }
        }
    }
}
