/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.seeders;

/**
 *
 * @author lilac
 */
import java.io.FileWriter;
import java.io.IOException;
import com.mycompany.thepetproject.utils.auth.Password;

/*
    WARNING! BE CAREFUL WHEN RESEEDING DATA 
    AS CODE MIGHT DEPEND ON THE CURRENT DATA SEEDED.
    RESEEDING MAY REQUIRE YOU TO UPDATE CODE!
*/
public class UserSeeder {
    // Arrays of 20 first names and 20 simple passwords
    private static final String[] USERNAMES = {
        "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Ian", "Jack", 
        "Kathy", "Liam", "Mona", "Nina", "Oscar", "Paul", "Quincy", "Rachel", "Sam", "Tina"
    };
    
    private static final String[] PASSWORDS = {
        "123", "password", "qwerty", "abc123", "hello", "letmein", "jams", "iloveyou", "admin", "password",
        "123abc", "home", "BSCS2A", "321", "987", "dragon", "apple", "key", "qwerty123", "pass"
    };
    
    public static void generateUsers(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("Username,HashedPassword,UnhashedPassword\n");
            for (int i = 0; i < USERNAMES.length; i++) {
                String username = USERNAMES[i];
                String hashedPassword = Password.hash(PASSWORDS[i]);
                String unhashedPassword = PASSWORDS[i];
                
                writer.append(username).append(",").append(hashedPassword).append(",").append(unhashedPassword).append("\n");
            }
            System.out.println("CSV file of Users generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
