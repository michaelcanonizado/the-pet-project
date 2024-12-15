package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.utils.csv.Csv;
import java.util.Arrays;
import java.util.List;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
       
        String username = "Sam";
        String password = "qwerty123";
        
        Csv usersCsv = new Csv("data/users.csv");
        usersCsv.displayRows();
        int columnIndex = usersCsv.indexOfColumn("Username");
        
        System.out.println("\n\nResult for " + username + ": ");
        List<String[]> searchResult = usersCsv.search(username, columnIndex);
        for (String[] row : searchResult) {
            System.out.println(Arrays.toString(row));
        }
    }
}
