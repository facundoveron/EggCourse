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
public class ViewerExercise5 {
    private String name;
    private Integer age;
    private Double money;

    /**
     * Default constructor method
     */
    public ViewerExercise5() {
    }

    /**
     * Constructor method
     * 
     * @param name
     * @param age
     * @param money 
     */
    public ViewerExercise5(String name, Integer age, Double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    //Get and Set
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
    
    
}
