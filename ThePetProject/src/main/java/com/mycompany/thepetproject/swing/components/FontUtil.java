package com.mycompany.thepetproject.swing.components;

/**
 *
 * @author deynklarys
 */

/**
 * initialize
    private Font displayFont;
    private Font headingFont;
    private Font bodyFont;
    private Font labelFont;
*
* must be added before ThePetProject initComponents()
    displayFont = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 48f, Font.BOLD);
    headingFont = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 36f, Font.BOLD);
    bodyFont = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 24f, Font.PLAIN);
    labelFont = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 18f, Font.PLAIN);
 */

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontUtil {

    public static Font loadCustomFont(String fontPath, float size, int style) {
        try {
            // Load the custom font
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(style, size);
            // Register the font with the graphics environment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
