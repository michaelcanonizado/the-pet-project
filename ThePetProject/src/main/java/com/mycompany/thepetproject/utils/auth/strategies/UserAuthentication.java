/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth.strategies;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.main.user.User;
import com.mycompany.thepetproject.main.user.UserList;
import com.mycompany.thepetproject.utils.auth.Password;

/**
 *
 * @author lilac
 */
public class UserAuthentication implements AuthenticationStrategy {

    @Override
    public User authenticate(String username, String password) {
        // Get user via entered username (Check by username)
        User user = UserList.getUser(username);
        if (user == null) return null;
        
        // If username is valid and user object is found, check entered password (Check by password)
        boolean isCorrectPassword = Password.verify(password, user.getPasswordSalt(), user.getHashedPassword());
        if (isCorrectPassword) return user;

        // If username is correct but password is not, return null
        return null;
    }
    
}
