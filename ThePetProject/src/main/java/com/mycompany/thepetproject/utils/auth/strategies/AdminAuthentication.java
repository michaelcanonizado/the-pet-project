/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth.strategies;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.main.admin.Pet;
import com.mycompany.thepetproject.main.admin.AdminList;
import com.mycompany.thepetproject.utils.auth.Password;

/**
 *
 * @author lilac
 */
public class AdminAuthentication implements AuthenticationStrategy {

    @Override
    public Pet authenticate(String username, String password) {
       // Get user via entered username (Check by username)
        Pet admin = AdminList.getAdmin(username);
        if (admin == null) return null;
        
        // If username is valid and user object is found, check entered password (Check by password)
        boolean isCorrectPassword = Password.verify(password, admin.getPasswordSalt(), admin.getHashedPassword());
        if (isCorrectPassword) return admin;

        // If username is correct but password is not, return null
        return null;
    }
}
