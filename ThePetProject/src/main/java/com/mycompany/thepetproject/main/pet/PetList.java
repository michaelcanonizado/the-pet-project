/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.main.pet;

/**
 *
 * @author lilac
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.mycompany.thepetproject.main.pet.Pet;

public class PetList {
    private static final String FILE_NAME = "data/pets.csv";
    private static List<Pet> pets = new ArrayList<>();
    
    // Method to add pet to list
    public static void addPet(Pet pet) {
        pets.add(pet);
    }
    
    // Get pet methods
    public static Pet getPet(UUID id) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }
        return null;
    }
    public static Pet getPet(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }
    
    // Method to check if a UUID already exists in the list
    public static boolean isPetInList(UUID id) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    // Get the file name used by the class to serialize and deserialize
    public static String getFilePath() {
        return FILE_NAME;
    }
    
    // Method to print the list of admins
    public static void printPets() {
        StringBuilder compiledPetStrings = new StringBuilder();
        compiledPetStrings.append("PetList [");
        for (Pet pet : pets) {
            String petString = "\n{" +
                "\n\t" + "id: " + pet.getId() + "," +
                "\n\t" + "name: " + pet.getName() + "," +
                "\n\t" + "type: " + pet.getType().toString() + "," +
                "\n\t" + "sex: " + pet.getSex().toString() + "," +
                "\n\t" + "age: " + pet.getAge() + "," +
                "\n\t" + "description: " + pet.getDescription() + "," +
                "\n},";
            compiledPetStrings.append(petString);
        }
        compiledPetStrings.append("\n]");
        System.out.println(compiledPetStrings);
    }
}
