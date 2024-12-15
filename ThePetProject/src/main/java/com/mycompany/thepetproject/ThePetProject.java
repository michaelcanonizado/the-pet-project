package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import java.util.Scanner;

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.UserList;
import com.mycompany.thepetproject.utils.auth.SessionManager;
import com.mycompany.thepetproject.utils.auth.SessionRole;
import com.mycompany.thepetproject.utils.auth.strategies.AuthenticationStrategy;
import com.mycompany.thepetproject.utils.auth.strategies.AdminAuthentication;
import com.mycompany.thepetproject.utils.auth.strategies.UserAuthentication;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
        
        // Get the Singleton instance of SessionManager
        SessionManager sessionManager = SessionManager.getInstance();

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please log in.");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Determine if the user is an admin or a user
        System.out.print("Are you logging in as an Admin? (yes/no): ");
        String roleInput = scanner.nextLine().trim().toLowerCase();
        SessionRole role = roleInput.equals("yes") ? SessionRole.ADMIN : SessionRole.USER;

        // Use the appropriate authentication strategy
        AuthenticationStrategy strategy = role.equals(SessionRole.ADMIN)
                ? new AdminAuthentication()
                : new UserAuthentication();

        // Authenticate and set the session
        if (sessionManager.authenticate(role, username, password, strategy)) {
            System.out.println(role + " login successful!");
        } else {
            System.out.println("Invalid credentials. You are logged in as a Guest.");
        }

        // Display different views based on the role
        if (sessionManager.isLoggedIn()) {
            if (sessionManager.getRole().equals(SessionRole.ADMIN)) {
                System.out.println("Showing admin dashboard...");
            } else {
                System.out.println("Showing user dashboard...");
            }
        } else {
            System.out.println("Showing guest dashboard...");
        }

        // Simulate logout
        sessionManager.logout();
        System.out.println("Logged out. Current role: " + sessionManager.getRole());
    }
}
