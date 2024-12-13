/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth;

/**
 *
 * @author lilac
 */
public class SessionManager {
    private static SessionManager instance;
    private boolean isLoggedIn = false;

    private SessionManager() {};
    
    // Get the singleton instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public boolean authenticate(String username, String password, AuthenticationStrategy strategy) {
        if (strategy.authenticate(username, password)) {
            isLoggedIn = true;
            return true;
        } else {
            isLoggedIn = false;
            return false;
        }
    }
    
    // Check if someone is logged in
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    // Log current user/admin out
    public void logout() {
        isLoggedIn = false;
    }
}
