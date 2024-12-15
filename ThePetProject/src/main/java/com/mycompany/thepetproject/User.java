/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */
import com.mycompany.thepetproject.utils.auth.Password;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    // REMOVE ATTRIBUTE WHEN IN PRODUCTION!!!
    private String unhashedPassword;
    private String hashedPassword;
    private byte[] passwordSalt;
    
    public User(String username, String unhashedPassword) {
        try {
            this.id = UUID.randomUUID();
            this.username = username;
            this.unhashedPassword = unhashedPassword;
            byte[] salt = Password.generateSalt();
            this.passwordSalt = salt;
            this.hashedPassword = Password.hash(unhashedPassword, salt);
        } catch (NoSuchAlgorithmException err) {
            System.out.println(
                    "Error generating salt for " +
                    username + 
                    ": " +
                    err); 
        }
    }
    
    public UUID getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getUnhashedPassword() {
        return unhashedPassword;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public byte[] getPasswordSalt() {
        return passwordSalt;
    }
    
    @Override
    public String toString() {
        return "User {" +
                "\n\t" + "id: " + id + "," +
                "\n\t" + "username: " + username + "," +
                "\n\t" + "unhashedPassword: " + unhashedPassword + "," +
                "\n\t" + "hashedPassword: " + hashedPassword + "," +
                "\n\t" + "passwordSalt: " + Password.saltBtyeArrToString(passwordSalt) + "," +
                "\n}";
    }
}
