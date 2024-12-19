package com.mycompany.thepetproject.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.mycompany.thepetproject.utils.csv.Csv;

public class PetList {
    private static final String FILE_NAME = "data/pets.csv";
    private static List<Pet> pets = new ArrayList<>();

    // Method to add pet to list
    public static void addPet(Pet pet) {
        if (!isPetInList(pet.getId())) {
            pets.add(pet);
        }
    }

    public static void removePet(UUID id) {
        pets.removeIf(pet -> pet.getId().equals(id));
    }

    public static void setPetStatus(UUID id, PetStatus status) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                pet.setStatus(status);
            }
        }
        savePets();
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

    public static List<Pet> getPets() {
        if (pets.isEmpty()) {
            loadPets();
        }
        return pets;
    }

    public static List<Pet> filterPets(PetStatus status) {
        List<Pet> filteredPets = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getStatus().equals(status)) {
                filteredPets.add(pet);
            }
        }
        return filteredPets;
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
        List<Pet> petsCopy = new ArrayList<>(pets); // Create a copy of the list for iteration
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.append("id,type,name,age,sex,status,description\n");
            for (Pet pet : petsCopy) {
                writer.append(pet.getId().toString()).append(",");
                writer.append(pet.getType().toString()).append(",");
                writer.append(pet.getName()).append(",");
                writer.append(String.valueOf(pet.getAge())).append(",");
                writer.append(pet.getSex().toString()).append(",");
                writer.append(pet.getStatus().toString()).append(",");
                writer.append(pet.getDescription()).append("\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to " + FILE_NAME + " : " + e.getMessage());
        }
    }

    public static void loadPets() {
        pets.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", 7); // Split into 7 parts to handle description with commas
                if (values.length == 7) {
                    PetType type = PetType.valueOf(values[1]);
                    String name = values[2];
                    int age = Integer.parseInt(values[3]);
                    PetSex sex = PetSex.valueOf(values[4]);
                    PetStatus status = PetStatus.valueOf(values[5]);
                    String description = values[6];

                    Pet pet = new Pet(type, name, age, sex, status, description);
                    pet.setId(UUID.fromString(values[0]));
                    if (!isPetInList(pet.getId())) {
                        pets.add(pet);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the file name used by the class to serialize and deserialize
    public static String getFilePath() {
        return FILE_NAME;
    }

    // Method to print the list of pets
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
                "\n\t" + "status: " + pet.getStatus().toString() + "," +
                "\n\t" + "description: " + pet.getDescription() + "," +
                "\n},";
            compiledPetStrings.append(petString);
        }
        compiledPetStrings.append("\n]");
        System.out.println(compiledPetStrings);
    }
}