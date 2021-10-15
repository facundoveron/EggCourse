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
public class StoreGuiaPooCollectionsServicie {
     private Scanner read = new Scanner(System.in);
    HashMap<String,StoreGuiaPooCollections> store = new HashMap();
    
    /**
     * Method to create a product
     * 
     * @return true, false;
     */
    private boolean createProduct(){
        String name = "";
        Double precie = null;
        String exit = "";
        String id = "";
        do{
            System.out.println("Enter the name product");
            name = read.next().toLowerCase();
        }while(name.isEmpty() || name == null);
        do{
            System.out.println("Enter the precie");
            precie = read.nextDouble();
        }while(precie == null || precie < 0.0);
        do{
            System.out.println("Enter the id");
            id = read.next();
        }while(id.isEmpty() || id == null);
        StoreGuiaPooCollections product = new StoreGuiaPooCollections(name, precie);
        store.put(id,product);
        
        System.out.println("quiere seguir agregando productos? si para seguir, de otra manera no se agregara");
        exit = read.next().toLowerCase();
        return exit.equals("yes");
    }
        
    /**
     * Method to modify a product
     */
    private void modifyPrecie(){
        String id;
        Double precie;
        id = read.next();
        for (Map.Entry<String, StoreGuiaPooCollections> entry : store.entrySet()) {
            String key = entry.getKey();
            StoreGuiaPooCollections value = entry.getValue();
            if(key.equals(id)){
                do{
                    System.out.println("ingrese el precio a modificar");
                    precie = read.nextDouble();
                }while(precie < 0);
                value.setPrice(precie);
            }
        }
    }
    
    /**
     * Method to delete product
     */
    private void deleteProduct(){
        String id;
        id = read.next();
        if(store.containsKey(id)){ 
            store.remove(store.containsKey(id));
        }
        
    }
    
    /**
     * Method to manage the methods as a menu
     * @param caso 
     */
    public void menu(int caso){
        switch (caso) {
            case 1:
                do{}while(createProduct());
                break;
            case 2:
                System.out.println("enter product id");
                modifyPrecie();
                break;
            case 3:
                System.out.println("enter product id");
                deleteProduct();
                break;
            case 4:
                for (Map.Entry<String, StoreGuiaPooCollections> entry : store.entrySet()) {
                    String key = entry.getKey();
                    StoreGuiaPooCollections value = entry.getValue();
                    System.out.println(" el id es " + key + " el nombre del producto es " + value.getName() + " y su precio es " + value.getPrice());
                }
                break;
        }
    }
}
