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
public class UserAuthentication implements AuthenticationStrategy {

    @Override
    public boolean authenticate(String username, String password) {
        // Simulate user authentication here
        String userUsername = "user";
        String userPassword = "123";

        return username.equals(userUsername) && password.equals(userPassword);
    }
    
}
