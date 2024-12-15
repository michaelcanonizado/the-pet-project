/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth.strategies;

/**
 *
 * @author lilac
 */
public interface AuthenticationStrategy {
    boolean authenticate(String username, String password);
}
