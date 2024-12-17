/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.main.admin;

/**
 *
 * @author lilac
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mycompany.thepetproject.main.admin.Admin;
import com.mycompany.thepetproject.utils.auth.Password;

public class AdminList implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "data/admins.ser";
    private static List<Admin> admins = new ArrayList<>();
    
    // Method to add admin to list
    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }
    
    // Get admin methods
    public static Admin getAdmin(UUID id) {
        for (Admin admin : admins) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }
    public static Admin getAdmin(String username) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }
    
    // Method to check if a UUID already exists in the list
    public static boolean isAdminInList(UUID id) {
        for (Admin admin : admins) {
            if (admin.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    // Serialize the static list of admins to a file
    public static void serializeAdmins() {        
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(admins);
            System.out.println("Admin list serialized to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Deserialize the static list of admins from a file
    public static void deserializeAdmins() {
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            admins = (List<Admin>)in.readObject();
            System.out.println("Admin list deserialized from " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Get the file name used by the class to serialize and deserialize
    public static String getSerializationFilePath() {
        return FILE_NAME;
    }
    
    // Method to print the list of admins
    public static void printAdmins() {
        StringBuilder compiledAdminStrings = new StringBuilder();
        compiledAdminStrings.append("AdminList [");
        for (Admin admin : admins) {
            String adminString = "\n{" +
                "\n\t" + "id: " + admin.getId() + "," +
                "\n\t" + "username: " + admin.getUsername() + "," +
                "\n\t" + "unhashedPassword: " + admin.getUnhashedPassword() + "," +
                "\n\t" + "hashedPassword: " + admin.getHashedPassword() + "," +
                "\n\t" + "passwordSalt: " + Password.saltBtyeArrToString(admin.getPasswordSalt()) + "," +
                "\n},";
            compiledAdminStrings.append(adminString);
        }
        compiledAdminStrings.append("\n]");
        System.out.println(compiledAdminStrings);
    }
}
