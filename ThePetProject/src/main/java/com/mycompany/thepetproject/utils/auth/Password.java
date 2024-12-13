/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth;

/**
 *
 * @author lilac
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Password {
    // Hash a password
    public static String hash(String password) {
        try {
            // Get an instance of SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Hash the password
            byte[] hashedBytes = digest.digest(password.getBytes());
            // Convert the hash into a Base64 string (or hexadecimal)
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException err) {
            throw new RuntimeException("Error hashing password", err);
        }
    }
    
    // Compare an unhashed password to a hashed password
    public static boolean verify(String unhashedPassword, String storedHash) {
        String hashedPassword = hash(unhashedPassword);
        return hashedPassword.equals(storedHash);
    }
}
