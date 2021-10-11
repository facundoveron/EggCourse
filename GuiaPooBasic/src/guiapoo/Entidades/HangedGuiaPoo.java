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
public class HangedGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private String[] word;
    private Integer numberOfLetterFound;
    private Integer numberOfMovesLimit;
    private Integer counter = 0;
    /**
     * Default constructor method
     */
    public HangedGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param word
     * @param numberOfLetterFound
     * @param numberOfMovesLimit
     */
    public HangedGuiaPoo(String[] word, Integer numberOfLetterFound, Integer numberOfMovesLimit) {
        this.word = word;
        this.numberOfLetterFound = numberOfLetterFound;
        this.numberOfMovesLimit = numberOfMovesLimit;
    }

    //Get and Set
    public String[] getWord() {
        return word;
    }

    public void setWord(String[] word) {
        this.word = word;
    }

    public Integer getNumberOfLetterFound() {
        return numberOfLetterFound;
    }

    public void setNumberOfLetterFound(Integer numberOfLetterFound) {
        this.numberOfLetterFound = numberOfLetterFound;
    }

    public Integer getNumberOfMovesLimit() {
        return numberOfMovesLimit;
    }

    public void setNumberOfMovesLimit(Integer numberOfMovesLimit) {
        this.numberOfMovesLimit = numberOfMovesLimit;
    }

    /**
     * Method that asks the user for the word and maximum number of moves.
     */
    private void createGame() {
        String palabra = "";
        Integer cantidadDejugadasMaxima = 0;
        do {
            System.out.println("Enter a word");
            palabra = read.next();
        } while (palabra.isEmpty() || palabra == null);
        palabra = palabra.trim();
        this.word = palabra.split("");
        do {
            System.out.println("Enter the number of moves limit, it must be greater than the word length or equal to the word length.");
            cantidadDejugadasMaxima = read.nextInt();
        } while (cantidadDejugadasMaxima == null || cantidadDejugadasMaxima < this.word.length - 1);
        this.numberOfMovesLimit = cantidadDejugadasMaxima;
    }

    /**
     * Shows the length of the word
     */
    private void length() {
        System.out.println(this.word.length);
    }

    /**
     * The method receives a letter and searches if it is in the word. Informs
     * if the letter was already in the word.
     *
     * @param letter
     */
    private void search(String letter) {
        Boolean verify = false;
        for (int i = 0; i < word.length; i++) {
            if (this.word[i].equals(letter)) {
                verify = true;
            }
        }
        if(verify){
            System.out.println("The letter was found");
        }else{
            System.out.println("The letter is not found");
        }
    }

    /**
     * The method receives a letter and shows how many letters have been found and how many are missing. Returns true if the letter was found, false if
     * not. if it is not found, a chance is subtracted.
     *
     * @param letter
     * @return
     */
    private Boolean found(String letter) {
        Integer counter = 0;
        Boolean retorno = false;
        for (int i = 0; i < this.word.length; i++) {
            if (this.word[i].equals(letter)) {
                counter += 1;
                retorno = true;
            }
        }
        System.out.println("The words found are " + counter);
        System.out.println("The missing ones " + (word.length - counter));
        return retorno;
    }

    /**
     * Method that shows how many chances the player has left
     */
    private void attempts(String letter) {
        if(!(found(letter))){
            System.out.println("the number of remaining opportunities: " + (getNumberOfMovesLimit() - 1));
            setNumberOfMovesLimit(getNumberOfMovesLimit()-1);
        }
    }
    
    
    public void game(){
        String letter;
        createGame();
        do{
            System.out.println("Enter a letter");
            letter = read.next();
            length();
            search(letter);
            found(letter);
            attempts(letter);
        }while(getNumberOfMovesLimit() > 0);
    }
}
