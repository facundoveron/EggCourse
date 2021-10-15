/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import guiapoorelaciones.Enum.FormOfPaymentExercise6;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Facundo
 */
public class InstallmentManagementExercise6 {

    private ArrayList<PolicyManagementExercise6> policy;
    private Integer numberOfQuotas;
    private Integer totalAmountOfPremium;
    private Boolean paid;
    private Date dueDate;
    private FormOfPaymentExercise6 formOfPayment;

    /**
     * Default constructer method
     */
    public InstallmentManagementExercise6() {
    }

    /**
     * Constructer method
     * 
     * @param policy
     * @param numberOfQuotas
     * @param totalAmountOfPremium
     * @param paid
     * @param dueDate
     * @param formOfPayment 
     */
    public InstallmentManagementExercise6(ArrayList<PolicyManagementExercise6> policy, Integer numberOfQuotas, Integer totalAmountOfPremium, Boolean paid, Date dueDate, FormOfPaymentExercise6 formOfPayment) {
        this.policy = policy;
        this.numberOfQuotas = numberOfQuotas;
        this.totalAmountOfPremium = totalAmountOfPremium;
        this.paid = paid;
        this.dueDate = dueDate;
        this.formOfPayment = formOfPayment;
    }

    
    //Get and Set
    public ArrayList<PolicyManagementExercise6> getPolicy() {
        return policy;
    }

    public void setPolicy(ArrayList<PolicyManagementExercise6> policy) {
        this.policy = policy;
    }

    public Integer getNumberOfQuotas() {
        return numberOfQuotas;
    }

    public void setNumberOfQuotas(Integer numberOfQuotas) {
        this.numberOfQuotas = numberOfQuotas;
    }

    public Integer getTotalAmountOfPremium() {
        return totalAmountOfPremium;
    }

    public void setTotalAmountOfPremium(Integer totalAmountOfPremium) {
        this.totalAmountOfPremium = totalAmountOfPremium;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public FormOfPaymentExercise6 getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPaymentExercise6 formOfPayment) {
        this.formOfPayment = formOfPayment;
    }
    
    
    
}
