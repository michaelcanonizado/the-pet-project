/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject;

import java.util.UUID;
import com.mycompany.thepetproject.Type;
import com.mycompany.thepetproject.Sex;

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
    
    public Pet(Type type, String name, int age, Sex sex, String description) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.description = description;
    }
    
    public UUID getID() {
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
    public String getDescription() {
        return description;
    }
}
