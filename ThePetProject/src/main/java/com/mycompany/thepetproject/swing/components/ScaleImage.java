/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.swing.components;

/**
 *
 * @author deynklarys
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ScaleImage {

    private void loadImage(String filePath, JLabel labelImage) {
        try {
            // Load the image
            BufferedImage originalImage = ImageIO.read(new File(filePath));
    
            // Get the original dimensions of the image
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
    
            // Get the dimensions of the JLabel
            int labelWidth = labelImage.getWidth();
            int labelHeight = labelImage.getHeight();
    
            // Calculate the new dimensions while maintaining the aspect ratio
            int newWidth = labelWidth;
            int newHeight = (labelWidth * originalHeight) / originalWidth;
    
            if (newHeight > labelHeight) {
                newHeight = labelHeight;
                newWidth = (labelHeight * originalWidth) / originalHeight;
            }
    
            // Create a new BufferedImage with the size of the JLabel
            BufferedImage scaledImage = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = scaledImage.createGraphics();
    
            // Draw the scaled image centered in the BufferedImage
            int x = (labelWidth - newWidth) / 2;
            int y = (labelHeight - newHeight) / 2;
            g2d.drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), x, y, null);
            g2d.dispose();
    
            // Set the BufferedImage as the icon of the JLabel
            labelImage.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void scaleImage(String filePath, JLabel image) {
        SwingUtilities.invokeLater(() -> loadImage(filePath, image));
    }
}
