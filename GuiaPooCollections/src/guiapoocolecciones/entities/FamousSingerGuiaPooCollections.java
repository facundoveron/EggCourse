/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class FamousSingerGuiaPooCollections {

    private Scanner read = new Scanner(System.in);
    private String name;
    private String bestSellingAlbum;

    public FamousSingerGuiaPooCollections() {
    }

    public FamousSingerGuiaPooCollections(String name, String bestSellingAlbum) {
        this.name = name;
        this.bestSellingAlbum = bestSellingAlbum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestSellingAlbum() {
        return bestSellingAlbum;
    }

    public void setBestSellingAlbum(String bestSellingAlbum) {
        this.bestSellingAlbum = bestSellingAlbum;
    }
    
    /**
     * Method to create the singer
     * 
     * @return famousSingerGuiaPooCollections
     */
    private FamousSingerGuiaPooCollections createSinger() {
        String nombre = "";
        String discoMasVendido = "";
        do {
            System.out.println("Enter the name ");
            nombre = read.nextLine();
        } while (nombre.isEmpty() || nombre == null);
        do {
            System.out.println("Enter the best-selling album");
            discoMasVendido = read.nextLine();
        } while (discoMasVendido.isEmpty() || discoMasVendido == null);
        FamousSingerGuiaPooCollections famousSingerGuiaPooCollections;
        return famousSingerGuiaPooCollections = new FamousSingerGuiaPooCollections(nombre, discoMasVendido);
    }
    
    /**
     * Method to delete the singer
     * 
     * @param singer 
     */
    private void deleteSinger(ArrayList<FamousSingerGuiaPooCollections> singer){
        String nombre = "";
        do{
            System.out.println("Enter the name ");
            nombre = read.nextLine();
        }while(nombre.isEmpty() || nombre == null);
        Iterator<FamousSingerGuiaPooCollections> singers = singer.iterator();
        while(singers.hasNext()){
            FamousSingerGuiaPooCollections singerNext = singers.next();
            if(singerNext.getName().equals(nombre)){
                singers.remove();
            }
        }
    }
    
    /**
     * Method to add 5 singers to the list
     *
     * @param singer
     */
    public void addFiveSinger(ArrayList<FamousSingerGuiaPooCollections> singer) {
        for (int i = 0; i < 5; i++) {
            singer.add(createSinger());
        }
    }
    
    /**
     * Method to manage the methods of the class, menu type
     * 
     * @param singer 
     */
    public void menu(ArrayList<FamousSingerGuiaPooCollections> singer) {
        Boolean decide = true;
        Integer caso = null;
        do {
            System.out.println("Enter the number with the operation to be performed. 1: add another singer to the list. 2: Delete a singer. 3: Exit the program. ");
            caso = read.nextInt();
            switch (caso) {
                case 1:
                    singer.add(createSinger());
                    break;
                case 2:
                    deleteSinger(singer);
                    break;
                case 3:
                    decide = false;
                    break;
                default:
                    System.out.println("Value entered is not valid");
            }
        } while (decide);
    }
}
