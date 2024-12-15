package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.User;
import com.mycompany.thepetproject.UserList;
import com.mycompany.thepetproject.utils.seeders.UserSeeder;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
        
        UserSeeder.generateUsers(UserList.getSerializationFilePath());
        UserList.deserializeUsers();
        UserList.printUsers();
    }
}
