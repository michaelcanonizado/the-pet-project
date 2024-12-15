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
       
        User user1 = new User("mike", "abc");
        User user2 = new User("john", "123");
        User user3 = new User("jacob", "pass");
        
        UserList.addUser(user1);
        UserList.addUser(user2);
        UserList.addUser(user3);
        UserList.printUsers();
    }
}
