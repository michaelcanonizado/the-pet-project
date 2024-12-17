/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepetproject.utils.seeders;
/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.main.admin.Pet;
import com.mycompany.thepetproject.main.admin.AdminList;

/*
    WARNING! BE CAREFUL WHEN RESEEDING DATA 
    AS CODE MIGHT DEPEND ON THE CURRENT DATA SEEDED.
    RESEEDING MAY REQUIRE YOU TO UPDATE CODE!
*/
public class AdminSeeder {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";
    
    public static void generateAdmins() {
        Pet admin = new Pet(USERNAME,PASSWORD);
        AdminList.addAdmin(admin);
        AdminList.serializeAdmins();
    }
}
