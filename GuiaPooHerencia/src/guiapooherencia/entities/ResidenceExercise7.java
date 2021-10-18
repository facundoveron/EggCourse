/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

/**
 *
 * @author Facundo
 */
public class ResidenceExercise7 extends HotelExtrasExercise7{
    private Integer numberOfRooms;
    private Boolean discountsForGuilds;
    private Boolean sportsField;

    /**
     * Default constructer method
     */
    public ResidenceExercise7() {
    }

    /**
     * Constructer method
     * 
     * @param numberOfRooms
     * @param discountsForGuilds
     * @param sportsField
     * @param privado
     * @param numberOfSquareMeters
     * @param name
     * @param address
     * @param location
     * @param manager 
     */
    public ResidenceExercise7(Integer numberOfRooms, Boolean discountsForGuilds, Boolean sportsField, Boolean privado, Integer numberOfSquareMeters, String name, String address, String location, String manager) {
        super(privado, numberOfSquareMeters, name, address, location, manager);
        this.numberOfRooms = numberOfRooms;
        this.discountsForGuilds = discountsForGuilds;
        this.sportsField = sportsField;
    }

    //Get and Set
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Boolean getDiscountsForGuilds() {
        return discountsForGuilds;
    }

    public void setDiscountsForGuilds(Boolean discountsForGuilds) {
        this.discountsForGuilds = discountsForGuilds;
    }

    public Boolean getSportsField() {
        return sportsField;
    }

    public void setSportsField(Boolean sportsField) {
        this.sportsField = sportsField;
    }
}
