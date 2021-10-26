/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.services;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class MainService {

    Scanner read = new Scanner(System.in);
    ProductService productService = new ProductService();
    ManufacturerService manufacturerService = new ManufacturerService();

    /**
     * Method that functions as a menu for interacting with the application 
     * 
     * @throws Exception 
     */
    public void menu() throws Exception {
        try {
            Integer opcion = null;
            do {
                System.out.println("Enter the option to\n"
                        + "1) Lists the name of all the products in the product table.\n"
                        + "2) List the names and prices of all the products in the product table.\n"
                        + "3) List those products whose price is between 120 and 202.\n"
                        + "4) Search and list all the Laptops in the product table.\n"
                        + "5) List the name and price of the cheapest product.\n"
                        + "6) Enter a product to the database.\n"
                        + "7) Enter a manufacturer to the database.\n"
                        + "8) Edit a product with data of your choice.\n"
                        + "9) to exit");
                opcion = read.nextInt();
            } while (opcion == null);
            do {
                switch (opcion) {
                    case 1:
                        productService.listNameAllProducts();
                        break;
                    case 2:
                        productService.listNameAndPrice();
                        break;
                    case 3:
                        productService.listByPrice();
                        break;
                    case 4:
                        productService.listLaptops();
                        break;
                    case 5:
                        productService.cheapest();
                        break;
                    case 6:
                        productService.createProduct();
                        break;
                    case 7:
                        manufacturerService.createManufacturer();
                        break;
                    case 8:
                        productService.edit();
                        break;
                    case 9:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("the option entered is incorrect");
                }
            } while (opcion != 9);
        } catch (Exception e) {
            throw e;
        }
    }

}
