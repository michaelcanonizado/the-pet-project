/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.csv;

/**
 *
 * @author lilac
 */
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Csv {
    private List<String[]> data;
    
    public Csv(String filePath) {
        data = new ArrayList<>();
        loadCsv(filePath);
    }
    
    // Load CSV content into data list
    private void loadCsv(String filePath) {
        try {
            List<String> rows = Files.readAllLines(Paths.get(filePath));
            for (String row : rows) {
                data.add(row.split(","));
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
    
    // Get index of column
    public int indexOfColumn(String columnHeader) {
        if (data.isEmpty()) {
            return -1;
        }
        
        // Find index of columnHeader in data header
        String[] headerCells = data.get(0);
        for (int i = 0; i < headerCells.length; i++) {
            if (headerCells[i].equals(columnHeader)) {
                return i;
            }
        }
        
        // Desired column header is not found
        return -1;
    }
    
    // Search for a keyword in a specific column
    public List<String[]> search(String keyword, int columnIndex) {
        List<String[]> results = new ArrayList<>();
        for (String[] row : data) {
            if (row.length > columnIndex && row[columnIndex].contains(keyword)) {
                results.add(row);
            }
        }
        return results;
    }
    
    // Display the data in a user-friendly format
    public void displayRows() {
        for (String[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    public int getNumberOfRows() {
        return data.size();
    }
    public String[] getRow(int index) {
        return data.get(index);
    }
}
