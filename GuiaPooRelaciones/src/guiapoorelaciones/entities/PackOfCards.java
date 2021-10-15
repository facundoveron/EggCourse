/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class PackOfCards {

    private ArrayList<CardExercise3> spades;
    private ArrayList<CardExercise3> aceOfClubs;
    private ArrayList<CardExercise3> gold;
    private ArrayList<CardExercise3> copas;
    private ArrayList<CardExercise3> packOfCards;
    private Integer counter;

    public PackOfCards() {
        this.counter = 0;
    }

    public PackOfCards(ArrayList<CardExercise3> spades, ArrayList<CardExercise3> aceOfClubs, ArrayList<CardExercise3> gold, ArrayList<CardExercise3> copas, ArrayList<CardExercise3> packOfCards) {
        this.spades = spades;
        this.aceOfClubs = aceOfClubs;
        this.gold = gold;
        this.copas = copas;
        this.packOfCards = packOfCards;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public ArrayList<CardExercise3> getSpades() {
        return spades;
    }

    public void setSpades(ArrayList<CardExercise3> spades) {
        this.spades = spades;
    }

    public ArrayList<CardExercise3> getAceOfClubs() {
        return aceOfClubs;
    }

    public void setAceOfClubs(ArrayList<CardExercise3> aceOfClubs) {
        this.aceOfClubs = aceOfClubs;
    }

    public ArrayList<CardExercise3> getGold() {
        return gold;
    }

    public void setGold(ArrayList<CardExercise3> gold) {
        this.gold = gold;
    }

    public ArrayList<CardExercise3> getCopas() {
        return copas;
    }

    public void setCopas(ArrayList<CardExercise3> copas) {
        this.copas = copas;
    }

    public ArrayList<CardExercise3> getPackOfCards() {
        return packOfCards;
    }

    public void setPackOfCards(ArrayList<CardExercise3> packOfCards) {
        this.packOfCards = packOfCards;
    }

    private ArrayList<CardExercise3> createCards(String stick) {
        ArrayList<CardExercise3> cards = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            if (i != 8 && i != 9) {
                CardExercise3 card = new CardExercise3();
                card.setStick(stick);
                card.setNumber(i);
                cards.add(card);
            }
        }
        return cards;
    }

    public void shuffle() {
        this.spades = createCards("spades");
        this.aceOfClubs = createCards("aceOfClubs");
        this.gold = createCards("gold");
        this.copas = createCards("copas");
        Integer i = 0;
        Integer j = 9;
        this.packOfCards = new ArrayList<>();
        do {
            this.packOfCards.add(this.spades.get(i));
            this.packOfCards.add(this.aceOfClubs.get(j));
            this.packOfCards.add(this.gold.get(i));
            this.packOfCards.add(this.copas.get(j));
            i++;
            j--;
        } while (i < 10);
//        packOfCards.forEach(aux -> {
//            System.out.println(aux.getStick() + " - " + aux.getNumber());
//        });
    }

    public CardExercise3 nextCard() {
        CardExercise3 card = this.packOfCards.get(counter);
        counter++;
        return card;
    }

    public Integer available() {
        return this.packOfCards.size() - counter;
    }

    public ArrayList<CardExercise3> toGive(Integer size) {
        ArrayList<CardExercise3> cards = new ArrayList<>();
        if (!(size == null || size < 0 || size > 41)) {
            for (int i = 0; i < size; i++) {
                cards.add(nextCard());
            }
        }
        return cards;
    }
    
    public void heapCards(){
        if(counter == 0){
            System.out.println("no card has been issued");
        }else{
            for (int i = 0; i < counter; i++) {
                System.out.println(this.packOfCards.get(i).getStick() + " - " + this.packOfCards.get(i).getNumber());
            }
        }
    }
    
    public void showDeck(){
        for (int i = counter; i < this.packOfCards.size(); i++) {
            System.out.println(this.packOfCards.get(i).getStick() + " - " + this.packOfCards.get(i).getNumber());
        }
    }
}
