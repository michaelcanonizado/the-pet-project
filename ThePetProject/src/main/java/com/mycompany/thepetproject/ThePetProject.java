package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.utils.auth.Password;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
       
        
        String unhashedPassword = "123";
        String storedHash = "IcLKMSh2WzAq2IokbC9TYWNpgGv3ioXikn+p+6/1OcA=";
        byte[] storedSalt = Password.saltStringToByteArr("WWefjFR8+pEZIYPr7ffrPA==");
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
