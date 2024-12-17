package com.mycompany.thepetproject.swing.components;

/**
 *
 * @author deynklarys
 */

/**
 * initialize
    private Font fontBold48f;
    private Font fontBold36f;
    private Font fontPlain24f;
    private Font fontBold20f; for pet cards
    private Font fontPlain18f;
    private Font fontBold14f; for pet cards
    private Font fontPlain14f; for pet cards
*
* must be added before ThePetProject initComponents()
    fontBold48f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 48f, Font.BOLD);
    fontBold36f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 36f, Font.BOLD);
    fontPlain24f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 24f, Font.PLAIN);
    fontBold20f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 20f, Font.BOLD);
    fontPlain18f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 18f, Font.PLAIN);
    fontBold14f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 14f, Font.BOLD);
    fontPlain14f = FontUtil.loadCustomFont("src/main/java/com/mycompany/thepetproject/swing/text/Inter.ttf", 14f, Font.PLAIN);
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
