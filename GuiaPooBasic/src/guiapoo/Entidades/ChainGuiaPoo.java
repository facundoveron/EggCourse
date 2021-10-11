/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo.Entidades;

/**
 *
 * @author Facundo
 */
public class ChainGuiaPoo {

    private String sentence;
    private Integer length;

    /**
     * Default constructor method
     */
    public ChainGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param sentence
     */
    public ChainGuiaPoo(String sentence) {
        this.sentence = sentence;
        this.length = sentence.length();
    }

    //Get and Set
    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Integer getLength() {
        return length;
    }

    /**
     * Method for calculating the number of vowels in a word
     */
    public void showVowels() {
        String[] vowels = this.sentence.split("");
        Integer counter = 0;
        for (int i = 0; i < vowels.length; i++) {
            String letter = vowels[i].toLowerCase();
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u")) {
                counter += 1;
            }
        }
        System.out.println("the number of vowels is " + counter);
    }

    /**
     * Method to invert the attribute sentence
     */
    public void invertPhrase() {
        String[] letter = this.sentence.split("");
        String invert = "";
        for (int i = letter.length - 1; i >= 0; i--) {
            invert += letter[i];
        }
        System.out.println(invert);
    }

    /**
     * method to count how many times the character passed as a parameter is
     * repeated in the phrase
     *
     * @param letter
     */
    public void timesRepeated(String letter) {
        String[] phrase = sentence.split("");
        Integer counter = 0;
        if (verify(letter)) {
            letter = letter.substring(0, 1);
            for (int i = 0; i < phrase.length; i++) {
                if (phrase[i].equals(letter)) {
                    counter++;
                }
            }
            System.out.println("The letter is repeated " + counter + " times");
        }
    }

    /**
     * Method to compare the length of the phrase of the class with the phrase
     * passed by parameter
     *
     * @param phrase
     */
    public void compareLength(String phrase) {
        if (verify(phrase)) {
            if (phrase.length() == this.sentence.length()) {
                System.out.println("are the same length");
            } else if (phrase.length() > this.sentence.length()) {
                System.out.println("letter passed by parameter is longer");
            } else {
                System.out.println("the sentence is longer");
            }
        }
    }

    /**
     * Method to join the current phrase with the one passed by parameter
     *
     * @param phrase
     */
    public void joinSentences(String phrase) {
        if (verify(phrase)) {
            String join = this.sentence + phrase;
            System.out.println(join);
        }
    }

    /**
     * Method that replaces all letters "a" with the character passed by the
     * user
     *
     * @param letter
     */
    public void replace(String letter) {
        String replaceLetter = "";
        if (verify(letter)) {
            String[] phrase = sentence.toLowerCase().split("");
            for (int i = 0; i < phrase.length; i++) {
                if (phrase.equals("a")) {
                    replaceLetter += letter;
                } else {
                    replaceLetter = phrase[i];
                }
            }
            System.out.println(replaceLetter);
        }
    }

    /**
     * Method that checks if the phrase has the letter passed as parameter
     *
     * @param letter
     */
    public Boolean contains(String letter) {
        if(verify(letter)){
            String[] phrase = letter.split("");
            for(int i = 0; i < phrase.length; i++){
                if(phrase[i].equals(letter)){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verify(String letter) {
        if (letter == null || letter.isEmpty()) {
            System.out.println("letter passed by null or empty parameter");
            return false;
        } else {
            return true;
        }
    }
}
