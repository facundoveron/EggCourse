/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones.entities;

/**
 *
 * @author Facundo
 */
public class IntegratedCustomerManagementExercise6 {
    private String name;
    private String lastName;
    private Long dni;
    private String email;
    private String address;
    private Long phone;

    /**
     * Default constructer method
     */
    public IntegratedCustomerManagementExercise6() {
    }

    /**
     * Constructer method
     * 
     * @param name
     * @param lastName
     * @param dni
     * @param email
     * @param address
     * @param phone 
     */
    public IntegratedCustomerManagementExercise6(String name, String lastName, Long dni, String email, String address, Long phone) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    
    //Get and Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
    
    
}
