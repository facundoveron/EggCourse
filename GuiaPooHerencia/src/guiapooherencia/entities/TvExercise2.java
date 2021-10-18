/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapooherencia.entities;

import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class TvExercise2 extends ApplianceExercise2 {

    private Scanner read = new Scanner(System.in);
    private Double resolution;
    private Boolean sintonizadorTdt;

    public TvExercise2(Double resolution, Boolean sintonizadorTdt) {
        this.resolution = resolution;
        this.sintonizadorTdt = sintonizadorTdt;
    }

    /**
     * Constructer method
     *
     * @param resolution
     * @param sintonizadorTdt
     * @param price
     * @param color
     * @param energyConsumption
     * @param weight
     */
    public TvExercise2(Double resolution, Boolean sintonizadorTdt, Double price, String color, String energyConsumption, Integer weight) {
        super(price, color, energyConsumption, weight);
        this.resolution = resolution;
        this.sintonizadorTdt = sintonizadorTdt;
    }

    /**
     * Default constructer method
     */
    public TvExercise2() {
    }

    public Double getResolution() {
        return resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public Boolean getSintonizadorTdt() {
        return sintonizadorTdt;
    }

    public void setSintonizadorTdt(Boolean sintonizadorTdt) {
        this.sintonizadorTdt = sintonizadorTdt;
    }

    public void createTv() {
        ApplianceExercise2 appliance = new ApplianceExercise2();
        appliance.createAppliance();
        this.color = appliance.getColor();
        this.energyConsumption = appliance.getEnergyConsumption();
        this.weight = appliance.getWeight();
        this.price = appliance.getPrice();
        Double resolucion = 0.0;
        String sintonizador = "";
        do {
            System.out.println("Enter the resolution");
            resolucion = read.nextDouble();
        } while (resolucion == null || resolucion < 0);
        this.resolution = resolucion;
        System.out.println("have sintonizador");
        sintonizador = read.next();
        if (sintonizador.equals("yes")) {
            this.sintonizadorTdt = true;
        }else{
            this.sintonizadorTdt = false;
        }
        finalPriceTv();
    }
    
    public void finalPriceTv(){
        if(this.resolution > 40){
            this.price += ((this.price/10) * 3);
        }
        if(sintonizadorTdt){
            this.price += 500;
        }
    } 
}
