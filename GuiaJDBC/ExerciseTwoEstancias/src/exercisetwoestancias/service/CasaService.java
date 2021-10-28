/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import exercisetwoestancias.entities.Casa;
import exercisetwoestancias.persistence.CasaDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class CasaService {

    private CasaDAO casaDAO;

    /**
     * Constructer method
     */
    public CasaService() {
        this.casaDAO = new CasaDAO();
    }

    /**
     * Method to search for houses by ID
     *
     * @param id
     * @throws Exception
     */
    public void searchById(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id null");
            }
            Casa casa = casaDAO.consultById(id);
            if (casa == null) {
                throw new Exception("house not found");
            } else {
                System.out.println("Street: " + casa.getCalle() + " Number: " + casa.getNumero()
                        + " zip code: " + casa.getCodigoPostal() + " City: " + casa.getCodigoPostal()
                        + " Country: " + casa.getPais() + " Date from: " + casa.getFechaDesde() + " Date to: "
                        + casa.getFechaHasta() + " Minimum time: " + casa.getTiempoMinimo() + " Maximum time: "
                        + casa.getTiempoMaximo() + " Room price: " + casa.getPrecioHabitacion() + " Type of housing: " + casa.getTipoVivienda());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method search and list available homes for the period from August 1, 2020
     * to August 31, 2020 in the UK August 1, 2020 to August 31, 2020 in the
     * United Kingdom
     *
     * @throws Exception
     */
    public void listOfAvailableHouese() throws Exception {
        try {
            Collection<Casa> houses = casaDAO.listByCountryAndDate();
            if (houses.size() == 0) {
                System.out.println("No houses with this condition were found ");
            } else {
                houses.forEach(aux -> {
                    System.out.println("Street: " + aux.getCalle() + " Number: " + aux.getNumero()
                            + " zip code: " + aux.getCodigoPostal() + " City: " + aux.getCodigoPostal()
                            + " Country: " + aux.getPais() + " Date from: " + aux.getFechaDesde() + " Date to: "
                            + aux.getFechaHasta() + " Minimum time: " + aux.getTiempoMinimo() + " Maximum time: "
                            + aux.getTiempoMaximo() + " Room price: " + aux.getPrecioHabitacion() + " Type of housing: " + aux.getTipoVivienda());
                });
                System.out.println("");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Query the DB to return those homes available as of a given date and a
     * specific number of days. and a specific number of days.
     *
     * @param date
     * @param numberOfDays
     * @throws Exception
     */
    public void listHousesOfDateAndDay(String date, Integer numberOfDays) throws Exception {
        try {
            if (date == null || date.isEmpty()) {
                throw new Exception("date null or date empty");
            }
            if (numberOfDays == null || numberOfDays < 0) {
                throw new Exception("number of days null or number of days negative");
            }
            Collection<Casa> houses = casaDAO.listByDateAndDay(date, numberOfDays);
            if (houses.size() == 0 || houses == null) {
                System.out.println("No houses with this condition were found ");
            } else {
                houses.forEach(aux -> {
                    System.out.println("Street: " + aux.getCalle() + " Number: " + aux.getNumero()
                            + " zip code: " + aux.getCodigoPostal() + " City: " + aux.getCodigoPostal()
                            + " Country: " + aux.getPais() + " Date from: " + aux.getFechaDesde() + " Date to: "
                            + aux.getFechaHasta() + " Minimum time: " + aux.getTiempoMinimo() + " Maximum time: "
                            + aux.getTiempoMaximo() + " Room price: " + aux.getPrecioHabitacion() + " Type of housing: " + aux.getTipoVivienda());
                });
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method requesting date and day data to query the database
     *
     * @throws Exception
     */
    public void housesOfDateAndDay() throws Exception {
        Scanner read = new Scanner(System.in);
        try {
            String day = null;
            String month = null;
            String year = null;
            String date = null;
            Integer numberOfDays = null;
            do {
                System.out.println("Enter the day");
                day = read.next();
            } while (day.isEmpty() || day == null);
            do {
                System.out.println("Enter the month");
                month = read.next();
            } while (month.isEmpty() || month == null);
            do {
                System.out.println("Enter the year");
                year = read.next();
            } while (year.isEmpty() || year == null);
            date = year + "-" + month + "-" + day;
            do {
                System.out.println("Enter the number of days");
                numberOfDays = read.nextInt();
            } while (numberOfDays == null || numberOfDays < 0);
            listHousesOfDateAndDay(date, numberOfDays);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that updates the price of the houses of UK
     *
     * @throws Exception
     */
    public void increasePrice() throws Exception {
        try {
            casaDAO.increasePriceUK();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method showing the number of houses per country
     *
     * @throws Exception
     */
    public void viewHousesByCountry() throws Exception {
        try {
            ArrayList<String> houses = casaDAO.numberHousesByCountry();
            houses.forEach(aux -> {
                System.out.println(aux);
            });
        } catch (Exception e) {
            throw e;
        }
    }

    public void viewHousesClean() throws Exception {
        try {
            ArrayList<Casa> houses = casaDAO.cleanHomes();
            if (houses.size() == 0 || houses == null) {
                System.out.println("No houses with this condition were found ");
            } else {
                houses.forEach(aux -> {
                    System.out.println("Street: " + aux.getCalle() + " Number: " + aux.getNumero()
                            + " zip code: " + aux.getCodigoPostal() + " City: " + aux.getCodigoPostal()
                            + " Country: " + aux.getPais() + " Date from: " + aux.getFechaDesde() + " Date to: "
                            + aux.getFechaHasta() + " Minimum time: " + aux.getTiempoMinimo() + " Maximum time: "
                            + aux.getTiempoMaximo() + " Room price: " + aux.getPrecioHabitacion() + " Type of housing: " + aux.getTipoVivienda());
                });
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }
}
