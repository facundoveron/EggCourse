/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.services;

import exerciseOneTienda.entities.Producto;
import exerciseOneTienda.persistence.FabricanteDAO;
import exerciseOneTienda.persistence.ProductoDAO;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class ProductService {
    Scanner read = new Scanner(System.in);
    private ProductoDAO productoDAO;
    private FabricanteDAO fabricanteDAO;

    /**
     * Constructer method
     */
    public ProductService() {
        this.productoDAO = new ProductoDAO();
        this.fabricanteDAO = new FabricanteDAO();
    }

    
    /**
     * Method to create product
     * @throws Exception 
     */
    public void createProduct() throws Exception {
        try {
            Integer code = null;
            String name = null;
            Double price = null;
            Integer codeManufacturer = null;
            do {
                System.out.println("Enter the product code");
                code = read.nextInt();
            } while (code == null);
            do {
                System.out.println("Enter the product name");
                name = read.nextLine();
            } while (name == null || name.isEmpty());
            do {
                System.out.println("Enter the product price");
                price = read.nextDouble();
            } while (price < 0 || price == null);
            do {
                System.out.println("Enter the product code the manufacturer");
                codeManufacturer = read.nextInt();
            } while (codeManufacturer == null);
            saveProduct(code, name, price, codeManufacturer);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Method to save product
     *
     * @param code
     * @param name
     * @param price
     * @param code_manufacturer
     * @throws Exception
     */
    public void saveProduct(Integer code, String name, Double price, Integer code_manufacturer) throws Exception {
        try {
            if (code == null || productoDAO.searchByCode(code) != null) {
                throw new Exception("code null or this code is already registered");
            }
            if (name == null || name.isEmpty()) {
                throw new Exception("name null or empty");
            }
            if (price == null || price < 0) {
                throw new Exception("price null or negative");
            }
            if (code_manufacturer == null || fabricanteDAO.searchByCode(code_manufacturer) == null) {
                throw new Exception("code manucfacturer is null or this manufacturer does not exist");
            }
            Producto product = new Producto(code, name, price, code_manufacturer);
            productoDAO.saveProduct(product);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to edit a product
     * 
     * @throws Exception
     */
    public void edit() throws Exception {
        Integer opcion = null;
        Integer code = null;
        do {
            try {
                System.out.println("choose 1 to modify the name, 2 to modify the price, 3 to modify the manufacturer code, 4 to exit ");
                opcion = read.nextInt();
            } catch (Exception e) {
                opcion = 5;
                throw e;
            }
            try {
                System.out.println("enter the code");
                code = read.nextInt();
            } catch (Exception e) {
                throw e;
            }
            switch (opcion) {
                case 1:
                    String name = null;
                    do {
                        System.out.println("Enter the new name");
                        name = read.nextLine();
                    } while (name == null || name.isEmpty());
                    productoDAO.editAProduct(code, name, 1);
                    break;
                case 2:
                    Double preci = null;
                    do {
                        System.out.println("Enter the new preci");
                        preci = read.nextDouble();
                    } while (preci == null || preci < 0);
                    productoDAO.editAProduct(code, preci, 2);
                    break;
                case 3:
                    Integer codeFabricante = null;
                    do {
                        System.out.println("Enter the new code");
                        codeFabricante = read.nextInt();
                    } while (codeFabricante == null || fabricanteDAO.searchByCode(codeFabricante) == null);
                    productoDAO.editAProduct(code, codeFabricante, 3);
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("the option entered is incorrect");
            }
        } while (opcion != 4);
    }

    /**
     * Method showing the names of all products
     * 
     * @throws Exception
     */
    public void listNameAllProducts() throws Exception {
        try {
            Collection<String> list;
            list = productoDAO.nameOfAllProducts();
            list.forEach(aux -> {
                System.out.println("Name: " + aux);
            });
        } catch (Exception e) {
            throw e;
        }
    }

    
    /**
     * Method showing the name and price of all products
     * 
     * @throws Exception 
     */
    public void listNameAndPrice() throws Exception {
        try {
            Collection<String> list = productoDAO.nameAndPriceOfAllProducts();
            list.forEach(aux -> {
                System.out.println(aux);
            });
        } catch (Exception e) {
            throw e;
        }
    }

    
    /**
     * Method that displays a list of products that is between a price of 120 and 202
     * 
     * @throws Exception 
     */
    public void listByPrice() throws Exception {
        try {
            Collection<Producto> list = productoDAO.productByPrice();
            list.forEach(aux -> {
                System.out.println("Code: " + aux.getCodigo() + " Name: " + aux.getNombre() + " Price: " + aux.getPrecio() + " Code Manufacture: " + aux.getCodigo_fabricante());
            });
        } catch (Exception e) {
            throw e;
        }
    }

    
    /**
     * Method showing products that are portable 
     * @throws Exception 
     */
    public void listLaptops() throws Exception {
        try {
            Collection<Producto> list = productoDAO.laptops();
            list.forEach(aux -> {
                System.out.println("Code: " + aux.getCodigo() + " Name: " + aux.getNombre() + " Price: " + aux.getPrecio() + " Code Manufacture: " + aux.getCodigo_fabricante());
            });
        } catch (Exception e) {
            throw e;
        }
    }

    
    /**
     * Method showing the cheapest product 
     * 
     * @throws Exception 
     */
    public void cheapest() throws Exception {
        try {
            System.out.println("the cheapest product is name: " + productoDAO.cheapestProduct());
        } catch (Exception e) {
            throw e;
        }
    }
}
