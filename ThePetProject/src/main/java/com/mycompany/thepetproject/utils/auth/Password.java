/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth;

/**
 *
 * @author lilac
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class Password {
    private static final int SALT_LENGTH = 16;
    private static final int HASH_ITERATIONS = 65536;
    private static final int HASH_LENGTH = 256;
    
    // Generate salt
    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            secureRandom.nextBytes(salt);
            return salt;
        } catch (Exception err) {
            System.err.println("Error generating salt: " + err.getMessage());
            // Return default salt
            return new byte[16];
        }
    }
    
    // Convert a byte[] salt to String salt
    public static String saltBtyeArrToString(byte[] salt) {
        return Base64.getEncoder().encodeToString(salt);
    }
    
    // Convert a String salt to byte[] salt
    public static byte[] saltStringToByteArr(String salt) {
        return Base64.getDecoder().decode(salt);
    }
    
    // Hash a password
    public static String hash(String password, byte[] salt)  {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, HASH_ITERATIONS, HASH_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception err) {
            throw new RuntimeException("Error hashing password: ", err);
        }
    }
    
    // Compare an unhashed password to a hashed password
    public static boolean verify(String unhashedPassword, byte[] storedSalt, String storedHash) {
        String hashedPassword = hash(unhashedPassword, storedSalt);
        return hashedPassword.equals(storedHash);
    }
}
