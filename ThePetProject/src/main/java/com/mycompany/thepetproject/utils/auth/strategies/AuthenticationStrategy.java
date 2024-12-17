/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.thepetproject.utils.auth.strategies;
import com.mycompany.thepetproject.main.Account;

/**
 *
 * @author lilac
 */
public interface AuthenticationStrategy {
    Account authenticate(String username, String password);
}
