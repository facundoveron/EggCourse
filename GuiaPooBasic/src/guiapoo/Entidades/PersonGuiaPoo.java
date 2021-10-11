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
public class PersonGuiaPoo {

    private Scanner read = new Scanner(System.in);
    private String name;
    private Integer age;
    private String sex;
    private Double weight;
    private Double height;

    /**
     * Default constructor method
     */
    public PersonGuiaPoo() {
    }

    /**
     * Constructor method
     *
     * @param name
     * @param age
     * @param sex
     * @param weight
     * @param height
     */
    public PersonGuiaPoo(String name, Integer age, String sex, Double weight, Double height) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    //Get and Set
    public Scanner getRead() {
        return read;
    }

    public void setRead(Scanner read) {
        this.read = read;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Method for creating the person, assigning values to the attributes
     */
    public void createAPerson() {
        System.out.println("Enter a name");
        String nombre;
        do {
            nombre = read.next();
        } while (nombre.isEmpty() || nombre == null);
        this.name = nombre;
        System.out.println("Enter a age");
        Integer edad;
        do {
            edad = read.nextInt();
        } while (edad == null || edad < 0);
        this.age = edad;
        System.out.println("Enter a sexo");
        String sexo;
        do {
            sexo = read.next().toUpperCase();
        } while (sexo == null || sexo.isEmpty() || !((sexo.equals("H")) || (sexo.equals("M")) || (sexo.equals("O"))));
        this.sex = sexo;
        System.out.println("Enter a weight");
        Double peso;
        do {
            peso = read.nextDouble();
        } while (peso == null || peso < 1);
        this.weight = peso;
        System.out.println("Enter a height");
        Double altura;
        do {
            altura = read.nextDouble();
        } while (altura == null || altura < 0);
        this.height = altura;
    }

    /**
     * Method for calculating the imc
     *
     * @return -1, 0, 1, null
     */
    public Integer createIMC() {
        if (this.weight != null || this.height != null || this.weight > 0 || this.height > 0) {
            Double imc = this.weight / Math.pow(this.height, 2);
            if (imc < 20) {
                System.out.println("low weight");
                return -1;
            } else if (imc < 25) {
                System.out.println("ideal weight");
                return 0;
            } else {
                System.out.println("overweight");
                return 1;
            }
        } else {
            return null;
        }
    }

    /**
     * Method to find out if the person is of legal age
     *
     * @return true, false, null
     */
    public Boolean isOfLegalAge() {
        if (this.age != null || this.age > 0) {
            return age > 17;
        } else {
            return null;
        }
    }
    
    
}
