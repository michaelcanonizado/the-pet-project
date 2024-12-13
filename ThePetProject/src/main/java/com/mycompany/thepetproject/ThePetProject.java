package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
    }
}
