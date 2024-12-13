/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth;

/**
 *
 * @author lilac
 */
enum Role {
    ADMIN,
    USER,
    GUEST
}

public class SessionManager {
    private static SessionManager instance;
    private boolean isLoggedIn = false;
    private Role role = Role.GUEST;

    private SessionManager() {};
    
    // Get the singleton instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    // Authenticate user or admin based on strategy
    public boolean authenticate(Role role, String username, String password, AuthenticationStrategy strategy) {
        if (strategy.authenticate(username, password)) {
            isLoggedIn = true;
            this.role = role;
            return true;
        } else {
            isLoggedIn = false;
            this.role = role.GUEST;
            return false;
        }
    }
    
    // Check if someone is logged in
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    // Get session role
    public Role getRole() {
        return role;
    }
    
    // Log current user/admin out
    public void logout() {
        isLoggedIn = false;
    }
}
