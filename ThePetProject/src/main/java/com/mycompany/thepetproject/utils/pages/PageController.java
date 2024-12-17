/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.pages;
import com.mycompany.thepetproject.utils.pages.Page;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

/**
 *
 * @author lilac
 */
public class PageController {
    private static PageController instance;
    private static JTabbedPane tabbedPane;
    private List<Page> pages = new ArrayList<>();
    private Page previousPage;
    private Page currentPage;

    public PageController() {};
    
    // Get the singleton instance
    public static PageController getInstance() {
        if (instance == null) {
            instance = new PageController();
        }
        return instance;
    }
    
    public void setTabbedPane(JTabbedPane tabbedPane) {
        if (this.tabbedPane == null) {
            this.tabbedPane = tabbedPane;
        } else {
            throw new IllegalStateException("JTabbedPane has already been set.");
        }
    }
    
    public void addPage(Page page) {
        if (pages.isEmpty()) {
            currentPage = page;
        }
        pages.add(page);
        tabbedPane.add(page.getName(), page.getPanel());
    }
    
    public void changePage(String name) {
        for (Page page : pages) {
            if (page.getName().equals(name)) {
                tabbedPane.setSelectedIndex(page.getIndex());
                previousPage = currentPage;
                currentPage = page;
            }
        }
        System.out.println("Current page: " + currentPage.getName());
        System.out.println("Previous page: " + previousPage.getName());
    }
}
