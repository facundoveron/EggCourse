/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

import guiapoorelaciones.Enum.FormOfPaymentExercise6;
import guiapoorelaciones.Enum.TypeOfCoverageExercise6;
import java.util.Date;

/**
 *
 * @author Facundo
 */
public class PolicyManagementExercise6 {
    private IntegratedCustomerManagementExercise6 customer;
    private VehicleManagementExercise6 vehicle;
    private Integer policyNumber;
    private Date startDate;
    private Date endDate; 
    private Integer numberOfInstallments;
    private Integer totalInsuredAmount;
    private Boolean includesHail;
    private TypeOfCoverageExercise6 typeOfCoverage; 

    
    /**
     * Default constructer method
     */
    public PolicyManagementExercise6() {
    }

    /**
     * Constructer method
     * 
     * @param customer
     * @param vehicle
     * @param policyNumber
     * @param startDate
     * @param endDate
     * @param numberOfInstallments
     * @param totalInsuredAmount
     * @param includesHail
     * @param typeOfCoverage 
     */
    public PolicyManagementExercise6(IntegratedCustomerManagementExercise6 customer, VehicleManagementExercise6 vehicle, Integer policyNumber, Date startDate, Date endDate, Integer numberOfInstallments, Integer totalInsuredAmount, Boolean includesHail, TypeOfCoverageExercise6 typeOfCoverage) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfInstallments = numberOfInstallments;
        this.totalInsuredAmount = totalInsuredAmount;
        this.includesHail = includesHail;
        this.typeOfCoverage = typeOfCoverage;
    }

    //Get and Set
    public IntegratedCustomerManagementExercise6 getCustomer() {
        return customer;
    }

    public void setCustomer(IntegratedCustomerManagementExercise6 customer) {
        this.customer = customer;
    }

    public VehicleManagementExercise6 getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleManagementExercise6 vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getTotalInsuredAmount() {
        return totalInsuredAmount;
    }

    public void setTotalInsuredAmount(Integer totalInsuredAmount) {
        this.totalInsuredAmount = totalInsuredAmount;
    }

    public Boolean getIncludesHail() {
        return includesHail;
    }

    public void setIncludesHail(Boolean includesHail) {
        this.includesHail = includesHail;
    }

    public TypeOfCoverageExercise6 getTypeOfCoverage() {
        return typeOfCoverage;
    }

    public void setTypeOfCoverage(TypeOfCoverageExercise6 typeOfCoverage) {
        this.typeOfCoverage = typeOfCoverage;
    }
    
    
}
