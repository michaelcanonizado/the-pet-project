/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.pages;
import javax.swing.JPanel;

/**
 *
 * @author lilac
 */
public class Page {
    private int index;
    private String name;
    private PageBlueprint panel;
    
    public Page(int index, String name, PageBlueprint panel) {
        this.index = index;
        this.name = name;
        this.panel = panel;
    }
    
    public void repaint() {
        panel.revalidate();
        panel.repaint();
    }
    
    public PageBlueprint getPanel() {
        return panel;
    }
    
    public String getName() {
        return name;
    }
    
    public int getIndex() {
        return index;
    }
}
