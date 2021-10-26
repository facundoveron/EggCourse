/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.persistence;

import exerciseOneTienda.entities.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public final class ProductoDAO extends DAO {

    /**
     * Method to save product
     *
     * @param product
     * @throws Exception
     */
    public void saveProduct(Producto product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Product null");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES (" + product.getCodigo() + " , '" + product.getNombre() + "' , "
                    + product.getPrecio() + " , " + product.getCodigo_fabricante() + " );";

            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Lists the name of all the products in the product table
     *
     * @return names;
     * @throws SQLException
     * @throws Exception
     */
    public Collection<String> nameOfAllProducts() throws SQLException, Exception {
        try {
            String sql = "SELECT nombre FROM producto;";
            consult(sql);
            Collection<String> names = new ArrayList();
            while (resultSet.next()) {
                names.add(resultSet.getString(1));
            }
            close();
            return names;
        } catch (Exception e) {
            e.printStackTrace();
            close();
            throw new Exception("Error");
        }
    }

    /**
     * Lists the names and prices of all the products in the product table.
     *
     * @return nameAndPrice
     * @throws SQLException
     * @throws Exception
     */
    public Collection<String> nameAndPriceOfAllProducts() throws SQLException, Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consult(sql);
            Collection<String> namesAndPrice = new ArrayList();
            while (resultSet.next()) {
                namesAndPrice.add("Name: " + resultSet.getString(1) + ". Price: " + resultSet.getDouble(2));
            }
            close();
            return namesAndPrice;
        } catch (Exception e) {
            e.printStackTrace();
            close();
            throw new Exception("Error");
        }
    }

    /**
     * List those products whose price is between 120 and 202.
     *
     * @return productsByPrice
     * @throws SQLException
     * @throws Exception
     */
    public Collection<Producto> productByPrice() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio >= 120 AND precio <= 202;";
            consult(sql);
            Collection<Producto> productsByPrice = new ArrayList();
            Producto product = null;
            while (resultSet.next()) {
                product = new Producto();
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                product.setCodigo_fabricante(resultSet.getInt(4));
                productsByPrice.add(product);
            }
            close();
            return productsByPrice;
        } catch (Exception e) {
            e.printStackTrace();
            close();
            throw new Exception("Error");
        }
    }

    /**
     * Search and list all the Laptops in the table product
     *
     * @return productsLaptops
     * @throws SQLException
     * @throws Exception
     */
    public Collection<Producto> laptops() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%';";
            consult(sql);
            Collection<Producto> productsLaptops = new ArrayList();
            Producto product = null;
            while (resultSet.next()) {
                product = new Producto();
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                product.setCodigo_fabricante(resultSet.getInt(4));
                productsLaptops.add(product);
            }
            close();
            return productsLaptops;
        } catch (Exception e) {
            e.printStackTrace();
            close();
            throw new Exception("Error");
        }
    }

    /**
     * List the name and price of the cheapest product
     *
     * @return cheapest
     * @throws SQLException
     * @throws Exception
     */
    public String cheapestProduct() throws SQLException, Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;";
            consult(sql);
            if (resultSet.next()) {
                String cheapest = "Name: " + resultSet.getString(1) + " Price: " + resultSet.getDouble(2);
                close();
                return cheapest;
            } else {
                close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            close();
            throw new Exception("Error");
        }
    }

    /**
     * Method to edit a product with data of your choice.
     *
     * @param code
     * @param parametro
     * @throws Exception
     */
    public void editAProduct(Integer code, Object parametro, Integer opcion) throws Exception {
        try {
            if (code == null) {
                throw new Exception("code null");
            }
            String sqlImplent = null;
            if (opcion == 3) {
                sqlImplent = "codigo_fabricante = " + parametro;
            } else if (opcion == 1) {
                sqlImplent = "nombre = '" + parametro + "'";
            } else if (opcion == 2) {
                sqlImplent = "precio = " + parametro;
            }
            if(sqlImplent != null){
                String sql = "UPDATE producto SET "
                        + sqlImplent + " WHERE codigo = " + code + ";";
                insertModifyDelete(sql);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method to search by code
     *
     * @param code
     * @return true, false
     * @throws Exception
     */
    public Producto searchByCode(Integer code) throws Exception {
        try {
            if (code == null) {
                throw new Exception("Code null");
            }
            String sql = "SELECT * FROM producto WHERE codigo = " + code + ";";
            consult(sql);
            Producto producto = null;
            while(resultSet.next()){
                producto = new Producto();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                producto.setCodigo_fabricante(resultSet.getInt(4));
            }
            close();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
}
