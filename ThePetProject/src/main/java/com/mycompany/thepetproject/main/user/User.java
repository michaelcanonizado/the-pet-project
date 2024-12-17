/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.main.user;

/**
 *
 * @author lilac
 */
import com.mycompany.thepetproject.Account;
import com.mycompany.thepetproject.Account;
import com.mycompany.thepetproject.utils.auth.Password;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class User extends Account { 
    public User(String username, String unhashedPassword) {
        try {
            do {
                this.setId(UUID.randomUUID());
            } while (UserList.isUserInList(this.getId()));
            this.setUsername(username);
            this.setUnhashedPassword(unhashedPassword);
            byte[] salt = Password.generateSalt();
            this.setPasswordSalt(salt);
            this.setHashedPassword(Password.hash(unhashedPassword, salt));
        } catch (NoSuchAlgorithmException err) {
            System.out.println(
                    "Error generating salt for " +
                    this.getUsername() + ": " +
                    err); 
        }
    }
    
    @Override
    public String toString() {
        return "User {" +
                "\n\t" + "id: " + this.getId() + "," +
                "\n\t" + "username: " + this.getUsername() + "," +
                "\n\t" + "unhashedPassword: " + this.getUnhashedPassword() + "," +
                "\n\t" + "hashedPassword: " + this.getHashedPassword() + "," +
                "\n\t" + "passwordSalt: " + Password.saltBtyeArrToString(this.getPasswordSalt()) + "," +
                "\n}";
    }
}
