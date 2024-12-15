/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject;

import java.security.NoSuchAlgorithmException;
import com.mycompany.thepetproject.utils.auth.Password;
import java.util.UUID;
import java.io.Serializable;

/**
 *
 * @author lilac
 */
public abstract class Account implements Serializable {
    private UUID id;
    private String username;
    // REMOVE ATTRIBUTE WHEN IN PRODUCTION!!!
    private String unhashedPassword;
    private String hashedPassword;
    private byte[] passwordSalt;
    
    public UUID getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getUnhashedPassword() {
        return unhashedPassword;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public byte[] getPasswordSalt() {
        return passwordSalt;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUnhashedPassword(String unhashedPassword) {
        this.unhashedPassword = unhashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    
    @Override
    public abstract String toString();
}