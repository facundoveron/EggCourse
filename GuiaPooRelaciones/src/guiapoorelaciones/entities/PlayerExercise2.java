/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class PlayerExercise2 {
    private Scanner read = new Scanner(System.in);
    private Integer id;
    private String name;
    private Boolean wet;

    /**
     * Default constructor method
     */
    public PlayerExercise2() {
    }

    /**
     * Constructor method
     * 
     * @param id
     * @param name
     * @param wet 
     */
    public PlayerExercise2(Integer id, String name, Boolean wet) {
        this.id = id;
        this.name = name;
        this.wet = wet;
    }

    //Get and Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWet() {
        return wet;
    }

    public void setWet(Boolean wet) {
        this.wet = wet;
    }
        
    /**
     * Method 
     * 
     * @param r
     * @return true, false; 
     */
    public Boolean shot(RevolverExercise2 r){
        if(r.wet()){
            wet = false;
            return false;
        }else{
            r.jet();
        }
        return true;
    }
    
    /**
     * Method for creating the list of players 
     * 
     * @return ArrayList<Player> listPlayer;
     */
    public ArrayList<PlayerExercise2> listPlayers(){
        Integer quantity = null;
        String nombre = "";
        System.out.println("enter the number of players, less than or equal to 6");
        ArrayList<PlayerExercise2> listPlayer = new ArrayList<>();
        do {
            quantity = read.nextInt();
        } while (quantity == null || quantity < 0 || quantity > 6);
        for (int i = 0; i < quantity; i++) {
            do {
                System.out.println("Enter the name player");
                nombre = read.nextLine();
            } while (nombre.isEmpty() || nombre == null);
            PlayerExercise2 player = new PlayerExercise2(i, nombre, false);
            listPlayer.add(player);
        }
        return listPlayer;
    }
}
