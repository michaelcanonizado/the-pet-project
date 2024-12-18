package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import java.util.Scanner;

import com.mycompany.thepetproject.swing.pages.Index;

import com.mycompany.thepetproject.main.UserList;
import com.mycompany.thepetproject.main.AdminList;
import com.mycompany.thepetproject.main.PetList;
import com.mycompany.thepetproject.main.Pet;
import com.mycompany.thepetproject.main.PetStatus;
import com.mycompany.thepetproject.utils.auth.SessionManager;
import com.mycompany.thepetproject.utils.auth.SessionRole;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.utils.auth.strategies.AdminAuthentication;
import com.mycompany.thepetproject.utils.auth.strategies.UserAuthentication;
import com.mycompany.thepetproject.utils.seeders.AdminSeeder;
import com.mycompany.thepetproject.utils.seeders.UserSeeder;
import java.util.List;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Index pages = new Index();
            pages.setVisible(true);
        });

        UserList.loadUsers();
        AdminSeeder.generateAdmins();

        PetList.loadPets();
        PetList.savePets();
        PetList.loadPets();
        PetList.savePets();

        
//        PetList.loadPets();
//        PetList.savePets();
//        List<Pet> pets = PetList.filterPets(PetStatus.ADOPTED);
//        for (Pet pet : pets) {
//            System.out.println(pet);
//        }
    }
}
