/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.seeders;

import com.mycompany.thepetproject.utils.auth.Password;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lilac
 */

/*
    WARNING! BE CAREFUL WHEN RESEEDING DATA 
    AS CODE MIGHT DEPEND ON THE CURRENT DATA SEEDED.
    RESEEDING MAY REQUIRE YOU TO UPDATE CODE!
*/
public class AdminSeeder {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";
    
    public static void generateAdmin(String filename) throws NoSuchAlgorithmException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("Username,HashedPassword,UnhashedPassword,Salt\n");
            String username = USERNAME;
            String unhashedPassword = PASSWORD;
            byte[] saltAsByteArr = Password.generateSalt();
            String saltAsString = Password.saltBtyeArrToString(saltAsByteArr);
            String hashedPassword = Password.hash(PASSWORD, saltAsByteArr);
                
            writer.append(username).append(",").append(hashedPassword).append(",").append(unhashedPassword).append(",").append(saltAsString).append("\n");
            
            System.out.println("CSV file of Admin generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
