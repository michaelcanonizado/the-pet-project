/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.swing.text;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


/**
 * Loads customs fonts and ensures that each font is only loaded once.
 * @author drioj
 */
public class FontLoader {
    
    private static Font inter = null;
    
    public static Font loadCustomFontInter() {
        if (inter == null) {
            try {
                inter = Font.createFont(Font.TRUETYPE_FONT, new File("Inter.ttf"));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Inter.ttf")));
            }
            catch (IOException | FontFormatException e) {}
        }
        return inter;
    }
}