/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.utils.auth.SessionRole;
import com.mycompany.thepetproject.Account;

public class SessionManager {
    private static SessionManager instance;
    private boolean isLoggedIn = false;
    private SessionRole role = SessionRole.GUEST;
    private Account account = null;

    private SessionManager() {};
    
    // Get the singleton instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    // Authenticate accounts based on strategy
    public boolean authenticate(SessionRole role, String username, String password, AuthenticationStrategy strategy) {
        Account account = strategy.authenticate(username, password);
        
        if (account == null) {
            isLoggedIn = false;
            this.role = role.GUEST;
            this.account = null;
            return false;
        } 
        
        isLoggedIn = true;
        this.role = role;
        this.account = account;
        return true;
    }
    
    // Check if someone is logged in
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    // Getters
    public Account getAccount() {
        return account;
    }
    public SessionRole getRole() {
        return role;
    }
    
    // Log current account out
    public void logout() {
        this.account = null;
        this.isLoggedIn = false;
        this.role = SessionRole.GUEST;
    }
}
