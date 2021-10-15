/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import java.util.Objects;

/**
 *
 * @author Facundo
 */
public class RevolverExercise2 {

    private Integer currentPosition;
    private Integer waterPosition;
    
    /**
     * Default constructor method
     */
    public RevolverExercise2() {
    }
    
    /**
     * Constructor method
     * 
     * @param currentPosition
     * @param waterPosition 
     */
    public RevolverExercise2(Integer currentPosition, Integer waterPosition) {
        this.currentPosition = currentPosition;
        this.waterPosition = waterPosition;
    }
    
    //Get and Set
    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer getWaterPosition() {
        return waterPosition;
    }

    public void setWaterPosition(Integer waterPosition) {
        this.waterPosition = waterPosition;
    }
    
    /**
     * Method that gives random position to the drum and water
     */
    public void fillRevolver() {
        this.currentPosition = (int) (Math.random() * 10);
        this.waterPosition = (int) (Math.random() * 10);
    }
    
    /**
     * Method that returns true if the position of the water matches the current position
     * 
     * @return true, false;
     */
    public Boolean wet(){
        return Objects.equals(currentPosition, waterPosition);
    }
    
    /**
     * Method of switching to the next drum position
     */
    public void jet(){
        if(this.currentPosition >= 10){
            this.currentPosition = 0;
        }else{
            this.currentPosition += 1;        
        }
    }

    @Override
    public String toString() {
        return "Revolver{" + "currentPosition=" + currentPosition + ", waterPosition=" + waterPosition + '}';
    }
    
    
}
