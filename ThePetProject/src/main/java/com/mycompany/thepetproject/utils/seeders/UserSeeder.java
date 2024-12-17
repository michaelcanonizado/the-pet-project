/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.seeders;

/**
 *
 * @author lilac
 */
import java.security.NoSuchAlgorithmException;
import java.io.FileWriter;
import java.io.IOException;
import com.mycompany.thepetproject.utils.auth.Password;
import com.mycompany.thepetproject.main.UserList;
import com.mycompany.thepetproject.main.User;

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
    
    public static void generateUsers() {
        for (int i = 0; i < USERNAMES.length; i++) {
            String password = PASSWORDS[i] != null ? PASSWORDS[i]: "123";
            User user = new User(USERNAMES[i], password);
            UserList.addUser(user);
        }
        UserList.saveUsers();
    }
}
