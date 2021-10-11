/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class SecretMonthGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
    private String secretMonth = months[2];

    /**
     * Default constructor method
     */
    public SecretMonthGuiaPoo() {
    }

    //Get and Set
    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public String getSecretMonth() {
        return secretMonth;
    }

    public void setSecretMonth(String secretMonth) {
        this.secretMonth = secretMonth;
    }

    /**
     *  Method where the user is asked for a month and if he/she gets it right, the game is over.
     */
    public void play() {
        String month = "";
        Integer counter = 0;
        do {
            if (counter == 0) {
                System.out.println("Guess the secret month. Enter the name of the month in lowercase");
            }else{
                System.out.println("You have not guessed correctly. Try to guess it by entering another month: " + month);
            }
            month = read.next().toLowerCase();
            counter++;
        } while (!(month.equals(secretMonth)));
        System.out.println("You guessed right!");
    }

}
