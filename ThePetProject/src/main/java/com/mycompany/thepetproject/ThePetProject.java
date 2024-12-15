package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.User;
import com.mycompany.thepetproject.UserList;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
        
        UserList.deserializeUsers();
        User user1 = new User("jacob", "abc");        
        UserList.addUser(user1);
        UserList.serializeUsers();
    }
}
