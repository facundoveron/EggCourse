/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.persistence;

import exercisetwoestancias.entities.Casa;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public final class CasaDAO extends DAO {

    private EstanciaDAO estanciaDAO;

    public CasaDAO() {
        this.estanciaDAO = new EstanciaDAO();
    }

    /**
     * Method searching your home by id
     *
     * @param id
     * @return casa
     * @throws Exception
     */
    public Casa consultById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            String sql = "SELECT * FROM casas WHERE id_casa = " + id;
            consult(sql);
            Casa casa = null;
            while (resultSet.next()) {
                casa = new Casa();
                casa.setIdCasa(resultSet.getInt(1));
                casa.setCalle(resultSet.getString(2));
                casa.setNumero(resultSet.getInt(3));
                casa.setCodigoPostal(resultSet.getString(4));
                casa.setCiudad(resultSet.getString(5));
                casa.setPais(resultSet.getString(6));
                casa.setFechaDesde(resultSet.getDate(7));
                casa.setFechaHasta(resultSet.getDate(8));
                casa.setTiempoMinimo(resultSet.getInt(9));
                casa.setTiempoMaximo(resultSet.getInt(10));
                casa.setPrecioHabitacion(resultSet.getDouble(11));
                casa.setTipoVivienda(resultSet.getString(12));
            }
            close();
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that brings the houses according to a given country and a given
     * date
     *
     * @return houses;
     * @throws Exception
     */
    public Collection<Casa> listByCountryAndDate() throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE pais = 'Reino Unido' AND (fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31');";
            consult(sql);
            Collection<Casa> houses = new ArrayList<>();
            Casa house = null;
            while (resultSet.next()) {
                house = new Casa();
                house.setIdCasa(resultSet.getInt(1));
                house.setCalle(resultSet.getString(2));
                house.setNumero(resultSet.getInt(3));
                house.setCodigoPostal(resultSet.getString(4));
                house.setCiudad(resultSet.getString(5));
                house.setPais(resultSet.getString(6));
                house.setFechaDesde(resultSet.getDate(7));
                house.setFechaHasta(resultSet.getDate(8));
                house.setTiempoMinimo(resultSet.getInt(9));
                house.setTiempoMaximo(resultSet.getInt(10));
                house.setPrecioHabitacion(resultSet.getDouble(11));
                house.setTipoVivienda(resultSet.getString(12));
                houses.add(house);
            }
            close();
            return houses;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that lists houses according to specific dates and days
     *
     * @param date
     * @param numberOfDays
     * @return houses
     * @throws Exception
     */
    public Collection<Casa> listByDateAndDay(String date, Integer numberOfDays) throws Exception {
        try {
            if (date == null || date.isEmpty()) {
                throw new Exception("date null or empty");
            }
            if (numberOfDays == null || numberOfDays < 0) {
                throw new Exception("number of days null or number of days negative");
            }
            String sql = "SELECT * FROM casas WHERE fecha_hasta <= '" + date + "' AND (tiempo_minimo < " + numberOfDays + " AND tiempo_maximo > " + numberOfDays + ");";
            consult(sql);
            Collection<Casa> houses = new ArrayList<>();
            Casa house = null;
            while (resultSet.next()) {
                house = new Casa();
                house.setIdCasa(resultSet.getInt(1));
                house.setCalle(resultSet.getString(2));
                house.setNumero(resultSet.getInt(3));
                house.setCodigoPostal(resultSet.getString(4));
                house.setCiudad(resultSet.getString(5));
                house.setPais(resultSet.getString(6));
                house.setFechaDesde(resultSet.getDate(7));
                house.setFechaHasta(resultSet.getDate(8));
                house.setTiempoMinimo(resultSet.getInt(9));
                house.setTiempoMaximo(resultSet.getInt(10));
                house.setPrecioHabitacion(resultSet.getDouble(11));
                house.setTipoVivienda(resultSet.getString(12));
                houses.add(house);
            }
            close();
            return houses;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that returns a list with the ids of the houses that have been
     * rented at some time.
     *
     * @return houses;
     * @throws Exception
     */
    public ArrayList<Integer> listHousesId() throws Exception {
        try {
            ArrayList<Integer> houses = estanciaDAO.listById("id_casa");
            if (houses == null || houses.size() == 0) {
                throw new Exception("no house found");
            }
            return houses;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that returns the id of the houses that are in the UK
     *
     * @return idHouse
     * @throws Exception
     */
    public ArrayList<Integer> idHouseByUK() throws Exception {
        try {
            String sql = "SELECT id_casa FROM casas WHERE pais = 'Reino Unido';";
            consult(sql);
            ArrayList<Integer> idHouse = new ArrayList<>();
            while (resultSet.next()) {
                idHouse.add(resultSet.getInt(1));
            }
            close();
            return idHouse;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that increases the price of rooms in UK homes
     *
     * @throws Exception
     */
    public void increasePriceUK() throws Exception {
        try {
            ArrayList<Integer> id = idHouseByUK();
            String sql = "";
            Integer precio = null;
            for (Integer aux : id) {
                sql = "SELECT precio_habitacion FROM casas WHERE id_casa = " + aux + ";";
                consult(sql);
                while (resultSet.next()) {
                    precio = resultSet.getInt(1);
                    precio = precio + precio / 20;
                }
                close();
                sql = "UPDATE casas SET precio_habitacion = " + precio + " WHERE id_casa = " + aux + ";";
                insertModifyDelete(sql);
                close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that queries the number of houses in each country
     *
     * @return count
     * @throws Exception
     */
    public ArrayList<String> numberHousesByCountry() throws Exception {
        try {
            String sql = "SELECT count(*), pais FROM casas GROUP BY pais;";
            consult(sql);
            ArrayList<String> count = new ArrayList<>();
            while (resultSet.next()) {
                count.add("Number of houses: " + resultSet.getInt(1) + " Country: " + resultSet.getString(2));
            }
            close();
            return count;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Casa> cleanHomes() throws Exception {
        try {
            ComentariosDAO comentariosDAO = new ComentariosDAO();
            ArrayList<Integer> id = comentariosDAO.idHousesCleanList();
            String sql = "";
            ArrayList<Casa> houses = new ArrayList<>();
            Casa house = null;
            for (Integer aux : id) {
                sql = "SELECT * FROM casas WHERE id_casa = " + aux + ";";
                consult(sql);
                while (resultSet.next()) {
                    house = new Casa();
                    house.setIdCasa(resultSet.getInt(1));
                    house.setCalle(resultSet.getString(2));
                    house.setNumero(resultSet.getInt(3));
                    house.setCodigoPostal(resultSet.getString(4));
                    house.setCiudad(resultSet.getString(5));
                    house.setPais(resultSet.getString(6));
                    house.setFechaDesde(resultSet.getDate(7));
                    house.setFechaHasta(resultSet.getDate(8));
                    house.setTiempoMinimo(resultSet.getInt(9));
                    house.setTiempoMaximo(resultSet.getInt(10));
                    house.setPrecioHabitacion(resultSet.getDouble(11));
                    house.setTipoVivienda(resultSet.getString(12));
                    houses.add(house);
                }
                close();
            }
            return houses;
        } catch (Exception e) {
            throw e;
        }
    }
}
