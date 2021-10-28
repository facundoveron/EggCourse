/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.service;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class MainService {

    private Scanner read = new Scanner(System.in);
    private FamiliaService familiaService = new FamiliaService();
    private CasaService casaService = new CasaService();
    private ClienteService clienteService = new ClienteService();
    private ComentariosService comentariosService = new ComentariosService();
    private EstanciaService estanciaService;
    public MainService() {
        this.estanciaService = new EstanciaService();
    }

    
    public void menu() throws Exception {
        try {
            Integer opcion = null;
            do {
                System.out.println("1) List those families that have at least 3 children, and with a maximum age of less than 10 years of age years old.\n"
                        + "2) Search and list available homes for the period from August 1, 2020 to August 31, 2020 in the UK August 1, 2020 to August 31, 2020 in the United Kingdom.\n"
                        + "3) Find all those families whose email address is from Hotmail.\n"
                        + "4) Query the DB to return those houses available from a given date and a specific number of days and a specific number of days\n"
                        + "5) List the data of all the clients that at some point made a stay and the description of the house where the stay was made and the description of the house where they stayed.\n"
                        + "6) List all the stays that have been booked by a client, show the name, country and city of the client,\n"
                        + "country and city of the client and also the information of the house that was booked. The one that would replace the previous one\n"
                        + "7) Due to the devaluation of the pound sterling against the euro you want to increase the price per day by 5% increase the price per day by 5% for all houses in the UK. Mostar the updated prices.\n"
                        + "8) Obtain the number of houses that exist for each of the different countries.\n"
                        + "9) Find and list those houses in the UK that have been said to be 'clean' (reviews) (comments) that are 'clean'.\n"
                        + "10) Insert new data in the stays table verifying the availability of the dates.\n"
                        + "11) To exit");
                System.out.println("");
                opcion = read.nextInt();
                switch(opcion){
                    case 1:
                        familiaService.listFamiliesBySon();
                        break;
                    case 2:
                        casaService.listOfAvailableHouese();
                        break;
                    case 3:
                        familiaService.listFamiliesByEmail();
                        break;
                    case 4:
                        casaService.housesOfDateAndDay();
                        break;
                    case 5:
                        clienteService.listCustomer();
                        comentariosService.viewComments();
                        break;
                    case 6:
                        estanciaService.listId();
                        break;
                    case 7:
                        casaService.increasePrice();
                        break;
                    case 8:
                        casaService.viewHousesByCountry();
                        break;
                    case 9:
                        casaService.viewHousesClean();
                        break;
                }
            } while (opcion != 11 || opcion == null);
        } catch (Exception e) {
            throw e;
        }
    }
}
