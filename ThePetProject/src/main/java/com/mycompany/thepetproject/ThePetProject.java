package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import java.util.Scanner;

import com.mycompany.thepetproject.swing.pages.Index;

import com.mycompany.thepetproject.main.user.UserList;
import com.mycompany.thepetproject.main.admin.AdminList;
import com.mycompany.thepetproject.main.pet.PetList;
import com.mycompany.thepetproject.main.pet.Pet;
import com.mycompany.thepetproject.main.pet.Status;
import com.mycompany.thepetproject.utils.auth.SessionManager;
import com.mycompany.thepetproject.utils.auth.SessionRole;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.utils.auth.strategies.AdminAuthentication;
import com.mycompany.thepetproject.utils.auth.strategies.UserAuthentication;
import java.util.List;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Index pages = new Index();
            pages.setVisible(true);
        });
        
        PetList.loadPets();
        PetList.savePets();
        List<Pet> pets = PetList.filterPets(Status.ADOPTED);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
