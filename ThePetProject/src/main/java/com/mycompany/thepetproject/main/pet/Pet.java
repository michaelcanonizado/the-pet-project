/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.main.pet;

import java.util.UUID;
import com.mycompany.thepetproject.main.pet.Type;
import com.mycompany.thepetproject.main.pet.Sex;

/**
 *
 * @author lilac
 */
public class Pet {
    private UUID id;
    private Type type;
    private String name;
    private int age;
    private Sex sex;
    private String description;
    private Status status;
    
    public Pet(Type type, String name, int age, Sex sex, Status status, String description) {
        do {
            this.id = UUID.randomUUID();
        } while (PetList.isPetInList(this.id));
        this.type = type;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.status = status;
    }
    
    public UUID getId() {
        return id;
    }
    public Type getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public Status getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "Pet {" +
                "\n\t" + "id: " + id + "," +
                "\n\t" + "name: " + name + "," +
                "\n\t" + "type: " + type + "," +
                "\n\t" + "age: " + age + "," +
                "\n\t" + "sex: " + sex + "," +
                "\n\t" + "status: " + status + "," +
                "\n\t" + "description: " + description + "," +
                "\n}";
    }
}
