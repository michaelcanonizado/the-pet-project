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
import com.mycompany.thepetproject.utils.csv.Csv;

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
    
    public static void savePets() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Pet pet : pets) {
                writer.append("id,type,name,age,sex,description\n");
                writer.append(pet.getId().toString()).append(",");
                writer.append(pet.getType().toString()).append(",");
                writer.append(pet.getName()).append(",");
                writer.append(String.valueOf(pet.getAge())).append(",");
                writer.append(pet.getSex().toString()).append(",");
                writer.append(pet.getDescription()).append(",");
                writer.append("\n");
                System.out.println("Saved pet: "+pet.getName());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to " + FILE_NAME + " : " + e.getMessage());
        }
    }
    
    public static void loadPets() {
        Csv csv = new Csv(FILE_NAME);
        for (int i = 1; i < csv.getNumberOfRows(); i++) {
            String[] row = csv.getRow(i);
            Type type = null;
            if (row[1].equals("Cat")) {
                type = Type.CAT;
            } else if (row[1].equals("Dog")) {
                type = Type.DOG;
            }
            String name = row[2];
            int age = Integer.parseInt(row[3]);
            Sex sex = null;
            if (row[4].equals("M")) {
                sex = Sex.Male;
            } else if (row[4].equals("F")) {
                sex = Sex.Female;
            }
            String description = row[5];
            
            Pet pet = new Pet(type, name, age, sex, description);
            pets.add(pet);
        }
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
