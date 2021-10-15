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
public class GameExercise2 {

    private ArrayList<PlayerExercise2> players;
    private RevolverExercise2 revolver;

    /**
     * Default constucter method
     */
    public GameExercise2() {
    }

    /**
     * Constructer method
     *
     * @param players
     * @param revolver
     */
    public GameExercise2(ArrayList<PlayerExercise2> players, RevolverExercise2 revolver) {
        this.players = players;
        this.revolver = revolver;
    }

    //Get and Set
    public ArrayList<PlayerExercise2> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerExercise2> players) {
        this.players = players;
    }

    public RevolverExercise2 getRevolver() {
        return revolver;
    }

    public void setRevolver(RevolverExercise2 revolver) {
        this.revolver = revolver;
    }
    
    /**
     * Method to simulate the game
     * 
     * @param game 
     */
    public void round(GameExercise2 game) {
        Integer i = -1;
        do {
            i++;
            if (i >= game.players.size()) {
                i = 0;
            }
            System.out.println("the player " + this.players.get(i).getName() + " current position " + game.getRevolver().getCurrentPosition() + " - water position" + game.getRevolver().getWaterPosition());
        } while (game.getPlayers().get(i).shot(revolver));
    }
    
    /**
     * Method to create game
     */
    public void createGame() {
        RevolverExercise2 revolver = new RevolverExercise2();
        revolver.fillRevolver();
        this.revolver = revolver;
        PlayerExercise2 player = new PlayerExercise2();
        this.players = player.listPlayers();
    }
}
