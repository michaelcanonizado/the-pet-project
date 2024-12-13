package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.utils.auth.Password;
import com.mycompany.thepetproject.utils.seeders.AdminSeeder;
import com.mycompany.thepetproject.utils.seeders.UsersSeeder;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
       
        String unhashedPassword = "123";
        String storedHash = "2PuX6/z0BKlWbwmI5+aNm3hld4TA5fkBu3XHMklm5/A=";
        byte[] storedSalt = Password.saltStringToByteArr("mqoSQtK1z1udcejyr34iAw==");
        boolean isCorrectPassword = Password.verify(unhashedPassword, storedSalt, storedHash);
        
        System.out.println(
                unhashedPassword +
                " == " +
                storedHash +
                " : " +
                isCorrectPassword
        );
    }
}
