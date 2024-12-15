/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */
import com.mycompany.thepetproject.User;
import com.mycompany.thepetproject.utils.auth.Password;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserList implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<User> users = new ArrayList<>();
    
    // Method to add user to list
    public static void addUser(User user) {
        users.add(user);
    }
    
    // Get user methods
    public static User getUser(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public static User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    // Method to check if a UUID already exists in the list
    public static boolean isUserIdInList(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    // Method to print the list of users
    public static void printUsers() {
        StringBuilder compiledUserStrings = new StringBuilder();
        compiledUserStrings.append("UserList [");
        for (User user : users) {
            String userString = "\n{" +
                "\n\t" + "id: " + user.getId() + "," +
                "\n\t" + "username: " + user.getUsername() + "," +
                "\n\t" + "unhashedPassword: " + user.getUnhashedPassword() + "," +
                "\n\t" + "hashedPassword: " + user.getHashedPassword() + "," +
                "\n\t" + "passwordSalt: " + Password.saltBtyeArrToString(user.getPasswordSalt()) + "," +
                "\n},";
            compiledUserStrings.append(userString);
        }
        compiledUserStrings.append("\n]");
        System.out.println(compiledUserStrings);
    }
}
