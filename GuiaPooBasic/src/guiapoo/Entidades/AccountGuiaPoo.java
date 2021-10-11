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
public class AccountGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private Integer accountNumber;
    private Long DNICustomer;
    private Double currentBalance;
    /**
     * Default constructor method
     */
    public AccountGuiaPoo() {
    }
    
    /**
     * Constructor method
     * 
     * @param AccountNumber
     * @param DNICustomer
     * @param currentBalance 
     */
    public AccountGuiaPoo(Integer AccountNumber, Long DNICustomer, Double currentBalance) {
        this.accountNumber = AccountNumber;
        this.DNICustomer = DNICustomer;
        this.currentBalance = currentBalance;
    }
    
    //Get and Set
    public Scanner getRead() {
        return read;
    }

    public void setRead(Scanner read) {
        this.read = read;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer AccountNumber) {
        this.accountNumber = AccountNumber;
    }

    public Long getDNICustomer() {
        return DNICustomer;
    }

    public void setDNICustomer(Long DNICustomer) {
        this.DNICustomer = DNICustomer;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    /**
     * Method to create a bank account
     */
    public void createAccount() {
        System.out.println("Enter the account number");
        Integer numeroCuenta;
        do {
            numeroCuenta = read.nextInt();
        } while (numeroCuenta == null || numeroCuenta < 0);
        this.accountNumber = numeroCuenta;
        System.out.println("Enter the DNI customer");
        Long dniCliente;
        do {
            dniCliente = read.nextLong();
        } while (dniCliente == null || dniCliente < 0);
        this.DNICustomer = dniCliente;
        System.out.println("Enter the current balance");
        Double saldo;
        do {
            saldo = read.nextDouble();
        } while (saldo == null || saldo < 0);
        this.currentBalance = saldo;
    }
    
    /**
     * Method to enter money
     * @param income 
     */
    public void enter(Double income) {
        if (!(income == null || income < 0)) {
            this.currentBalance += income;
        }
    }
    
    /**
     * Method to withdraw money
     * @param retreat 
     */
    public void withdraw(Double retreat) {
        if (!(retreat == null || retreat < 0)) {
            if (retreat > currentBalance) {
                this.currentBalance = 0.0;
            } else {
                this.currentBalance -= retreat;
            }
        }
    }

    /**
     * Method to extract 20% of the current balance
     * @return currentBalance/5
     */
    public Double quickExtraction() {
        if (this.currentBalance == 0) {
            return 0.0;
        } else {
            return currentBalance / 5;
        }
    }
    
    /**
     * Method to check current balance
     */
    public void checkBalance() {
        if (this.currentBalance == null) {
            System.out.println("Unoffered story");
        } else {
            System.out.println(this.currentBalance);
        }
    }
    
    /**
     * Method to check account information
     */
    public void checkDate() {
        if (this.DNICustomer == null || this.accountNumber == null || this.currentBalance == null) {
            System.out.println("Unoffered story");
        } else {
            System.out.println("The account number is " + this.accountNumber
                    + ". The DNI customer is " + this.accountNumber
                    + ". The current balance is " + this.currentBalance
            );
        }
    }
}
