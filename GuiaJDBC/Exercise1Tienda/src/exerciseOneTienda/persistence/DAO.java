/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Facundo
 */
public abstract class DAO {

    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String USER = "root";
    private final String PASSWORD = "UseRNAme13.!";
    private final String DATABASE = "tienda";

    /**
     * Method to connect to the database
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected void connect() throws ClassNotFoundException, SQLException {
        try {
            //dynamically loads the driver extending from driverManager
            Class.forName("com.mysql.cj.jdbc.Driver");

            //manages the set of drivers java database connectivity(jdbc) we connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE , USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    /**
     * Method to disconnect from the database
     *
     * @throws SQLException
     */
    protected void close() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Method for inserting, modifying or deleting in the database
     *
     * @param sql
     * @throws SQLException
     * @throws Exception
     */
    protected void insertModifyDelete(String sql) throws SQLException, Exception {
        try {
            //connect to the database
            connect();

            //create a statement 
            statement = connection.createStatement();

            //execute the statement with the sql passed by parameter
            statement.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException e) {
            try {
                //operation that returns the database to some previous state
                connection.rollback();
                throw e;
            } catch (Exception ex) {
                throw ex;
            }
        } finally {
            close();
        }
    }

    /**
     * Method for consulting the databases
     *
     * @param sql
     * @throws Exception
     */
    protected void consult(String sql) throws Exception {
        try {
            //connect to the database
            connect();
            //create a statement 
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
