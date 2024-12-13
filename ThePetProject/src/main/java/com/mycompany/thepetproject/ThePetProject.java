package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.utils.auth.AdminAuthentication;
import com.mycompany.thepetproject.utils.auth.UserAuthentication;
import com.mycompany.thepetproject.utils.auth.SessionManager;
import com.mycompany.thepetproject.utils.auth.AuthenticationStrategy;
import com.mycompany.thepetproject.utils.auth.SessionRole;

import com.mycompany.thepetproject.utils.seeders.UserSeeder;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
        
        UserSeeder.generateUsers("data/users.csv");
    }
}
