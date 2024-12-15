/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth.strategies;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;

/**
 *
 * @author lilac
 */
public class AdminAuthentication implements AuthenticationStrategy {

    @Override
    public boolean authenticate(String username, String password) {
        // Simulate admin authentication
        // Verify admin username and password here
        String adminUsername = "admin";
        String adminPassword = "password123";

        return username.equals(adminUsername) && password.equals(adminPassword);
    }
}
