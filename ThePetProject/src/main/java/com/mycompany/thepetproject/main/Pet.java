/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.main;

import java.util.UUID;
import com.mycompany.thepetproject.main.PetType;
import com.mycompany.thepetproject.main.PetSex;

/**
 *
 * @author lilac
 */
public class Pet {
    private UUID id;
    private PetType type;
    private String name;
    private int age;
    private PetSex sex;
    private String description;
    private PetStatus status;
    
    public Pet(PetType type, String name, int age, PetSex sex, PetStatus status, String description) {
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
    public PetType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public PetSex getSex() {
        return sex;
    }
    public PetStatus getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }

    public UUID getPetById(UUID id) {
        return this.id = id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setType(PetType type) {
        this.type = type;
    }
    public void setSex(PetSex sex) {
        this.sex = sex;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(PetStatus status) {
        this.status = status;
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
